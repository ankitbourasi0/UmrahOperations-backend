package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.model.HotelFollowup;
import com.umrahoperations.UmrahOperations.repository.HotelFollowupRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelFollowupService {

    private  final HotelFollowupRepository hotelFollowupRepository;
    private static final Logger logger = LoggerFactory.getLogger(HotelFollowupService.class);


    public List<HotelFollowup> getAllBookings() {
        List<Object[]> results = hotelFollowupRepository.findAllBookings();
        List<HotelFollowup> bookings = new ArrayList<>();

        for (Object[] row : results) {
            try {
                // Log each column value for debugging
                for (int i = 0; i < row.length; i++) {
                    logger.debug("Column {}: {} (Type: {})",
                            i,
                            row[i],
                            (row[i] != null ? row[i].getClass().getName() : "null")
                    );
                }

                HotelFollowup booking = new HotelFollowup();

                booking.setId(convertToString(row[0])); // Set ID for JPA
                booking.setBookingId(convertToString(row[0]));
                booking.setBookingDate(convertToString(row[1]));
                booking.setAgentId(convertToString(row[2]));
                booking.setAgentName(convertToString(row[3]));
                booking.setSupplier(convertToString(row[4]));
                booking.setCityId(convertToInteger(row[5]));
                booking.setCityName(convertToString(row[6]));
                booking.setHotelId(convertToString(row[7]));
                booking.setHotelName(convertToString(row[8]));
                booking.setSaleAmount(convertToDouble(row[9]));
                booking.setStatus(convertToInteger(row[10]));
                booking.setStatusName(convertToString(row[11]));
                booking.setAgentCurrency(convertToString(row[12]));
                booking.setTotalAmount(convertToDouble(row[13]));
                booking.setBookingType(convertToInteger(row[14]));
                booking.setOptionDate(convertToString(row[15]));
                booking.setToken(convertToString(row[16]));

                bookings.add(booking);

            } catch (Exception e) {
                logger.error("Error processing row: ", e);
                // Log the problematic row
                StringBuilder rowData = new StringBuilder("Row data: ");
                for (Object cell : row) {
                    rowData.append(cell).append(", ");
                }
                logger.error(rowData.toString());
            }
        }

        return bookings;
    }

    // Utility methods
    private String convertToString(Object value) {
        return value != null ? value.toString() : null;
    }

    private Integer convertToInteger(Object value) {
        if (value == null) return null;
        try {
            if (value instanceof Number) {
                return ((Number) value).intValue();
            }
            return Integer.parseInt(value.toString().trim());
        } catch (NumberFormatException e) {
            logger.error("Error converting to Integer: " + value, e);
            return null;
        }
    }

    private Double convertToDouble(Object value) {
        if (value == null) return null;
        try {
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            }
            return Double.parseDouble(value.toString().trim());
        } catch (NumberFormatException e) {
            logger.error("Error converting to Double: " + value, e);
            return null;
        }
    }
    private String[] convertArrayToString(Object[] array) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = convertToString(array[i]);
        }
        return result;
    }
}
