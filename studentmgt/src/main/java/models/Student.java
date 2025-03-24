package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(length=40,nullable = false)
	private String name;
	@Column(length=10,unique = true)
	private String contact;
	private Status status=Status.ACTIVE;

}
