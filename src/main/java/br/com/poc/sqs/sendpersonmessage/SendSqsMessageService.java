package br.com.poc.sqs.sendpersonmessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;

@Service
public class SendSqsMessageService {

	@Value("${cloud.aws.sqs.endpoint}")
	private String destinationQueue;

	private final QueueMessagingTemplate messagingTemplate;

	public SendSqsMessageService(QueueMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}

	public void send(final String messagePayload) {

		Message<String> msg = MessageBuilder.withPayload(messagePayload)
				.build();

		messagingTemplate.send(destinationQueue, msg);
	}

}
