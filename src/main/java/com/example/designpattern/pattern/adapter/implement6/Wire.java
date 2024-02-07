package com.example.designpattern.pattern.adapter.implement6;

public class Wire {
    private String name;
    private WireCap left;
    private WireCap right;
    public Wire(String name){
        this.name = name;
        this.left = new WireCap(this);
        this.right = new WireCap(this);
    }

    public void linkLeftTo(Wire link){
        left.addLinkTo(link.getRightWireCap());
        link.getRightWireCap().addLinkTo(left);
    }

    public WireCap getRightWireCap(){
        return right;
    }

    public void printWireConnectionsToRight(){
        Wire wire = this;
        while(wire.hasLinkedRightCap())
        {
            wire.printRightCap();
            wire = wire.getRightLink();
        }
    }

    public Wire getRightLink(){
        return getRightWireCap().getLink().getWire();
    }

    public void printRightCap(){
        System.out.println(getRightWireCap());
    }

    public boolean hasLinkedRightCap(){
        return !getRightWireCap().link.equals(WireCap.LooseCap);
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return "Wire "+ name;
    }
}
