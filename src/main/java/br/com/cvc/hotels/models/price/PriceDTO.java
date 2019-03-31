package br.com.cvc.hotels.models.price;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO extends PriceCommon {

    private Double adult;
    private Double child;

}
