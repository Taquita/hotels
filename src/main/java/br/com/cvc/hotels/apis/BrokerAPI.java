package br.com.cvc.hotels.apis;

import br.com.cvc.hotels.models.hotel.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Interface for external access API
 */
@FeignClient(url = "https://cvcbackendhotel.herokuapp.com/", name = "hotels")
public interface BrokerAPI {

    @GetMapping("/hotels/avail/{id}")
    List<HotelDTO> getHotelDataByCityID(@PathVariable("id") Long id);

    @GetMapping("/hotels/{id}")
    List<HotelDTO> getHotelDataByID(@PathVariable("id") Long id);

}
