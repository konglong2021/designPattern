package com.example.designpattern.pattern.decorator.implement3;

abstract class AbstractDecorator extends Component{
    protected Component com;
    public void SetTheComponent(Component c){
        com = c;
    }
    public void doJob(){
        if (com != null) {
            com.doJob();
        }
    }
}
