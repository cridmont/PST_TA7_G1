package com.example.amst1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table categoria(id integer primary key autoincrement, descripcion text not null, imgsrc text not null)");
        db.execSQL("insert into categoria values (null, 'Acción','accion')");
        db.execSQL("insert into categoria values (null, 'Auto Ayuda','help')");
        db.execSQL("insert into categoria values (null, 'Romance','romance')");
        db.execSQL("insert into categoria values (null, 'Terror','terror')");

        db.execSQL("create table userdata(codigo varchar(3) not null primary key, username text unique not null, password text not null," +
                "name text not null, apellidos text not null, correo text not null, celular varchar(10), " +
                "favcategoria integer not null, foreign key (favcategoria) references categoria(id))");
        db.execSQL("insert into userdata values ('001', 'admin', 'admin', 'Erick', 'Pulley'," +
                "'ersepull@espol.edu.ec','1722657556', 1)");
        db.execSQL("insert into userdata values ('002', 'user', 'password', 'Darien', 'Bustos'," +
                "'dardbust@espol.edu.ec','0941459620', 3)");
        db.execSQL("insert into userdata values ('003', 'Montenegro', '1234', 'Cristoffer', 'Montenegro'," +
                "'cridmont@espol.edu.ec','0202504437', 2)");
        db.execSQL("insert into userdata values ('004', 'Gio', 'dav', 'Giovanny', 'Mite'," +
                "'gwmite@espol.edu.ec','0958444911', 4)");

        db.execSQL("create table libro(isbn varchar(4) unique not null primary key," +
                "titulo text not null, autor text not null, publicacion varchar(4)," +
                "descripcion text not null, imgsrc text not null," +
                "idcategoria integer not null, foreign key (idcategoria) references categoria(id))");
        db.execSQL("insert into libro values ('0001', 'EL EFECTO MARIPOSA', 'Joaquin de Saint-Aymour','2007'," +
                "'¿Se puede materializar el sueño de nuestra vida? Según la Teoría del Caos, una pequeña influencia en el sistema puede causar una reacción global modificando la realidad, tal como el aleteo de una mariposa en Brasil puede provocar un tornado en Japón: es el llamado Efecto Mariposa.'," +
                "'a_elefectomariposa_joaquindesaint', 1)");
        db.execSQL("insert into libro values ('0002', 'LOS JUEGOS DEL HAMBRE ENTRE LLAMAS', 'Suzanne Collins','2009'," +
                "'Katniss Everdeen ha sobrevivido a Los juegos del hambre. Pero el Capitolio quiere venganza. ... Aunque Katniss debería sentirse aliviada, se rumorea que existe una rebelión contra el Capitolio, una rebelión que puede que Katniss y Peeta hayan ayudado a inspirar.'," +
                "'a_enllamas_suzannecollins', 1)");
        db.execSQL("insert into libro values ('0003', 'JUEGO DE TRONOS CANCION DE HIELO Y FUEGO', 'George R. R. Martin','1996'," +
                "'Tras el largo verano, el inverno se acerca a los Siete Reinos. Lord Eddard Stark, señor de Invernalia, deja sus dominios para unirse a la corte de su amigo el rey Robert Baratheon, llamado el Ursurpador, hombre díscolo y otrora guerrero audaz cuyas mayores aficiones son comer, beber y engendrar bastardos.'," +
                "'a_juegodetronos_georgemartin', 1)");

        db.execSQL("insert into libro values ('0004', 'EN BUSCA DE LA FELICIDAD', 'Chris Gardner','2006'," +
                "'En Busca de la Felicidad narra la lucha constante por sobrevivir, donde el amor de un padre hacia su hijo da fuerzas para seguir adelante, para no rendirse en el camino tras perder el trabajo y ser abandonado por su mujer.'," +
                "'h_enbuscadelafelicidad_chrisgardner', 2)");
        db.execSQL("insert into libro values ('0005', 'HOW TO GET RICH DONALD TRUMP', 'Donald Trump','2004'," +
                "'En esta obra, Donald Trump nos da las claves para saber cómo debemos invertir, impresionar al jefe y conseguir un aumento, dirigir un negocio de forma eficiente, negociar cualquier tipo de cosa y de qué manera pensar y vivir a lo grande.'," +
                "'h_howtogetrich_donaldtrump', 2)");
        db.execSQL("insert into libro values ('0006', 'PADRE RICO PADRE POBRE', 'Robert T. Kiyosaki','1997'," +
                "'El libro de finanzas personales número 1 en todo el mundo.Con un estilo claro y ameno, este libro te pondrá en el camino directo al éxito financiero y así lograrás que el dinero trabaje para ti.'," +
                "'h_padrericopadrepobre_robertkiyosaki1', 2)");


        db.execSQL("insert into libro values ('0007', 'BAJO LA MISMA ESTRELLA', 'John Green','2012'," +
                "'Una historia que explora cuán exquisita y trágica puede ser la aventura de saberse vivo y querer a alguien. Emotiva, irónica y afilada. Una novela teñida de humor y de tragedia que habla de nuestra capacidad para soñar incluso en las circunstancias más difíciles. A Hazel y a Gus les gustaría tener vidas más corrientes.'," +
                "'r_blme_johngreen', 3)");
        db.execSQL("insert into libro values ('0008', 'LO QUE EL VIENTO SE LLEVO', 'Margaret Mitchell','1936'," +
                "'La novela gira en torno a la historia de una joven de una familia aristócrata sureña, Scarlett OHara en la época de la Guerra de Secesión. ... De por medio muchas vicisitudes y relaciones de Scarlett con otros hombres por despecho o por interés.'," +
                "'r_loqueelvientosellevo_mitchell', 3)");
        db.execSQL("insert into libro values ('0009', 'ORGULLO Y PREJUICIO', 'Jane Austen','1813'," +
                "'La señora Bennet ha criado a sus cinco hijas con el único deseo de encontrar marido. La llegada al vecindario de Charles Bingley, un joven rico y soltero, con algunas amistades despierta el interés de las hermanas Bennet y de las familias vecinas, que verán una excelente oportunidad para cumplir su propósito.'," +
                "'r_orgulloyprejuicio_janeausten', 3)");

        db.execSQL("insert into libro values ('0010', 'CORALINE', 'Neil Gaiman','2002'," +
                "'Pronto Coraline se da cuenta de que, tras los espejos, hay otros niños que han caído en la trampa. Son como almas perdidas, y ahora ella es su única esperanza de salvación. Pero para rescatarlos tendrá también que recuperar a sus verdaderos padres, y cumplir así el desafío que le permitirá volver a su vida anterior.'," +
                "'t_coraline_neilgatman', 4)");
        db.execSQL("insert into libro values ('0011', 'HANNIBAL', 'Thomas Harris','1999'," +
                "'Hannibal Lecter, huérfano y testigo de barbaridades indescriptibles, sobrevive al vendaval de la Segunda Guerra Mundial en Europa del Este. Al terminar el conflicto su tío le localiza en un orfanato soviético y lo lleva a París para vivir con él y su bella esposa, lady Murasaki.'," +
                "'t_hanibal_thomasharris1', 4)");
        db.execSQL("insert into libro values ('0012', 'IT', 'Stephen King','1986'," +
                "'Cuenta la historia de un grupo de siete niños que son aterrorizados por un malvado monstruo -al que llaman «Eso»- que es capaz de cambiar de forma, alimentándose del terror que produce en sus víctimas.'," +
                "'t_it_stephenking', 4)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}