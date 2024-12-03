package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.BookHotelData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<BookHotelData, Long> {
    @Query(value =
            "SELECT " +
                    "hrpd_hotel_id, " +
                    "hrpd_room_type, rt_name_la, rt_name_ar, rt_no_of_beds, " +
                    "NVL((SELECT MAX(hri_image) FROM hotel_room_images WHERE hri_hm_id = hrpd_hotel_id AND hri_rt_id = hrpd_room_type), hm_logo) AS room_type_image, " +
                    "hrpd_meals, lm_name_la AS meals_la, lm_name_la AS meals_ar, " +
                    "SUM(NVL(hrpd_purchase, 0)) AS pur_amount, " +
                    "SUM(hrpd_sale) AS sale_amount, " +
                    "hrpd_room_view, hrpd_sharing, lhs_name_la AS sharing_la, lhs_name_ar AS sharing_ar, hv_name_la, hv_name_ar, " +
                    "NVL(hrpd_supplier, hrpd_owner) AS hrpd_supplier " +
                    "FROM " +
                    "hotel_rate_plan_days, " +
                    "hotel_room_types, " +
                    "luk_hotel_meals, " +
                    "hotel_master, " +
                    "luk_hotel_sharing, " +
                    "Hotel_Views " +
                    "WHERE " +
                    "hrpd_date BETWEEN TO_DATE(:checkInDate,'dd-MM-yyyy') AND TO_DATE(:checkOutDate,'dd-MM-yyyy') - 1 " +
                    "AND hrpd_hotel_id = hm_id " +
                    "AND hrpd_room_type = rt_id " +
                    "AND hrpd_meals = lm_id " +
                    "AND hrpd_hotel_id = :hotelId " +
                    "AND NVL(hrpd_supplier, hrpd_owner) = :supplierId  " +
                    "AND hrpd_room_view = hv_id " +
                    "AND hrpd_sharing = lhs_id " +
                    "GROUP BY " +
                    "hrpd_owner, hrpd_supplier, hrpd_hotel_id, hrpd_room_view, hrpd_room_type, hrpd_meals, " +
                    "rt_name_la, rt_name_ar, rt_no_of_beds, hm_logo, lm_name_la, lm_name_ar, hrpd_sharing, lhs_name_la, lhs_name_ar, hv_name_la, hv_name_ar " +
                    "ORDER BY " +
                    "rt_no_of_beds", nativeQuery = true
    )
    List<Object[]> getHotelRoomData(
            @Param("checkInDate") String checkInDate,
            @Param("checkOutDate") String checkOutDate,
            @Param("hotelId") Long hotelId,
            @Param("supplierId") Long supplierId

    );
}