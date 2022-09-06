package com.rsk.springdatajpa.one_to_many;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rsk.springdatajpa.one_to_many.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByEmpsalaryGreaterThan(double sal);

	@Query("from Employee where empsalary>:sal")
	public List<Employee> getEmployeezz(@Param("sal") double salary); 

}
 