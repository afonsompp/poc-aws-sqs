package br.com.poc.sqs.savepersoninformation;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Person savePerson(String personString) {
		var convertedPerson = PersonParser.convertToPerson(personString);
		return personRepository.save(convertedPerson);
	}
}
