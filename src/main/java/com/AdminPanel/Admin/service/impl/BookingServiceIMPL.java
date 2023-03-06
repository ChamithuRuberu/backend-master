package com.AdminPanel.Admin.service.impl;

import com.AdminPanel.Admin.dto.request.RequestBookingSaveDTO;
import com.AdminPanel.Admin.entity.Booking;
import com.AdminPanel.Admin.entity.BookingDeails;
import com.AdminPanel.Admin.repo.BookinDetailsRepo;
import com.AdminPanel.Admin.repo.BookingRepo;
import com.AdminPanel.Admin.repo.MovieRepo;
import com.AdminPanel.Admin.repo.UserRepo;
import com.AdminPanel.Admin.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingServiceIMPL implements BookingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private BookinDetailsRepo bookinDetailsRepo;

    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private UserRepo userRepo;


    @Override
    @Transactional
    public String addBooking(RequestBookingSaveDTO requestBookingSaveDTO) {
        Booking booking = new Booking(

                requestBookingSaveDTO.getDate(),
                requestBookingSaveDTO.getTotalPrice(),
                userRepo.getById(requestBookingSaveDTO.getUserid())
        );
        bookingRepo.save(booking);

        if (bookingRepo.existsById(booking.getBookingId())){
            List<BookingDeails>bookingDeails=modelMapper.
                    map(requestBookingSaveDTO.getRequestBookingSaveDetailsDTOS(),new TypeToken<List<BookingDeails>>(){
                    }.getType());


            for (int i=0;i<bookingDeails.size();i++){
                bookingDeails.get(i).setBooking_id(booking);
                bookingDeails.get(i).setMovie_id(movieRepo.getById(requestBookingSaveDTO.getRequestBookingSaveDetailsDTOS().get(i).getMovie()));
            }
            if (bookingDeails.size()>0){
                bookinDetailsRepo.saveAll(bookingDeails);
            }

        }
        return "Booking saved";
    }
}
