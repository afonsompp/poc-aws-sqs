package br.com.poc.sqs.recivepersonmessage;

import org.springframework.stereotype.Service;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;

@Service
public class PersonMessageListener {
	@SqsListener(value = "person-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public void receive(String message) {
		System.out.println(message);
	}
}
