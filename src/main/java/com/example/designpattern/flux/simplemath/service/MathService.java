package com.example.designpattern.flux.simplemath.service;

import com.example.designpattern.flux.simplemath.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {
    public ResponseDto findSquare(int input){
        return  new ResponseDto(input*input);
    }

    public List<ResponseDto> multiplicationTable(int input){
        return IntStream.range(1,10)
                .peek(i -> SleepUtil.sleepSecond(1))
                .peek(i -> System.out.println("math-service processing :" + i))
                .mapToObj(i -> new ResponseDto(i * input))
                .collect(Collectors.toList());
    }
}
