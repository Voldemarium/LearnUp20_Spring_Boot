package ru.learnUp.LearnUp20_Spring_Boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.learnUp.LearnUp20_Spring_Boot.service.Operation;
import ru.learnUp.LearnUp20_Spring_Boot.service.Processor;
import ru.learnUp.LearnUp20_Spring_Boot.service.registry.ProcessorRegistry;

import java.util.Map;

@Configuration //аннотация @Configuration подразумевает формирование внутри себя бинов
public class AppConfig {
	@Bean //формирование бинов внутри этого метода
	public ProcessorRegistry processorRegistry(
			Processor sumProcessor,
			Processor subtractProcessor,
			Processor multiplyProcessor
	) {
		return new ProcessorRegistry(Map.of(
				Operation.PLUS, sumProcessor,
				Operation.MINUS, subtractProcessor,
				Operation.MULTIPLY, multiplyProcessor
		));
	}
}
