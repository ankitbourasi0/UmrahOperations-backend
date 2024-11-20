package com.umrahoperations.UmrahOperations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelRoomDTO {
    private int hrpdHotelId;
    private int hrpdRoomType;
    private String rtNameLa;
    private String rtNameAr;
    private int rtNoOfBeds;
    private String roomTypeImage;
    private int hrpdMeals;
    private String mealsLa;
    private String mealsAr;
    private double purAmount;
    private double saleAmount;
    private int hrpdRoomView;
    private int hrpdSharing;
    private String sharingLa;
    private String sharingAr;
    private String hvNameLa;
    private String hvNameAr;
    private int hrpdSupplier;
}