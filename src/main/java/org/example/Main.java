package org.example;

import org.example.Controlador.ControladorFA;
import org.example.Vista.VentanaFA;

public class Main
{
    public static void main(String[] args)
    {
        VentanaFA ventana = new VentanaFA("Proyecto Final: Futbol Americano.");
        ControladorFA controller = new ControladorFA(ventana);
    }
}