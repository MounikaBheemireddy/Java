package com.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.bean.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Integer>{
	@Query("select e from Employe e where e.age=:age")
	
    List<Employe> findByAge(Integer age);
	@Query("select a from Employe a where a.age=:age and a.isActive=:isactive")
	List<Employe> findByAgeIsactive(Integer age, boolean isactive);
	@Query("select a from Employe a ORDER BY  a.age DESC")
	List<Employe> findByAge( );
	Optional<Employe> findByEmail(String email);
    Employe findByPassword(String password);
    @Query("select a from Employe a ORDER BY  a.age ASC")
	List<Employe> findByAge1( );
	
}
