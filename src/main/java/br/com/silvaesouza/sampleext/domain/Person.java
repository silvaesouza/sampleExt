package br.com.silvaesouza.sampleext.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity (name="tb_person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator (initialValue = 1, allocationSize=1, sequenceName="person_seq", name="person_seq")
	@GeneratedValue (generator="person_seq", strategy=GenerationType.AUTO)
	@Column (nullable=false)
	private Integer code;
	private String name;
	private String email;
	private String phone;
	private String cell;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}