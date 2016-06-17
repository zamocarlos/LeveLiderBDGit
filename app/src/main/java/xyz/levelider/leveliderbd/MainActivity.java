package xyz.levelider.leveliderbd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    //antes extends AppCompatActivity,
    //en el ejemplo de muestra extinede de ListActivity
    //atributos
    Button btnEnviar;
   //ListView lista;
    EditText eTNombre;
    EditText eTCota;
    TextView txtNombre, txtCota;

    private FuenteDatos fuente_datos;
    //private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        //elementos interface
        btnEnviar = (Button)findViewById(R.id.btn_enviar);
        //lista = (ListView)findViewById(R.id.list_view);
        eTNombre = (EditText)findViewById(R.id.et_nombre);
        eTCota = (EditText)findViewById(R.id.et_cota);
        txtNombre = (TextView)findViewById(R.id.txtNombreNuevo);
        txtCota = (TextView)findViewById(R.id.txtCotaNueva);

        //Crear nuevo objeto FuenteDatos
        fuente_datos = new FuenteDatos(this);

        /*
        //Iniciando el nuevo Adaptador
        adapter = new SimpleCursorAdapter(
                this,
                R.id.list_view,
                fuente_datos.getTodasBasesMedicion(),
                new String[]{FuenteDatos.ColumnasBasesMedicion.NOMBRE_BASES_MEDICION, FuenteDatos.ColumnasBasesMedicion.COTA_BASES_MEDICION},
                new int[]{android.R.id.text1, android.R.id.text2},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER

        );

        setListAdapter(adapter);
        */

    }
    //eventos click
    public void clickEnviar(View v) {

        Toast toast = Toast.makeText(this, "Pulsado algún botón", Toast.LENGTH_LONG);
        toast.show();
        if (v.getId()==R.id.btn_enviar) {
            //Click en enviar
            String nombre=eTNombre.getText().toString();
            Double cota = Double.parseDouble(eTCota.getText().toString());
            fuente_datos.guardarFila(nombre, cota);
            txtNombre.setText(nombre);
            txtCota.setText(cota.toString());

            //Refrescando la lista manualmente
            //adapter.changeCursor(fuente_datos.getTodasBasesMedicion());


        }
    }


}


