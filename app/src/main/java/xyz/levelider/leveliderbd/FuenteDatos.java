package xyz.levelider.leveliderbd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Creado por ${Carlos} el día 17/06/2016.
 */
public class FuenteDatos {
    //Metainformación de la base de datos
    public static final String NOMBRE_BASES_MEDICION = "BASES_MEDICION";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";
    public static final String NUMERO_TYPE = "number";

    //Campos de la tabla BASES_MEDICION
    public static class ColumnasBasesMedicion{
        public static final String ID_BASES_MEDICION = BaseColumns._ID;
        public static final String NOMBRE_BASES_MEDICION = "nombre";
        public static final String COTA_BASES_MEDICION = "cota";
        public static final String DESCRIPCION_BASES_MEDICION = "descripcion";
        public static final String ORIGEN_BASES_MEDICION = "origen";
    }

    //Script de Creación de la tabla BASES_MEDICION
    public static final String CREAR_TABLA_BASES_MEDICION =
            "create table "+NOMBRE_BASES_MEDICION+" (" +
                    ColumnasBasesMedicion.ID_BASES_MEDICION+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnasBasesMedicion.NOMBRE_BASES_MEDICION+" "+STRING_TYPE+" not null,"+
                    ColumnasBasesMedicion.COTA_BASES_MEDICION+" "+NUMERO_TYPE+" not null,"+
                    ColumnasBasesMedicion.DESCRIPCION_BASES_MEDICION+" "+STRING_TYPE+", "+
                    ColumnasBasesMedicion.ORIGEN_BASES_MEDICION+" "+STRING_TYPE;

    //////////////////////////////////////////////////////////////////////////////////////////
    //Variables para manipulación de datos
    private LectorRegistrosDBHelper openHelper;
    private SQLiteDatabase baseDatos;

    public FuenteDatos(Context context) {
        //Creando una instancia hacia la base de datos
        openHelper = new LectorRegistrosDBHelper(context);
        baseDatos = openHelper.getWritableDatabase();
    }

    public void guardarFila (String nombre, long cota) {
        //Nuestro contenedor de valores
        ContentValues valores = new ContentValues();

        //Seteando nombre y cota
        valores.put(ColumnasBasesMedicion.NOMBRE_BASES_MEDICION, nombre);
        valores.put(ColumnasBasesMedicion.COTA_BASES_MEDICION, cota);

        //Insertando en la base de datos
        baseDatos.insert(NOMBRE_BASES_MEDICION, null, valores); //valores tiene que ser del tipo ContentValues()
    }

    public Cursor getTodasBasesMedicion(){
        //Seleccionamos todas las filas de la tabla BASES_MEDICION
        return baseDatos.rawQuery("select * from "+NOMBRE_BASES_MEDICION, null);
    }


}
