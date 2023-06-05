package org.example.Controlador;

import org.example.Modelo.FutbolAmericano;
import org.example.Modelo.ModeloTablaFA;
import org.example.Vista.VentanaFA;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorFA extends MouseAdapter
{
    private VentanaFA view;
    private ModeloTablaFA modelo;

    public ControladorFA(VentanaFA view)
    {
        this.view = view;
        modelo = new ModeloTablaFA();
        this.view.getTblFA().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblFA().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(e.getSource() == this.view.getBtnCargar())
        {
            System.out.println("Evento sobre el boton CARGAR.");
            modelo.cargarDatos();
            this.view.getTblFA().setModel(modelo);
            this.view.getTblFA().updateUI();
        }

        if(e.getSource() == this.view.getBtnAgregar())
        {
            System.out.println("Evento sobre el boton AGREGAR.");
            FutbolAmericano FA = new FutbolAmericano();
            FA.setID(0);
            FA.setTipoArticulo(this.view.getTxtTipo().getText());
            FA.setMarcaArticulo(this.view.getTxtMarca().getText());
            FA.setColor(this.view.getTxtColor().getText());
            FA.setTalla(this.view.getTxtTalla().getText());
            FA.setURLImagen(this.view.getTxtURL().getText());
            if(modelo.agregarDatosFA(FA))
            {
                JOptionPane.showMessageDialog(view,"El registro se agrego correctamente.","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(view,"El registro no se pudo agregar correctamente.","Error",JOptionPane.ERROR_MESSAGE);
            }
            modelo.cargarDatos();
            this.view.getTblFA().setModel(modelo);
            this.view.getTblFA().updateUI();
            this.view.limpiar();
        }
       if(e.getSource() == view.getTblFA())
       {
           System.out.println("Evento sobre la TABLA");
           int index = this.view.getTblFA().getSelectedRow();
           FutbolAmericano tmp = modelo.getFAatIndex(index);
           try
           {
               this.view.getLblImagen().setIcon(tmp.getImagen());
           }
           catch (MalformedURLException me)
           {
               System.out.println(e.toString());
           }
       }

        if(e.getSource() == view.getBtnActualizar())
        {
            System.out.println("Evento sobre el botón ACTUALIZAR");
            FutbolAmericano FAUpdate = new FutbolAmericano();
            int index = (int) this.view.getTblFA().getValueAt(this.view.getTblFA().getSelectedRow(), 0);
            FAUpdate.setID(index);
            FAUpdate.setTipoArticulo(this.view.getTxtTipoUpdate().getText());
            FAUpdate.setMarcaArticulo(this.view.getTxtMarcaUpdate().getText());
            FAUpdate.setColor(this.view.getTxtColorUpdate().getText());
            FAUpdate.setTalla(this.view.getTxtTallaUpdate().getText());
            FAUpdate.setURLImagen(this.view.getTxtURLUpdate().getText());
            if (modelo.Actualizar(FAUpdate))
            {
                JOptionPane.showMessageDialog(view,"El registro se modifico correctamente.","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(view,"El registro no se pudo modificar correctamente.","Error",JOptionPane.ERROR_MESSAGE);
            }
            modelo.cargarDatos();
            this.view.getTblFA().setModel(modelo);
            this.view.getTblFA().updateUI();
            this.view.limpiar();
        }

        if(e.getSource() == view.getBtnEliminar())
        {
            System.out.println("Evento sobre el botón ELIMINAR");
            int index = (int) this.view.getTblFA().getValueAt(this.view.getTblFA().getSelectedRow(), 0);
            System.out.println(index);
            int respuesta = JOptionPane.showConfirmDialog(this.view, "¿Quieres eliminar este registro?","Aviso",JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_NO_OPTION)
            {
                modelo.Eliminar(String.valueOf(index));
                JOptionPane.showMessageDialog(this.view,"El registro se elimino correctamente.","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(view,"El registro no se elimino.","Error",JOptionPane.ERROR_MESSAGE);
            }
            modelo.cargarDatos();
            this.view.getTblFA().setModel(modelo);
            this.view.getTblFA().updateUI();
        }
    }
}
