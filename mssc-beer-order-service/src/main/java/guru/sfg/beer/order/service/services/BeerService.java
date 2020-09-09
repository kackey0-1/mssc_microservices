package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.services.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by k-k on 2020/09/09
 */
public interface BeerService {
    Optional<BeerDto> getBeerById(UUID beerId);

    Optional<BeerDto> getBeerByUpc(String upc);
}
