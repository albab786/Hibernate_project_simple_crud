package com.infosys.controller;

import com.infosys.dao.EmployeeDao;
import com.infosys.entity.Employee;

import java.util.List;

public class EmployeeController {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
//        Employee employee = new Employee(5, "john", "john@gmail.com", 198676);
//        dao.saveEmployeeDao(employee);
       // Employee employeeByIddao = dao.getEmployeeByIddao(5);
//        boolean b = dao.deleteEmployeeByIddao(5);
//        if (b ) {
//            System.out.println("data deleted");
//        } else {
//            System.out.println("data not found pls check your id");
//        }

//        List<Employee> emp = dao.getEmlpoyeeByNamedao("john");
//        emp.forEach(e-> System.out.println(e));

        boolean b = dao.deleteEmployeeByIddao(6);
        if (b ) {
            System.out.println("data deleted");
        } else {
            System.out.println("data not found pls check your id");
        }

    }
}
