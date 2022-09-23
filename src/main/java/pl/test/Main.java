package pl.test;

import pl.test.zadanie2.PowerOfN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test6?useSSL=false&serverTimezone=UTC",
                "root",
                "root"
        );

    PowerOfN pofn = new PowerOfN(conn);

        System.out.println(pofn.getPowerOfN(81));

    }
}