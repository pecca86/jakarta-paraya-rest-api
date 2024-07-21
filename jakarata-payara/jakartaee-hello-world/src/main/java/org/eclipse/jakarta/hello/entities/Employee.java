package org.eclipse.jakarta.hello.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.eclipse.jakarta.hello.dtos.Color;

import java.util.Date;

@Entity
@Table(name = "employee")
@ValidEmployee
public class Employee {

    public enum Gender {
        NA,
        FEMALE,
        MALE,
        OTHER
    }

    @Id
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "first_name")
    @NotEmpty
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE) // only date without time
    private Date hireDate;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING) // save the enum as string value, not enum index
    private Gender gender;

    @Column(name = "favorite_color")
    @Convert(converter = ColorConverter.class) // use the ColorConverter to serialize/deserialize Color
    private Color favoriteColor; // we need to add a converter class that tells how to serialize/deserialize Color

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Color getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(Color favoriteColor) {
        this.favoriteColor = favoriteColor;
    }
}
