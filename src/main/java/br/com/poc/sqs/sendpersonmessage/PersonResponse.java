package br.com.poc.sqs.sendpersonmessage;

public class PersonResponse {

	private String message;

	@Deprecated
	public PersonResponse() {

	}

	public PersonResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
