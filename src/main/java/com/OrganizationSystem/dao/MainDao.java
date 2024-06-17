package com.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.OrganizationSystem.entity.Country;
import com.OrganizationSystem.entity.Employee;
@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		
		Session session=null;
		Transaction trsc=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			trsc=session.beginTransaction();
			session.persist(c);
			trsc.commit();
			msg="Record Added Successfully";
		}catch(Exception e) {
			if(trsc!=null) {
				trsc.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateCountry(int id, Country c) {
		Session session=null;
		Transaction trsc=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			trsc=session.beginTransaction();
			
			Country country=session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);
			trsc.commit();
			msg="Record Updated Successfully";
		}catch(Exception e) {
			if(trsc!=null) {
				trsc.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
		
		
	}

	public String deleteCountry(int id) {
		Session session=null;
		Transaction trsc=null;
		String msg=null;
		
		try {
			session= factory.openSession();
			trsc=session.beginTransaction();
			Country country=session.get(Country.class, id);
			session.remove(country);
			
			trsc.commit();
			msg="Record Deleted Successfully";
		}catch(Exception e){
			if(trsc!=null) {
				trsc.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String addEmployee(Employee emp) {
		Session session=null;
		Transaction trsc=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			trsc=session.beginTransaction();
			session.persist(emp);
			trsc.commit();
			msg="Record added successfully";
		}catch(Exception e) {
			if(trsc!=null) {
				trsc.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateEmployee(Employee emp) {
		Session session=null;
		Transaction trsc=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			trsc=session.beginTransaction();
			
			Employee employee= session.get(Employee.class, emp.getId());
			employee.setName(emp.getName());
			employee.setDepartment(emp.getDepartment());
			employee.setStatus(emp.getStatus());
			employee.setMobile(emp.getMobile());
			employee.setEmail(emp.getEmail());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setCreatedby(emp.getCreatedby());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setUpdateddtm(emp.getUpdateddtm());
			employee.setSalary(emp.getSalary());
			employee.setC(emp.getC());
			
			session.merge(employee);
			trsc.commit();
			msg="Employee updated";
			
		} catch (Exception e) {
			if(trsc!=null) {
				trsc.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteEmp(Employee emp) {
		Session session=null;
		Transaction trsc=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			trsc=session.beginTransaction();
			
			Employee employee= session.get(Employee.class, emp.getId());
			session.remove(employee);
			trsc.commit();
			msg="Employee data deleted";
		} catch (Exception e) {
			if(trsc!=null) {
				trsc.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Employee> getAllEmp() {
		Session session=null;
		Transaction trsc=null;
		String HQLQuery="from Employee";
		List<Employee> list=null;
		
		try {
			session=factory.openSession();
			trsc=session.beginTransaction();
			Query<Employee> query=session.createQuery(HQLQuery, Employee.class);
			list=query.list();
			trsc.commit();
		} catch (Exception e) {
			if(trsc!=null) {
				trsc.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}

	public Employee getParticularRecord(int id) {
		Session session=null;
		Transaction trsc=null;
		
		Employee emp=null;
		
		try {
			session=factory.openSession();
			trsc=session.beginTransaction();
			emp=session.get(Employee.class, id);
			trsc.commit();
		} catch (Exception e) {
			if(trsc!=null) {
				trsc.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return emp;
	}


	public List<Employee> getStatusRecord(String status) {
		Session session=null;
		Transaction trsc=null;
		List<Employee>list=null;
		String HQLQuery="from Employee where status=:mystatus";
		
		try {
			session=factory.openSession();
			trsc=session.beginTransaction();
			Query<Employee> query=session.createQuery(HQLQuery, Employee.class);
			query.setParameter("mystatus", status);
			list=query.list();
			trsc.commit();
		} catch (Exception e) {
			if(trsc!=null) {
				trsc.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	public Employee login(Employee emp) {
		Session session=null;
		Transaction trsc=null;
		Employee employee =null;
		String HQLQuery="from Employee where email=:email and mobile=:mobile";
		
		try {
			session=factory.openSession();
			trsc=session.beginTransaction();
			Query<Employee>query=session.createQuery(HQLQuery,Employee.class);
			query.setParameter("email", emp.getEmail());
			query.setParameter("mobile", emp.getMobile());
			employee=query.uniqueResult();
			trsc.commit();
			
		} catch (Exception e) {
			if(trsc!=null) {
				trsc.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return employee;
	}

}
