-- 1. Подсчитать общее количество лайков, которые получили пользователи младше 12 лет.

SELECT COUNT(*) AS likes_for_users_up_to_12
  FROM likes
  JOIN users ON likes.user_id = users.id
  JOIN profiles ON users.id = profiles.user_id
 WHERE FLOOR((CAST( NOW() as DATE ) - profiles.birthday) / 10000) < 12;
 
-- 2. Определить кто больше поставил лайков (всего): мужчины или женщины.

SELECT IF (
(SELECT COUNT(*)
  FROM likes
  JOIN users ON likes.user_id = users.id
  JOIN profiles ON users.id = profiles.user_id
 WHERE profiles.gender = 'm')
> (SELECT COUNT(*)
  FROM likes
  JOIN users ON likes.user_id = users.id
  JOIN profiles ON users.id = profiles.user_id
 WHERE profiles.gender = 'f'),
 "Men",
 "Women"
) AS more_likes;

-- 3. Вывести всех пользователей, которые не отправляли сообщения.

SELECT u.id, u.firstname, u.lastname, IF (
m.from_user_id IS NULL,
"didn't send messages",
"send message"
) AS status
FROM users AS u
LEFT JOIN messages AS m ON u.id = m.from_user_id
WHERE m.from_user_id IS NULL;

