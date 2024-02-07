package com.example.designpattern.pattern.adapter.implement6;

import java.util.List;

public interface PS2Device {
    static final String GND = "PS/2 GND";
    static final String BLUE = "PS/2 BLUE";
    static final String BLACK = "PS/2 BLACK";
    static final String WHITE = "PS/2 WHITE";
    static final String GREEN = "PS/2 GREEN";
    static final String _5V = "PS/2 5V";
    public List<Wire> getWires();
    public void printWiresConnectionsToRight();
}
