package br.com.cvc.hotels.controllers;

import br.com.cvc.hotels.models.hotel.HotelDTO;
import br.com.cvc.hotels.services.HotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author Jonathna Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Class controller for price methods
 */
@Api(value = "PriceController")
@RestController
@RequestMapping(value = "/price")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    @ApiOperation(value = "Get Book with pagination")
    public List<HotelDTO> getHotelsForPeriod(
            @RequestParam(value = "city") Long city,
            @RequestParam(value = "checkin") @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkIn,
            @RequestParam(value = "checkout") @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkOut,
            @RequestParam(value = "children", defaultValue = "0") Integer children,
            @RequestParam(value = "adults", defaultValue = "0") Integer adults
    ) {
        return hotelService.hotelPriceByCity();
    }


}
