package br.com.cvc.hotels.services.impl;

import br.com.cvc.hotels.exceptions.DateInvalidException;
import br.com.cvc.hotels.apis.BrokerAPI;
import br.com.cvc.hotels.mappers.PriceMapper;
import br.com.cvc.hotels.mappers.RoomMapper;
import br.com.cvc.hotels.models.hotel.HotelDTO;
import br.com.cvc.hotels.models.hotel.HotelReturnDTO;
import br.com.cvc.hotels.models.room.RoomDTO;
import br.com.cvc.hotels.models.room.RoomReturnDTO;
import br.com.cvc.hotels.services.HotelService;
import br.com.cvc.hotels.utils.TimeUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final BrokerAPI brokerAPI;
    private ModelMapper mapper;

    public HotelServiceImpl(BrokerAPI brokerAPI) {
        this.brokerAPI = brokerAPI;
        this.mapper = new ModelMapper();
    }

    public List<HotelReturnDTO> hotelPriceByCity(Long city, LocalDate checkIn, LocalDate checkOut, Integer children, Integer adults) {
        RoomMapper.convertMapper(mapper);
        PriceMapper.convertMapper(mapper);
        if (checkIn.isAfter(checkOut))
            throw new DateInvalidException("The date of check-in and after the check-out date", HttpStatus.BAD_REQUEST);
        int diff = TimeUtils.daysDiff(checkIn, checkOut);
        return this.brokerAPI.getHotelDataByCityID(city).stream().map(hotel -> this.mappingToHotelReturn(hotel, adults, children, diff)).collect(Collectors.toList());
    }

    public HotelReturnDTO mappingToHotelReturn(HotelDTO hotel, Integer adults, Integer children, int days) {
        HotelReturnDTO hotelR = mapper.map(hotel, HotelReturnDTO.class);
        hotelR.setRooms(hotel.getRooms().stream().map(room -> this.mappingToRoomReturn(room, adults, children, days)).collect(Collectors.toList()));
        return hotelR;
    }

    public RoomReturnDTO mappingToRoomReturn(RoomDTO room, Integer adults, Integer children, int days) {
        RoomReturnDTO roomR = mapper.map(room, RoomReturnDTO.class);
        roomR.setTotalPrice(adults, children, days);
        return roomR;
    }

}
