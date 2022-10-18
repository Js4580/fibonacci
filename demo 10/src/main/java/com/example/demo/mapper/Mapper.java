package com.example.demo.mapper;

import com.example.demo.models.Fibonacci;
import com.example.demo.models.dto.FibonacciResponse;
import com.example.demo.models.dto.FibonacciRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final ModelMapper modelMapper;

    @Autowired
    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Fibonacci convertToFibonacci(FibonacciRequest fibonacciRequest){
        return modelMapper.map(fibonacciRequest, Fibonacci.class);
    }
    public FibonacciResponse convertToFibonacciResponse(Fibonacci fibonacci){
        return modelMapper.map(fibonacci, FibonacciResponse.class);
    }
}
