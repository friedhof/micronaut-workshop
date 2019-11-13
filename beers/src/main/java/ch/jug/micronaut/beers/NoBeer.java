package ch.jug.micronaut.beers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Flowable;

@Fallback
public class NoBeer implements BeerClient {

    private static final Logger logger = LoggerFactory.getLogger(NoBeer.class);

    @Override
    public Flowable<Beer> fetchBeers() {
        logger.info("Fallback implementation called!");
        return Flowable.empty();
    }

}
