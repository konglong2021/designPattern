package com.example.designpattern.pattern.adapter.implement6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PS2Keyboard implements PS2Device{
    public final List<Wire> wires = Arrays.asList(
            new Wire(_5V),
            new Wire(WHITE),
            new Wire(GREEN),
            new Wire(BLACK),
            new Wire(BLUE),
            new Wire(GND)
    );

    @Override
    public List<Wire> getWires() {
        return Collections.unmodifiableList(wires);
    }

    @Override
    public void printWiresConnectionsToRight() {
        for (Wire wire : wires) {
            wire.printWireConnectionsToRight();
        }
    }
}
