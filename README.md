
# Запуск контейнера #

> docker-compose up 

# Запуск jar файла #

## для mysql ##

>java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar

## для postgresql #

>java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar


# Запуск тестов #

## для mysql ##

>./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app" allureServe

## для postgresql ##

>./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app" allureServe


# Генерация отчетов Allure #

## команды для генерации: ## 

> ./gradlew allureReport
>
> ./gradlew allureServe

## для завершения работы allureServe ##

> Выполнить команду: Ctrl + С

# Остановка работы контейнера #

> docker-compose down 