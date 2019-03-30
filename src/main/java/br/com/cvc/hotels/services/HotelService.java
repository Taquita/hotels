package br.com.cvc.hotels.services;

import br.com.cvc.hotels.models.hotel.HotelDTO;

import java.util.List;

public interface HotelService {

    public List<HotelDTO> hotelPriceByCity();

}
