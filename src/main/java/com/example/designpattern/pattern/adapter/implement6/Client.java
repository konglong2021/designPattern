package com.example.designpattern.pattern.adapter.implement6;

public class Client {
    public static void main(String[] args) {
        USBDevice adapter = new PS2ToUSBAdapter(new PS2Keyboard());
        adapter.plugInto(new USBPort());
    }
}
