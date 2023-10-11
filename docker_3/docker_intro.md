# ДЗ-3: "Введение в Docker"

> Задание:
> 1. запустить контейнер с БД mariaDB, используя инструкции на сайте: https://hub.docker.com/
> 2. добавить в контейнер hostname такой же, как hostname системы через переменную (-h аргумент)
> 3. заполнить БД данными через консоль
> 4. запустить phpmyadmin (в контейнере) и через веб проверить, что все введенные данные доступны
> 5. *(не обязательно) натсроить связку postgresql + adminer

Ищем на [hub.docker.com](https://hub.docker.com/) mariadb и читаем документацию.

Создаём папку с которой свяжем базу данных из контейнера:

`mkdir mymariadb`

Запускаем контейнер:

`docker run --name mariadb-container -d -v /home/andrew/mymariadb:/var/lib/mysql -e MARIADB_ROOT_PASSWORD=0208 mariadb:10.10.2`

`docker ps`

![scr_1](/images/scr_1.jpg)

Заходим в контейнер из в базу данных:

```
docker exec -it <id> bash
mysql -u root -p
```

Создаём базу данных, добавляем таблицу.

```
CREATE DATABASE test1;
CREATE TABLE test1.table (id INT, volume CHAR);
SHOW DATABASES;
```

![scr_2](/images/scr_2.jpg)

```
USE test1;
SHOW TABLES;
```

![scr_3](/images/scr_3.jpg)

---

Ищем на [hub.docker.com](https://hub.docker.com/) phpmyadmin и читаем документацию.

`docker run --name myphpmyadmin -d --link mariadb-container:db -p 8081:80 phpmyadmin`

`docker ps`

![scr_4](/images/scr_4.jpg)

В браузере заходим на localhost:8081

![scr_5](/images/scr_5.jpg)

Останавливаем все контейнеры и очищаем систему от всего ненужного:

```
docker stop $(docker ps -aq)
docker system prune -af
```
