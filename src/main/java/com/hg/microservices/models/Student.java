package com.hg.microservices.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "Student")
@Table(name = "\"Students\"", schema = "public")
@OnDelete(action = OnDeleteAction.CASCADE)
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_student_person"))
public class Student extends Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "schoolarship", columnDefinition = "boolean DEFAULT 'false'")
	private Boolean schoolarship = false;
	
	//State = 1:Inscrito, 2:Retirado, 3:Graduado, etc
	@Column(name = "state", columnDefinition = "integer DEFAULT '1'")
	private Integer state = 1;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "\"StudentCourse\"",
			joinColumns = @JoinColumn(
					name = "student_id",
					referencedColumnName = "id",
					foreignKey = @ForeignKey(
							name = "fk_student_course",
							foreignKeyDefinition = "FOREIGN KEY (student_id)\r\n" + 
									"        REFERENCES public.\"Students\" (id) MATCH SIMPLE\r\n" + 
									"        ON UPDATE CASCADE\r\n" + 
									"        ON DELETE CASCADE",
									value = ConstraintMode.CONSTRAINT
							)
					),
			inverseJoinColumns = @JoinColumn(
					name = "course_key",
					referencedColumnName = "key",
					foreignKey = @ForeignKey(
							name = "fk_course_student",
							foreignKeyDefinition = "FOREIGN KEY (course_key)\r\n" + 
									"        REFERENCES public.\"Courses\" (key) MATCH SIMPLE\r\n" + 
									"        ON UPDATE CASCADE\r\n" + 
									"        ON DELETE CASCADE",
									value = ConstraintMode.CONSTRAINT
							)
					),
			uniqueConstraints = @UniqueConstraint(name = "composite_key", columnNames = {"student_id", "course_key"})
			)
	private List<Course> enrolled_courses;

	public Boolean getSchoolarship() {
		return schoolarship;
	}

	public void setSchoolarship(Boolean schoolarship) {
		this.schoolarship = schoolarship;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Course> getEnrolled_courses() {
		return enrolled_courses;
	}

	public void setEnrolled_courses(List<Course> enrolled_courses) {
		this.enrolled_courses = enrolled_courses;
	}
	
	

}
