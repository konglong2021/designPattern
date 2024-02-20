package com.example.designpattern.pattern.composite.implement1;

import java.util.ArrayList;
import java.util.List;

public class Directory extends File{

    private List<File> children = new ArrayList<>();
    public Directory(String name){
        super(name);
    }
    public void add(File file){
        children.add(file);
    }

    public File[] getFiles(){
        return children.toArray(new File[children.size()]);
    }

    public boolean remove(File file){
        return children.remove(file);
    }
    @Override
    public void ls() {
        System.out.println("Branch " + getName());
        children.forEach(File::ls);
    }
}
