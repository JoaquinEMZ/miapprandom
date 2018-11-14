package com.example.joakk.aplicacion_test.entidades;

import java.io.Serializable;

public class productos implements Serializable {

    private String nombre_producto;
    private int valor_unitario;
    private int stock;

    public productos(String nombre_producto, int valor_unitario, int stock) {
        this.nombre_producto = nombre_producto;
        this.valor_unitario = valor_unitario;
        this.stock = stock;
    }

    public productos(){

    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(int valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
