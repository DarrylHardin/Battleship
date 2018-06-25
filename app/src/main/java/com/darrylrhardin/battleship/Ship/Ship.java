package com.darrylrhardin.battleship.Ship;

import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Ship {
        private int shipSize;
        private int shipArmor = 1;
        private ArrayList<String> shipPosition = new ArrayList<>();
    ArrayList<String> tempShipPosition = new ArrayList<>();
        private static ArrayList<String> taken = new ArrayList<>();
        private String incrementPositionString;
        private int incrementPosition;
        public int getShipSize(){

            return shipSize;
        }

        public void setShipSize(int s){
            shipSize = s;
        }

        public ArrayList<String> getShipPosition(){
            return shipPosition;
        }

        private String getValue(int incrementPosition) {
            switch (incrementPosition) {
                case 1:
                    incrementPositionString = "a";
                    break;
                case 2:
                    incrementPositionString = "b";
                    break;
                case 3:
                    incrementPositionString = "c";
                    break;
                case 4:
                    incrementPositionString = "d";
                    break;
                case 5:
                    incrementPositionString = "e";
                    break;
                case 6:
                    incrementPositionString = "f";
                    break;
                case 7:
                    incrementPositionString = "g";
                    break;
                default:
                    incrementPositionString = "h";
                    break;
            }
            return incrementPositionString;
        }

        public void setShipPosition() {
            int direction = (int) (Math.random() * 2) + 1;
            boolean takenTrue = false;
            int fixedPosition = (int) (Math.random() * 4) + 1;
            incrementPosition = (int) (Math.random() * (8 - shipSize)) + 1;
            if(direction == 1) {
                String letter = getValue(fixedPosition);
                for (int i = 0; i < shipSize; i++) {
                    tempShipPosition.add(letter + incrementPosition);
                    if (taken.contains(letter + incrementPosition)) {
                        tempShipPosition.clear();
                        Log.i(TAG, "tempShipPosition: " + tempShipPosition);
                        setShipPosition();
                        takenTrue = true;
                        break;
                    }
                    incrementPosition++;
                }
            } else {

                for (int i = 0; i < shipSize; i++) {
                    String letter = getValue(incrementPosition++);
                    tempShipPosition.add(letter + fixedPosition);
                    if (taken.contains(letter + fixedPosition)) {
                        tempShipPosition.clear();
                        Log.i(TAG, "tempShipPosition: " + tempShipPosition);
                        setShipPosition();
                        takenTrue = true;
                        break;
                    }
                }
            }
            if(!takenTrue) {
                for (int s = 0; s < shipSize; s++) {
                    shipPosition.add(tempShipPosition.get(s));
                    taken.add(tempShipPosition.get(s));
                }
                Log.i(TAG, "shipPosition: " + shipPosition);
                Log.i(TAG, "taken: " + taken);
            }
        }

}