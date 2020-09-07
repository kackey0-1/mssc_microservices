package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by k-k on 2020/09/08
 */
public class BeerOrderLineMapperIml implements BeerOrderLineMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
        if(line == null) {
            return null;
        }
        BeerOrderLineDto.BeerOrderLineDtoBuilder beerOrderLineDto = BeerOrderLineDto.builder();
        beerOrderLineDto.createdDate(dateMapper.asOffsetDateTime(line.getCreatedDate()));
        beerOrderLineDto.lastModifiedDate(dateMapper.asOffsetDateTime(line.getLastModifiedDate()));
        beerOrderLineDto.upc(line.getUpc());
        beerOrderLineDto.beerId(line.getBeerId());
        beerOrderLineDto.orderQuantity(line.getOrderQuantity());
        return beerOrderLineDto.build();
    }

    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto) {
        if(dto == null) {
            return null;
        }
        BeerOrderLine.BeerOrderLineBuilder beerOrderLine = BeerOrderLine.builder();

        beerOrderLine.id(dto.getBeerId());
        if (dto.getVersion() != null) {
            beerOrderLine.version(dto.getVersion().longValue());
        }
        beerOrderLine.createdDate(dateMapper.asTimestamp(dto.getCreatedDate()));
        beerOrderLine.lastModifiedDate(dateMapper.asTimestamp(dto.getLastModifiedDate()));
        beerOrderLine.upc(dto.getUpc());
        beerOrderLine.beerId(dto.getBeerId());
        beerOrderLine.orderQuantity(dto.getOrderQuantity());
        return beerOrderLine.build();
    }
}
