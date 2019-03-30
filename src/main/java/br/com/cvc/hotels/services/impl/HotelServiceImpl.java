package br.com.cvc.hotels.services.impl;

import br.com.cvc.hotels.apis.BrokerAPI;
import br.com.cvc.hotels.models.hotel.HotelDTO;
import br.com.cvc.hotels.services.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final BrokerAPI brokerAPI;

    public HotelServiceImpl(BrokerAPI brokerAPI) {
        this.brokerAPI = brokerAPI;
    }

    public List<HotelDTO> hotelPriceByCity() {
        return this.brokerAPI.getHotelDataByCityID(1032L);
    }

}
