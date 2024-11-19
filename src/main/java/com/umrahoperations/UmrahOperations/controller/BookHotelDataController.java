package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.model.BookHotelData;
import com.umrahoperations.UmrahOperations.service.BookHotelDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-hotel-data")
@RequiredArgsConstructor
public class BookHotelDataController {
    private final BookHotelDataService bookHotelDataService;

    @GetMapping
    public List<BookHotelData> getAllBookHotelData() {
        return bookHotelDataService.getAllBookHotelData();
    }

    @GetMapping("/{id}")
    public BookHotelData getBookHotelDataById(@PathVariable Long id) {
        return bookHotelDataService.getBookHotelDataById(id);
    }

    @PostMapping
    public BookHotelData createBookHotelData(@RequestBody BookHotelData bookHotelData) {
        return bookHotelDataService.createBookHotelData(bookHotelData);
    }

    @PutMapping("/{id}")
    public BookHotelData updateBookHotelData(@PathVariable Long id, @RequestBody BookHotelData bookHotelData) {
        return bookHotelDataService.updateBookHotelData(id, bookHotelData);
    }

    @DeleteMapping("/{id}")
    public void deleteBookHotelData(@PathVariable Long id) {
        bookHotelDataService.deleteBookHotelData(id);
    }
}