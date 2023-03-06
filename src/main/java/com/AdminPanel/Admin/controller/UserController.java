package com.AdminPanel.Admin.controller;


import com.AdminPanel.Admin.dto.MovieDTO;
import com.AdminPanel.Admin.dto.UserDTO;
import com.AdminPanel.Admin.dto.request.RequestUserSaveDTO;
import com.AdminPanel.Admin.dto.request.RequestUserUpdateDTO;
import com.AdminPanel.Admin.service.UserService;
import com.AdminPanel.Admin.util.FileUploadUtil;
import com.AdminPanel.Admin.util.StanderResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
   private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<StanderResponse> saveUser(@RequestBody RequestUserSaveDTO requestUserSaveDTO) {
        String id=userService.addUser(requestUserSaveDTO);
        return new ResponseEntity<StanderResponse>(
                new StanderResponse(201,id+" Saved Succecfully ",id),
                HttpStatus.CREATED
        );
    }
    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public UserDTO getUserById(@RequestParam(value = "id") int id) {
        UserDTO userDTO = userService.getUserById(id);
        return userDTO;
    }

    @GetMapping(
            path = {"/get-by-name"},
            params={"name"}
    )
    public List<UserDTO> getmemberbyname(@RequestParam(value = "name")String username) throws NotFoundException {
        List<UserDTO>getUser=userService.getByName(username);
        return getUser;
    }

    @GetMapping(
            path = "/get-by-Nic",
            params = "Nic"
    )
    public UserDTO GetMemberByNIC(@RequestParam(value = "Nic") String nic) {
        UserDTO memberDTO = userService.getMemberByNIC(nic);
        return memberDTO;
    }

    @PutMapping("/updateUser")
    public String updateMameber(@RequestBody RequestUserUpdateDTO requestUserUpdateDTO) {
        String updated = userService.updateUser(requestUserUpdateDTO);
        return updated + "updated";
    }

    @GetMapping(
            path = "get-all-Users"
    )
    public ResponseEntity<StanderResponse> getAllUsers() {

        List<UserDTO> userDTOS = userService.getAllUsers();
        return new ResponseEntity<StanderResponse>(

                new StanderResponse(200," done",userDTOS),
                HttpStatus.OK
        );
    }
    @PostMapping("/uploadImg")
    public void saveImag(@RequestParam ("files")MultipartFile[] files){

    }
}
