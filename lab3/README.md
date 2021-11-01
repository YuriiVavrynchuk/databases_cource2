1. Завдання виконується на основі спроектованої моделі БД в
лаб.роботі No1.
2. Для даної моделі слід здійснити повторний аналіз структури
БД на предмет забезпечення 3ї нормальної форми, наявності
усіх Primary Key.
3. Для реалізації БД написати сценарій для її створення у ядрі
MySQL, який повинен відповідати наступним критеріям:
- SQL-скріпт можна запускати декілька раз підряд і при
цьому не повинні з’являтися помилки через існуючі
елементи БД. Тобто повинні бути передбачені відповідні
DROP для таблиць та IF EXISTS на створення БД.
- Для кожної таблиці слід здійснити заповнення даними по
10-15 INSERT, при цьому передбачити правильний
порядок вставки даних.
- Створити для таблиць як мінімум 2 додаткові індекси,
згідно виконаного попереднього аналізу структури даних.