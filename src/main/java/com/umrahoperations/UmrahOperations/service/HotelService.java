package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.HotelRoomDTO;
import com.umrahoperations.UmrahOperations.model.BookHotelData;
import com.umrahoperations.UmrahOperations.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public List<BookHotelData> getAllBookHotelData() {
        return hotelRepository.findAll();
    }

    public List<HotelRoomDTO> getHotelRoomData(String checkInDate, String checkOutDate) {
        // Calculate number of nights
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(checkInDate, formatter);
        LocalDate endDate = LocalDate.parse(checkOutDate, formatter);
        int nights = (int) ChronoUnit.DAYS.between(startDate, endDate);

        List<Object[]> data = hotelRepository.getHotelRoomData(checkInDate, checkOutDate, nights);
        return data.stream()
                .map(row -> new HotelRoomDTO(
                        ((Number) row[0]).intValue(),
                        ((Number) row[1]).intValue(),
                        (String) row[2],
                        (String) row[3],
                        ((Number) row[4]).intValue(),
                        (String) row[5],
                        ((Number) row[6]).intValue(),
                        (String) row[7],
                        (String) row[8],
                        ((Number) row[9]).doubleValue(),
                        ((Number) row[10]).doubleValue(),
                        ((Number) row[11]).intValue(),
                        ((Number) row[12]).intValue(),
                        (String) row[13],
                        (String) row[14],
                        (String) row[15],
                        (String) row[16],
                        ((Number) row[17]).intValue()
                ))
                .collect(Collectors.toList());
    }
    public BookHotelData createBookHotelData(BookHotelData bookHotelData) {
        return hotelRepository.save(bookHotelData);
    }

//    public BookHotelData updateBookHotelData(Long id, BookHotelData bookHotelData) {
//        BookHotelData existingBookHotelData = getBookHotelDataById(id);
//        // Update the existing entity with the new data
//        return hotelRepository.save(existingBookHotelData);
//    }

    public void deleteBookHotelData(Long id) {
        hotelRepository.deleteById(id);
    }
}