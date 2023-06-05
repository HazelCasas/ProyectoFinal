package org.example.Vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class VentanaFA extends JFrame
{
    private JLabel lblID;
    private JLabel lblTipo;
    private JLabel lblMarca;
    private JLabel lblColor;
    private JLabel lblTalla;
    private JLabel lblURL;
    private JTextField txtID;
    private JTextField txtTipo;
    private JTextField txtMarca;
    private JTextField txtColor;
    private JTextField txtTalla;
    private JTextField txtURL;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JTable tblFA;
    private JLabel lblImagen;
    private JButton btnEliminar;
    private JLabel lblIDUpdate;
    private JLabel lblTipoUpdate;
    private JLabel lblMarcaUpdate;
    private JLabel lblColorUpdate;
    private JLabel lblTallaUpdate;
    private JLabel lblURLUpdate;
    private JTextField txtIDUpdate;
    private JTextField txtTipoUpdate;
    private JTextField txtMarcaUpdate;
    private JTextField txtColorUpdate;
    private JTextField txtTallaUpdate;
    private JTextField txtURLUpdate;
    private JButton btnActualizar;

    public VentanaFA(String title) throws HeadlessException
    {
        super(title);
        this.setSize(1200,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //Panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(155, 87, 87));
        lblID = new JLabel("ID:");
        txtID = new JTextField(5);
        txtID.setText("0");
        txtID.setEnabled(false);
        lblTipo = new JLabel("Tipo de articulo:");
        txtTipo = new JTextField(20);
        lblMarca = new JLabel("Marca del articulo:");
        txtMarca = new JTextField(20);
        lblColor = new JLabel("Color del articulo:");
        txtColor = new JTextField(15);
        lblTalla = new JLabel("Talla/tamaño del articulo:");
        txtTalla = new JTextField(10);
        lblURL = new JLabel("Imagen del articulo:");
        txtURL = new JTextField(30);
        btnAgregar = new JButton("Agregar");

        panel1.add(lblID);
        panel1.add(txtID);
        panel1.add(lblTipo);
        panel1.add(txtTipo);
        panel1.add(lblMarca);
        panel1.add(txtMarca);
        panel1.add(lblColor);
        panel1.add(txtColor);
        panel1.add(lblTalla);
        panel1.add(txtTalla);
        panel1.add(lblURL);
        panel1.add(txtURL);
        panel1.add(btnAgregar);

        //Panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(94, 110, 166, 255));
        tblFA = new JTable();
        panel2.add(tblFA);
        scrollPane = new JScrollPane(tblFA);
        panel2.add(scrollPane);
        btnCargar = new JButton("Cargar...");
        panel2.add(btnCargar);

        //Panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(94, 110, 166,255));
        lblImagen = new JLabel("...");
        panel3.add(lblImagen);

        //Panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(155, 87, 87));
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        lblIDUpdate = new JLabel("ID:");
        txtIDUpdate = new JTextField(5);
        txtIDUpdate.setText("0");
        txtIDUpdate.setEnabled(false);
        lblTipoUpdate = new JLabel("Tipo de articulo:");
        txtTipoUpdate = new JTextField(20);
        lblMarcaUpdate = new JLabel("Marca del articulo:");
        txtMarcaUpdate = new JTextField(20);
        lblColorUpdate = new JLabel("Color del articulo:");
        txtColorUpdate = new JTextField(15);
        lblTallaUpdate = new JLabel("Talla/tamaño del articulo:");
        txtTallaUpdate = new JTextField(10);
        lblURLUpdate = new JLabel("Imagen del articulo:");
        txtURLUpdate = new JTextField(30);

        panel4.add(lblIDUpdate);
        panel4.add(txtIDUpdate);
        panel4.add(lblTipoUpdate);
        panel4.add(txtTipoUpdate);
        panel4.add(lblMarcaUpdate);
        panel4.add(txtMarcaUpdate);
        panel4.add(lblColorUpdate);
        panel4.add(txtColorUpdate);
        panel4.add(lblTallaUpdate);
        panel4.add(txtTallaUpdate);
        panel4.add(lblURLUpdate);
        panel4.add(txtURLUpdate);
        panel4.add(btnActualizar);
        panel4.add(btnEliminar);

        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblID() {
        return lblID;
    }

    public void setLblID(JLabel lblID) {
        this.lblID = lblID;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }

    public void setLblTipo(JLabel lblTipo) {
        this.lblTipo = lblTipo;
    }

    public JLabel getLblMarca() {
        return lblMarca;
    }

    public void setLblMarca(JLabel lblMarca) {
        this.lblMarca = lblMarca;
    }

    public JLabel getLblColor() {
        return lblColor;
    }

    public void setLblColor(JLabel lblColor) {
        this.lblColor = lblColor;
    }

    public JLabel getLblTalla() {
        return lblTalla;
    }

    public void setLblTalla(JLabel lblTalla) {
        this.lblTalla = lblTalla;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(JTextField txtTipo) {
        this.txtTipo = txtTipo;
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(JTextField txtMarca) {
        this.txtMarca = txtMarca;
    }

    public JTextField getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(JTextField txtColor) {
        this.txtColor = txtColor;
    }

    public JTextField getTxtTalla() {
        return txtTalla;
    }

    public void setTxtTalla(JTextField txtTalla) {
        this.txtTalla = txtTalla;
    }

    public JTextField getTxtURL() {
        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {
        this.txtURL = txtURL;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JTable getTblFA() {
        return tblFA;
    }

    public void setTblFA(JTable tblFA)
    {
        this.tblFA = tblFA;
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JLabel getLblTipoUpdate() {
        return lblTipoUpdate;
    }

    public void setLblTipoUpdate(JLabel lblTipoUpdate) {
        this.lblTipoUpdate = lblTipoUpdate;
    }

    public JLabel getLblMarcaUpdate() {
        return lblMarcaUpdate;
    }

    public void setLblMarcaUpdate(JLabel lblMarcaUpdate) {
        this.lblMarcaUpdate = lblMarcaUpdate;
    }

    public JLabel getLblColorUpdate() {
        return lblColorUpdate;
    }

    public void setLblColorUpdate(JLabel lblColorUpdate) {
        this.lblColorUpdate = lblColorUpdate;
    }

    public JLabel getLblTallaUpdate() {
        return lblTallaUpdate;
    }

    public void setLblTallaUpdate(JLabel lblTallaUpdate) {
        this.lblTallaUpdate = lblTallaUpdate;
    }

    public JLabel getLblURLUpdate() {
        return lblURLUpdate;
    }

    public void setLblURLUpdate(JLabel lblURLUpdate) {
        this.lblURLUpdate = lblURLUpdate;
    }

    public JTextField getTxtTipoUpdate() {
        return txtTipoUpdate;
    }

    public void setTxtTipoUpdate(JTextField txtTipoUpdate) {
        this.txtTipoUpdate = txtTipoUpdate;
    }

    public JTextField getTxtMarcaUpdate() {
        return txtMarcaUpdate;
    }

    public void setTxtMarcaUpdate(JTextField txtMarcaUpdate) {
        this.txtMarcaUpdate = txtMarcaUpdate;
    }

    public JTextField getTxtColorUpdate() {
        return txtColorUpdate;
    }

    public void setTxtColorUpdate(JTextField txtColorUpdate) {
        this.txtColorUpdate = txtColorUpdate;
    }

    public JTextField getTxtTallaUpdate() {
        return txtTallaUpdate;
    }

    public void setTxtTallaUpdate(JTextField txtTallaUpdate) {
        this.txtTallaUpdate = txtTallaUpdate;
    }

    public JTextField getTxtURLUpdate() {
        return txtURLUpdate;
    }

    public void setTxtURLUpdate(JTextField txtURLUpdate) {
        this.txtURLUpdate = txtURLUpdate;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JLabel getLblIDUpdate() {
        return lblIDUpdate;
    }

    public void setLblIDUpdate(JLabel lblIDUpdate) {
        this.lblIDUpdate = lblIDUpdate;
    }

    public JTextField getTxtIDUpdate() {
        return txtIDUpdate;
    }

    public void setTxtIDUpdate(JTextField txtIDUpdate) {
        this.txtIDUpdate = txtIDUpdate;
    }

    public void limpiar()
    {
        txtTipo.setText("");
        txtMarca.setText("");
        txtColor.setText("");
        txtTalla.setText("");
        txtURL.setText("");
    }
}
