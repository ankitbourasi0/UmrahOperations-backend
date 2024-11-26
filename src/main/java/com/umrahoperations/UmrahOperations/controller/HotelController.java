package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.HotelBookingDTO;
import com.umrahoperations.UmrahOperations.dto.HotelRoomDTO;
import com.umrahoperations.UmrahOperations.model.BookHotelData;
import com.umrahoperations.UmrahOperations.model.HotelBooking;
import com.umrahoperations.UmrahOperations.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-hotel-data")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    private final static Logger log = LoggerFactory.getLogger(HotelController.class);
    @GetMapping
    public List<BookHotelData> getAllBookHotelData() {
        return hotelService.getAllBookHotelData();
    }

    @GetMapping("/hotel-room")
    public List<HotelRoomDTO> getHotelRoomData(
            @RequestParam String checkInDate,
            @RequestParam String checkOutDate
    ) {
        return hotelService.getHotelRoomData(checkInDate, checkOutDate);
    }

    @PostMapping("/hotel-room")
    public ResponseEntity<HotelBookingDTO> createHotelBooking(@RequestBody HotelBookingDTO bookingDTO) {
        log.info("Request to create hotel booking: {}", bookingDTO);
        return ResponseEntity.ok(hotelService.createHotelBooking(bookingDTO));
    }
//    @GetMapping("/{id}")
//    public BookHotelData getBookHotelDataById(@PathVariable Long id) {
//        return hotelService.getBookHotelDataById(id);
//    }

//    @PostMapping
//    public BookHotelData createBookHotelData(@RequestBody BookHotelData bookHotelData) {
//        return hotelService.createBookHotelData(bookHotelData);
//    }

//    @PutMapping("/{id}")
//    public BookHotelData updateBookHotelData(@PathVariable Long id, @RequestBody BookHotelData bookHotelData) {
//        return hotelService.updateBookHotelData(id, bookHotelData);
//    }

    @DeleteMapping("/{id}")
    public void deleteBookHotelData(@PathVariable Long id) {
        hotelService.deleteBookHotelData(id);
    }
}