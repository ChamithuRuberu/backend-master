package com.AdminPanel.Admin.dto.request;
import com.AdminPanel.Admin.entity.BookingDeails;
import com.AdminPanel.Admin.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBookingSaveDTO {

    private Date date;
    private Double TotalPrice;
    private int userid;
    private List<RequestBookingSaveDetailsDTO> requestBookingSaveDetailsDTOS;

}
