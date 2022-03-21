package com.stc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stc.Model.Appointment;
import com.stc.Service.AppointmentService;
import com.stc.dto.AppointmentRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author salama
 */
//@Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "AppointmentControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)

public class AppointmentController {
	
	
	@Autowired
	private  AppointmentService appointmentService;





	@PostMapping("/Appointment")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response =  Appointment.class)})
	public ResponseEntity<?> addAppointment(@RequestBody AppointmentRequest appointmentRequest) {

		return ResponseEntity.ok(appointmentService.saveAppointment(appointmentRequest));
	}
	
	@GetMapping("/Appointment")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Appointment.class)})
	public ResponseEntity<?> GetAppointment() {

		return ResponseEntity.ok(appointmentService.GetAppointment());
	}
	
	

	@GetMapping("/todayAppointments")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Appointment.class)})
	public ResponseEntity<?> GettodayAppointment() {
		return ResponseEntity.ok(appointmentService.gettodayapp());
	}
	
	@GetMapping("/Appointmentsbydate")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Appointment.class)})
	public ResponseEntity<?> GetAppointmentbydate(@RequestParam("date") String date) {
		return ResponseEntity.ok(appointmentService.getbydate(date));
	}

	@GetMapping("/Appointmentsbypatien")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Appointment.class)})
	public ResponseEntity<?> GetAppointmentbypatien(@RequestParam("name") String name) {
		return ResponseEntity.ok(appointmentService.getbypatienname(name));
	}
	

	@PostMapping("/Appointmentcancelled")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Appointment.class)})
	public ResponseEntity<?> GetAppointmentbypatien(@RequestParam("id") Long id,@RequestParam("reason") String reason) {
		return ResponseEntity.ok(appointmentService.GetAppointmentbyid(id, reason));
	}
	
	
	@GetMapping("/Appointmentid")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Appointment.class)})
	public ResponseEntity<?> GetAppointmentbypatien(@RequestParam("id") Long id) {
		return ResponseEntity.ok(appointmentService.GetAppointmentbyid(id));
	}


}
