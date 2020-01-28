package com.brainstation.Practice07.dao;

import com.brainstation.Practice07.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private List<UserDTO> userDTOS;


    public UserDAO() {
        userDTOS = new ArrayList<>();
    }


    public UserDTO save(UserDTO userDTO){
        for(UserDTO u : userDTOS){
            if(u.getUsername().equals(userDTO.getUsername())){
                return null;
            }
        }
        userDTO.setId((long)userDTOS.size());
        userDTOS.add(userDTO);

        return userDTO;
    }

    public UserDTO findByUsername(String username){
        for(UserDTO u : userDTOS){
            if (u.getUsername().equals(username))return u;
        }

         return null;
    }
}
