## Ручное тестирование с помощью Postman

Поднимем базу данных и приложение на localhost:8080 и протестируем наши эндпоинты:

### Получить все записи:

![all records](./images/scr-2.png)

### Вывести сумму с баланса кошелька, меньшую, чем баланс:

![withdraw](./images/scr-3.png)

### Вывести сумму, превышающую баланс кошелька

![withdraw not funds](./images/scr-4.png)

### Вывести все деньги с баланса

![withdraw all](./images/scr-5.png)

### Внести депозит на баланс кошелька

![deposit](./images/scr-6.png)

### Выполнить запрос с некорректным значением `operationType`

![unknoun operation type](./images/scr-7.png)

### Выполнить запрос на изменение кошелька при отсутсвии такого в бд

![changeWallet not found ](./images/scr-8.png)

### Получить баланс кошелька с указанным ID

![wallet balance](./images/scr-9.png)

### Выполнить запрос на получение баланса кошелька, не существующего в бд

![not found wallet](./images/scr-10.png)

### Результаты тестов приложения

![tests](./images/scr-1.png)