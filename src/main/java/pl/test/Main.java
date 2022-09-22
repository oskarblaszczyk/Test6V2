package pl.test;

import pl.test.zadanie2.PowerOfN;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
    PowerOfN pofn = new PowerOfN();

        System.out.println(pofn.getPowerOfN(81));

    }
}