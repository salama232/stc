package com.stc.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.stc.Model.Patien;

import lombok.Data;

/**
 * @author salama
 * @since 20/03/2022
 */
@Data
public class AppointmentRequest {

	private Long ID;

	@NotEmpty
	private Date Appointmentdate;
	@NotEmpty
	private Patien patien;
	private String Status;
	private String Reason;

	public static Builder getBuilder() {
		return new Builder();
	}

	public AppointmentRequest(Long iD, @NotEmpty Date appointmentdate, @NotEmpty Patien patien
			,String status,String reason) {
		super();
		ID = iD;
		Appointmentdate = appointmentdate;
		this.patien = patien;
		this.Status=status;
		this.Reason=reason;
	}

	public static class Builder {
		private Long ID;
		private Date Appointmentdate;
		private Patien patien;
		private String Status;
		private String Reason;
		
		public Builder addPatienID(final Long PatienID) {
			this.ID = PatienID;
			return this;
		}

		public Builder addAppointmentdate(final Date appointmentdate) {
			this.Appointmentdate = appointmentdate;
			return this;
		}

		public Builder addPatien(final Patien patien) {
			this.patien = patien;
			return this;
		}
		public Builder addAppointmentStatus(final String status) {
			this.Status = status;
			return this;
		}
		public Builder addcancellReason(final String reason) {
			this.Reason = reason;
			return this;
		}
		public AppointmentRequest build() {
			return new AppointmentRequest(ID, Appointmentdate, patien,Status,Reason);
		}
	}
}
