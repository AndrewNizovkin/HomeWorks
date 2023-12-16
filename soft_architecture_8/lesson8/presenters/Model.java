package ru.geekbrains.lesson8.presenters;

import ru.geekbrains.lesson8.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Удаляет запись о регистрации с указанным ID для столика
     * с указанным номером и новая регистрация с новыми данными
     * @param oldReservation старый ID регистрации
     * @param reservationDate новая дата регистрации
     * @param tableNo номер столика
     * @param name Имя клиента
     * @return новый ID регистрации
     */
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);


    }
