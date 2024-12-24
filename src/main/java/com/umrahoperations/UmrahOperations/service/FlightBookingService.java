package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.FlightBookingDTO;
import com.umrahoperations.UmrahOperations.model.FlightBooking;
import com.umrahoperations.UmrahOperations.model.FlightTraveller;
import com.umrahoperations.UmrahOperations.repository.FlightBookingRepository;
import com.umrahoperations.UmrahOperations.repository.FlightTravellerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class FlightBookingService {
    private final FlightBookingRepository flightBookingRepository;
    private final FlightTravellerRepository flightTravellerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FlightBookingService(FlightBookingRepository flightBookingRepository,
                                FlightTravellerRepository flightTravellerRepository,
                                ModelMapper modelMapper) {
        this.flightBookingRepository = flightBookingRepository;
        this.flightTravellerRepository = flightTravellerRepository;
        this.modelMapper = modelMapper;
    }

    public FlightBookingDTO saveFlightBooking(FlightBookingDTO bookingDTO) {
        FlightBooking bookingEntity = modelMapper.map(bookingDTO, FlightBooking.class);

        // Save the booking first
        final FlightBooking savedBooking = flightBookingRepository.save(bookingEntity);

        // Map and save travellers
        if (bookingDTO.getTravellers() != null) {
            List<FlightTraveller> travellers = new ArrayList<>();

            for (var travellerDTO : bookingDTO.getTravellers()) {
                if (travellerDTO != null) {
                    FlightTraveller traveller = modelMapper.map(travellerDTO, FlightTraveller.class);
                    traveller.setFlightBooking(savedBooking);
                    travellers.add(flightTravellerRepository.save(traveller));
                }
            }

            savedBooking.setTravellers(travellers);
        }

        // Save the updated booking with travellers
        FlightBooking finalBooking = flightBookingRepository.save(savedBooking);
        return modelMapper.map(finalBooking, FlightBookingDTO.class);
    }
}