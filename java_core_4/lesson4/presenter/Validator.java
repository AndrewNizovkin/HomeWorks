package ru.geekbrains.core.lesson4.presenter;

import ru.geekbrains.core.lesson4.models.InsufficientFundsException;

public interface Validator {

    /**
     * Checks the validity of the amount
     * @param amount amount
     * @return
     */
    boolean checkAmount(double amount);

    /**
     * Checks availability of funds in the account
     * @param debet
     * @param credit
     * @return
     * @throws InsufficientFundsException
     */
    boolean checkBalance(double debet, double credit) throws InsufficientFundsException;
}
