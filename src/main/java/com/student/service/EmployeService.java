package com.student.service;

import java.util.List;

import com.student.bean.Employe;
import com.student.exception.StudentException;



public interface EmployeService {

	void saveEmploye(String name, Integer age, String email, String password);

	void deactivateEmploye(Integer id);



	void reactivateEmploye(Integer id);

	void deleteEmploye(Integer id);

	void updateEmploye(Integer id, String name);

	List<Employe> getAll();

	Employe findAllEmployeById(Integer id) throws StudentException;

	List<Employe> getByAge(Integer age);

	List<Employe> getByAgeIsactive(Integer age, boolean isactive);

	List<Employe> findByAge();
	
	Employe signUp(String email, String password);

	Employe login(String email, String password);
	List<Employe> findByAge1();
	

	

	

	

	

	

}
