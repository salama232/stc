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

import com.stc.Model.Patien;
import com.stc.Service.PatienService;
import com.stc.dto.PatienRequest;

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
@Api(value = "PatienControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)

public class PatienController {
	
	
	@Autowired
	private  PatienService patienService;





	@PostMapping("/patien")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Patien.class)})
	public ResponseEntity<?> addPatien(@RequestBody PatienRequest patienRequest) {

		return ResponseEntity.ok(patienService.savePatien(patienRequest));
	}
	
	@GetMapping("/patien")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Patien.class)})
	public ResponseEntity<?> GetPatien() {

		return ResponseEntity.ok(patienService.GetPatien());
	}
	
	
	@GetMapping("/patienname")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Patien.class)})
	public ResponseEntity<?> GetPatienbyid(@RequestParam("name")String name) {
		return ResponseEntity.ok(patienService.GetPatienbyname(name));
	}


}
