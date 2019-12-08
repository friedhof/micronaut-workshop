package ch.jug.micronaut.beers;

import io.micronaut.runtime.event.annotation.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeerAddedListener {

    private static final Logger logger = LoggerFactory.getLogger(BeerAddedEvent.class);

    @EventListener
    public void doSomethingOnNewBeer(final BeerAddedEvent event) {
        logger.info("Wow, there is a new beer available: {}", event.getBeer());
    }

}
