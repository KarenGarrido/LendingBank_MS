package com.tingeso.credit_simulator_service.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "credit_simulator")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditSimulatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idCreditSimulator;
    private Long montoPrestamoM;
    private Integer plazoN;
    private Float anualInteres;




}
