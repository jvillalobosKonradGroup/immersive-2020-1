package com.brainstation.Practice07.dao;

import com.brainstation.Practice07.dto.AuthorDTO;
import com.brainstation.Practice07.dto.BookDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorDAO {

    private List<AuthorDTO> authors;

    public AuthorDAO() {
        authors = new ArrayList<>();
    }

    /**
     *
     * @param authorDTO
     * @return
     */
    public AuthorDTO save(AuthorDTO authorDTO) {
        if (authorDTO.getId() != null) {
            for (AuthorDTO e : authors) {
                if (e.getId().equals(authorDTO.getId())) {
                    authors.set(authors.indexOf(e), authorDTO);
                }
            }
        } else {
            for (AuthorDTO e : authors) {
                if (e.getName().equals(authorDTO.getName())) return null;
            }
            authorDTO.setId((long) (authors.size()));
            authors.add(authorDTO);
        }

        return authorDTO;
    }

    public void delete(Long id) {
        for (AuthorDTO e : authors) {
            if (e.getId().equals(id)) {
                authors.remove(authors.indexOf(e));
            }
        }
    }

    public List<AuthorDTO> findAll() {
        return authors;
    }

    public AuthorDTO findByName(String name) {
        for (AuthorDTO e : authors) {
            if (e.getName().equals(name)) return e;
        }
        return null;
    }

    public BookDTO saveBook(BookDTO bookDTO, String authorName) {
        List<BookDTO> bookDTOS;
        for (AuthorDTO e : authors) {
            if (e.getName().equals(authorName)) {
                bookDTOS = e.getBooks();
                if (!bookDTOS.isEmpty()) {
                    for (BookDTO b : bookDTOS) {
                        if (b.getName().equals(bookDTO.getName())) {
                            return null;
                        }
                    }
                }
                bookDTO.setId((long) (bookDTOS.size()));
                bookDTOS.add(bookDTO);
                e.setBooks(bookDTOS);
            }
        }
        return bookDTO;

    }
}
