package com.example.designpattern.pattern.adapter.implement6;

public class WireCap {
    WireCap link = WireCap.LooseCap;
    private Wire wire;
    public static WireCap LooseCap = new WireCap(null);
    public WireCap(Wire wire){
        this.wire = wire;
    }

    public void addLinkTo(WireCap link){
        this.link = link;
    }
    public Wire getWire(){
        return wire;
    }

    public String toString(){
        if(link.equals(WireCap.LooseCap)){return  "WireCap belonging to LooseCap";}
        return  "WireCap belonging to "+ wire + " is linked to " + link.getWire();
    }

    public WireCap getLink(){
        return link;
    }
}
