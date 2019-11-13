package ch.jug.micronaut.beers;

import org.junit.jupiter.api.Test;

import io.micronaut.test.annotation.MicronautTest;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@MicronautTest
class BeerServiceTest {

    @Inject 
    BeerService service;

    @Test
    public void testBeers() throws Exception {
        final List<Beer> beers = new ArrayList<>();
        service.getAllBeers().subscribe(beers::add);
        assertEquals(3, beers.size());
    }
}
