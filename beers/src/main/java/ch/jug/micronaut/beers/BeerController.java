package ch.jug.micronaut.beers;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Flowable;

@Controller("/beers")
public class BeerController {

    private final BeerService service;

    public BeerController(final BeerService service) {
        this.service = service;
    }

    @Get
    public Flowable<Beer> getAllBeers() {
        return service.getAllBeers();
    }

    @Post
    public void addBeer(@Body final Beer beer) {
        service.addBeer(beer);
    }

}
