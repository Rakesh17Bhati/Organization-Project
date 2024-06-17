package com.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OrganizationSystem.entity.Country;
import com.OrganizationSystem.entity.Employee;
import com.OrganizationSystem.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {
	
	@Autowired
	MainService service;
	
	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {
		String msg=service.addCountry(c);
		return msg;
	}
	
	@PutMapping("updatecountry/{id}")
	public String updateCountry(@PathVariable int id, @RequestBody Country c) {
		String msg=service.updateCountry(id, c);
		return msg;
	}
	
	@DeleteMapping("deletecountry/{id}")
	public String deleteCountry(@PathVariable int id) {
		String msg=service.deleteCountry(id);
		return msg;
	}
	
	@PostMapping("addemp")
	public String addEmployee(@RequestBody Employee emp) {
		String msg=service.addEmployee(emp);
		return msg;
	}
	
	@PutMapping("updateemp")
	public String updateEmployee(@RequestBody Employee emp) {
		String msg=service.updateEmployee(emp);
		return msg;
	}
//	Tried new way but it is not recommended.
	@DeleteMapping("deleteemp")
	public String deleteEmp(@RequestBody Employee emp) {
		String msg=service.deleteEmp(emp);
		return msg;
	}
	
	@GetMapping("getemp")
	public List<Employee> getAllEmp(){
		List<Employee> list=service.getAllEmp();
		return list;
	}
	
	@GetMapping("getempbyid/{id}")
	public Employee getParticularRecord(@PathVariable int id) {
		Employee emp=service.getParticularRecord(id);
		return emp;
	}
	
	@GetMapping("getempbystatus/{status}")
	public List<Employee> getStatusRecord(@PathVariable String status) {
		List<Employee>list=service.getStatusRecord(status);
		return list;
	}
	
	@PostMapping("login")
	public HashMap login(@RequestBody Employee emp) {
		HashMap map=service.login(emp);
		return map;
	}

}
