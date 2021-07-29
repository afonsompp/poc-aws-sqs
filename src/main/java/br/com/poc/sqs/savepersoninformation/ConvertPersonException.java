package br.com.poc.sqs.savepersoninformation;

public class ConvertPersonException extends RuntimeException {

	public ConvertPersonException(String msg, Throwable exception) {
		super(msg, exception);
	}

}
