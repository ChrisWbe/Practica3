package com.example.christian.quintero.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class hoteles extends AppCompatActivity {
    private ListView lista;
    private WebView myWeb;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles);

        lista = (ListView)findViewById(R.id.listaH);
        myWeb = (WebView)findViewById(R.id.webHoteles);
        texto = (TextView)findViewById(R.id.tHoteles);

        Typeface font = Typeface.createFromAsset(getAssets(), "Coffee At Midnight Demo.ttf");
        texto.setTypeface(font);

        String[] valores = new String[]{"Hotel Los recuerdos", "El descanso del Arriero", "Rock a Town Hostel"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, valores);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    myWeb.loadUrl("http://www.hotellosrecuerdos.com/");
                }
                else if(position == 1){
                    myWeb.loadUrl("http://www.hoteleldescansodelarriero.com/");
                }
                else if(position == 2){
                    myWeb.loadUrl("http://www.rockatownguatape.com/");
                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.acerca_de){
            Intent aAcerca = new Intent(this, acercaDe.class);
            startActivity(aAcerca);
        }
        return super.onOptionsItemSelected(item);
    }
}
