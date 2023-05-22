package ru.learnUp.LearnUp20_Spring_Boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.LearnUp20_Spring_Boot.service.Calculator;
import ru.learnUp.LearnUp20_Spring_Boot.service.Operation;
import ru.learnUp.LearnUp20_Spring_Boot.service.ValueService;

@SpringBootApplication
public class LearnUp20SpringBootApplication {
	private static final Logger log = LoggerFactory.getLogger(LearnUp20SpringBootApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(LearnUp20SpringBootApplication.class, args);

		Calculator calculator = context.getBean(Calculator.class);
		log.info("{} * {} = {}", 3, 2, calculator.calculate(3, 2, Operation.MULTIPLY));

		context.getBean(ValueService.class).print();
	}
}
