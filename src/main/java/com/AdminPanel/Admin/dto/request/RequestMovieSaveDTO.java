package com.AdminPanel.Admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMovieSaveDTO {
    private String MovieName;
    private String description;
    private String releaseDate;
    private String Director;
    private int duration;
    private String photo;
}
