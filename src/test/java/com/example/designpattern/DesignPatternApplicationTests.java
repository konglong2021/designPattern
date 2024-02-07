package com.example.designpattern;

import com.example.designpattern.pattern.prototype.ProtoFalse;
import com.example.designpattern.pattern.prototype.ProtoTrue;
import com.example.designpattern.pattern.singleton.implement3.SingA;
import com.example.designpattern.pattern.singleton.implement3.SingB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import java.util.*;

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

    @Test
    void wildcards(){
        List<List<?>> lists = new ArrayList<List<?>>();
        lists.add(List.of(1,2,3));
        lists.add(List.of("four","five"));
        assert lists.equals(List.of(List.of(1, 2, 3), List.of("four", "five")));
        assert lists.getFirst().getFirst().toString().equals("1");
    }

    @Test
    void restrictionWildCard(){
        List<Number> nums = new ArrayList<Number>();
        List<? super Number> sink = nums;
        List<? extends Number> source = nums;
        for (int i=0; i<4; i++) sink.add(i);
        int sum = nums.stream().mapToInt(Number::intValue).sum();
        assert sum == 6;
    }

    @Test
    void comparator(){
        Comparator<String> sizeOrder =
                new Comparator<>() {
                    public int compare(String s1, String s2) {
                        return
                                s1.length() < s2.length() ? -1 :
                                        s1.length() > s2.length() ? 1 :
                                                s1.compareTo(s2) ;
                    }
                };
        assert "two".compareTo("three") > 0;
        assert sizeOrder.compare("two","three") < 0;
    }

}
