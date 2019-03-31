package br.com.cvc.hotels.services;

import br.com.cvc.hotels.apis.BrokerAPI;
import br.com.cvc.hotels.builders.hotel.HotelDTOBuilder;
import br.com.cvc.hotels.builders.room.RoomDTOBuilder;
import br.com.cvc.hotels.exceptions.DateInvalidException;
import br.com.cvc.hotels.models.hotel.HotelDTO;
import br.com.cvc.hotels.models.room.RoomDTO;
import br.com.cvc.hotels.models.room.RoomReturnDTO;
import br.com.cvc.hotels.services.impl.HotelServiceImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 * @see HotelServiceImpl
 *
 * Class for testing HotelService
 */
@RunWith(SpringRunner.class)
public class HotelServiceTest {

    @InjectMocks
    public HotelServiceImpl service;

    @Mock
    public BrokerAPI api;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    /**
     * @since 2019.03.30
     * @see DateInvalidException
     *
     * Test for capture exception case date check-in after the check-out date
     */
    @Test
    public void shouldIfCheckinIsAfterCheckoutReturnException() {
        LocalDate init = LocalDate.now();
        LocalDate end = init.minusDays(6);
        exceptionRule.expect(DateInvalidException.class);
        exceptionRule.expectMessage("The date of check-in and after the check-out date");
        this.service.hotelPriceByCity(1L, init, end, 0, 0);
    }

    /**
     * @since 2019.03.30
     *
     * Test for check called method mappingToHotelReturn three times
     */
    @Test
    public void shouldCheckIfCalledSetMappingToHotelMethod() {
        HotelServiceImpl serviceSpy = spy(service);
        LocalDate init = LocalDate.now();
        LocalDate end = init.plusDays(6);
        List<HotelDTO> hotels = HotelDTOBuilder.manyHotels(3);
        when(api.getHotelDataByCityID(1L)).thenReturn(hotels);
        doReturn(null).when(serviceSpy).mappingToHotelReturn(any(HotelDTO.class), eq(1), eq(0), anyInt());
        serviceSpy.hotelPriceByCity(1L, init, end, 0, 1);
        verify(serviceSpy, times(3)).mappingToHotelReturn(any(HotelDTO.class), eq(1), eq(0), anyInt());
    }

    /**
     * @since 2019.03.30
     * @see BrokerAPI
     *
     * Test for check called API method getHotelDataByCityID someone in one times
     */
    @Test
    public void shouldCheckCalledAPIMethodGetHotelDataByCityID() {
        HotelServiceImpl serviceSpy = spy(service);
        LocalDate init = LocalDate.now();
        LocalDate end = init.plusDays(6);
        List<HotelDTO> hotels = HotelDTOBuilder.manyHotels(3);
        when(api.getHotelDataByCityID(1L)).thenReturn(hotels);
        doReturn(null).when(serviceSpy).mappingToHotelReturn(any(HotelDTO.class), eq(1), eq(0), anyInt());
        serviceSpy.hotelPriceByCity(1L, init, end, 0, 1);
        verify(api, times(1)).getHotelDataByCityID(1L);
    }

    /**
     * @since 2019.03.30
     * @see RoomReturnDTO
     *
     * Test for check called method setTotalPrice
     */
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

    /**
     * @since 2019.03.30
     *
     * Test for check called method mappingToRoomReturn three times
     */
    @Test
    public void shouldCheckIfCalledSetWithArgsInMappingHotelMethod() {
        HotelDTO hotel = HotelDTOBuilder.oneHotel().now();
        HotelServiceImpl serviceSpy = spy(service);
        List<RoomDTO> rooms = RoomDTOBuilder.manyRooms(3);
        hotel.setRooms(rooms);
        doReturn(null).when(serviceSpy).mappingToRoomReturn(any(RoomDTO.class), eq(1), eq(0), eq(2));
        serviceSpy.mappingToHotelReturn(hotel, 1, 0, 2);
        verify(serviceSpy, times(3)).mappingToRoomReturn(any(RoomDTO.class), eq(1), eq(0), eq(2));
    }

    /**
     * @since 2019.03.31
     * @see DateInvalidException
     *
     * Test for capture exception case date check-in after the check-out date
     */
    @Test
    public void shouldCheckIfThrowExceptionInGetHotelsByID() {
        LocalDate init = LocalDate.now();
        LocalDate end = init.minusDays(6);
        exceptionRule.expect(DateInvalidException.class);
        exceptionRule.expectMessage("The date of check-in and after the check-out date");
        this.service.hotelPriceByHotel(1L, init, end, 0, 0);
    }

    /**
     * @since 2019.03.31
     *
     * Test for check called method mappingToHotelReturn three times
     */
    @Test
    public void shouldCheckIfCalledSetMappingToHotelMethodInGetHotelByID() {
        HotelServiceImpl serviceSpy = spy(service);
        LocalDate init = LocalDate.now();
        LocalDate end = init.plusDays(6);
        List<HotelDTO> hotels = HotelDTOBuilder.manyHotels(3);
        when(api.getHotelDataByID(1L)).thenReturn(hotels);
        doReturn(null).when(serviceSpy).mappingToHotelReturn(any(HotelDTO.class), eq(1), eq(0), anyInt());
        serviceSpy.hotelPriceByHotel(1L, init, end, 0, 1);
        verify(serviceSpy, times(3)).mappingToHotelReturn(any(HotelDTO.class), eq(1), eq(0), anyInt());
    }

    /**
     * @since 2019.03.31
     * @see BrokerAPI
     *
     * Test for check called API method getHotelDataByID someone in one times
     */
    @Test
    public void shouldCheckIfCalledFeignMethodGetHotelDataByID() {
        HotelServiceImpl serviceSpy = spy(service);
        LocalDate init = LocalDate.now();
        LocalDate end = init.plusDays(6);
        List<HotelDTO> hotels = HotelDTOBuilder.manyHotels(3);
        when(api.getHotelDataByID(1L)).thenReturn(hotels);
        doReturn(null).when(serviceSpy).mappingToHotelReturn(any(HotelDTO.class), eq(1), eq(0), anyInt());
        serviceSpy.hotelPriceByHotel(1L, init, end, 0, 1);
        verify(api, times(1)).getHotelDataByID(1L);
    }


}
