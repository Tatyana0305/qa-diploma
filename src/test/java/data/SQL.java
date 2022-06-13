package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQL {
    private static String url = System.getProperty("db.url");
    private static String user = System.getProperty("db.user");
    private static String password = System.getProperty("db.password");


    @SneakyThrows
    public static Integer getAmountDebitCard() {
        QueryRunner runner = new QueryRunner();
        try (
                Connection conn = DriverManager.getConnection(
                        url, user, password);
        ) {
            return runner.query(conn, "SELECT amount FROM payment_entity " +
                            "ORDER BY created DESC",
                    new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static String getStatusPayCard() {
        QueryRunner runner = new QueryRunner();
        try (
                Connection conn = DriverManager.getConnection(
                        url, user, password);
        ) {
            return runner.query(conn, "SELECT status FROM payment_entity " +
                            "ORDER BY created DESC",
                    new ScalarHandler<>());
        }
    }


    @SneakyThrows
    public static String getStatusPayCredit() {
        QueryRunner runner = new QueryRunner();
        try (
                Connection conn = DriverManager.getConnection(
                        url, user, password);
        ) {
            return runner.query(conn, "SELECT status FROM credit_request_entity " +
                            "ORDER BY created DESC",
                    new ScalarHandler<>());
        }

    }

    @SneakyThrows
    public static String getTransactionIdPayCard() {
        QueryRunner runner = new QueryRunner();
        try (
                Connection conn = DriverManager.getConnection(
                        url, user, password);
        ) {
            return runner.query(conn, "select transaction_id from payment_entity pe " +
                            "order by created desc",
                    new ScalarHandler<>());
        }
    }


    @SneakyThrows
    public static String getBankIdCreditCard() {
        QueryRunner runner = new QueryRunner();
        try (
                Connection conn = DriverManager.getConnection(
                        url, user, password);
        ) {

            return runner.query(conn, "select bank_id from credit_request_entity cre " +
                            "order by created desc",
                    new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static String getCreditId() {
        QueryRunner runner = new QueryRunner();
        try (
                Connection conn = DriverManager.getConnection(
                        url, user, password);
        ) {
            return runner.query(conn, "select credit_id from order_entity oe " +
                            "order by created desc",
                    new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static String getPaymentId() {
        QueryRunner runner = new QueryRunner();
        try (
                Connection conn = DriverManager.getConnection(
                        url, user, password);
        ) {
            return runner.query(conn, "select payment_id from order_entity oe " +
                            "order by created desc",
                    new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static void deleteTables() {
        QueryRunner runner = new QueryRunner();
        String deleteCredit = "DELETE FROM credit_request_entity";
        String deleteOrder = "DELETE FROM order_entity";
        String deletePayment = "DELETE FROM payment_entity";
        try (
                Connection conn = DriverManager.getConnection(
                        url, user, password);
        ) {
            runner.update(conn, deleteCredit);
            runner.update(conn, deleteOrder);
            runner.update(conn, deletePayment);
        }
    }
}