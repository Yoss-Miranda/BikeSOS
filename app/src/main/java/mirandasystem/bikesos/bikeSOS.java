package mirandasystem.bikesos;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


public class bikeSOS extends AppCompatActivity{
    private String nombre,telefono,mensaje;
    private TextView nombre_label,telefono_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_sos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre_label=(TextView)findViewById(R.id.nombre1_label);
        telefono_label=(TextView)findViewById(R.id.telefono1_label);

        cargaPreferencias();

    }
    private void cargaPreferencias(){
        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        nombre= prefe.getString("nombre1","");
        telefono= prefe.getString("telefono1","");
        mensaje=prefe.getString("mensaje1","");
        nombre_label.setText(nombre);
        telefono_label.setText(telefono);
    }

    public void abreMapa(View view){
        Intent activitySettings = new Intent(this, MapsActivity.class );
        startActivity(activitySettings);
    }

    private void enviaSMS(){

            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(telefono, null,mensaje, null, null);
    }

    private void cancelAlarma(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bike_so, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent activitySettings = new Intent(this, preferencias.class );
            startActivity(activitySettings);
        }

        return super.onOptionsItemSelected(item);
    }



}
