/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jorge.farfan
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
@Path("investigador")
public class AgenteExterno {

    @GET
    @Path("obtenerRevistas")
    
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

    
  
    
    
}