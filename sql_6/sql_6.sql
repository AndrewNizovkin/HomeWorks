-- ДЗ: Для решения использовать БД semimar_4

USE semimar_4;

-- 1. Создайте таблицу user_old, аналогичную таблице users. Создайте процедуру, 
-- с помощью которой можно переместить любого (одного) пользователя из таблицы
-- users в таблицу users_old. (использование транзакции с выбором commit или rollback 
-- - обязательно)

DROP TABLE IF EXISTS user_old;
CREATE TABLE user_old (
	id SERIAL PRIMARY KEY,
    firstname VARCHAR(50),
    lastname VARCHAR(50) COMMENT 'Фамилия',
    email VARCHAR(120) UNIQUE
);

DROP PROCEDURE IF EXISTS move_user;
DELIMITER //
CREATE PROCEDURE move_user (moved_id INT)
BEGIN
  START TRANSACTION;
  IF(SELECT u.id FROM users AS u WHERE u.id = moved_id) THEN
    SET @id := (SELECT u.id FROM users AS u WHERE u.id = moved_id);
    SET @firstname := (SELECT u.firstname FROM users AS u WHERE u.id = moved_id);
    SET @lastname := (SELECT u.lastname FROM users AS u WHERE u.id = moved_id);
    SET @email := (SELECT u.email FROM users AS u WHERE u.id = moved_id);

    INSERT user_old VALUES 
    (@id, @firstname, @lastname, @email);
  
    DELETE FROM users
    WHERE users.id = moved_id;
    COMMIT;
  ELSE
    SELECT "Нет такого пользователя в users" AS error;
	ROLLBACK;
  END IF;
END //
DELIMITER ;

CALL move_user (1);
CALL move_user (2);
CALL move_user (10);
  
SELECT * FROM users;
SELECT * FROM user_old;


-- 2. Создайте хранимую функцию hello(), которая будет возвращать приветствие, 
-- в зависимости от текущего времени суток. С 6:00 до 12:00 функция должная возвращать
-- фразу "Доброе утро", с 12:00 до 18:00 функция должна возвращать фразу "Добрый день", 
-- с 18:00 до 00:00 - "Дообрый вечер", с 00:00 до 6:00 - "Доброй ночи".

DROP FUNCTION IF EXISTS welcome;
DELIMITER //
CREATE FUNCTION welcome() 
RETURNS TEXT DETERMINISTIC
BEGIN
  SET @current_time := CAST(CURRENT_TIME() AS TIME);
  SET @midnight := CAST('0:00:00' AS TIME);
  SET @morning := CAST('6:00:00' AS TIME);
  SET @midday := CAST('12:00:00' AS TIME);
  SET @evening := CAST('18:00:00' AS TIME);
  SET @result := "Добрый вечер";

  IF(@current_time >= @midnight AND @current_time < @morning) THEN
    SET @result := "Доброй ночи";
  END IF;

  IF(@current_time >= @morning AND @current_time < @midday) THEN
    SET @result := "Доброе утро";
  END IF;

  IF(@current_time >= @midday AND @current_time < @evening) THEN
    SET @result := "Добрый день";
  END IF;
  
RETURN @result;
END //
DELIMITER ;

SELECT welcome();
