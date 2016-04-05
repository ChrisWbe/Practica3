package com.example.christian.quintero.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class publicidad extends AppCompatActivity {
    private TextView eTit1, eTit2, eHot, eBar, eSit, eDem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicidad);
        eTit1 = (TextView)findViewById(R.id.principal1);
        eTit2 = (TextView)findViewById(R.id.principal2);
        eHot = (TextView)findViewById(R.id.hot);
        eBar = (TextView)findViewById(R.id.bar);
        eSit = (TextView)findViewById(R.id.sit);
        eDem = (TextView)findViewById(R.id.dem);
        Typeface font = Typeface.createFromAsset(getAssets(), "Coffee At Midnight Demo.ttf");
        eTit1.setTypeface(font);
        eTit2.setTypeface(font);
    }

    //Actividad para Hoteleria
   public void iHotel(View obj){
        Intent aHotel = new Intent(this, hoteles.class);
        startActivity(aHotel);

    }

    //Actividad para Bares
    public void iBar(View obj){
        Intent aBar = new Intent(this, bares.class);
        startActivity(aBar);
    }

    //Actividad para Sitios Turisticos
    public void iSitios(View obj){
        Intent aSitios = new Intent(this, sitios.class);
        startActivity(aSitios);
    }

    //Actividad para Informacion demografica
    public void iDemografia(View obj){
        Intent aDemo = new Intent(this, demografia.class);
        startActivity(aDemo);
    }

    //Inflo el menu en el action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //Programo la accion de mi menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.acerca_de){
            Intent aAcerca = new Intent(this, acercaDe.class);
            startActivity(aAcerca);
        }
        return super.onOptionsItemSelected(item);
    }

}
