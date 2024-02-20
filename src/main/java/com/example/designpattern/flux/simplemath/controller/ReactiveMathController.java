package com.example.designpattern.flux.simplemath.controller;

import com.example.designpattern.flux.simplemath.dto.ResponseDto;
import com.example.designpattern.flux.simplemath.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/reactive")
public class ReactiveMathController {

    @Autowired
    private ReactiveMathService mathService;

    @GetMapping("/square/{input}")
    public Mono<ResponseDto> findSquare(@PathVariable int input){
        return mathService.otherSquare(input);
    }

    @GetMapping("/table/{input}")
    public Flux<ResponseDto> table(@PathVariable int input){
        return mathService.multiplicationTable(input);
    }

    @GetMapping(value = "/table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ResponseDto> tableStream(@PathVariable int input){
        return mathService.multiplicationTable(input);
    }
}
