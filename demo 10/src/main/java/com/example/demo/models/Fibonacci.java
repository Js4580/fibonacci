package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fibonacci")
@Getter
@Setter
public class Fibonacci {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "solution")
    private long solution;
    @Column(name = "times")
    private long times;
    @Transient
    private long number;
}
