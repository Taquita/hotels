package br.com.cvc.hotels.builders.hotel;

import br.com.cvc.hotels.models.hotel.HotelDTO;

import java.util.ArrayList;
import java.util.List;

public class HotelDTOBuilder {

    private HotelDTO hotel;

    private HotelDTOBuilder() { }

    public static List<HotelDTO> manyHotels(int length) {
        List<HotelDTO> hotels = new ArrayList<>();
        for (long i = 0; i < length; i++) {
            hotels.add(oneHotel(i).now());
        }
        return hotels;
    }

    public static HotelDTOBuilder oneHotel() {
        return oneHotel(1L);
    }

    public static HotelDTOBuilder oneHotel(Long id) {
        HotelDTOBuilder builder = new HotelDTOBuilder();
        builder.hotel = new HotelDTO();
        builder.hotel.setId(id);
        builder.hotel.setName("Hotel 1");
        builder.hotel.setCityCode(1L);
        builder.hotel.setCityName("Porto Alegre");
        return builder;
    }

    public HotelDTO now() {
        return this.hotel;
    }

}
