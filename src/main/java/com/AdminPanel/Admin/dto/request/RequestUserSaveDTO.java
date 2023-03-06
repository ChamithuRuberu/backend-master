package com.AdminPanel.Admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserSaveDTO {

    private String  userName;
    private String userNic;
    private int memberContact;
    private String userEmail;
    private String password;
}
