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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class bares extends AppCompatActivity {
    private ListView lista;
    private WebView myWeb;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bares);
        lista = (ListView)findViewById(R.id.listaB);
        myWeb = (WebView)findViewById(R.id.webBares);
        texto = (TextView)findViewById(R.id.tBares);
        Typeface font = Typeface.createFromAsset(getAssets(), "Coffee At Midnight Demo.ttf");
        texto.setTypeface(font);

        String[] valores = new String[]{"Los Recuerdos de Ella", "Charcuteria Sorbitos", "La Playita"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, valores);
        lista.setAdapter(adaptador);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    myWeb.loadUrl("http://toplocalplaces.com/colombia/guatape/bar/tienda-carniceria-bar-los-recuerdos-de-ella/241475252618264");
                }
                else if(position == 1){
                    myWeb.loadUrl("https://www.google.com/search?q=charcuteria+sorbitos+guatape&ie=utf-8&oe=utf-8");
                }
                else if(position == 2){
                    myWeb.loadUrl("http://bares.guiabbb.co/094843/La_Playita");
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
