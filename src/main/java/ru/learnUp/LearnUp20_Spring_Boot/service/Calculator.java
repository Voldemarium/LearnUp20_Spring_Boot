package ru.learnUp.LearnUp20_Spring_Boot.service;

import org.springframework.stereotype.Service;
import ru.learnUp.LearnUp20_Spring_Boot.service.processors.registry.ProcessorRegistry;


@Service      //@Service - это аннотация класса - бина с бизнес-логикой,
public class Calculator {

    private final ProcessorRegistry registry;

    public Calculator(ProcessorRegistry registry) {
        this.registry = registry;
    }

    public int calculate(int a, int b, Operation operation) {
        return registry.findByType(operation).process(a, b);
    }

}
