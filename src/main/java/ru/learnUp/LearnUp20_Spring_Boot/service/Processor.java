package ru.learnUp.LearnUp20_Spring_Boot.service;

public interface Processor {

    Operation getOperation();

    int process(int a, int b);

}
