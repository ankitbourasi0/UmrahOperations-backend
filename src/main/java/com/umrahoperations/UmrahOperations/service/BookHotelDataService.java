package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.model.BookHotelData;
import com.umrahoperations.UmrahOperations.repository.BookHotelDataRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookHotelDataService {
    private final BookHotelDataRepository bookHotelDataRepository;

    public List<BookHotelData> getAllBookHotelData() {
        return bookHotelDataRepository.findAll();
    }

    public BookHotelData getBookHotelDataById(Long id) {
        return bookHotelDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book Hotel Data not found with ID: " + id));
    }

    public BookHotelData createBookHotelData(BookHotelData bookHotelData) {
        return bookHotelDataRepository.save(bookHotelData);
    }

    public BookHotelData updateBookHotelData(Long id, BookHotelData bookHotelData) {
        BookHotelData existingBookHotelData = getBookHotelDataById(id);
        // Update the existing entity with the new data
        return bookHotelDataRepository.save(existingBookHotelData);
    }

    public void deleteBookHotelData(Long id) {
        bookHotelDataRepository.deleteById(id);
    }
}