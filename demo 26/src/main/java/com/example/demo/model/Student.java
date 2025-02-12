package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "dob_year")
    private int dobYear;

    @Column(name = "dob_month")
    private int dobMonth;

    @Column(name = "dob_day")
    private int dobDay;

    @Transient
    private int age;


    public Student(String name, int dobYear, int dobMonth, int dobDay) {
        this.name = name;
        this.dobYear = dobYear;
        this.dobMonth = dobMonth;
        this.dobDay = dobDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDobYear() {
        return dobYear;
    }

    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }

    public int getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(int dobMonth) {
        this.dobMonth = dobMonth;
    }

    public int getDobDay() {
        return dobDay;
    }

    public void setDobDay(int dobDay) {
        this.dobDay = dobDay;
    }

    public int getAge() {
        // Calculate age based on the current date and DOB
        LocalDate birthDate = LocalDate.of(dobYear, dobMonth, dobDay);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
