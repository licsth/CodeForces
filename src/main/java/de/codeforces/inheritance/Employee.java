package de.codeforces.inheritance;

import java.math.BigDecimal;

public class Employee extends Person {
    BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
