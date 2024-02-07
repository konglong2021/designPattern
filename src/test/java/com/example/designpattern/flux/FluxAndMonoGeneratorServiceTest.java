package com.example.designpattern.flux;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FluxAndMonoGeneratorServiceTest {
    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void nameFlux(){
        //given

        //when
        var nameFlux = fluxAndMonoGeneratorService.nameFlux();

        //then
        StepVerifier.create(nameFlux)
                .expectNext("alex", "bob", "charlie")
                .verifyComplete();
    }

    @Test
    void TypeImplement(){
        //given
        List<Number> nums = new ArrayList<>();
        //List<? extends Number> numbers = ints; // <? extends Number// >
        List<Integer> ints = List.of(1, 2, 3, 4, 5);
        List<Double> dbls = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
        //when
        nums.addAll(ints);
        nums.addAll(dbls);
        System.out.println(nums);
        assert nums.equals(List.of(1, 2, 3, 4, 5, 1.0, 2.0, 3.0, 4.0, 5.0));
        //then
    }


}
