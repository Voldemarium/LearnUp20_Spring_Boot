package ru.learnUp.LearnUp20_Spring_Boot.service;

import org.springframework.stereotype.Service;

import java.util.Collection;


@Service      //@Service - это аннотация класса - бина с бизнес-логикой,
public class Calculator {

    private final Collection<Processor> processors;

    public Calculator(Collection<Processor> processors) {
        this.processors = processors;
    }

    public int calculate(int a, int b, Operation operation) {
        return processors.stream()
               .filter(p -> p.getOperation() == operation)
               .findAny()
               .orElseThrow(() -> new RuntimeException("unknown operation"))
               .process(a, b);
    }

}
