package com.example.test_task.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * This class provides the Wallet entity
 * @author Nizovkin A.V.
 */
@Entity
@Data
@Table(name = "wallets")
@NoArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "balance")
    private long balance;


}
