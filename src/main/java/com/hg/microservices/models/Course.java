package com.hg.microservices.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "Course")
@Table(name = "\"Courses\"", schema = "public")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//KEY = 1, 2, 3, ...
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "key")
	private Long key;
	
	@ManyToOne
	@JoinColumn(
			name = "teacher_id",
			referencedColumnName = "id",
			foreignKey = @ForeignKey(
					name = "fk_course_teacher",
					foreignKeyDefinition = "FOREIGN KEY (teacher_id)\r\n" + 
							"        REFERENCES public.\"Teachers\" (id) MATCH SIMPLE\r\n" + 
							"        ON UPDATE CASCADE\r\n" + 
							"        ON DELETE CASCADE",
							value = ConstraintMode.CONSTRAINT
					)
			)
	private Teacher teacher;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "start_date", nullable = false, columnDefinition = "date DEFAULT 'now()'")
	private LocalDate start_date = ZonedDateTime.now(ZoneId.of("America/Guayaquil")).toLocalDate();
	
	@Column(name = "ending_date", nullable = false)
	private LocalDate ending_date;

	@JsonIdentityInfo(
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id"
			)
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToMany(mappedBy = "enrolled_courses", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Student> enrolled_students;
	
	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnding_date() {
		return ending_date;
	}

	public void setEnding_date(LocalDate ending_date) {
		this.ending_date = ending_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getEnrolled_students() {
		return enrolled_students;
	}

	public void setEnrolled_students(List<Student> enrolled_students) {
		this.enrolled_students = enrolled_students;
	}
	
	

}
