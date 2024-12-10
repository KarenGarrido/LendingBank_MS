package com.tingeso.user_register_service.Services;

import com.tingeso.user_register_service.Entities.BankUserEntity;
import com.tingeso.user_register_service.Repositories.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class BankUserService {
    @Autowired
    BankUserRepository bankUserRepository;

    //Obtener el listado de los usuarios
    public ArrayList<BankUserEntity> getBankUsers() {return (ArrayList<BankUserEntity>) bankUserRepository.findAll();}

    public BankUserEntity getBankUserByRut(String rutUser) {return bankUserRepository.findByRutUser(rutUser);}

    //Registrar un usuario
    //rutUser,userType,userBirth,userIncome,employeeAntiquity,hasdicom
    public BankUserEntity createBankUser(String rutUser, String userType, LocalDate userBirth, Double userIncome, Integer employeeAntiquity, Integer hasDicom, String email, String password) {
        BankUserEntity newBankUser = new BankUserEntity();

        //Revisar que el usuario exista
        BankUserEntity bankUserExist = bankUserRepository.findByRutUser(rutUser);
        //Si el usuario existe, retorna null ya que no se permite crear un usuario con un que ya existe
        if(bankUserExist != null){
            System.out.println("Ya existe un usuario con este run.");
            return null;
        }
        //Si el resultado es null, proceso a crear el usuario
        else{
            newBankUser.setRutUser(rutUser);
            newBankUser.setUserType(userType);
            newBankUser.setUserBirth(userBirth);
            newBankUser.setUserIncome(userIncome);
            newBankUser.setEmployeeAntiquity(employeeAntiquity);
            newBankUser.setHasDicom(hasDicom);
            newBankUser.setEmail(email);
            newBankUser.setPassword(password);
            System.out.println("Usuario creado con exito");
            return bankUserRepository.save(newBankUser);
        }

    }


}
