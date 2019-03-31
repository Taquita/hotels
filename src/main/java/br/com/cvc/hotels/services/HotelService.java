package br.com.cvc.hotels.services;

import br.com.cvc.hotels.models.hotel.HotelReturnDTO;

import java.time.LocalDate;
import java.util.List;

public interface HotelService {

    public List<HotelReturnDTO> hotelPriceByCity(Long city, LocalDate checkIn, LocalDate checkOut, Integer children, Integer adults);

}
