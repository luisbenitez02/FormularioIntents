package com.example.luisb.formulariointents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarActivity extends AppCompatActivity {
    /*Text Views de datos*/
    private TextView nameData;
    private TextView naceData;
    private TextView phoneData;
    private TextView emailData;
    private TextView descriptData;
    private Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        Bundle datos = getIntent().getExtras();
        //tomamos el nombre de la var que entragamos en el Intent
        String nombre = datos.getString(getResources().getString(R.string.pName));
        String nace = datos.getString(getResources().getString(R.string.pNace));
        String telefono = datos.getString(getResources().getString(R.string.pPhone));
        String email = datos.getString(getResources().getString(R.string.pEmail));
        String descript = datos.getString(getResources().getString(R.string.pDescript));

        //vamos a mostrar los datos en la view
        nameData = (TextView) findViewById(R.id.tvNameData);
        naceData = (TextView) findViewById(R.id.tvNaceData);
        phoneData = (TextView) findViewById(R.id.tvTelData);
        emailData = (TextView) findViewById(R.id.tvEmailData);
        descriptData = (TextView) findViewById(R.id.tvDescriptData);

        //asignamos el texto
        nameData.setText(nombre);
        naceData.setText(nace);
        phoneData.setText(telefono);
        emailData.setText(email);
        descriptData.setText(descript);

        //vamos a definir la accion de regresar BACK a nuestro boton
        atras = (Button) findViewById(R.id.atras);

        atras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
