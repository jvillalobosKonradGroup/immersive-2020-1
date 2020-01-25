package com.book.repository;

import com.book.dto.AuthorDTO;
import com.book.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.ListIterator;

@Repository
public class UserRepository {
    private ArrayList<UserDTO> dtos;

    public UserRepository() {
        this.dtos = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("aduarte");
        userDTO.setPassword("patito");
        this.dtos.add(userDTO);

        userDTO = new UserDTO();
        userDTO.setUsername("rdak");
        userDTO.setPassword("patito2");
        this.dtos.add(userDTO);

    }

    public UserDTO getUser(String username) {
        ListIterator<UserDTO> listIterator = dtos.listIterator();
        UserDTO currentUserDTO = null;
        boolean found = false;

        while (!found && listIterator.hasNext()) {
            currentUserDTO = listIterator.next();

            if (currentUserDTO.getUsername().equals(username)) {
                found = true;
            }
        }

        return currentUserDTO;
    }

    public boolean verifyPassword(UserDTO dto) {
        boolean correctPassword = false;
        UserDTO userDTO = getUser(dto.getUsername());

        // Username doesnt exist
        if(userDTO != null) {
            correctPassword = dto.getPassword().equals(userDTO.getPassword());
        }

        return correctPassword;
    }
}
