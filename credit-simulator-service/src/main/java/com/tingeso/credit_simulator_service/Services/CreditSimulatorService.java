package com.tingeso.credit_simulator_service.Services;

import com.tingeso.credit_simulator_service.Entities.CreditSimulatorEntity;
import com.tingeso.credit_simulator_service.Repositories.CreditSimulatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditSimulatorService {
    @Autowired
    CreditSimulatorRepository creditSimulatorRepository;

    //Entregar todos los simuladores de crédito
    public List<CreditSimulatorEntity> listCreditSimulator() {return creditSimulatorRepository.findAll();}

    //Simulador de crédito. Ingresar monto del prestamo, periodo en años y tasa de inetres anual en decimal
    public Double simularCredito(Double montoPrestamoM, Integer plazoN, Double anualInteres){
        Integer totalPagosN = plazoN * 12;
        Double interesMensualR = (anualInteres / 12) / 100;
        System.out.println("Tasa Mensual: " + interesMensualR + ", Número de Pagos: " + totalPagosN + " MontoPrestamo:" + montoPrestamoM);

        //Aplicar formula
        Double arribaFormula = interesMensualR * Math.pow(1 + interesMensualR,totalPagosN);
        System.out.println("Tasa Mensual: " + interesMensualR + ", Número de Pagos: " + totalPagosN + "MontoPrestamo:" + montoPrestamoM + "denominador:" + arribaFormula);
        Double cuotaMensualM = (montoPrestamoM * ((interesMensualR * Math.pow(1 + interesMensualR, totalPagosN))/(Math.pow(1 + interesMensualR, totalPagosN) - 1)));
        return (double) Math.round(cuotaMensualM);
    }
}
