Для запуска сервиса с указанием пути к базе данных можно использовать следующие команды:
для mysql java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
для postgresql
java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
Запуск тестов также стоит выполнить с параметрами, указав путь к базе данных в командной строке:
для mysql
gradlew test -Ddb.url=jdbc:mysql://localhost:3306/app
для postgresql
gradlew test -Ddb.url=jdbc:postgresql://localhost:5432/app