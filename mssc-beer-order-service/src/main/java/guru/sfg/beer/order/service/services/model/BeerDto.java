package guru.sfg.beer.order.service.services.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by k-k on 2020/09/09
 */
@Data
public class BeerDto {
    private UUID id;
    private String beerName;
    private String beerStyle;
    private String upc;
    private BigDecimal price;
}
