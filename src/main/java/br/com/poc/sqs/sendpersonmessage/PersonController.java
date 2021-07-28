package br.com.poc.sqs.sendpersonmessage;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@PostMapping
	public ResponseEntity<PersonResponse> sendSqsMessage(
			@RequestBody @Valid PersonRequest personRequest) {

		return ResponseEntity.ok(new PersonResponse("Person submitted with success"));
	}

}
