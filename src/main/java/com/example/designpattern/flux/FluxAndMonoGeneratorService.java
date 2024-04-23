package com.example.designpattern.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {
    public Flux<String> nameFlux(){
        return Flux.fromIterable(List.of("alex", "bob", "charlie"))
                .log();
    }

    public Mono<String> nameMono(){
        return Mono.just("alex1")
                .log();
    }
    public static void main(String[] args){
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        service.nameFlux().subscribe(name -> System.out.println("Name is :" + name));
        service.nameMono().subscribe(name ->  System.out.println("Mono name is :" + name));
    }
}
