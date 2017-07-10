package com.example.luisb.formulariointents;

import java.util.Calendar;//el IDE importa la lib vieja

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editNace;
    private int dia;
    private int mes;
    private int anio;

    /*Text edit*/
    //los defino aqui para poderlos editar en los diferentes metodos mas facil
    private EditText editNombre;
    private EditText editPhone;
    private EditText editEmail;
    private EditText editDescript;

    private Contacto nuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*asocio los elementos con las vistas*/
        editNace = (EditText) findViewById(R.id.editNace);
        editNombre = (EditText) findViewById(R.id.EditNombre);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editDescript = (EditText) findViewById(R.id.editDescription);

        Button siguiente = (Button) findViewById(R.id.button);

        /*
        * Al boton ser pulsado llamara a este metodo
        * */
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //capturamos los textos en cada campo
                String nombre = editNombre.getText().toString();
                String nacimiento = editNace.getText().toString();
                String telefono = editPhone.getText().toString();
                String email = editEmail.getText().toString();
                String descripcion = editDescript.getText().toString();

                //podria pasar los datos en variable directo a cada intent pero queria probar los objetos

                nuevo = new Contacto(nombre,telefono,email,nacimiento,descripcion);


                Intent intento = new Intent(MainActivity.this,ConfirmarActivity.class);
                /*pName es una var de texto que tiene el string "Nombre"
                * para mantener nuestro codigo ordenando lo uso asi
                * sin embargo tambien puedo poner por ejemplo "nombre"
                y de igual manera pedirlo en confirmarActivity.java*/
                intento.putExtra(getResources().getString(R.string.pName),nuevo.getNombre());
                intento.putExtra(getResources().getString(R.string.pNace), nuevo.getNacimiento());
                intento.putExtra(getResources().getString(R.string.pPhone), nuevo.getTelefono());
                intento.putExtra(getResources().getString(R.string.pEmail), nuevo.getEmail());
                intento.putExtra(getResources().getString(R.string.pDescript), nuevo.getDescript());
                startActivity(intento);
            }
        });

    }

    /*
    * Vamos a recibir la pulsacion de icono de calendario
    * */
    public void datePicker(View v){

        final Calendar nace = Calendar.getInstance();
        dia = nace.get(Calendar.DAY_OF_MONTH);
        mes = nace.get(Calendar.MONTH);
        anio = nace.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //mostraremos la fecha que selecciona el usuario en nuestro TextView
                editNace.setText(dayOfMonth + "/" + (month+1) + "/" + year);
            }
        }, dia, mes, anio);

        datePickerDialog.show();
    }


}
