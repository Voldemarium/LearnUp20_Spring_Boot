package ru.learnUp.LearnUp20_Spring_Boot.service.processors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.learnUp.LearnUp20_Spring_Boot.service.Operation;
import ru.learnUp.LearnUp20_Spring_Boot.service.Processor;

@Component
@Profile("testing")
public class SubtractProcessor implements Processor {

    @Override
    public Operation getOperation() {
        return Operation.MINUS;
    }

    @Override
    public int process(int a, int b) {
        return a - b;
    }
}
