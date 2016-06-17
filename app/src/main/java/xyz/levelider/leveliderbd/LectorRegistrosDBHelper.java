package xyz.levelider.leveliderbd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Creado por ${Carlos} el día 17/06/2016.
 */
public class LectorRegistrosDBHelper extends SQLiteOpenHelper{
    public static final String NOMBRE_BD = "Almazan.db";
    public static final int VERSION_BD = 1;

    //constructor
    public LectorRegistrosDBHelper(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la tabla BASES_MEDICION
        db.execSQL(FuenteDatos.CREAR_TABLA_BASES_MEDICION);
        /*  Nota: Usamos execSQL() ya que las sentencias son
            para uso interno y no están relacionadas con entradas
            proporcionadas por los usuarios
        */

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*  Añade los cambios que se realizarán en el esquema
                en tu proxima versión
             */

    }
}
