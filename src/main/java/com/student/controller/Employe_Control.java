package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.bean.Employe;
import com.student.exception.StudentException;
import com.student.service.EmployeService;

@RestController
@RequestMapping("/employe")

public class Employe_Control {
	@Autowired
private EmployeService employeService;
	@PostMapping("/save")
public String saveEmploye(@RequestParam String name,@RequestParam Integer age,
		@RequestParam String email,@RequestParam String password) {
employeService.saveEmploye(name,age,email,password);
return "Sucess";
	}
@PostMapping("/deactivate")
public String deactivateEmploye(@RequestParam Integer id) {
employeService.deactivateEmploye(id);
return "Sucess";
}

@PostMapping("/reactivate")
public String reactivateEmploye(@RequestParam Integer id) {
employeService.reactivateEmploye(id);
return "Sucess";
}	
@PostMapping("/delete")
public String deleteEmploye(@RequestParam Integer id) {
employeService.deleteEmploye(id);
return "Sucess";
}	
@PutMapping("/update")
public String updateEmploye(@RequestParam Integer id,@RequestParam String name) {
	
	employeService.updateEmploye(id,name);
	
return "Sucess";
}
@GetMapping("/get-all")
public List<Employe> getAll() {
	List<Employe> employelist=employeService.getAll();
	return employelist;
}
@GetMapping("/findbyid")
public Employe findAllEmployeById(@RequestParam Integer id) throws StudentException {
	
	Employe employe=employeService.findAllEmployeById(id); 
	return employe;
}

@GetMapping("/get-by-age")
public List<Employe> getByAge(@RequestParam Integer age) {
	List<Employe> employelist=employeService.getByAge(age);
	return employelist;
}
@GetMapping("/get-by-age-isactive")
public List<Employe> getByAgeIsactive(@RequestParam Integer age,@RequestParam boolean isactive) {
	List<Employe> employelist=employeService.getByAgeIsactive(age,isactive);
	return employelist;
}
@GetMapping("/find-by-age")
public List<Employe> findByAge() {
	List<Employe> employelist=employeService.findByAge();
	return employelist;
}
@PostMapping
public Employe signUp(@RequestParam String email,@RequestParam String password) {
	
	return employeService.signUp(email,password);
	}
@PostMapping("/login")
public Employe login(@RequestParam String email,@RequestParam String password ){
     Employe employe=employeService.login(email,password);
     return employe;
}
@GetMapping("/find-by-age-asc")
public List<Employe> findByAge1() {
	List<Employe> employelist=employeService.findByAge1();
	return employelist;
}
}










