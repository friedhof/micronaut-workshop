package ch.jug.micronaut.beers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class BeerService {

    private final List<Beer> beers = new ArrayList<>();

    public BeerService() {
        addBeer(new Beer(1L, "Luzerner Bier", "Brauerei Luzern AG"));
        addBeer(new Beer(2L, "Lozärner Bier", "Lozärner Bier AG"));
        addBeer(new Beer(3L, "Urbräu", "Tavolago AG"));
    }

    public Observable<Beer> getAllBeers() {
        return Observable.fromIterable(beers);
    }

    public void addBeer(final Beer beer) {
        beers.add(beer);
    }

}
