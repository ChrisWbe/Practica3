package com.example.christian.quintero.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

public class demografia extends AppCompatActivity {
    private TextView texto;
    private WebView myWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demografia);

        texto = (TextView)findViewById(R.id.tDem);
        Typeface font = Typeface.createFromAsset(getAssets(), "Coffee At Midnight Demo.ttf");
        texto.setTypeface(font);

        myWeb = (WebView)findViewById(R.id.webDem);


        myWeb.loadUrl("https://es.wikipedia.org/wiki/Guatap%C3%A9");
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
