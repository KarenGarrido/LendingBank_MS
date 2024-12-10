package com.tingeso.credit_simulator_service.Repositories;

import com.tingeso.credit_simulator_service.Entities.CreditSimulatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditSimulatorRepository extends JpaRepository<CreditSimulatorEntity, Long> {
}
