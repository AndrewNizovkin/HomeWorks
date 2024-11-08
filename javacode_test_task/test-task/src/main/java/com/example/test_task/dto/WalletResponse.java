package com.example.test_task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * This class is used to transfer data
 * between application subsystems.
 * @author Nizovkin A.V.
 */
@Data
@NoArgsConstructor
public class WalletResponse {

    private UUID walletId;

    private long balance;

}
