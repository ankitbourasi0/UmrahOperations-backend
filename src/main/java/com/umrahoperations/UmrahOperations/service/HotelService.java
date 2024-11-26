package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.HotelBookingDTLDTO;
import com.umrahoperations.UmrahOperations.dto.HotelBookingDTO;
import com.umrahoperations.UmrahOperations.dto.HotelRoomDTO;
import com.umrahoperations.UmrahOperations.model.BookHotelData;
import com.umrahoperations.UmrahOperations.model.HotelBooking;
import com.umrahoperations.UmrahOperations.model.HotelBookingDTL;
import com.umrahoperations.UmrahOperations.repository.HotelBookingDTLRepository;
import com.umrahoperations.UmrahOperations.repository.HotelBookingRepository;
import com.umrahoperations.UmrahOperations.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    private final HotelBookingRepository hotelBookingRepository;
    private final HotelBookingDTLRepository hotelBookingDTLRepository;

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

    @Transactional
    public HotelBookingDTO createHotelBooking(HotelBookingDTO bookingDTO) {
        HotelBooking hotelBooking = convertToEntity(bookingDTO);
        hotelBooking.getBookingDetails().forEach(detail -> detail.setHotelBooking(hotelBooking));
        HotelBooking savedBooking = hotelBookingRepository.save(hotelBooking);
        return convertToDTO(savedBooking);
    }

    private HotelBooking convertToEntity(HotelBookingDTO dto) {
        HotelBooking hotelBooking = HotelBooking.builder()
                .hbDate(dto.getHbDate())
                .hbCustomerId(dto.getHbCustomerId())
                .hbSupplier(dto.getHbSupplier())
                .hbCountryId(dto.getHbCountryId())
                .hbCityId(dto.getHbCityId())
                .hbHotelId(dto.getHbHotelId())
                .hbSaleAmount(dto.getHbSaleAmount())
                .hbPurchaseAmount(dto.getHbPurchaseAmount())
                .hbEdate(LocalDate.now()) // Set current date for new bookings
                .hbEuser(dto.getHbEuser())
                .hbUuser(dto.getHbUuser())
                .hbUdate(LocalDate.now())
                .hbStatus(dto.getHbStatus())
                .hbAgentCurrency(dto.getHbAgentCurrency())
                .hbTotalAmount(dto.getHbTotalAmount())
                .hbBookingType(dto.getHbBookingType())
                .hbOptionDate(dto.getHbOptionDate())
                .hbToken(dto.getHbToken())
                .build();

        if (dto.getBookingDetails() != null) {
            List<HotelBookingDTL> details = dto.getBookingDetails().stream()
                    .map(detailDto -> HotelBookingDTL.builder()
                            .hbdCityId(detailDto.getHbdCityId())
                            .hbdHotelId(hotelBooking.getHbHotelId()) // Use hotel ID from parent
                            .hbdRoomType(detailDto.getHbdRoomType())
                            .hbdMeals(detailDto.getHbdMeals())
                            .hbdInDate(detailDto.getHbdInDate())
                            .hbdNights(detailDto.getHbdNights())
                            .hbdOutDate(detailDto.getHbdOutDate())
                            .hbdNoOfPax(detailDto.getHbdNoOfPax())
                            .hbdNoOfRoom(detailDto.getHbdNoOfRoom())
                            .hbdSaleAmount(detailDto.getHbdSaleAmount())
                            .hbdPurAmount(detailDto.getHbdPurAmount())
                            .hbdRemarks(detailDto.getHbdRemarks())
                            .hbdUuser(detailDto.getHbdUuser())
                            .hbdUdate(LocalDate.now())
                            .hbdConfirmationDt(detailDto.getHbdConfirmationDt())
                            .hbdPurchaseCo(detailDto.getHbdPurchaseCo())
                            .hbdStatus(detailDto.getHbdStatus())
                            .hbdRoomView(detailDto.getHbdRoomView())
                            .hbdSharing(detailDto.getHbdSharing())
                            .hotelBooking(hotelBooking)
                            .build())
                    .collect(Collectors.toList());
            hotelBooking.setBookingDetails(details);
        }
        return hotelBooking;
    }

    private HotelBookingDTL convertDetailToEntity(HotelBookingDTLDTO dto) {
        return HotelBookingDTL.builder()
                .hbdId(dto.getHbdId())
                .hbdInDate(dto.getHbdInDate())
                .hbdOutDate(dto.getHbdOutDate())
                .build();
    }

    private HotelBookingDTO convertToDTO(HotelBooking entity) {
        return HotelBookingDTO.builder()
                .hbId(entity.getHbId())
                .hbDate(entity.getHbDate())
                .hbCustomerId(entity.getHbCustomerId())
                .hbSupplier(entity.getHbSupplier())
                .hbCountryId(entity.getHbCountryId())
                .hbCityId(entity.getHbCityId())
                .hbHotelId(entity.getHbHotelId())
                .hbSaleAmount(entity.getHbSaleAmount())
                .hbPurchaseAmount(entity.getHbPurchaseAmount())
                .hbStatus(entity.getHbStatus())
                .hbAgentCurrency(entity.getHbAgentCurrency())
                .hbTotalAmount(entity.getHbTotalAmount())
                .hbBookingType(entity.getHbBookingType())
                .hbOptionDate(entity.getHbOptionDate())
                .hbToken(entity.getHbToken())
                .bookingDetails(entity.getBookingDetails().stream()
                        .map(this::convertDetailToDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    private HotelBookingDTLDTO convertDetailToDTO(HotelBookingDTL entity) {
        return HotelBookingDTLDTO.builder()
                .hbdId(entity.getHbdId())
                .hbdCityId(entity.getHbdCityId())
                .hbdHotelId(entity.getHbdHotelId())
                .hbdRoomType(entity.getHbdRoomType())
                .hbdMeals(entity.getHbdMeals())
                .hbdInDate(entity.getHbdInDate())
                .hbdNights(entity.getHbdNights())
                .hbdOutDate(entity.getHbdOutDate())
                .hbdNoOfPax(entity.getHbdNoOfPax())
                .hbdNoOfRoom(entity.getHbdNoOfRoom())
                .hbdSaleAmount(entity.getHbdSaleAmount())
                .hbdPurAmount(entity.getHbdPurAmount())
                .hbdRemarks(entity.getHbdRemarks())
                .hbdConfirmationDt(entity.getHbdConfirmationDt())
                .hbdPurchaseCo(entity.getHbdPurchaseCo())
                .hbdStatus(entity.getHbdStatus())
                .hbdRoomView(entity.getHbdRoomView())
                .hbdSharing(entity.getHbdSharing())
                .hbdUuser(entity.getHbdUuser())
                .hbdUdate(entity.getHbdUdate())
                .build();
    }

//    public BookHotelData createBookHotelData(BookHotelData bookHotelData) {
//        return hotelRepository.save(bookHotelData);
//    }

//    public BookHotelData updateBookHotelData(Long id, BookHotelData bookHotelData) {
//        BookHotelData existingBookHotelData = getBookHotelDataById(id);
//        // Update the existing entity with the new data
//        return hotelRepository.save(existingBookHotelData);
//    }

    public void deleteBookHotelData(Long id) {
        hotelRepository.deleteById(id);
    }

    public HotelBooking saveHotelBooking(HotelBooking hotelBooking) {

        HotelBooking savedHotelBooking = hotelBookingRepository.save(hotelBooking);

//        for (HotelBookingDTL hotelBookingDTL : hotelBookingDTLList) {
//            hotelBookingDTL.setHbdBookingId(savedHotelBooking.getHbId());
//            hotelBookingDTLRepository.save(hotelBookingDTL);
//        }

        return savedHotelBooking;
    }
}