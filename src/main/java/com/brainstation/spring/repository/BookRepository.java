package com.brainstation.spring.repository;

import com.brainstation.spring.DTO.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(
            value = "select count(*) from book where name = :name",
            nativeQuery = true)
    int findByName(String name);

}
