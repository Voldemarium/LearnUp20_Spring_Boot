package ru.learnUp.LearnUp20_Spring_Boot.service.processors;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.learnUp.LearnUp20_Spring_Boot.service.Operation;
import ru.learnUp.LearnUp20_Spring_Boot.service.Processor;

@Component
//@Primary
@Scope(value = "singleton")
@Profile("testing")
public class SumProcessor implements Processor {

    @Override
    public Operation getOperation() {
        return Operation.PLUS;
    }

    @Override
    public int process(int a, int b) {
        return a + b;
    }
}
