package com.AdminPanel.Admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int userId;
    private String  userName;
    private String userNic;
    private int memberContact;
    private String userEmail;
    private String password;
    private boolean activestate;
}
