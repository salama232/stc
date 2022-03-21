package com.stc.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stc.Model.Appointment;
import com.stc.Model.Patien;
import com.stc.Repository.AppointmentRepository;
import com.stc.dto.AppointmentRequest;

/**
 * 
 * @author salama
 *
 */
@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private PatienService patienService;
	@Transactional
	public 	Appointment saveAppointment(final AppointmentRequest formDTO) {
		Appointment appointment = new Appointment();
		appointment.setAppointmentdate(formDTO.getAppointmentdate());
		appointment.setStatus(formDTO.getStatus());
		appointment.setReason(formDTO.getReason());
		appointment.setPatien(formDTO.getPatien());	
		Date now = Calendar.getInstance().getTime();
		appointment.setCreatedDate(now);
		appointment.setUpdateDate(now);
		appointmentRepository.save(appointment);
		return appointment;
	}

	@Transactional
	public 	List<Appointment> GetAppointment() {
		return appointmentRepository.findAll();
	}

	

	
	@Transactional
	public 	Appointment GetAppointmentbyid(final Long id,final String reason) {
		System.out.println(id+" "+reason);
		Appointment appointment = appointmentRepository.findById(id).get();
		System.out.println(appointment.getId());
		appointment.setStatus("Cancelled");
		appointment.setReason(reason);
		
		return appointmentRepository.save(appointment);
		
	}
	
	
	@Transactional
	public 	Appointment GetAppointmentbyid(final Long id) {
		return  appointmentRepository.findById(id).get();

		
	}
	
	
	@Transactional
	public 	List<Appointment>  gettodayapp() {
		Date now = Calendar.getInstance().getTime();
		return appointmentRepository.findBytoday(now);
	}
	
	@Transactional
	public 	List<Appointment> getbydate(final String date){
		return appointmentRepository.findBydate(date);
	}
	
	@Transactional
	public 	List<Appointment> getbypatienname(final String name){
		
		Patien patien=patienService.GetPatienbyname(name);
		
		return appointmentRepository.findBypatein(patien);
	}
	
	



}
