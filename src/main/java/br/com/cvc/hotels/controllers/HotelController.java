package br.com.cvc.hotels.controllers;

import br.com.cvc.hotels.models.hotel.HotelReturnDTO;
import br.com.cvc.hotels.services.HotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Jonathna Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Class controller for price methods
 */
@Api(value = "PriceController")
@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    /**
     * Return List Hotels with calc for clients by City ID
     *
     * @param city - city ID for search hotels
     * @param checkIn - date check-in in hotel
     * @param checkOut - date check-out in hotel
     * @param children - number the children staying in hotel
     * @param adults - number the adults staying  in hotel
     * @return List<HotelReturnDTO>
     */
    @GetMapping(value = "/city")
    @ApiOperation(value = "Get Book with pagination")
    public List<HotelReturnDTO> getHotelsForPeriod(
            @RequestParam(value = "city") Long city,
            @RequestParam(value = "checkin") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkIn,
            @RequestParam(value = "checkout") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkOut,
            @RequestParam(value = "children", defaultValue = "0") Integer children,
            @RequestParam(value = "adults", defaultValue = "0") Integer adults
    ) {
        return hotelService.hotelPriceByCity(city, checkIn, checkOut, children, adults);
    }

    /**
     * Return List Hotels with calc for clients by Hotel ID
     *
     * @param hotel - Hotel ID for calc
     * @param checkIn - date check-in in hotel
     * @param checkOut - date check-out in hotel
     * @param children - number the children staying in hotel
     * @param adults - number the adults staying  in hotel
     * @return List<HotelReturnDTO>
     */
    @GetMapping
    @ApiOperation(value = "Get Book with pagination")
    public List<HotelReturnDTO> getHotelsForPeriodById(
            @RequestParam(value = "hotel") Long hotel,
            @RequestParam(value = "checkin") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkIn,
            @RequestParam(value = "checkout") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkOut,
            @RequestParam(value = "children", defaultValue = "0") Integer children,
            @RequestParam(value = "adults", defaultValue = "0") Integer adults
    ) {
        return hotelService.hotelPriceByHotel(hotel, checkIn, checkOut, children, adults);
    }


}
