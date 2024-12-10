package com.tingeso.user_register_service.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "bank_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idBankUser;
    //Rut del usuario para identificarlo
    private String rutUser;
    //Tipo de trabajo del usuario, es decir dependiente o independiente
    private String userType;
    //Fecha del nacimiento del usuario para calcular la edad actual
    private LocalDate userBirth;
    //Ingresos del usuario
    private Double userIncome;
    //Antigüedad en su trabajo en años (evaluando si en meses)
    private Integer employeeAntiquity;
    //Booleano que verifica si el usuario pertenece a dicom. 0 = falso y 1 = verdadero
    private Integer hasDicom;
    //rutUser,userType,userBirth,userIncome,employeeAntiquity,hasdicom
    private String email;
    private String password;
}
