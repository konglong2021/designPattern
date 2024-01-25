package com.example.designpattern;

import com.example.designpattern.pattern.prototype.ProtoFalse;
import com.example.designpattern.pattern.prototype.ProtoTrue;
import com.example.designpattern.pattern.singleton.implement3.SingA;
import com.example.designpattern.pattern.singleton.implement3.SingB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class DesignPatternApplicationTests {

    @Autowired
    SingB singB1;
    @Autowired
    SingB singB2;

    @Autowired
    ProtoTrue true1;
    @Autowired
    ProtoTrue true2;

    @Autowired
    ProtoFalse false1;
    @Autowired
    ProtoFalse false2;

    @Test
public void testSingleton() {
        SingA singA1 = SingA.getInstance();
        SingA singA2 = SingA.getInstance();
        Assertions.assertNotNull(singA1);
        Assertions.assertSame(singA1, singA2);
        Assertions.assertNotNull(singB1);
        Assertions.assertSame(singB1, singB2);
    }

    @Test
    public void testPrototype(){
        Assertions.assertSame(false1,false2);
        Assertions.assertNotSame(true1,true2);
    }
}
