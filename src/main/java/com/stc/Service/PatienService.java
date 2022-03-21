package com.stc.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stc.Model.Patien;
import com.stc.Repository.PatienRepository;
import com.stc.dto.PatienRequest;

/**
 * 
 * @author salama
 *
 */
@Service
public class PatienService {

	@Autowired
	private PatienRepository patienRepository;

	@Transactional
	public 	Patien savePatien(final PatienRequest formDTO) {
		Patien patien = new Patien();
		patien.setAddress(formDTO.getAddress());
		patien.setAge(formDTO.getAge());
		patien.setEmail(formDTO.getEmail());
		patien.setPhone(formDTO.getPhone());
		patien.setName(formDTO.getName());
		
		Date now = Calendar.getInstance().getTime();
		patien.setCreatedDate(now);
		patien.setUpdateDate(now);
		patienRepository.save(patien);
		return patien;
	}

	@Transactional
	public 	List<Patien> GetPatien() {
		return patienRepository.findAll();
	}
	
	@Transactional
	public 	Patien GetPatienbyname(final String name) {
		return patienRepository.findpatienbyname(name);
	}

	

}
