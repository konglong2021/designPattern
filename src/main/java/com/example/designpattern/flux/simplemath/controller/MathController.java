package com.example.designpattern.flux.simplemath.controller;

import com.example.designpattern.flux.simplemath.dto.ResponseDto;
import com.example.designpattern.flux.simplemath.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {
    @Autowired
    private MathService mathService;

    @GetMapping("/square/{input}")
    public ResponseDto findSquare(@PathVariable int input){
        return mathService.findSquare(input);
    }

    @GetMapping("/table/{input}")
    public List<ResponseDto> table(@PathVariable int input){
        return mathService.multiplicationTable(input);
    }
}
