package com.example.designpattern.flux.simplemath.service;

import com.example.designpattern.flux.simplemath.dto.ResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveMathService {
    public Mono<ResponseDto> findSquare(int input){
        return Mono.just(new ResponseDto(input*input));
    }

    public Mono<ResponseDto> otherSquare(int input){
        return Mono.fromSupplier(() -> input * input)
                .map(ResponseDto::new);
    }

    public Flux<ResponseDto> multiplicationTable(int input){
        return Flux.range(1,10)
//                .doOnNext(i -> SleepUtil.sleepSecond(1))
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Reactive math-service processing :" + i))
                .map(i -> new ResponseDto(i * input));
    }
}
