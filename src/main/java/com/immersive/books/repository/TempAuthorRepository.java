package com.immersive.books.repository;

import com.immersive.books.domain.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TempAuthorRepository {
    private ArrayList<Author> authors = new ArrayList<>();

    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(this.authors.isEmpty() ? 0 : (long) this.authors.size());
            this.authors.add(author);
            return author;
        } else {
            for (Author e: this.authors) {
                if (e.getId().equals(author.getId())) {
                    e.setName(author.getName());
                    e.setBirthDate(author.getBirthDate());
                    e.setDeathDate(author.getDeathDate());
                    e.setPublishedBooks(author.getPublishedBooks());
                    return e;
                }
            }
            return null;
        }
    }

    public List<Author> findAllAuthors() {
        return this.authors;
    }

    public Author findAuthorById(Long authorId) {
        for (Author e: this.authors) {
            if (e.getId().equals(authorId)) return e;
        }

        return null;
    }

    public boolean removeAuthor (Long authorId) {
        for (Author e: this.authors) {
            if (e.getId().equals(authorId)) {
                this.authors.remove(e);
                return true;
            }
        }
        return false;
    }
}


