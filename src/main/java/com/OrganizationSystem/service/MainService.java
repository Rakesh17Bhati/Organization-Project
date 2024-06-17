package com.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrganizationSystem.dao.MainDao;
import com.OrganizationSystem.entity.Country;
import com.OrganizationSystem.entity.Employee;

@Service
public class MainService {
	@Autowired
	MainDao dao;
	
	public String addCountry(Country c){
		String msg=dao.addCountry(c);
		if(Objects.isNull(msg)) {
			msg="Record failed to added";
		}
		return msg;
	}

	public String updateCountry(int id, Country c) {
		String msg=dao.updateCountry(id,c);
		if(Objects.isNull(msg)) {
			msg="Record failed to update";
		}
		return msg;
	}

	public String deleteCountry(int id) {
		String msg=dao.deleteCountry(id);
		if(Objects.isNull(msg)) {
			msg="Record failed to delete";
		}
		return msg;
	}

	public String addEmployee(Employee emp) {
		
		String msg=dao.addEmployee(emp);
		if(Objects.isNull(msg)) {
			msg="Record failed to added";
		}
		return msg;
	}

	public String updateEmployee(Employee emp) {
		String msg=dao.updateEmployee(emp);
		if(Objects.isNull(msg)) {
			msg="Employee not updated";
		}
		return msg;
	}

	public String deleteEmp(Employee emp) {
		String msg=dao.deleteEmp(emp);
		if(Objects.isNull(msg)) {
			msg="Employee data not deleted";
		}
		return msg;
	}

	public List<Employee> getAllEmp() {
		List<Employee>list=dao.getAllEmp();
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}

	public Employee getParticularRecord(int id) {
		Employee emp=dao.getParticularRecord(id);
		if(Objects.isNull(emp)) {
			emp=null;
		}
		return emp;
	}

	public List<Employee> getStatusRecord(String status) {
		List<Employee>list=dao.getStatusRecord(status);
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}

	public HashMap login(Employee emp) {
		Employee employee=dao.login(emp);
		HashMap map=new HashMap();
		if(Objects.isNull(employee)) {
			map.put("msg", "Invalid User");
			map.put("User", employee);
		}
		else {
			map.put("msg", "Valid User");
			map.put("User", employee);
		}
		return map;
	}

}
