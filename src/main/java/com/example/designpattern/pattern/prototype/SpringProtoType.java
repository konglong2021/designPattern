package com.example.designpattern.pattern.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringProtoType {

    @Bean
    public ProtoFalse protoFalse(){
        return new ProtoFalse();
    }

    @Bean
    @Scope("prototype")
    public ProtoTrue protoTrue(){
        return new ProtoTrue();
    }
}

//Usage will define in test
