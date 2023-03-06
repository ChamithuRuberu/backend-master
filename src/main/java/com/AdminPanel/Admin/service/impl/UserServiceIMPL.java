package com.AdminPanel.Admin.service.impl;

import com.AdminPanel.Admin.dto.MovieDTO;
import com.AdminPanel.Admin.dto.UserDTO;
import com.AdminPanel.Admin.dto.request.RequestUserSaveDTO;
import com.AdminPanel.Admin.dto.request.RequestUserUpdateDTO;
import com.AdminPanel.Admin.entity.Movie;
import com.AdminPanel.Admin.entity.User;
import com.AdminPanel.Admin.repo.UserRepo;
import com.AdminPanel.Admin.service.UserService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addUser(RequestUserSaveDTO requestUserSaveDTO) {
        User user  = modelMapper.map(requestUserSaveDTO, User.class);
        if (! userRepo.existsById(user.getUserId())){
            return userRepo.save(user).getUserName();
        }
        return null;
    }

    @Override
    public UserDTO getUserById(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            UserDTO userDTO = modelMapper.map(user.get(), UserDTO.class);
            return userDTO;
        }
        return null;
    }

    @Override
    public List<UserDTO> getByName(String username) throws NotFoundException {
        List<User> members = userRepo.findAllByUserNameEquals(username);
        if (members.size() != 0) {
            // modelMapper........................................
            List<UserDTO> userDTOS = modelMapper.map(members, new TypeToken<List<UserDTO>>() {
            }.getType());
            return userDTOS;
        } else {
            throw new NotFoundException("not found that type of name");
        }
    }

    @Override
    public UserDTO getMemberByNIC(String nic) {
        Optional<User>member=userRepo.findByUserNicEquals(nic);
        if (member.isPresent()){
            UserDTO userDTO = modelMapper.map(member.get(),UserDTO.class);
            return userDTO;
        }
       return null;
    }

    @Override
    public String updateUser(RequestUserUpdateDTO requestUserUpdateDTO) {
        if (userRepo.existsById(requestUserUpdateDTO.getUserId())) {
            User user=userRepo.getById(requestUserUpdateDTO.getUserId());
            user.setPassword(requestUserUpdateDTO.getPassword());

            return userRepo.save(user).getUserName();
        }
        return "Not in DATABASE";
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> getUser = userRepo.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();

        List<UserDTO> userDTOS1 = modelMapper.
                map(getUser, new TypeToken<List<UserDTO>>() {
                }.getType());
        return userDTOS1;
    }
}
