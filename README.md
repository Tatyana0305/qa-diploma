## Описание сервиса ##

>Данный проект представляет собой автоматизацию тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка
> Приложение представляет из себя веб-сервис.
> Приложение предлагает купить тур по определённой цене с помощью двух способов:
>-Обычная оплата по дебетовой карте
>-Уникальная технология: выдача кредита по данным банковской карты
>Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:

>-сервису платежей (далее - Payment Gate)
>-кредитному сервису (далее - Credit Gate)
>Приложение должно в собственной СУБД сохранять информацию о том, каким способом был совершён платёж и успешно ли он был совершён (при этом данные карт сохранять не допускается).
> 

## Запуск контейнера ##

> docker-compose up 

## Запуск jar файла ##

### для mysql ###

>java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar

### для postgresql ###

>java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar


## Запуск тестов ##

### для mysql ###

>./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app" allureServe

### для postgresql ###

>./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app" allureServe


## Генерация отчетов Allure ##

### команды для генерации: ### 

> ./gradlew allureReport
>
> ./gradlew allureServe

### для завершения работы allureServe ###

> Выполнить команду: Ctrl + С

## Остановка работы контейнера ##

> docker-compose down 