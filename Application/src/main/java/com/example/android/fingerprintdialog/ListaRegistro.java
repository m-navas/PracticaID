package com.example.android.fingerprintdialog;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.fingerprintdialog.entidades.Registro;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListaRegistro extends AppCompatActivity {

    ListView lv_registro;

    ArrayList<String> listaInformacion;
    ArrayList<Registro> listaRegistros;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_registro);

        lv_registro = (ListView)findViewById(R.id.lv_registro);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_registros", null, 1);

        consultarListaRegistros();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaInformacion);

        lv_registro.setAdapter(adaptador);

        lv_registro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String ts = listaRegistros.get(i).getTimestamp().toString();
                Toast.makeText(getApplicationContext(), ts, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void consultarListaRegistros() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Registro registro = null;
        listaRegistros = new ArrayList<>();

        // select * from registro
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_REGISTROS, null);

        while(cursor.moveToNext()){
            registro = new Registro(cursor.getString(0), cursor.getInt(1) > 0, cursor.getInt(2) > 0, cursor.getInt(3) > 0, cursor.getLong(4));
            listaRegistros.add(registro);
        }

        db.close();

        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<>();


        for(Registro r: listaRegistros){
            String elemento = "";
            //elemento+=r.getUsuario() + " - ";
            if(r.getUsuario().equals("propietario")){
                elemento+="Propietario - ";
                if(r.getFn())
                    elemento+="Falso Negativo: SI - ";
                else
                    elemento+="Falso Negativo: NO - ";
            }else{
                elemento+="Externo - ";
                if(r.getFp())
                    elemento+="Falso Positivo: SI - ";
                else
                    elemento+="Falso Positivo: NO - ";
            }

            if(r.getError()){
                elemento+="Error: SI \n";
            }else{
                elemento+="Error: NO \n";
            }

            String pattern = "dd/MM/yyyy hh:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String date = simpleDateFormat.format(new Date(r.getTimestamp()));

            elemento+="Fecha: "+date;

            Utilidades.log(elemento);


            listaInformacion.add(elemento);

        }
    }
}
