package ch.jug.micronaut.beers;

public class BeerAddedEvent {

    private final Beer beer;

    public BeerAddedEvent(final Beer beer) {
        this.beer = beer;
    }

    public Beer getBeer() {
        return beer;
    }
}
