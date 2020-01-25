package com.book.repository;

import com.book.dto.AuthorDTO;
import com.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.ListIterator;

@Repository
public class AuthorRepository {
    private ArrayList<AuthorDTO> dtos;

    public AuthorRepository() {
        this.dtos = new ArrayList<>();
    }

    public AuthorDTO getAuthor(int id) {
        AuthorDTO dto = getAuthorDTO(id);

        return dto;
    }

    public void createAuthor(AuthorDTO dto) {
        this.dtos.add(dto);
    }

    public AuthorDTO getAuthorDTO(int id) {
        ListIterator<AuthorDTO> listIterator = dtos.listIterator();
        AuthorDTO currentAuthorDTO = null;
        boolean found = false;

        while (!found && listIterator.hasNext()) {
            currentAuthorDTO = listIterator.next();

            if (currentAuthorDTO.getId() == id) {
                found = true;
            }
        }

        return currentAuthorDTO;
    }

    public boolean exist(int id) { return dtos.stream().anyMatch(dto -> dto.getId() == id); }

    public void updateAuthor(int id, AuthorDTO dto) {
        ListIterator<AuthorDTO> listIterator = dtos.listIterator();
        AuthorDTO currentAuthorDTO ;
        boolean found = false;

        while (!found && listIterator.hasNext()) {
            currentAuthorDTO = listIterator.next();

            if (currentAuthorDTO.getId() == id) {
                listIterator.set(dto);
                found = true;
            }
        }
    }

    public void deleteAuthor(int id) {
        ListIterator<AuthorDTO> listIterator = dtos.listIterator();
        AuthorDTO currentAuthorDTO ;
        boolean found = false;

        while (!found && listIterator.hasNext()) {
            currentAuthorDTO = listIterator.next();

            if (currentAuthorDTO.getId() == id) {
                listIterator.remove();
                found = true;
            }
        }
    }

    public AuthorDTO addBook(int id, Book book) {
        ListIterator<AuthorDTO> listIterator = dtos.listIterator();
        AuthorDTO currentAuthorDTO = null;
        boolean found = false;

        while (!found && listIterator.hasNext()) {
            currentAuthorDTO = listIterator.next();

            if (currentAuthorDTO.getId() == id) {
                currentAuthorDTO.addBook(book);
              //  listIterator.set(currentAuthorDTO);
                found = true;
            }
        }

        return currentAuthorDTO;
    }

    public ArrayList<AuthorDTO> getAll() {
        return this.dtos;
    }

    public boolean existBook(int id, Book book) {
        AuthorDTO dto = getAuthor(id);

        if(dto.getBooks() != null) {
            return dto.getBooks().stream().anyMatch(
                    bookDTO ->
                            bookDTO.getName().equals(book.getName())
            );
        } else {
            return false;
        }
    }
}
