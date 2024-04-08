package com.linktic.linktic_test.infrastructure.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "insured")
public class InsuredEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificationNumber;
    private Integer identificationType;
    private String lastName;
    private String firstName;
    private Integer gender;
    private LocalDate dateOfBirth;
}
