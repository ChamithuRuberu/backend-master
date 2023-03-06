package com.AdminPanel.Admin.service;


import com.AdminPanel.Admin.dto.request.RequestBookingSaveDTO;

public interface BookingService {

    String addBooking(RequestBookingSaveDTO requestBookingSaveDTO);
}
