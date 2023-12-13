package com.example.models;

import java.util.Scanner;

public class Producto {

    public String nombre;
    public String codigo;
    public double precio;
    public int stock;
    public   String marca;
    public   String color;
    public   String calidad;
    public String tipo;



    public Producto() {

    }

    public Producto(String nombre, String codigo, String marca, String color, String calidad, double precio, int stock, String tipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.marca = marca;
        this.color = color;
        this.calidad = calidad;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrecioAsString() {
        return String.valueOf(this.precio);
    }

    public void setPrecioAsString(String precioStr) {
        this.precio = Double.parseDouble(precioStr);
    }
    public String getStockAsString() {
        return String.valueOf(this.stock);
    }

    public void setStockAsString(String stockStr) {
        this.stock = Integer.parseInt(stockStr);
    }

    public void ingresarDatos(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto: ");
        this.nombre = sc.next();
        System.out.println("Ingrese el codigo del producto: ");
        this.codigo = sc.next();
        System.out.println("Ingrese la marca del producto");
        this.marca = sc.next();
        System.out.println("Ingrese el color del producto");
        this.color = sc.next();
        System.out.println("Ingrese la calidad del producto");
        this.calidad = sc.next();
        System.out.println("Ingrese el precio del producto");
        this.precio = sc.nextDouble();
        System.out.println("Ingrese el stock del producto");
        this.stock = sc.nextInt();

    }

}