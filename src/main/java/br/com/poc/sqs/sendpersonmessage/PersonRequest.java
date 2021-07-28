package br.com.poc.sqs.sendpersonmessage;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hibernate.validator.constraints.br.CPF;

public class PersonRequest {

	@NotBlank
	@Size(min = 3)
	private String firstName;
	@NotBlank
	@Size(min = 3)
	private String lastName;
	@NotBlank
	@CPF
	private String cpf;
	@NotNull
	@Past
	private LocalDate bornDate;

	@Deprecated
	public PersonRequest() {}

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

	public String toJsonString() throws JsonProcessingException {
		var mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		return mapper.writeValueAsString(this);
	}

}
