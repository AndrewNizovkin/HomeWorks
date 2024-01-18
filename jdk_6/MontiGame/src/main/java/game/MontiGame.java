package game;

import java.util.*;

public class MontiGame {
    private static int counter;
    private int wins;
    private int loss;
    private HashMap<Integer, Boolean> log;
    private Random random;
    private List<Door> doors;

    public MontiGame() {
        random = new Random();
        doors = new ArrayList<>();
        log = new HashMap<>();
        fillDoors();
    }

    /**
     * Первый ход игрока
     */
    public void playerFirstMove() {
        doors.get(random.nextInt(3)).setMarked(true);
    }

    /**
     * Монти открывает дверь
     */
    public void montiOpenDoor() {
        int index;
        while (true) {
            index = random.nextInt(3);
            if (!doors.get(index).isMarked() && !doors.get(index).isPrize()) {
                doors.get(index).setOpen(true);
                return;
            }
        }
    }

    /**
     * Игрок меняет выбор
     */
    public void playerChangesChoice() {
        doors.forEach(x -> {
            if (!x.isOpen()) x.setMarked(!x.isMarked());
        });
    }

    /**
     * Записывает результат в лог
     */
    public void logResult() {
        log.put(counter, getResult());
    }

    /**
     * Возвращает результат игры
     * @return
     */
    public boolean getResult() {
        for (Door door: doors) {
            if (door.isMarked() && door.isPrize()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Выводит результаты игры
     */
    public void showStatistic() {
        calculate();
        for (Map.Entry<Integer, Boolean> set: log.entrySet()) {
            System.out.println("Итерация: " + set.getKey() + "  Результат: " + set.getValue());
        }
        System.out.println("-".repeat(30));
        System.out.println("Всего игр:" + log.size());
        System.out.println("Побед:" + wins);
        System.out.println("Поражений:" + loss);
    }

    /**
     * Проводит статистический анализ сыгранных партий
     */
    private void calculate() {
        wins = 0;
        loss = 0;
        for (Boolean res: log.values()) {
            if (res) {
                wins++;
            } else {
                loss++;
            }
        }
    }

    /**
     * Выполняет начальные установки игры
     */
    public void startGame() {
        counter++;
        doors.forEach(x -> {
            x.setMarked(false);
            x.setOpen(false);
            x.setPrize(false);
        });
        doors.get(random.nextInt(3)).setPrize(true);

    }

    /**
     * Заполняет массив дверей
     */
    private void fillDoors() {
        for (int i = 0; i < 3; i++) {
            doors.add(new Door());
        }

    }
}
