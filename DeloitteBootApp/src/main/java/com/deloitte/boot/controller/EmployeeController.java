package com.deloitte.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deloitte.boot.model.Employee;
import com.deloitte.boot.service.EmployeeService;

@Controller
public class EmployeeController implements ErrorController {

	@Autowired
	EmployeeService es;
	
	@GetMapping("/employees")
	public String getAllEmployees(Model m) {
		List<Employee> empList=es.getAllEmployees();
		m.addAttribute("emps", empList);
		return "viewall.jsp";
		
	}
	
	@GetMapping("/employee")
	public String getEmployee(@RequestParam("empId")String empId,Model m) {
		try {
			Employee emp=es.getEmployee(empId);
			m.addAttribute("empl", emp);	
		}
		catch(Exception e){
			
			m.addAttribute("errormsg",e.getMessage());
			return "error";
		}
		
		return "viewemp.jsp";
		
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
		return "success.jsp";
		
	}
	/*
	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("empId")String empId,Model m) {
		
		String msg="";
		if(es.deleteEmployee(empId))
			msg="Deleted Employee with id = "+empId;
		else
			msg="no employee found with id= "+empId;
		m.addAttribute("emp", msg);
		return "show.jsp";
		
	}
	*/
	
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("empId")String empId,Model m) {
		
		String msg="";
		if(es.deleteEmployee(empId))
			msg="Deleted Employee with id = "+empId;
		else
			msg="no employee found with id= "+empId;
		m.addAttribute("emp", msg);
		return "show.jsp";
		
	}

	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee emp, Model m) {
		try {
			
		Employee e = es.updateEmployee(emp);
		m.addAttribute("empl", e);
		}
		catch(Exception e){
			
			m.addAttribute("errormsg",e.getMessage());
			return "error";
		}
		return "viewemp.jsp";
		
	}
	
	
	@Override
	@RequestMapping(path="/error")
	public String getErrorPath() {
		return"error.jsp";
	}
	
	
	@GetMapping("/updateinit")
	public String UpdatePageInit(@RequestParam("empId") String empId, Model m) {
		
		Employee emp = es.getEmployee(empId);
		System.out.println(emp);
		m.addAttribute("empl", emp);
		return "updateemp.jsp";
		}
/*
	@RequestMapping(path="/error")
	public String showErrorPage() {
		return"error.jsp";
	}
	*/

}
