package br.com.poc.sqs.sendpersonmessage;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ValidatorExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ObjectOfInvalidFields handler(MethodArgumentNotValidException exception) {
		List<InvalidField> errors = extractFieldErrors(exception);

		return new ObjectOfInvalidFields("Request with invalid fields", HttpStatus.BAD_REQUEST.value(),
				errors);

	}

	private List<InvalidField> extractFieldErrors(
			MethodArgumentNotValidException exception) {
		List<InvalidField> response = new ArrayList<>();
		List<FieldError> errors = exception.getFieldErrors();

		errors.forEach(e -> {
			var error = new InvalidField(e.getField(), e.getDefaultMessage());
			response.add(error);
		});

		return response;
	}
}
