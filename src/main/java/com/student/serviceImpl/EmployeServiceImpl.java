package com.student.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.bean.Employe;
import com.student.exception.StudentException;
import com.student.repository.EmployeRepository;
import com.student.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public void saveEmploye(String name, Integer age, String email, String password) {

		Employe empl = new Employe();
		empl.setName(name);
		empl.setAge(age);
		empl.setEmail(email);
		empl.setPassword(password);
		empl.setActive(true);
		employeRepository.save(empl);
	}

	@Override
	public void deactivateEmploye(Integer id) {

		Optional<Employe> employeoptional = employeRepository.findById(id);
		if (employeoptional.isPresent()) {
			Employe employe = employeoptional.get();
			employe.setActive(false);
			employeRepository.save(employe);
		}
	}

	@Override
	public void reactivateEmploye(Integer id) {

		Optional<Employe> employeoptional = employeRepository.findById(id);
		if (employeoptional.isPresent()) {
			Employe employe = employeoptional.get();
			employe.setActive(true);
			employeRepository.save(employe);
		}
	}

	@Override
	public void deleteEmploye(Integer id) {

		Optional<Employe> employeoptional = employeRepository.findById(id);

		Employe employe = employeoptional.get();
		employeRepository.delete(employe);

	}

	@Override
	public void updateEmploye(Integer id, String name) {

		Optional<Employe> employeoptional = employeRepository.findById(id);
		if (employeoptional.isPresent()) {
			Employe employe = employeoptional.get();
			employe.setName(name);
			employeRepository.save(employe);
		}
	}

	@Override
	public List<Employe> getAll() {

		List<Employe> employeList = employeRepository.findAll();

		return employeList;
	}

	@Override
	public Employe findAllEmployeById(Integer id) throws StudentException {

		Optional<Employe> employeoptional = employeRepository.findById(id);
		if (!employeoptional.isPresent()) {
			throw new StudentException("user details not found");
		}
		Employe employe = employeoptional.get();

		return employe;

	}

	@Override
	public List<Employe> getByAge(Integer age) {

		List<Employe> employelist = employeRepository.findByAge(age);

		return employelist;
	}

	@Override
	public List<Employe> getByAgeIsactive(Integer age, boolean isactive) {

		List<Employe> employelist = employeRepository.findByAgeIsactive(age, isactive);

		// List<Employe> employelist1=employeRepository.findByAge(age);

		return employelist;
	}

	@Override
	public List<com.student.bean.Employe> findByAge() {

		List<Employe> employelist = employeRepository.findByAge1();

		return employelist;

	}

	@Override
	public Employe signUp(String email, String password) {

		validateSignUp(email, password);
		Employe employe = new Employe();
		BeanUtils.copyProperties(password, employe, getClass());
		employeRepository.save(employe);
		return new Employe();
	}

	private void validateSignUp(String email, String password) {

	}

	@Override
	public Employe login(String email, String password) {

		Optional<Employe> employeoptional = employeRepository.findByEmail(email);
		if (!employeoptional.isPresent()) {
			throw new RuntimeException("User email is not avilable");

		}
		if (!employeoptional.get().isActive()) {
			throw new RuntimeException("user is not active");

		}
		Employe employe = employeoptional.get();

		if (!employe.getPassword().equals(password)) {
			throw new RuntimeException("Password mismatch.");
		}
		return employe;

	}

	@Override
	public List<com.student.bean.Employe> findByAge1() {

		List<Employe> employelist = null;
		
 employelist=employeRepository.findByAge1();
		
		return employelist;
		
	}

}
