package com.infosys.dao;

import com.infosys.entity.Employee;
import jakarta.persistence.*;

import java.util.List;

public class EmployeeDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public Employee saveEmployeeDao(Employee employee) {
        et.begin();
        em.persist(employee);
        et.commit();
        return employee;
    }
    public Employee getEmployeeByIddao(int empId){
        Employee employee = em.find(Employee.class, empId);
        return employee;
    }
    public boolean deleteEmployeeByIddao(int empId){
        Employee employee = em.find(Employee.class, empId);
        if (employee!=null){
            et.begin();
            em.remove(employee);
            et.commit();
        }
        return false;
    }
    public List<Employee> displayAllEmployeeDao(){
        return em.createQuery("FROM EMPLOYEE").getResultList();
    }

    public List<Employee> getEmlpoyeeByNamedao(String name){
        Query query = em.createQuery("SELECT e from Employee e where e.name=?1");
        query.setParameter(1,name);
        return query.getResultList();
    }
    public Employee getSingleEmlpoyeeByNamedao(String name){
        Query query = em.createQuery("SELECT e from Employee e where e.name=?1");
        query.setParameter(1,name);
        try {
            return (Employee)query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //by using native query
    public Employee getEmlpoyeeByEmaildao(String name){
        Query query = em.createNativeQuery("select * from emp where email=?1",Employee.class);
        query.setParameter(1,name);
        try {
            return (Employee)query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    // Update employee email by ID using native query
    public int updateEmployeeEmailById(Long id, String newEmail) {
        Query query = em.createNativeQuery("UPDATE emp SET email = ?1 WHERE id = ?2");
        query.setParameter(1, newEmail);
        query.setParameter(2, id);

        try {
            return query.executeUpdate();  // Returns the number of affected rows
        } catch (Exception e) {
            e.printStackTrace();
            return 0;  // Return 0 in case of an error
        }
    }
    // Delete employee by email using native query
    public int deleteEmployeeByEmail(String email) {
        Query query = em.createNativeQuery("DELETE FROM emp WHERE email = ?1");
        query.setParameter(1, email);

        try {
            return query.executeUpdate();  // Returns the number of affected rows
        } catch (Exception e) {
            e.printStackTrace();
            return 0;  // Return 0 in case of an error
        }
    }
    // Update employee email by ID using JPQL
    public int updateEmployeeEmailByIdUsingJPQL(Long id, String newEmail) {
        Query query = em.createQuery("UPDATE Employee e SET e.email = :newEmail WHERE e.id = :id");
        query.setParameter("newEmail", newEmail);
        query.setParameter("id", id);

        try {
            return query.executeUpdate();  // Returns the number of affected rows
        } catch (Exception e) {
            e.printStackTrace();
            return 0;  // Return 0 in case of an error
        }
    }




}
