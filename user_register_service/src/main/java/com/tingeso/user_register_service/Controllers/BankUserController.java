package com.tingeso.user_register_service.Controllers;

import com.tingeso.user_register_service.Entities.BankUserEntity;
import com.tingeso.user_register_service.Services.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bankUser")
@CrossOrigin("*")
public class BankUserController {
    @Autowired
    BankUserService bankUserService;

    @GetMapping("/getAll")
    public ResponseEntity<List<BankUserEntity>> listBankUser(){
        List<BankUserEntity> bankUsers = bankUserService.getBankUsers();
        return ResponseEntity.ok(bankUsers);
    }
    //String rutUser, String userType, LocalDate userBirth, Double userIncome, Integer employeeAntiquity, Integer hasDicom
    @PostMapping("/creatBankUser/{rutUser}/{userType}/{userBirth}/{userIncome}/{employeeAntiquity}/{hasDicom}/{email}/{password}")
    public ResponseEntity<BankUserEntity> createBankUser(@PathVariable("rutUser") String rutUser,
                                                         @PathVariable("userType") String userType,
                                                         @PathVariable("userBirth") LocalDate userBirth,
                                                         @PathVariable("userIncome") Double userIncome,
                                                         @PathVariable("employeeAntiquity") Integer employeeAntiquity,
                                                         @PathVariable("hasDicom") Integer hasDicom,
                                                         @PathVariable("email") String email,
                                                         @PathVariable("password") String password){
        BankUserEntity newBankUser = bankUserService.createBankUser(rutUser,userType,userBirth,userIncome,employeeAntiquity,hasDicom,email,password);
        return ResponseEntity.ok(newBankUser);
    }



}
