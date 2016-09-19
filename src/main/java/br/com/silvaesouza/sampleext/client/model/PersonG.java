package br.com.silvaesouza.sampleext.client.model;

import java.io.Serializable;

public class PersonG implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer code;
	private String name;
	private String phone;
	private String cell;
	private String email;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}