package com.linktic.linktic_test.infrastructure.output.persistence.entity;

import jakarta.persistence.Column;
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
    @Column(name = "identification_number")
    private Long identificationNumber;
    @Column(name = "identification_type")
    private Integer identificationType;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
}
