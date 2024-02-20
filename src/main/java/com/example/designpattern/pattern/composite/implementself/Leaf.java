package com.example.designpattern.pattern.composite.implementself;

import java.util.ArrayList;
import java.util.List;

public class Leaf extends Tree {

    private List<Tree> tree = new ArrayList<>();
    public Leaf(String name) {
        super(name);
    }

    public Leaf add(Tree tree){
        this.tree.add(tree);
        return this;
    }

    public List<Tree> getTree(){
        return tree;
    }

    public void remove(Tree tree){
        this.tree.remove(tree);
    }

    @Override
    public void printStructure() {
        System.out.println("Leaf " + getName());
        getTree().forEach(Tree::printStructure);
    }
}
