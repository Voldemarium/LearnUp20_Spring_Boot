package ru.learnUp.LearnUp20_Spring_Boot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ValueService {

	private static final Logger log = LoggerFactory.getLogger(ValueService.class);
	private final String value;
	private final Processor processor;

	public ValueService(
			@Value("${service.value}") String value, Processor processor) {  //@Value означает, что переменная является свойством
		this.value = value;                             //service.value - ключ из resources/application.properties
		this.processor = processor;
	}

	public void print() {
		log.info("{}", value);
	}
}
