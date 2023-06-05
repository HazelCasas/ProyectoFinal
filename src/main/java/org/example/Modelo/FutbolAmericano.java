package org.example.Modelo;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FutbolAmericano
{
    private int ID;
    private String TipoArticulo;
    private String MarcaArticulo;
    private String Color;
    private String Talla;
    private String URLImagen;

    public FutbolAmericano() {
    }

    public FutbolAmericano(int ID, String tipoArticulo, String marcaArticulo, String color, String talla, String URLImagen) {
        this.ID = ID;
        TipoArticulo = tipoArticulo;
        MarcaArticulo = marcaArticulo;
        Color = color;
        Talla = talla;
        this.URLImagen = URLImagen;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTipoArticulo() {
        return TipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        TipoArticulo = tipoArticulo;
    }

    public String getMarcaArticulo() {
        return MarcaArticulo;
    }

    public void setMarcaArticulo(String marcaArticulo) {
        MarcaArticulo = marcaArticulo;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String talla) {
        Talla = talla;
    }

    public String getURLImagen() {
        return URLImagen;
    }

    public void setURLImagen(String URLImagen) {
        this.URLImagen = URLImagen;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    @Override
    public String toString() {
        return "FutbolAmericano{" +
                "ID=" + ID +
                ", TipoArticulo='" + TipoArticulo + '\'' +
                ", MarcaArticulo='" + MarcaArticulo + '\'' +
                ", Color=" + Color +
                ", Talla='" + Talla + '\'' +
                ", URLImagen='" + URLImagen + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException
    {
        URL url = new URL(this.URLImagen);
        return new ImageIcon(url);
    }
}
