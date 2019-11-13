package ch.jug.micronaut.beers;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.reactivex.Flowable;

@Client("${beers.url:`http://localhost:8080/beers`}")
@CircuitBreaker(delay = "5s", attempts = "5", multiplier = "2", reset = "10m")
public interface BeerClient {

    @Get
    public Flowable<Beer> fetchBeers();

}
