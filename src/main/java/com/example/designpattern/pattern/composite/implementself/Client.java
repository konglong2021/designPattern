package com.example.designpattern.pattern.composite.implementself;

public class Client {
    public static void main(String[] args) {
        Branche branche = new Branche("A Branche");
        Leaf leaf = new Leaf("A Leaf");
        Leaf leaf2 = new Leaf("B Leaf");

        Branche branche1 = new Branche("B Branche");
        Leaf leaf3 = new Leaf("C Leaf");
        Leaf leaf4 = new Leaf("D Leaf");
        branche1.add(leaf3).add(leaf4);
        leaf.add(branche1);
        branche.add(leaf).add(leaf2);
        branche.printStructure();
    }
}
