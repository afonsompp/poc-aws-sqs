package br.com.poc.sqs.savepersoninformation;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private LocalDate bornDate;

	@Deprecated
	public Person() {

	}

	public Long getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getCpf() {
		return this.cpf;
	}

	public LocalDate getBornDate() {
		return this.bornDate;
	}

}
