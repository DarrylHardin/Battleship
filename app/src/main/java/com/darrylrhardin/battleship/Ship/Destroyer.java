package com.darrylrhardin.battleship.Ship;

public class Destroyer extends Ship{
    @Override
    public void setShipSize(int s) {
        super.setShipSize(s + 2);
    }
}
