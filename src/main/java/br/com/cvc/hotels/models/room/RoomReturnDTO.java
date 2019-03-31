package br.com.cvc.hotels.models.room;

import br.com.cvc.hotels.models.price.PriceReturnDTO;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class RoomReturnDTO extends RoomCommon {

    private Double totalPrice;

    @Setter
    private PriceReturnDTO priceDetail;

    public void setTotalPrice(Integer adults, Integer children, long days) {
        Double totalAdults = (this.getPriceDetail().getPricePerDayAdult() * adults) * days;
        Double totalChildren = (this.getPriceDetail().getPricePerDayChild() * children) * days;
        this.totalPrice = totalAdults + totalChildren;
    }
}
