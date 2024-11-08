package com.example.test_task.repository;

import com.example.test_task.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * This interface provides communication between the database and the service layer
 * @author Nizovkin A.V.
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {

}
