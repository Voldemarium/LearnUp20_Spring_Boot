package ru.learnUp.LearnUp20_Spring_Boot.service.processors;

import org.springframework.stereotype.Component;
import ru.learnUp.LearnUp20_Spring_Boot.service.Operation;
import ru.learnUp.LearnUp20_Spring_Boot.service.Processor;

@Component
public class MultiplyProcessor implements Processor {
    @Override
    public Operation getOperation() {
        return Operation.MULTIPLY;
    }

    @Override
    public int process(int a, int b) {
        return a * b;
    }
}
