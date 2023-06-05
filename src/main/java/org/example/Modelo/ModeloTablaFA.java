package org.example.Modelo;

import org.example.ConexionBD.FutbolAmericanoDAO;
import org.example.Vista.VentanaFA;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaFA implements TableModel
{
    public static final int COLUMS = 6;
    private ArrayList<FutbolAmericano> datos;
    private FutbolAmericanoDAO FaDAO;

    public ModeloTablaFA()
    {
        FaDAO = new FutbolAmericanoDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaFA (ArrayList<FutbolAmericano> datos)
    {
        this.datos = datos;
    }

    @Override
    public int getRowCount()
    {
        return datos.size();
    }

    @Override
    public int getColumnCount()
    {
        return COLUMS;
    }

    @Override
    public String getColumnName(int i)
    {
        switch (i)
        {
            case 0:
                return "ID";
            case 1:
                return "Tipo";
            case 2:
                return "Marca";
            case 3:
                return "Color";
            case 4:
                return "Talla/Tamaño";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int i)
    {
        switch (i)
        {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int i, int i1)
    {
        return false;
    }

    @Override
    public Object getValueAt(int i, int i1)
    {
        FutbolAmericano tmp = datos.get(i);
        switch (i1)
        {
            case 0:
                return tmp.getID();
            case 1:
                return tmp.getTipoArticulo();
            case 2:
                return tmp.getMarcaArticulo();
            case 3:
                return tmp.getColor();
            case 4:
                return tmp.getTalla();
            case 5:
                return tmp.getURLImagen();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex)
    {
        switch (columnIndex){
            case 0:
                break;
            case 1:
                datos.get(rowIndex).setTipoArticulo((String) o);
                break;
            case 2:
                datos.get(rowIndex).setMarcaArticulo((String) o);
                break;
            case 3:
                datos.get(rowIndex).setColor((String) o);
                break;
            case 4:
                datos.get(rowIndex).setTalla((String) o);
                break;
            case 5:
                datos.get(rowIndex).setURLImagen((String) o);
                break;
            default:
                System.out.println("No se modifico ninguna celda.");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {

    }
    public void cargarDatos()
    {
        try
        {
            datos = FaDAO.obtenerTodo();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        catch (NullPointerException npe)
        {
            System.out.println(npe.getMessage());
        }
    }
    public boolean agregarDatosFA (FutbolAmericano futbolAmericano)
    {
        boolean resultado = false;
        try
        {
            if(FaDAO.insertar(futbolAmericano))
            {
                resultado = true;
            }
            else
            {
                resultado = false;
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public boolean Eliminar(String index)
    {
        boolean resultado = false;
        try
        {
            if(FaDAO.delete(Integer.parseInt(index)))
            {
                resultado = true;
            }
            else
            {
                resultado = false;
            }
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public boolean Actualizar(FutbolAmericano futbolAmericano)
    {
        boolean resultado = false;
        try
        {
            if(FaDAO.update(futbolAmericano))
            {
                resultado = true;
            }
            else
            {
                resultado = false;
            }
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public FutbolAmericano getFAatIndex(int idx)
    {
        return datos.get(idx);
    }
}
