package com.example.designpattern.pattern.decorator.implement2;

public class AbstractDecorator extends Component{
    protected Component component;
    public void setTheComponent(Component c){
        component = c;
    }
    @Override
    public void makeHouse() {
        if (component != null) {
            component.makeHouse();
        }
    }
}
