package ch.jug.micronaut.beers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class BeerService {

    private static final Logger logger = LoggerFactory.getLogger(BeerService.class);

    private final List<Beer> beers = new ArrayList<>();

    public BeerService() {
        addBeer(new Beer(1L, "Luzerner Bier", "Brauerei Luzern AG"));
        addBeer(new Beer(2L, "Lozärner Bier", "Lozärner Bier AG"));
        addBeer(new Beer(3L, "Urbräu", "Tavolago AG"));
    }

    public Flowable<Beer> getAllBeers() {
        return Flowable.create(emitter -> {
            for (final Beer beer : beers) {
                if (emitter.isCancelled())
                    return;
                Thread.sleep(1_000);
                logger.info("Emitting beer: {}", beer);
                emitter.onNext(beer);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);
    }

    public void addBeer(final Beer beer) {
        beers.add(beer);
    }

}
