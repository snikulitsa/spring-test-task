# Spring test task

> Примечание: не стоит смотреть на код фронтенда, он сгенерирован при помощи Jhipster и немного подправлен.

## Задача:
1. Регистрация пользователя (на вход подаётся email)
2. Генерируется случайный пароль
3. Пароль отправляется на почту
4. Пользователь может авторизоваться по адресу почты и полученному паролю.
5. Не авторизованного пользователя должно перебрасывать на страницу входа в случае попытки обращения к странице личного кабинета.
6. В случае если пользователь успешно авторизовался необходимо вывести страницу с текстом "Вы успешно авторизовались" и кнопкой Выход

## Стек технологий:
1. Spring Boot
2. Spring Security
3. Hibernate
4. MySQL либо Postgres

## Запуск
> npm 6.4.1, nodejs 8.12, java 8

в application.properties прописать настройки почты и БД
```
gradle bootRun
npm start
```