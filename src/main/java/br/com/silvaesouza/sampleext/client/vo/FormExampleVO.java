package br.com.silvaesouza.sampleext.client.vo;

import java.io.Serializable;

public class FormExampleVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String password;
	private String age;
	private String company;
	private String birthday;
	private String time;
	private String size;
	private String music;
	private String color;
	private String description;
	private String duration;

	public FormExampleVO() {
	}

	public FormExampleVO(String name, String email, String password, String age, String company, String birthday,
			String time, String size, String music, String color, String description, String duration) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.company = company;
		this.birthday = birthday;
		this.time = time;
		this.size = size;
		this.music = music;
		this.color = color;
		this.description = description;
		this.duration = duration;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
