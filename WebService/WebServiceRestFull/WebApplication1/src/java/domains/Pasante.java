package domains;

import clases.*;
import clases.PasanteMensaje;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import utils.Constants.*;

/**
 *
 * @author jorge
 */
@Path("pasante")
public class Pasante {

    @GET
    @Path("mensajes")
    public String listar() throws SQLException, ClassNotFoundException {
        
        ArrayList<PasanteMensaje> revisores = new ArrayList<>();
        Connection con = utils.Constants.OpenConnection();
        Statement query = con.createStatement();
        ResultSet revisor_query = null;
        
        try {
            revisor_query = query.executeQuery(utils.Constants.query_mensaje_pasantes);
        } catch (SQLException ex) {
        }
        try {
            while (revisor_query.next()) {
                PasanteMensaje r = null;
                try {
                    r = new PasanteMensaje(revisor_query.getInt("id"), revisor_query.getString("mensaje"), revisor_query.getString("username"));
                } catch (SQLException ex) {
                }
                revisores.add(r);
            }
        } catch (SQLException ex) {
        }
        Gson response = new Gson();
        return response.toJson(revisores);
    }
    
 
    @GET
    @Path("buscar_mensaje")
    public String buscar(@QueryParam("username") String username, @QueryParam("name_project") String project_name) throws SQLException, ClassNotFoundException {
        ArrayList<PasanteMensaje> mensajes = new ArrayList<>();
        Connection con = utils.Constants.OpenConnection();
        ResultSet mensajes_result = null;
        try {
            //Los mensajes de un pasante en particular
            PreparedStatement mensajeQuery = con
                    .prepareStatement(utils.Constants.query_mensaje_pasante);
            mensajeQuery.setString(1, username);
            mensajeQuery.setString(2, project_name);
            mensajes_result = mensajeQuery.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Pasante.class.getName()).log(Level.SEVERE, null, ex);
        }
        PasanteMensaje p = null;
        try {
            while (mensajes_result.next()) {
                try {
                    p = new PasanteMensaje(mensajes_result.getInt("id"), mensajes_result.getString("username"), mensajes_result.getString("mensaje"));
                    mensajes.add(p);
                } catch (SQLException ex) {
                    Logger.getLogger(PasanteMensaje.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson response = new Gson();
        return response.toJson(mensajes);
    }
 
}
