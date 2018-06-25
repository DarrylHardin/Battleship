package com.darrylrhardin.battleship.Ship;

public class Transport extends Ship {
    @Override
    public void setShipSize(int s) {
        super.setShipSize(s + 1);
    }
}
