package com.example.christian.quintero.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class sitios extends AppCompatActivity {
    private ListView lista;
    private WebView myWeb;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);

        lista = (ListView)findViewById(R.id.listS);
        myWeb = (WebView)findViewById(R.id.webSitios);
        texto = (TextView)findViewById(R.id.tSitios);

        Typeface font = Typeface.createFromAsset(getAssets(), "Coffee At Midnight Demo.ttf");
        texto.setTypeface(font);


        String[] valores = new String[]{"Piedra del Peñol", "Isla Guaca", "Represa de Guatapé", "Los Zócalos" };
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, valores);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    myWeb.loadUrl("http://www.minube.com.co/rincon/piedra-del-penol-a85982");
                }
                else if(position == 1){
                    myWeb.loadUrl("http://www.minube.com.co/rincon/isla-guaca-a886331");
                }
                else if(position == 2){
                    myWeb.loadUrl("http://www.minube.com.co/rincon/represa-de-guatape-a2141572");
                }
                else if(position == 3){
                    myWeb.loadUrl("http://www.minube.com.co/rincon/los-zocalos-de-guatape-a3621693");
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
