package pl.test.zadanie2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PowerN {
    @Id
    private int n;
    private  int powerN;

    public PowerN() {
    }

    public PowerN(int n, int powerN) {
        this.n = n;
        this.powerN = powerN;
    }

    public int getN() {
        return n;
    }

    public int getPowerN() {
        return powerN;
    }
}
