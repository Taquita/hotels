package br.com.cvc.hotels.builders.hotel;

import br.com.cvc.hotels.models.hotel.HotelReturnDTO;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 * @see HotelReturnDTO
 *
 * Class Builder for HotelReturnDTO
 */
public class HotelReturnDTOBuilder {

    private HotelReturnDTO hotel;

    private HotelReturnDTOBuilder() {}

    public static HotelReturnDTOBuilder oneHotel() {
        HotelReturnDTOBuilder builder = new HotelReturnDTOBuilder();
        builder.hotel = new HotelReturnDTO();
        builder.hotel.setId(1L);
        builder.hotel.setName("Hotel 1");
        builder.hotel.setCityCode(1L);
        builder.hotel.setCityName("Porto Alegre");
        return builder;
    }

    public HotelReturnDTO now() {
        return this.hotel;
    }

}
