package com.example.amst8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    Animation anim;             // Se inicializa animacion de transicion
    ImageView imageView;       //Se inicializa imagen de presentacion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);   //Se crea una vista para el splash
        imageView=(ImageView)findViewById(R.id.imageView); // Se declaro una imageView para mostrar la animacion.
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in); // Se creo la animacion.
        anim.setAnimationListener(new Animation.AnimationListener() { //Se implementa la animacion en el app
            @Override
            public void onAnimationStart(Animation animation) { //Funcion para empezar la animacion
            }

            @Override
            public void onAnimationEnd(Animation animation) {//Funcion para empezar la animacion
                startActivity(new Intent(Splash.this, Login.class));//comienza la interaccion en la app
                // MainActivity.class es la activity que se muestra despues de la pantalla splash.
                finish();//finaliza funcion
            }

            @Override
            public void onAnimationRepeat(Animation animation) {//Funcion para repetir la animacion
            }
        });
        imageView.startAnimation(anim);//Se comienza la animacion en el imageView
    }
}
