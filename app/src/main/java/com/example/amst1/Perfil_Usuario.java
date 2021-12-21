package com.example.amst1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Perfil_Usuario extends AppCompatActivity {
    private TextView tvname, tvapellido, tvcorreo, tvcelular, tvfavorito; //Se inicializan los textview de cada peticion de la app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil__usuario); //Se inicializa la ventana del xml para modificarla
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "bookstore", null, 1); //Se inicializa la base de datos de libros creada en archivos anteriores
        SQLiteDatabase db = admin.getReadableDatabase();  //Se vincula directamente con nuestra base de datos creada


        tvname= findViewById(R.id.tvname1); //vincula directamente lo que se escriba en la interfaz, en este caso el nombre
        tvapellido= findViewById(R.id.tvapellido1);//vincula directamente lo que se escriba en la interfaz, en este caso el apellido
        tvcorreo= findViewById(R.id.tvcorreo1);//vincula directamente lo que se escriba en la interfaz, en este caso el correo
        tvcelular= findViewById(R.id.tvcelular1);//vincula directamente lo que se escriba en la interfaz, en este caso el celular
        tvfavorito= findViewById(R.id.tvfavorito1);//vincula directamente lo que se escriba en la interfaz, en este caso el favorito
        Intent con = getIntent();
        String u = con.getStringExtra(Login.EXTRA_MESSAGE);//se crea nueva variable de letras que representa lo escrito
        Cursor fila = db.rawQuery(
                "select name,apellidos,correo,celular,favcategoria from userdata where username = '"+u+"'", null);//cuando exista algun dato de la base de datos que se vincule directamente con lo escrito
        if(fila.moveToFirst()) { //si se encuentra
            tvname.setText(fila.getString(0));//se muestra el nombre
            tvapellido.setText(fila.getString(1));//se muestra el apellido
            tvcorreo.setText(fila.getString(2));// se muestra el correo
            tvcelular.setText(fila.getString(3));//se muestra el celular
            Cursor cat = db.rawQuery(
                    "Select descripcion from categoria where id = " + fila.getString(4),null );
            if(cat.moveToFirst()) {
                tvfavorito.setText(cat.getString(0));
            }
            cat.close();
            fila.close(); //Finalmente se valida la categoria favorita por medio de una consulta
        }
        db.close();
    }

    public void salir(View view) {//Funcion salir
        Intent i = new Intent(this, Login.class );
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public void inicio(View view) {//funcion Inicio
        Intent i = new Intent(this, Main.class );
        Bundle datos = this.getIntent().getExtras();
        String msg1 = datos.getString(Login.EXTRA_MESSAGE);
        i.putExtra(Login.EXTRA_MESSAGE, msg1);
        startActivity(i);
        finish();
    }

    public void verCategorias(View v) {//funcion ver Categorias
        Intent i = new Intent(this, Categorias.class);
        Bundle datos = this.getIntent().getExtras();
        String msg1 = datos.getString(Login.EXTRA_MESSAGE);
        i.putExtra(Login.EXTRA_MESSAGE, msg1);
        startActivity(i);
        finish();
    }

    public void verPerfil(View view) {// funcion ver perfil
        Toast toast = Toast.makeText(this, "Se encuentra en la sección perfil", Toast.LENGTH_SHORT);
        toast.show();
    }


}