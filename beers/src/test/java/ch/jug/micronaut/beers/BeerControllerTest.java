package ch.jug.micronaut.beers;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class BeerControllerTest {

    @Inject
    private EmbeddedServer server;

    @Inject
    @Client("/")
    private RxHttpClient client;

    @Test
    public void testBody() throws Exception {
        final HttpRequest<String> request = HttpRequest.GET("/beers");
        final String body = client.toBlocking().retrieve(request);
        assertNotNull(body);
        assertEquals(body, "[{\"id\":1,\"name\":\"Luzerner Bier\",\"brewery\":\"Brauerei Luzern AG\"},{\"id\":2,\"name\":\"Lozärner Bier\",\"brewery\":\"Lozärner Bier AG\"},{\"id\":3,\"name\":\"Urbräu\",\"brewery\":\"Tavolago AG\"}]");
    }

    @Test
    public void testStatus() throws Exception {
        try(RxHttpClient client = server.getApplicationContext().createBean(RxHttpClient.class, server.getURL())) {
            assertEquals(HttpStatus.OK, client.toBlocking().exchange("/beers").status());
        }
    }
}
