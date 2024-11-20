package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.HotelRoomDTO;
import com.umrahoperations.UmrahOperations.model.BookHotelData;
import com.umrahoperations.UmrahOperations.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-hotel-data")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping
    public List<BookHotelData> getAllBookHotelData() {
        return hotelService.getAllBookHotelData();
    }


    @GetMapping("/hotel-room")
    public List<HotelRoomDTO> getHotelRoomData() {
        return hotelService.getHotelRoomData();
    }
    @GetMapping("/{id}")
    public BookHotelData getBookHotelDataById(@PathVariable Long id) {
        return hotelService.getBookHotelDataById(id);
    }

    @PostMapping
    public BookHotelData createBookHotelData(@RequestBody BookHotelData bookHotelData) {
        return hotelService.createBookHotelData(bookHotelData);
    }

    @PutMapping("/{id}")
    public BookHotelData updateBookHotelData(@PathVariable Long id, @RequestBody BookHotelData bookHotelData) {
        return hotelService.updateBookHotelData(id, bookHotelData);
    }

    @DeleteMapping("/{id}")
    public void deleteBookHotelData(@PathVariable Long id) {
        hotelService.deleteBookHotelData(id);
    }
}