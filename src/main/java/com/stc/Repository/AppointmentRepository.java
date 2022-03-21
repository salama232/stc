package com.stc.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stc.Model.Appointment;
import com.stc.Model.Patien;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

//	 Optional<Appointment> findById(Long id);

	List<Appointment> findAll();

	@Query("SELECT u FROM Appointment u WHERE u.Appointmentdate = ?1 or u.id= ?1")
	List<Appointment> findByAppointment(String name);
	
	
	@Query("SELECT u FROM Appointment u WHERE DATE(u.Appointmentdate) = DATE(?1)")
	List<Appointment> findBytoday(Date date);
	
	@Query("SELECT u FROM Appointment u WHERE DATE(u.Appointmentdate) = DATE(?1)")
	List<Appointment> findBydate(String date);
	
	@Query("SELECT u FROM Appointment u WHERE u.patien = ?1")
	List<Appointment> findBypatein(Patien patien);
	@Query("SELECT u FROM Appointment u WHERE u.id = ?1")
	Appointment findByid(Long id);



}
