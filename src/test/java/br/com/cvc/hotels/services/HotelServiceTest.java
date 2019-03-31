package br.com.cvc.hotels.services;

import br.com.cvc.hotels.apis.BrokerAPI;
import br.com.cvc.hotels.builders.hotel.HotelDTOBuilder;
import br.com.cvc.hotels.builders.hotel.HotelReturnDTOBuilder;
import br.com.cvc.hotels.builders.room.RoomDTOBuilder;
import br.com.cvc.hotels.builders.room.RoomReturnDTOBuilder;
import br.com.cvc.hotels.exceptions.DateInvalidException;
import br.com.cvc.hotels.models.hotel.HotelDTO;
import br.com.cvc.hotels.models.hotel.HotelReturnDTO;
import br.com.cvc.hotels.models.room.RoomDTO;
import br.com.cvc.hotels.models.room.RoomReturnDTO;
import br.com.cvc.hotels.services.impl.HotelServiceImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class HotelServiceTest {

    @InjectMocks
    public HotelServiceImpl service;

    @Mock
    public BrokerAPI api;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldIfCheckinIsAfterCheckoutReturnException() {
        LocalDate init = LocalDate.now();
        LocalDate end = init.minusDays(6);
        exceptionRule.expect(DateInvalidException.class);
        exceptionRule.expectMessage("The date of check-in and after the check-out date");
        this.service.hotelPriceByCity(1L, init, end, 0, 0);
    }

    @Test
    public void shouldIfCheckIsCalledSetRooms() {
        LocalDate init = LocalDate.now();
        LocalDate end = init.plusDays(6);
        List<HotelDTO> hotels = HotelDTOBuilder.manyHotels(3);
        List<RoomDTO> rooms = RoomDTOBuilder.manyRooms(1);
        hotels.forEach(hotel -> hotel.setRooms(rooms));
        when(api.getHotelDataByCityID(1L)).thenReturn(hotels);
        this.service.hotelPriceByCity(1L, init, end, 0, 0);
    }

    @Test
    public void shouldCheckIfCalledSetWithArgsInMappingRoomMethod() {
        RoomDTO room = RoomDTOBuilder.oneRoom().now();
        RoomReturnDTO roomR = mock(RoomReturnDTO.class);
        ModelMapper mapperMock = mock(ModelMapper.class);
        ReflectionTestUtils.setField(service, "mapper", mapperMock);
        when(mapperMock.map(room, RoomReturnDTO.class)).thenReturn(roomR);
        this.service.mappingToRoomReturn(room, 1,0,2);
        verify(roomR).setTotalPrice(1, 0, 2);
    }

    @Test
    public void shouldCheckIfCalledSetWithArgsInMappingHotelMethod() {
        HotelDTO hotel = HotelDTOBuilder.oneHotel().now();
        HotelServiceImpl serviceSpy = Mockito.spy(service);
        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room =  RoomDTOBuilder.oneRoom().now();
        rooms.add(room);
        hotel.setRooms(rooms);
        Mockito.doReturn(null).when(serviceSpy).mappingToRoomReturn(room, 1, 0, 2);
        serviceSpy.mappingToHotelReturn(hotel, 1, 0, 2);
        verify(serviceSpy).mappingToRoomReturn(room, 1, 0, 2);
    }

}
