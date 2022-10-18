package com.example.demo.services.impl;

import com.example.demo.models.Fibonacci;
import com.example.demo.repositories.FibonacciRepository;
import com.example.demo.services.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FibonacciServiceImpl implements FibonacciService {
    private final FibonacciRepository fibonacciRepository;

    @Autowired
    public FibonacciServiceImpl(FibonacciRepository fibonacciRepository) {
        this.fibonacciRepository = fibonacciRepository;
    }

    @Override
    public Fibonacci calculatorFibonacci(Fibonacci fibonacci) {
        int number = fibonacci.getNumber();


        long first = System.currentTimeMillis();
        long result = fibonacciFirst(number);
        long last = System.currentTimeMillis();

        fibonacci.setTimes(last - first);
        fibonacci.setSolution(result);
        fibonacciRepository.save(fibonacci);
        return fibonacci;
    }
    @Override
    public Fibonacci calculatorFibon(Fibonacci fibonacci) {
        int number = fibonacci.getNumber();

        long first = System.currentTimeMillis();
        long result = fibonacciSecond(number);
        long last = System.currentTimeMillis();

        fibonacci.setTimes(last - first);
        fibonacci.setSolution(result);
        fibonacciRepository.save(fibonacci);
        return fibonacci;
    }

    private long fibonacciSecond(int number) {
        long[] fibonacci = new long[number + 1];

        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int index = 2; index <= number; index++)
            fibonacci[index] = fibonacci[index - 1] + fibonacci[index - 2];

        return fibonacci[number];
    }

    private long fibonacciFirst(int number) {
        if (number <= 1)
            return number;
        return fibonacciFirst(number - 1) + fibonacciFirst(number - 2);
    }
}
