package com.AdminPanel.Admin.service;

import com.AdminPanel.Admin.dto.UserDTO;
import com.AdminPanel.Admin.dto.request.RequestUserSaveDTO;
import com.AdminPanel.Admin.dto.request.RequestUserUpdateDTO;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {
    String addUser(RequestUserSaveDTO requestUserSaveDTO);

    UserDTO getUserById(int id);

    List<UserDTO> getByName(String username) throws NotFoundException;

    UserDTO getMemberByNIC(String nic);

    String updateUser(RequestUserUpdateDTO requestUserUpdateDTO);

    List<UserDTO> getAllUsers();
}
