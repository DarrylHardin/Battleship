package com.darrylrhardin.battleship;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.darrylrhardin.battleship.Ship.Destroyer;
import com.darrylrhardin.battleship.Ship.Ship;
import com.darrylrhardin.battleship.Ship.Transport;
import com.darrylrhardin.battleship.Ship.Vessel;

import java.util.ArrayList;
import java.util.ResourceBundle;
import static android.content.ContentValues.TAG;
public class MainActivity extends AppCompatActivity {
    ArrayList<Ship> fleet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vessel vessel = new Vessel();
        Transport transport = new Transport();
        Destroyer destroyer = new Destroyer();
        setContentView(R.layout.activity_main);
        fleet = new ArrayList<>(3);
        fleet.add(vessel);
        fleet.add(transport);
        fleet.add(destroyer);
        for (int i = 0; i < fleet.size(); i++) {
            Log.i(TAG, "fleet loop: " + i);
            Ship thisShip = fleet.get(i);
            thisShip.setShipSize(3);
            thisShip.setShipPosition();
        }
    }

    public void checkHit(View view){
        Resources res = getResources();

        String position = res.getResourceEntryName(view.getId());
        for(int i = 0; i < fleet.size(); i++){
            if(fleet.get(i).getShipPosition().contains(position)){
                view.setBackgroundResource(R.drawable.fire);
            }
        }
        Log.i("checkHit: ", position);
    }

}
