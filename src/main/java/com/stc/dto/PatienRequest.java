package com.stc.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author salama
 * @since 20/03/2022
 */
@Data
public class PatienRequest {

	private Long ID;

	@NotEmpty
	private String name;
	@NotEmpty
	private int age;
	private String Email;
	private String phone;
	private String address;

	public static Builder getBuilder() {
		return new Builder();
	}

	public PatienRequest(Long iD, @NotEmpty String name, @NotEmpty int age, String email, String phone,
			String address) {
		super();
		ID = iD;
		this.name = name;
		this.age = age;
		Email = email;
		this.phone = phone;
		this.address = address;
	}

	public static class Builder {
		private Long ID;
		private String name;
		private int age;
		private String Email;
		private String phone;
		private String address;

		public Builder addPatienID(final Long PatienID) {
			this.ID = PatienID;
			return this;
		}

		public Builder addPatienName(final String PatienName) {
			this.name = PatienName;
			return this;
		}

		public Builder addPatienEmail(final String PatienEmail) {
			this.Email = PatienEmail;
			return this;
		}

		public Builder addAddress(final String address) {
			this.address = address;
			return this;
		}

		public Builder addPatienage(final int Patienage) {
			this.age = Patienage;
			return this;
		}

		public Builder addPatienphone(final String Patienphone) {
			this.phone = Patienphone;
			return this;
		}

		public PatienRequest build() {
			return new PatienRequest(ID, name, age, Email, phone, address);
		}
	}
}
