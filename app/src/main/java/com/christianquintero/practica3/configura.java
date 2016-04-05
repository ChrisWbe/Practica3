package com.christianquintero.practica3;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class configura extends AppCompatActivity {
    private TextView custom;
    private EditText eQuiz, ePro, ePra, eExpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configura);

        //Configuracion de la fuente de texto
        custom = (TextView)findViewById(R.id.nota2);
        Typeface font = Typeface.createFromAsset(getAssets(), "chp-fire.ttf");
        custom.setTypeface(font);

        eQuiz = (EditText)findViewById(R.id.epQuiz);
        ePro = (EditText)findViewById(R.id.epPro);
        ePra = (EditText)findViewById(R.id.epPrac);
        eExpo = (EditText)findViewById(R.id.epEx);

        //Para recibir los datos de otra actividad se debe crear un objeto tipo Bundle
        Bundle extras = getIntent().getExtras();

        eQuiz.setText(String.valueOf(extras.getInt("pQuiz")));
        ePro.setText(String.valueOf(extras.getInt("pPro")));
        ePra.setText(String.valueOf(extras.getInt("pPrac")));
        eExpo.setText(String.valueOf(extras.getInt("pExpo")));
    }

    public void guardar(View obje){

        if(eQuiz.getText().toString().isEmpty() || ePra.getText().toString().isEmpty() || ePro.getText().toString().isEmpty() || eExpo.getText().toString().isEmpty()){
            Toast.makeText(this, R.string.campos, Toast.LENGTH_LONG).show();
        }
        else{
            int tot;
            tot = Integer.valueOf(eQuiz.getText().toString()) + Integer.valueOf(ePra.getText().toString()) + Integer.valueOf(ePro.getText().toString()) + Integer.valueOf(eExpo.getText().toString());

            if(tot == 100){
                Intent envio = new Intent();
                //Envio el texto del edittext para mostrar el nuevo porcentaje
                envio.putExtra("npQuiz", eQuiz.getText().toString());
                envio.putExtra("npPro", ePro.getText().toString());
                envio.putExtra("npPra", ePra.getText().toString());
                envio.putExtra("npExpo", eExpo.getText().toString());
                //Envio el valor en el edittext para hacer los calculos
                envio.putExtra("vnpQuiz", Float.valueOf(eQuiz.getText().toString()));
                envio.putExtra("vnpPro", Float.valueOf(ePro.getText().toString()));
                envio.putExtra("vnpPra", Float.valueOf(ePra.getText().toString()));
                envio.putExtra("vnpExpo", Float.valueOf(eExpo.getText().toString()));
                setResult(RESULT_OK, envio);
                finish();
            }
            else if(tot < 100){

                Toast.makeText(this, R.string.totMe, Toast.LENGTH_LONG).show();
            }

            else{
                Toast.makeText(this, R.string.totSu, Toast.LENGTH_LONG).show();
            }
        }



    }
    public void limpiar(View Obje){
        eQuiz.setText("");
        ePra.setText("");
        ePro.setText("");
        eExpo.setText("");
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

