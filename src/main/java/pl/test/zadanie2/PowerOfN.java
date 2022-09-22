package pl.test.zadanie2;

import java.math.BigInteger;
import java.sql.*;

/*
dana jest metoda BigInteger getPowerOfN(int n)
ktora ma policzyc silnie z liczby N
uwaga: jesli taka silnia byla juz liczona - nie obliczamy jej ponownie, wynik powinien byc cacheowalny.
 */
public class PowerOfN {

    Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test6?useSSL=false&serverTimezone=UTC",
            "root",
            "root"
    );

    Statement stm = conn.createStatement();

    public PowerOfN() throws SQLException {

    }

    public BigInteger getPowerOfN(int n) throws SQLException {
        BigInteger result;
        String select = "select powerN from power_n where n = " + n + ";";
        ResultSet resultSet = stm.executeQuery(select);

        if(!resultSet.next()){
            result = powerOfN(n);
            String insert = "insert into power_n values(" + n + ", " + result + ");";
            stm.executeUpdate(insert);
            return result;
        }
        return new BigInteger(resultSet.getString(1));
    }
    private BigInteger powerOfN(int n){
        if(n <= 1){
            return new BigInteger(String.valueOf(1));
        }
        return new BigInteger(String.valueOf(n)).multiply(powerOfN(n-1));
    }
}
