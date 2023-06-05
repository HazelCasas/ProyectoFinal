package org.example.ConexionBD;

import org.example.Modelo.FutbolAmericano;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FutbolAmericanoDAO implements InterfazDAO
{
    public FutbolAmericanoDAO()
    {

    }

    @Override
    public boolean insertar(Object obj) throws SQLException
    {
        String sqlInsert = "INSERT INTO FutbolAmericano(TipoArticulo, MarcaArticulo, Color, Talla, URLImagen) VALUES (?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("FutbolAmericanoBD.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((FutbolAmericano)obj).getTipoArticulo());
        pstm.setString(2,((FutbolAmericano)obj).getMarcaArticulo());
        pstm.setString(3,((FutbolAmericano)obj).getColor());
        pstm.setString(4,((FutbolAmericano)obj).getTalla());
        pstm.setString(5,((FutbolAmericano)obj).getURLImagen());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException
    {
        String sqlUpdate = "UPDATE FutbolAmericano SET TipoArticulo = ?, MarcaArticulo = ?, Color = ?, Talla = ?, URLImagen = ? WHERE ID = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("FutbolAmericanoBD.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((FutbolAmericano)obj).getTipoArticulo());
        pstm.setString(2,((FutbolAmericano)obj).getMarcaArticulo());
        pstm.setString(3,((FutbolAmericano)obj).getColor());
        pstm.setString(4,((FutbolAmericano)obj).getTalla());
        pstm.setString(5,((FutbolAmericano)obj).getURLImagen());
        pstm.setInt(6,((FutbolAmericano)obj).getID());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException
    {
        String sqlDelete = "DELETE FROM FutbolAmericano WHERE ID = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("FutbolAmericanoBD.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(String.valueOf(id)));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException
    {
        String sql = "SELECT * FROM FutbolAmericano";
        ArrayList<FutbolAmericano> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.getInstance("FutbolAmericanoBD.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next())
        {
            resultado.add(new FutbolAmericano(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException
    {
        String sql = "SELECT * FROM FutbolAmericano WHERE ID = ? ; ";
        FutbolAmericano FA = null;
        PreparedStatement pstm = ConexionSingleton.getInstance("FutbolAmericanoBD.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if(rst.next())
        {
            FA = new FutbolAmericano(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
            return FA;
        }
        return null;
    }
}
