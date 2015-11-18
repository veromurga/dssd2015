package domains;

import clases.Articulo;
import clases.Palabra;
import clases.Revista;
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
@Path("revistas")
public class AgenteExterno {
    
  
    //Busca la revista con las PALABRAS CLAVES
    @GET
    @Path("buscarClaves")
    public String buscarPorPalabrasClaves(@QueryParam("palabras") String palabras) throws SQLException, ClassNotFoundException {
        ArrayList<Revista> revistas = new ArrayList<>();
        ArrayList<Palabra> revista_palabras = new ArrayList<Palabra>();
        ArrayList<Articulo> revista_articulos = new ArrayList<Articulo>();
        
        Connection con = utils.Constants.OpenConnection();
        Statement query = con.createStatement();
        String[] claves = palabras.split(",");
        
        for (String clave : claves) {
            
            ResultSet revistas_result = null;
            
            try {
                //Obtengo una revista por palabra clave que me pasaron
                PreparedStatement revistasQuery = con
                        .prepareStatement(utils.Constants.query_palabras_de_revista);
                
                revistasQuery.setString(1, clave);
                
                revistas_result = revistasQuery.executeQuery();
                
            } catch (SQLException ex) {
                Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                
                Revista r = null;
                
                while (revistas_result.next()) {
                    
                    try {
                        
                        r = new Revista(revistas_result.getInt("id_revista"), revistas_result.getString("nombre_revista"));
                        // Palabra p = new Palabra(revistas_result.getInt("id_palabra_clave"), revistas_result.getString("descripcion"),
                        //       revistas_result.getString("key_valor"));
                        //   palabras.add(p);
                        revistas.add(r);
                    } catch (SQLException ex) {
                        Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        Gson response = new Gson();
        
        return response.toJson(revistas);
        
    }

    @GET
    //Buscar revista por nombre
    @Path("buscarRevistaPorNombre")
    public String buscrRevistaPorNombre(@QueryParam("nombre_revista") String nombre_revista) throws SQLException, ClassNotFoundException {
        
        Connection con = utils.Constants.OpenConnection();
        Statement query = con.createStatement();
        
        ResultSet revistas_result = null;
        Revista r = null;
        
        try {
            //Obtengo una revista por palabra clave que me pasaron
            PreparedStatement revistasQuery = con
                    .prepareStatement(utils.Constants.query_revista_nombre );
            
            revistasQuery.setString(1, nombre_revista);
            
            revistas_result = revistasQuery.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            while (revistas_result.next()) {
                
                r = new Revista();
                r.setId(revistas_result.getInt("id_revista"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Gson response = new Gson();
        
        return response.toJson(r);
        
    }
  
    
}
