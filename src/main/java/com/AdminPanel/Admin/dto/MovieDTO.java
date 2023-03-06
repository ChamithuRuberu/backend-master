package com.AdminPanel.Admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private int MovieId;
    private String MovieName;
    private String description;
    private String releaseDate;
    private String Director;
    private int duration;
    private String photo;
    private boolean activestate;
}
