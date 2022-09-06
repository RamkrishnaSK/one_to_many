package com.rsk.springdatajpa.one_to_many;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.rsk.springdatajpa.one_to_many.entities.Address;
import com.rsk.springdatajpa.one_to_many.entities.Employee;

@SpringBootTest
class OneToManyApplicationTests {

	@Autowired
	private EmployeeRepository repo;

	@Test
	public void testInsert() {
		Employee emp1 = new Employee();
		emp1.setEmpname("Hardik Pandya");
		emp1.setEmpsalary(7690);
		emp1.setEmpmarital(true);

		Address addr1 = new Address();
		addr1.setFlat(881);
		addr1.setCity("Wellington");
		addr1.setCountry("New Zealand");
		addr1.setEmployee(emp1);

		Address addr2 = new Address();
		addr2.setFlat(666);
		addr2.setCity("Oslo");
		addr2.setCountry("Norway");
		addr2.setEmployee(emp1);

		List<Address> addrList = new ArrayList<>();
		addrList.add(addr1);
		addrList.add(addr2);

		emp1.setEmpaddress(addrList);
		repo.save(emp1);

		Employee emp2 = new Employee();
		emp2.setEmpname("Rishab Pant");
		emp2.setEmpsalary(34210);
		emp2.setEmpmarital(false);

		Address a1 = new Address();
		a1.setFlat(111);
		a1.setCity("Abu Dhabi");
		a1.setCountry("UAE - Dubai");
		a1.setEmployee(emp2);

		Address a2 = new Address();
		a2.setFlat(666);
		a2.setCity("Tokyo");
		a2.setCountry("Japan");
		a2.setEmployee(emp2);

		Address a3 = new Address();
		a3.setFlat(777);
		a3.setCity("Berlin");
		a3.setCountry("Germany");
		a3.setEmployee(emp2);

		List<Address> addrList2 = new ArrayList<>();
		addrList2.add(a1);
		addrList2.add(a2);
		addrList2.add(a3);

		emp2.setEmpaddress(addrList2);
		repo.save(emp2);

	}

	@Test
	@Transactional
	public void testRead() {
		List<Employee> myListz = repo.findAll();
		System.out.println("Employees Info : ");
		System.out.println("================");
		for (Employee e : myListz) {
			System.out.println("Id : " + e.getEmpid());
			System.out.println("Name : " + e.getEmpname());
			System.out.println("Salary : " + e.getEmpsalary());
			System.out.println("Marital : " + e.isEmpmarital());
			List<Address> adrListz = e.getEmpaddress();
			for (Address a : adrListz) {
				System.out.println("Flat Number : " + a.getFlat());
				System.out.println("City : " + a.getCity());
				System.out.println("Country : " + a.getCountry());
			}
			System.out.println("===========================================");
		}

	}

	@Test
	public void testFetchz() {
		List<Employee> listt = repo.getEmployeezz(30000);
		for (Employee e : listt) {
			System.out.println(e.getEmpid());
		}
	}

	@Test
	public void testFetch2() {
		List<Employee> empList = repo.findByEmpsalaryGreaterThan(7000);
		for (Employee e : empList) {
			System.out.println(e.getEmpid());
		}
	}

	@Test
	public void testUpdate() {
		Employee e = repo.findById(4).get();
		e.setEmpsalary(10000);
		List<Address> adrListz = e.getEmpaddress();
		for (Address a : adrListz) {
			a.setCountry("Heaven");
		}
		repo.save(e);
	}

	@Test
	public void testupdate2() {
		List<Employee> empListz = repo.getEmployeezz(50000);
		for (Employee e : empListz) {
			e.setEmpsalary(250.50);
		}
		repo.saveAll(empListz);
	}

	@Test
	public void testUpdate3() {
		List<Employee> list = repo.getEmployeezz(7000);
		for (Employee e : list) {
			List<Address> adrListzz = e.getEmpaddress();
			for (Address a : adrListzz) {
				a.setCity("xyz");
			}
		}
		repo.saveAll(list);
	}

	@Test 
	public void testDelete() {
		Employee e = repo.findById(3).get();
		repo.delete(e);
	}

	@Test
	public void testDelete2() {
		List<Employee> list = repo.getEmployeezz(9000);
		repo.deleteAll(list);
	}

}
