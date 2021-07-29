package br.com.poc.sqs.recivepersonmessage;

import org.springframework.stereotype.Service;
import br.com.poc.sqs.savepersoninformation.PersonService;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;

@Service
public class PersonMessageListener {

	private final PersonService personService;

	public PersonMessageListener(PersonService personService) {
		this.personService = personService;
	}

	@SqsListener(value = "person-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public void receivePersonMessage(String personString) {
		personService.savePerson(personString);
	}
}
