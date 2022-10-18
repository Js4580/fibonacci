package com.example.demo.controllers;

import com.example.demo.mapper.Mapper;
import com.example.demo.models.Fibonacci;
import com.example.demo.models.dto.FibonacciResponse;
import com.example.demo.models.dto.FibonacciRequest;
import com.example.demo.services.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {
    private final Mapper mapper;
    private final FibonacciService fibonacciService;

    @Autowired
    public FibonacciController(Mapper mapper,
                               FibonacciService fibonacciService) {
        this.mapper = mapper;
        this.fibonacciService = fibonacciService;
    }

    @PostMapping("/first")
    public FibonacciResponse solutionFibonacci(@RequestBody FibonacciRequest fibonacciRequest) {
        Fibonacci fibonacci = mapper.convertToFibonacci(fibonacciRequest);
        return mapper
                .convertToFibonacciResponse(fibonacciService
                        .calculatorFibonacci(fibonacci));
    }

    @PostMapping("/second")
    public FibonacciResponse solutionFibon(@RequestBody FibonacciRequest fibonacciRequest) {
        Fibonacci fibonacci = mapper.convertToFibonacci(fibonacciRequest);
        return mapper
                .convertToFibonacciResponse(fibonacciService
                        .calculatorFibon(fibonacci));
    }
}
