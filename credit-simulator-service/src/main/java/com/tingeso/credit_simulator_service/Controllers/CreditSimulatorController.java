package com.tingeso.credit_simulator_service.Controllers;


import com.tingeso.credit_simulator_service.Entities.CreditSimulatorEntity;
import com.tingeso.credit_simulator_service.Services.CreditSimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api/v1/creditSimulator/getAll
//http://localhost:8080/api/v1/creditSimulator/100000000/20/4.5
@RestController
@RequestMapping("/api/v1/creditSimulator")
public class CreditSimulatorController {
    @Autowired
    CreditSimulatorService creditSimulatorService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CreditSimulatorEntity>> getAllCreditSimulator(){
        List<CreditSimulatorEntity> creditSimulatorList = creditSimulatorService.listCreditSimulator();
        return ResponseEntity.ok(creditSimulatorList);
    }

    @GetMapping("/{montoPrestamoM}/{plazoN}/{anualInteres}")
    public ResponseEntity<Double> getCreditSimulatorAmount(@PathVariable("montoPrestamoM") Double montoPrestamoM, @PathVariable("plazoN") Integer plazoN, @PathVariable("anualInteres") Double anualInteres){
        Double creditSimulatorAmount = creditSimulatorService.simularCredito(montoPrestamoM,plazoN,anualInteres);
        return ResponseEntity.ok(creditSimulatorAmount);
    }
}
