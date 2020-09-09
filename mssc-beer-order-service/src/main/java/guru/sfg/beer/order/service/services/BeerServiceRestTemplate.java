package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.services.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by k-k on 2020/09/09
 */
@Slf4j
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BeerServiceRestTemplate implements BeerService {
    
   private RestTemplate restTemplate;
   private final String BEER_ID_PATH = "/api/v1/beer/";
   private final String BEER_UPC_PATH = "/api/v1/beerUpc/";
   
   private String beerServiceHost;

   @Autowired
   public void setRestTemplate(RestTemplateBuilder builder) {
      this. restTemplate = builder.build();
   }

   public void setBeerServiceHost(String beerServiceHost){
      this.beerServiceHost = beerServiceHost;
   }

   @Override
   public Optional<BeerDto> getBeerById(UUID beerId) {
      log.debug("Calling Beer Service");
      return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_ID_PATH + beerId.toString(), BeerDto.class));
   }

   @Override
   public Optional<BeerDto> getBeerByUpc(String upc) {
      log.debug("Calling Beer Service");
      return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_UPC_PATH + upc, BeerDto.class));
   }
}
