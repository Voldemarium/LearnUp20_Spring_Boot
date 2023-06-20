package ru.learnUp.LearnUp20_Spring_Boot.service.registry;

import ru.learnUp.LearnUp20_Spring_Boot.service.Operation;
import ru.learnUp.LearnUp20_Spring_Boot.service.Processor;

import java.util.Map;


public class ProcessorRegistry {
	private final Map<Operation, Processor> registry;

	public ProcessorRegistry(Map<Operation, Processor> registry) {
		this.registry = registry;
	}
	public Processor findByType(Operation operation) {
		if(!registry.containsKey(operation)) {
			throw new  RuntimeException("unknown operation");
		}
		 return registry.get(operation);
	}
}
