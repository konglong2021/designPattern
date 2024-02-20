package com.example.designpattern.pattern.composite.implement1;

public class Client {
    public static void main(String[] args) {
        File root = createTreeOne();
        root.ls();

        System.out.println("***************************");
        File root2 = createTreeTwo();
        root2.ls();
    }

    private static File createTreeOne(){
        File file1 = new BinaryFile("File1",1000);
        File file4 = new BinaryFile("File4",4000);
        Directory dir1 = new Directory("Dir1");
        dir1.add(file1);
        dir1.add(file4);
        File file2 = new BinaryFile("File2",2000);
        File file3 = new BinaryFile("File3",150);
        Directory dir2 = new Directory("Dir2");
        dir2.add(file2);
        dir2.add(file3);
        dir2.add(dir1);
        return dir2;
    }

    private static File createTreeTwo(){
        return new BinaryFile("Another file",200);
    }
}
