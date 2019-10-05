package de.codeforces.inheritance;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setSalary(BigDecimal.ZERO);
        employee.setAddress("Address");
        employee.setName("emp1");
    }
}
