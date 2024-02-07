package com.example.designpattern.pattern.adapter.implement6;

import java.util.List;

public class PS2ToUSBAdapter implements USBDevice{
    private PS2Device device;
    public PS2ToUSBAdapter(PS2Device device){
        this.device = device;
    }
    @Override
    public void plugInto(USBPort port) {
        List<Wire> ps2Wires = device.getWires();
        Wire wireRed = getWireWithNameFromList(PS2Device._5V,ps2Wires);
        Wire wireWhite = getWireWithNameFromList(PS2Device.WHITE,ps2Wires);
        Wire wireGreen = getWireWithNameFromList(PS2Device.GREEN,ps2Wires);
        Wire wireBlack = getWireWithNameFromList(PS2Device.BLACK,ps2Wires);
        port.wireRed.linkLeftTo(wireRed);
        port.wireWhite.linkLeftTo(wireWhite);
        port.wireGreen.linkLeftTo(wireGreen);
        port.wireBlack.linkLeftTo(wireBlack);
        device.printWiresConnectionsToRight();
    }

    private Wire getWireWithNameFromList(String name, List<Wire> wires){
        return wires.stream()
                .filter(x -> name.equals(x.getName()))
                .findAny().orElse(null);
    }
}
