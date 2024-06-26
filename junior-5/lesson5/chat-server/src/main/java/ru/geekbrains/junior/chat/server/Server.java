package ru.geekbrains.junior.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //region Поля

    /**
     * Серверный сокет
     */
    private final ServerSocket serverSocket;

    //endregion

    //region Конструкторы

    /**
     * Инициализация серверного сокета
     * @param serverSocket серверный сокет
     */
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    //endregion

    /**
     * Запускает сервер.
     * При подключении нового клиента запускает новый поток
     */
    public void runServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Подключен новый клиент!");
                ClientManager clientManager = new ClientManager(socket);
                Thread thread = new Thread(clientManager);
                thread.start();
            }
        }
        catch (Exception e){
            closeServerSocket();
        }
    }

    /**
     * Закрытие объекта ServerSocket, в случае возникновения исключения
     */
    private void closeServerSocket(){
        try{
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
