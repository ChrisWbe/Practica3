package com.christianquintero.practica3;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView fuente, tDefinitiva;
    private EditText eQuiz, ePro, ePrac, eExpo;
    private float nQuiz = 15, nExp = 10, nPro = 40, nPrac = 35;
    DecimalFormat df = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "Creacion", Toast.LENGTH_SHORT).show();

        //Configuracion de la fuente de texto
        fuente = (TextView)findViewById(R.id.nota);
        Typeface font = Typeface.createFromAsset(getAssets(), "chp-fire.ttf");
        fuente.setTypeface(font);

        //Enlace
        eQuiz = (EditText)findViewById(R.id.quiz);
        ePro = (EditText)findViewById(R.id.pro);
        ePrac = (EditText)findViewById(R.id.pacti);
        eExpo = (EditText)findViewById(R.id.expo);

        tDefinitiva = (TextView)findViewById(R.id.defini);


    }

    public void calculo(View obj){
        if(eQuiz.getText().toString().isEmpty() || ePro.getText().toString().isEmpty() || ePrac.getText().toString().isEmpty() || eExpo.getText().toString().isEmpty()){
            Toast.makeText(this, R.string.campos, Toast.LENGTH_LONG).show();
        }
        else if(eval()){
            Toast.makeText(this, R.string.valores , Toast.LENGTH_LONG).show();
        }
        else{
            float result;
            result = (float)(Float.valueOf(eQuiz.getText().toString())*(nQuiz/100) + Float.valueOf(ePrac.getText().toString())*(nPrac/100) + Float.valueOf(ePro.getText().toString())*(nPro/100) + Float.valueOf(eExpo.getText().toString())*(nExp/100));
            tDefinitiva.setText(String.valueOf(df.format(result)));
        }
    }

    public void limpiar(View obj){
        eQuiz.setText("");
        eExpo.setText("");
        ePrac.setText("");
        ePro.setText("");
        tDefinitiva.setText("");
    }

    //recibe la instancia tipo menu, infla en menu de la action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //programa los eventos del action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId(); //saber que boton a sido precionado
        if(id == R.id.settings){

            //Toast.makeText(this, "Selecciono configurar", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, configura.class);//creo un objeto tipo intent  para luego abrir mi actividad dos desde el menu
            //datos que se quieren pasar a la nueva actividad
            intent.putExtra("pQuiz", 15);
            intent.putExtra("pExpo", 10);
            intent.putExtra("pPrac", 40);
            intent.putExtra("pPro", 35);
            //1234 es el request code quien identifica quien lanza la actividad
            startActivityForResult(intent, 1234);
            //startActivity(intent);
            //itents se utilizan para la recepcion y envio de informacion entre eventos
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestcode quien envia los datos - numero, resultcode si la actividad o resultado es correcto, data el objeto tipo ident con los datos
        //String qu, ex, pra, pro;
        if(requestCode==1234 && resultCode==RESULT_OK){
            //Recibo el texto de la actividad2 y lo pongo como hint
            eQuiz.setText("");
            eExpo.setText("");
            ePrac.setText("");
            ePro.setText("");
            tDefinitiva.setText("Definitiva");
            eQuiz.setHint(data.getExtras().getString("npQuiz")+"%");
            eExpo.setHint(data.getExtras().getString("npExpo")+"%");
            ePrac.setHint(data.getExtras().getString("npPra")+"%");
            ePro.setHint(data.getExtras().getString("npPro")+"%");
            //Toast.makeText(this, "Nuevos datos: Quiz: "+qu+" Exposicion: "+ex+" Practica: "+pra+" Proyectos: "+pro, Toast.LENGTH_LONG).show();
            //Recibo el valor de la actividad2 y se almacena para hacer los calculos
            nQuiz = data.getExtras().getFloat("vnpQuiz");
            nPrac = data.getExtras().getFloat("vnpPra");
            nPro = data.getExtras().getFloat("vnpPro");
            nExp = data.getExtras().getFloat("vnpExpo");
            //Toast.makeText(this, String.valueOf(nQuiz), Toast.LENGTH_LONG).show();

        }
    }




    @Override
    protected void onStart() {
        super.onStart();

        //Toast.makeText(this, "Iniciacion", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "Resumen", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(this, "Reinicio", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "Destruido", Toast.LENGTH_SHORT).show();
    }

    public boolean eval(){
        float n1, n2, n3, n4;
        n1 = Float.valueOf(eQuiz.getText().toString());
        n2 = Float.valueOf(ePro.getText().toString());
        n3 = Float.valueOf(ePrac.getText().toString());
        n4 = Float.valueOf(eExpo.getText().toString());

        if(n1 < 0 || n1 > 5) {
            return true;
        }
        else if(n2 < 0 || n2 > 5){
            return true;
        }
        else if(n3 < 0 || n3 > 5){
            return true;
        }
        else if(n4 < 0 || n4 > 5){
            return true;
        }
        else
            return false;
    }

}
