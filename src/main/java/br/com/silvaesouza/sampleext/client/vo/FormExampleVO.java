package br.com.silvaesouza.sampleext.client.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FormExampleVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String password;
	private Integer age;
	private String company;
	private Date birthday;
	private Date time;
	private Integer size;
	private List<String> music;
	private String color;
	private String description;
	private Double duration;

	public FormExampleVO() {
	}

	public FormExampleVO(String name, String email, String password, Integer age, String company, Date birthday,
			Date time, Integer size, List<String> music, String color, String description, Double duration) {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<String> getMusic() {
		return music;
	}

	public void setMusic(List<String> music) {
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

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "FormExampleVO [name=" + name + ", email=" + email + ", password=" + password + ", age=" + age
				+ ", company=" + company + ", birthday=" + birthday + ", time=" + time + ", size=" + size + ", music="
				+ music + ", color=" + color + ", description=" + description + ", duration=" + duration + "]";
	}

}
