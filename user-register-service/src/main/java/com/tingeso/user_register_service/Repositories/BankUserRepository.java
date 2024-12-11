package com.tingeso.user_register_service.Repositories;

import com.tingeso.user_register_service.Entities.BankUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankUserRepository extends JpaRepository<BankUserEntity, Long> {
    //Encontrar usuario del banco por Rut
    public BankUserEntity findByRutUser(String rutUser);

}
