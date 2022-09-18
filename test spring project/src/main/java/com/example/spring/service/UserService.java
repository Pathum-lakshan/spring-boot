package com.example.spring.service;


import com.example.spring.dto.UserDTO;
import com.example.spring.entity.User;
import com.example.spring.repo.UserRep;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRep userRep;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO) {
        userRep.save(modelMapper.map(userDTO, User.class));

        return userDTO;
    }
    public Boolean deleteUser(UserDTO userDTO) {
        userRep.delete(modelMapper.map(userDTO, User.class));

       return true;
    }
    public UserDTO updateUser(UserDTO userDTO) {
         userRep.save(modelMapper.map(userDTO, User.class));

        return userDTO;
    }
    public List<UserDTO> getAllUsers(){
        List<User> all = userRep.findAll();
        return modelMapper.map(all,new TypeToken<List<UserDTO>>(){}.getType());
    }
}
