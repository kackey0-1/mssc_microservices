package guru.springframework.msscbeerservice.services.inventory;

import java.util.UUID;

/**
 * Created by k-k on 2020/08/30
 */
public interface BeerInventoryService {

    Integer getOnhandInventory(UUID beerId);
}
