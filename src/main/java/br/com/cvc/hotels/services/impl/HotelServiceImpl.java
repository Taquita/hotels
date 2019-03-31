package br.com.cvc.hotels.services.impl;

import br.com.cvc.hotels.apis.BrokerAPI;
import br.com.cvc.hotels.exceptions.DateInvalidException;
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

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Class for implements bossiness rules for Hotel
 */
@Service
public class HotelServiceImpl implements HotelService {

    private final BrokerAPI brokerAPI;
    private ModelMapper mapper;

    public HotelServiceImpl(BrokerAPI brokerAPI) {
        this.brokerAPI = brokerAPI;
        this.mapper = new ModelMapper();
    }

    /**
     * Method for search list hotel by city and calc total price for stay
     *
     * @param city - city ID for search hotels
     * @param checkIn - date check-in in hotel
     * @param checkOut - date check-out in hotel
     * @param children - number the children staying in hotel
     * @param adults - number the adults staying  in hotel
     * @return List<HotelReturnDTO>
     */
    @Override
    public List<HotelReturnDTO> hotelPriceByCity(Long city, LocalDate checkIn, LocalDate checkOut, Integer children, Integer adults) {
        RoomMapper.convertMapper(mapper);
        PriceMapper.convertMapper(mapper);
        if (checkIn.isAfter(checkOut))
            throw new DateInvalidException("The date of check-in and after the check-out date", HttpStatus.BAD_REQUEST);
        long diff = TimeUtils.daysDiff(checkIn, checkOut);
        return this.brokerAPI.getHotelDataByCityID(city).stream().map(hotel -> this.mappingToHotelReturn(hotel, adults, children, diff)).collect(Collectors.toList());
    }

    /**
     * Method for search list hotel by id and calc total price for stay
     *
     * @param hotelID - Hotel ID for calc
     * @param checkIn - date check-in in hotel
     * @param checkOut - date check-out in hotel
     * @param children - number the children staying in hotel
     * @param adults - number the adults staying  in hotel
     * @return List<HotelReturnDTO>
     */
    @Override
    public List<HotelReturnDTO> hotelPriceByHotel(Long hotelID, LocalDate checkIn, LocalDate checkOut, Integer children, Integer adults) {
        RoomMapper.convertMapper(mapper);
        PriceMapper.convertMapper(mapper);
        if (checkIn.isAfter(checkOut))
            throw new DateInvalidException("The date of check-in and after the check-out date", HttpStatus.BAD_REQUEST);
        long diff = TimeUtils.daysDiff(checkIn, checkOut);
        return this.brokerAPI.getHotelDataByID(hotelID).stream().map(hotel -> this.mappingToHotelReturn(hotel, adults, children, diff)).collect(Collectors.toList());
    }

    /**
     * Convert Hotel Object for calc values
     *
     * @param hotel - Hotel object for convert and calc
     * @param adults - number the children staying in hotel
     * @param children - number the adults staying  in hotel
     * @param days - diff days between check-in and check-out
     * @return HotelReturnDTO
     */
    public HotelReturnDTO mappingToHotelReturn(HotelDTO hotel, Integer adults, Integer children, long days) {
        HotelReturnDTO hotelR = mapper.map(hotel, HotelReturnDTO.class);
        hotelR.setRooms(hotel.getRooms().stream().map(room -> this.mappingToRoomReturn(room, adults, children, days)).collect(Collectors.toList()));
        return hotelR;
    }

    /**
     * Convert Room Object for calc values
     *
     * @param room - room object for convert and calc
     * @param adults - number the children staying in hotel
     * @param children - number the adults staying  in hotel
     * @param days - diff days between check-in and check-out
     * @return RoomReturnDTO
     */
    public RoomReturnDTO mappingToRoomReturn(RoomDTO room, Integer adults, Integer children, long days) {
        RoomReturnDTO roomR = mapper.map(room, RoomReturnDTO.class);
        roomR.setTotalPrice(adults, children, days);
        return roomR;
    }

}
