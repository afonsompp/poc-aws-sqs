package br.com.poc.sqs.sendpersonmessage;

public class InvalidField {

	private String field;
	private String message;

	public InvalidField(String field, String message) {
		this.field = field;
		this.message = message;

	}

	public String getField() {
		return this.field;
	}

	public String getMessage() {
		return this.message;
	}
}
