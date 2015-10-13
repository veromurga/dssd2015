/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.QueryHint;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 *
 * @author jorge
 */
@Path("personas")
public class Personas {

    @GET
    @Path("buscar")
    public String listar(@QueryParam("nom") String nom) {

        Connection con = null;
        Statement stat = null;

        String menssage = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/datos",
                    "root", "root");

            PreparedStatement psSelectConClave = con
                    .prepareStatement("select * from persona where nombre=?");

            psSelectConClave.setString(1, nom);
            ResultSet rs = psSelectConClave.executeQuery();
            while (rs.next()) {
                menssage += rs.getString(2);

            }
            con.close();

        } catch (SQLException ex) {

            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menssage;

    }

    @GET
    @Path("listar")
    public String listar() {

        Connection con = null;
        Statement stat = null;

        String menssage = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/datos",
                    "root", "root");

            Statement query = con.createStatement();
            ResultSet rest = query.executeQuery("SELECT * FROM persona");

            while (rest.next()) {
                menssage += rest.getString("nombre") + "  ";
            }
            System.out.println();

            con.close();

        } catch (SQLException ex) {

            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menssage;

    }
 
    @GET
    @Path("insertar")
    public String insertar(@QueryParam("nom") String nom, @QueryParam("ape") String ape) {

        Connection con = null;
        Statement stat = null;

        String menssage = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/datos",
                    "root", "root");

            String query = "insert into persona (nombre,apellido) values (?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, ape);

            preparedStmt.execute();

            con.close();

        } catch (SQLException ex) {

            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menssage;

    }

    @GET
    @Path("eliminar")
    public String eliminar(@QueryParam("nom") String nom) {

        Connection con = null;
        Statement stat = null;

        String menssage = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/datos",
                    "root", "root");

            String query = "delete from persona where nombre = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);

            // execute the preparedstatement
            preparedStmt.execute();

            con.close();

        } catch (SQLException ex) {

            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menssage;

    }

    @GET
    @Path("actualizar")
    public String actualizar(@QueryParam("nom") String nom, @QueryParam("ape") String ape) {

        Connection con = null;
        Statement stat = null;

        String menssage = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/datos",
                    "root", "root");

            // create the java mysql update preparedstatement
            String query = "update persona set apellido = ? where nombre = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, ape);
            preparedStmt.setString(2, nom);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            con.close();

        } catch (SQLException ex) {

            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menssage;

    }
}
