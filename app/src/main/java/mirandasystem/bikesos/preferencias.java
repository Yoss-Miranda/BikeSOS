package mirandasystem.bikesos;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by ed_yo on 14/10/2017.
 */

public class preferencias extends Activity {
    private EditText nombre1, telefono1,mensaje1;
    private Button guardar;
    private String nombre,telefono,mensaje;



    @Override
    //al abrir el activity, se cargan las preferencias
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferencias);
        nombre1=(EditText)findViewById(R.id.nombre_text);
        telefono1=(EditText)findViewById(R.id.telefono_text);
        mensaje1=(EditText)findViewById(R.id.mensaje_text);

        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        nombre= prefe.getString("nombre1","");
        telefono= prefe.getString("telefono1","");
        mensaje=prefe.getString("mensaje1","");

        nombre1.setText(nombre);
        telefono1.setText(telefono);
        mensaje1.setText(mensaje);
    }
//metodo que se ejecuta al oprimir el Boton Guardar, guarda la configuracion del
    //nombre de contacto, numero telefonico y el mensaje
    public void ejecutarConfiguracion(View v) {
        //se crea las preferancias y el contexto con el que se guardara en este caso es modo privado para evitar
        //que se abra con otra aplicación
        SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("nombre1",nombre1.getText().toString());
        editor.putString("telefono1",telefono1.getText().toString());
        editor.putString("mensaje1",mensaje1.getText().toString());
        editor.commit();
        finish();

        Toast.makeText(this, "Reinicia la App para que surta efecto los cambios", Toast.LENGTH_LONG).show();
    }



}
