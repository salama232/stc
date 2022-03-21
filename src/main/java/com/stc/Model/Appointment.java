package com.stc.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@JsonIgnoreProperties(value={"hibernateLazyInitializer"}) 
@Entity
@NoArgsConstructor
@Getter
@Setter
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Appointment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8435622565915959889L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "Appointment_date")
	private Date Appointmentdate; 
	
	@Column(name = "created_date", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patien_id", referencedColumnName = "id")
	@JsonIdentityReference(alwaysAsId = true)
	private Patien patien;
	
	@Column(name = "status", nullable = false, columnDefinition = "varchar(100) default 'new'") 
	private String status;
	
	@Column(name = "reason") 
	private String reason;
	
}
