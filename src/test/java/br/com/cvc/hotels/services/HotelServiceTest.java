package br.com.cvc.hotels.services;

import br.com.cvc.hotels.services.impl.HotelServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HotelServiceTest {

    @InjectMocks
    public HotelServiceImpl service;

}
