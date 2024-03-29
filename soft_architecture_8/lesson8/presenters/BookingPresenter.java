package ru.geekbrains.lesson8.presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateUILoadTables(){
        view.showTables(model.loadTables());
    }

    public void updateUIReservationTableResult(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }


    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIReservationTableResult(reservationNo);
        }
        catch (Exception e){
            updateUIReservationTableResult(-1);
        }
    }

    /**
     * Удаляет запись о регистрации с указанным ID для столика
     * с указанным номером и новая регистрация с новыми данными
     *
     * @param oldReservation  старый ID регистрации
     * @param reservationDate новая дата регистрации
     * @param tableNo         номер столика
     * @param name            Имя клиента
     */
    @Override
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int reservationNo = model.changeReservationTable(oldReservation, reservationDate,tableNo, name);
        updateUIReservationTableResult(reservationNo);

    }
}
