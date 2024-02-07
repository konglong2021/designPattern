package com.example.designpattern.pattern.proxy.implement2;

import java.util.ArrayList;
import java.util.List;

public class ProxySubject extends Subject{
    private Subject subject;
    String currentUser;
    List<String> registeredUsers;
    public ProxySubject(){
        if(subject == null){
            subject = new ConcreteSubject();
        }

        registeredUsers = new ArrayList<String>();
        registeredUsers.add("Admin");
        registeredUsers.add("Kate");
        registeredUsers.add("Sam");
    }
    @Override
    public void doSomeWork(String user) {
      System.out.println("\nThe proxy call is happening now.");
      System.out.println(user + " wants to invoke a proxy method.");
      if (registeredUsers.contains(user)){
          subject.doSomeWork(user);
      }else {
          System.out.println("Sorry, "+ user + ", you do not have access rights.");
      }
    }
}
