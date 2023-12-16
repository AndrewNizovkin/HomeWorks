package ru.geekbrains.lesson8.models;

import ru.geekbrains.lesson8.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableService implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {

        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    /**
     * Удаляет запись о регистрации с указанным ID для столика
     * с указанным номером и новая регистрация с новыми данными
     * @param oldReservation старый ID регистрации
     * @param reservationDate новая дата регистрации
     * @param tableNo номер столика
     * @param name Имя клиента
     * @return новый ID регистрации
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table: tables) {
            if (table.getNo() == tableNo) {
                table.getReservations().removeIf(x -> x.getId() == oldReservation);
                return reservationTable(reservationDate, tableNo, name);
            }
        }
        return -1;
    }
}