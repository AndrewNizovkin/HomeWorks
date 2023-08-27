-- ДЗ: Для решения использовать БД semimar_4

USE semimar_4;

-- 1. Создайте представление, в которое попадает информация о пользователях 
-- (имя, фамилия, город и пол), 
-- которые не старше 20 лет.

CREATE OR REPLACE VIEW users_up_to_20 AS
(
SELECT u.firstname, u.lastname, p.hometown, p.gender
  FROM users AS u
  JOIN profiles AS p
    ON u.id = p.user_id
 WHERE ((CAST( NOW() as DATE ) - p.birthday) / 10000) < 20
);
SELECT * FROM users_up_to_20;

-- 2. Найдите кол-во, отправленных сообщений каждым пользователем и 
-- выведите ранжированный список пользователей, 
-- указав имя и фамилию пользователя, 
-- количество отправленных сообщений и 
-- место в рейтинге (первое место у пользователя с максимальным количеством сообщений). 
-- (используйте DENSE_RANK).

WITH count_message AS
(
SELECT u.firstname, u.lastname,
COUNT(*) AS count_messages
FROM users AS u
JOIN messages AS m
ON u.id = m.from_user_id
GROUP BY m.from_user_id
)
SELECT c.firstname , c.lastname, c.count_messages,
DENSE_RANK() OVER(ORDER BY c.count_messages DESC) AS 'rank'
FROM count_message AS c;

-- 3. Выберите все сообщения, отсортируйте сообщения по возрастанию даты отправления 
-- (created_at) и найдите разницу дат отправления между соседними сообщениями, 
-- получившегося списка. (используйте LEAD или LAG)

SELECT m.id, m.created_at,
(m.created_at - LAG(m.created_at) OVER(ORDER BY created_at)) AS 'difference'
FROM messages AS m;