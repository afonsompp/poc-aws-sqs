package br.com.poc.sqs.savepersoninformation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PersonParser {

	private PersonParser() {}

	public static Person convertToPerson(String personString) {
		var mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());

		try {
			return mapper.readValue(personString, Person.class);
		} catch (JsonProcessingException e) {
			throw new ConvertPersonException("parameter cannot be parsed in Person class", e);

		}
	}
}
