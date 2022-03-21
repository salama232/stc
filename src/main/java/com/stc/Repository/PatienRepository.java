package com.stc.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stc.Model.Patien;

@Repository
public interface PatienRepository extends JpaRepository<Patien, Long> {

	 Optional<Patien> findById(Long id);
	 List<Patien> findAll();
	
	
	@Query("SELECT u FROM Patien u WHERE u.name = ?1")
	Patien findpatienbyname(String name);
	

}
