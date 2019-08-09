package com.deloitte.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.boot.model.Employee;
import com.deloitte.boot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	EmployeeService es;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return es.getAllEmployees();
		
	}
/*	@GetMapping("/employees")
	public String getAllEmployees(Model m) {
		List<Employee> empList=es.getAllEmployees();
		m.addAttribute("emps", empList);
		return "viewall.jsp";
		
	}
	*/
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployee(@RequestParam("empId")String empId,Model m) {
			Employee emp=es.getEmployee(empId);
			return emp;
		
	}
	/*
	@GetMapping("/employee")
	public String getEmployee(@RequestParam("empId")String empId,Model m) {
		try {
			Employee emp=es.getEmployee(empId);
			m.addAttribute("emp", emp);	
		}
		catch(Exception e){
			
			m.addAttribute("errormsg",e.getMessage());
			return "error";
		}
		
		return "show.jsp";
		
	}
	*/
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
	
		
			Employee e= es.addEmployee(emp);
			return e;
		
	}
	
/*	@PutMapping("/employees")
	public Employee updateEmployee(@ModelAttribute Employee emp) {	
		return es.updateEmployee(emp);
	}
	
	@PostMapping("/employee")
	public String addEmployee(@ModelAttribute Employee emp, Model m) {
		try {
		
			Employee e= es.addEmployee(emp);
			m.addAttribute("emp", e);
			
		}
		catch(Exception e){
			
			m.addAttribute("errormsg",e.getMessage());
			return "error";
		}
		return "show.jsp";
		
	}
	*/
/*	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("empId")String empId,Model m) {
		
		String msg="";
		if(es.deleteEmployee(empId))
			msg="Deleted Employee with id = "+empId;
		else
			msg="no employee found with id= "+empId;
		m.addAttribute("emp", msg);
		
		return "show.jsp";
		
	}*/
	@DeleteMapping("/employees/{empId}")
	public boolean updateEmployee(@PathVariable("empId")String empId) {
		return es.deleteEmployee(empId);
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return es.updateEmployee(emp);
		
	}
	
/*	
	@Override
	@RequestMapping(path="/error")
	public String getErrorPath() {
		return"error.jsp";
	}

	@RequestMapping(path="/error")
	public String showErrorPage() {
		return"error.jsp";
	}
	*/

}
