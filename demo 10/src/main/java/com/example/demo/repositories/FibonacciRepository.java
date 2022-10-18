package com.example.demo.repositories;

import com.example.demo.models.Fibonacci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciRepository extends JpaRepository<Fibonacci, Integer> {
}
