package br.com.poc.sqs.sendpersonmessage;

import javax.validation.Valid;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	private final SendSqsMessageService sendSqsMessage;

	public PersonController(SendSqsMessageService sendSqsMessage) {
		this.sendSqsMessage = sendSqsMessage;
	}

	@PostMapping
	public ResponseEntity<PersonResponse> sendSqsMessage(
			@RequestBody @Valid PersonRequest personRequest) throws JsonProcessingException {

		sendSqsMessage.send(personRequest.toJsonString());
		return ResponseEntity.ok(new PersonResponse("Person submitted with success"));
	}

}
