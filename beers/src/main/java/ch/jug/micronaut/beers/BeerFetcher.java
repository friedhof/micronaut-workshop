package ch.jug.micronaut.beers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.scheduling.annotation.Scheduled;

public class BeerFetcher {

    private static final Logger logger = LoggerFactory.getLogger(BeerFetcher.class);

    private final BeerClient client;

    public BeerFetcher(final BeerClient client) {
        this.client = client;
    }

    @Scheduled(fixedDelay = "${beers.fixed-delay:5s}", initialDelay = "${beers.initial-delay:10s}")
    public void fetchSomeBeer() {
        client.fetchBeers()
        .doOnError(e -> logger.error("Can't fetch beers!", e))
        .forEach(beer -> logger.info(beer.toString()));
    }

}
