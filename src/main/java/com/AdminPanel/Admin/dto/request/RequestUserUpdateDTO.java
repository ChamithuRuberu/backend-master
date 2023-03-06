package com.AdminPanel.Admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserUpdateDTO {
    private int userId;
    private String password;
}
