package com.example.joakk.aplicacion_test.utilidades;

public class Utilidades {
    //Constantes campos tabla productos
    public static final String TABLA_PRODUCTO ="productos";
    public static final String CAMPO_NOMBRE_PRODUCTO ="nombre_producto";
    public static final String CAMPO_VALOR_UNITARIO ="valor_unitario";
    public static final String CAMPO_STOCK ="stock";


    public static final String sqlCreate_Table_Products = "CREATE TABLE"+ " "+TABLA_PRODUCTO+ "("+CAMPO_NOMBRE_PRODUCTO+" "+ "TEXT,"+ CAMPO_VALOR_UNITARIO+" "+  "INTEGER, "+CAMPO_STOCK+" INTEGER)";


}
