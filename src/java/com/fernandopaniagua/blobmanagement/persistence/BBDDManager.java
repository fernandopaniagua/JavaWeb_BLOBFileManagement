package com.fernandopaniagua.blobmanagement.persistence;

import com.fernandopaniagua.blobmanagement.model.Imagen;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BBDDManager {
    public static void storeImage(Imagen imagen) 
            throws IOException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/imagenes", "root", "");
        String sql = "INSERT INTO imagenes (nombre, fichero) VALUE (?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, imagen.getNombre());
        ps.setBytes(2, imagen.getFichero());
        ps.execute();
        conexion.close();
    }
    public static ArrayList<Imagen> loadImages() throws ClassNotFoundException, SQLException{
        ArrayList<Imagen> imagenes = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/imagenes", "root", "");
        String sql = "select * from imagenes";
        Statement stm = conexion.createStatement();
        ResultSet resultados = stm.executeQuery(sql);
        while(resultados.next()){
            imagenes.add(new Imagen(resultados.getString("nombre"),resultados.getBytes("fichero")));
        }
        conexion.close();
        return imagenes;
    }
}
