package br.com.poc.sqs.shared.config;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;

@Configuration
public class SqsConfig {

	@Bean
	public QueueMessagingTemplate queueMessagingTemplate(
			AmazonSQSAsync amazonSQSAsync) {
		return new QueueMessagingTemplate(amazonSQSAsync);
	}
}
