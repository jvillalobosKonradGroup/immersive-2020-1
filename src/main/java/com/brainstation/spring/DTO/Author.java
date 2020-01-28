package com.brainstation.spring.DTO;

import com.brainstation.spring.models.AuthorModel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "birth_place")
    private String birthPlace;
    @Column(name="death_date")
    private LocalDate deathDate;
    @Column(name = "id_book")
    private Long idBook;

    public Author(){

    }

    public Author(AuthorModel authorModel){
        this.name = authorModel.getName();
        this.lastName = authorModel.getLastName();
        this.birthDate = authorModel.getBirthDate();
        this.birthPlace = authorModel.getBirthPlace();
        this.deathDate = authorModel.getDeathDate();
        this.idBook = authorModel.getIdBook();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

}
