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
import javax.persistence.QueryHint;
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

    @GET
    @Path("listar")
    public String listar() throws SQLException, ClassNotFoundException {

        ArrayList<Revista> revistas = new ArrayList<>();

        Connection con = utils.Constants.OpenConnection();
        Statement query = con.createStatement();

        ResultSet revistas_query = null;

        try {
            revistas_query = query.executeQuery(utils.Constants.query_revistas);

        } catch (SQLException ex) {
            Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            while (revistas_query.next()) {
                Revista r = null;
                try {

                    r = new Revista(revistas_query.getInt("id_revista"), revistas_query.getString("nombre_revista"));
                } catch (SQLException ex) {
                    Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
                }
                revistas.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
        }

        Gson response = new Gson();

        return response.toJson(revistas);

    }

    @GET
    @Path("buscar")
    public String buscar(@QueryParam("id") int id_revista) throws SQLException, ClassNotFoundException {

        ArrayList<Revista> revistas = new ArrayList<>();
        ArrayList<Palabra> palabras = new ArrayList<Palabra>();
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();

        Connection con = utils.Constants.OpenConnection();
        Statement query = con.createStatement();

        ResultSet revistas_result = null;
        ResultSet palabras_clave_result = null;
        ResultSet articulos_result = null;
        try {

            //Revista
            PreparedStatement revistaQuery = con
                    .prepareStatement(utils.Constants.query_revista);

            revistaQuery.setInt(1, id_revista);

            revistas_result = revistaQuery.executeQuery();

            //Los articulos de la revista
            PreparedStatement articulosQuery = con
                    .prepareStatement(utils.Constants.query_articulos_de_revista);

            articulosQuery.setInt(1, id_revista);

            articulos_result = articulosQuery.executeQuery();

            //Las palabras clase de la Revista
            PreparedStatement palabrasQuery = con
                    .prepareStatement(utils.Constants.query_palabras_de_revista);

            palabrasQuery.setInt(1, id_revista);

            palabras_clave_result = palabrasQuery.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            Revista r = null;

            while (revistas_result.next()) {

                try {

                    r = new Revista(revistas_result.getInt("id_revista"), revistas_result.getString("nombre_revista"));
                } catch (SQLException ex) {
                    Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            while (articulos_result.next()) {

                Articulo a = new Articulo(articulos_result.getInt("id_articulo"), articulos_result.getString("resumen"), articulos_result.getString("nombre_resumen"), articulos_result.getString("estado"));
                articulos.add(a);
            }

            while (palabras_clave_result.next()) {
                Palabra p = new Palabra(palabras_clave_result.getInt("id_palabra_clave"), palabras_clave_result.getString("descripcion"), palabras_clave_result.getString("key_valor"));
                palabras.add(p);

            }
            r.setArticulos(articulos);
            r.setPalabras(palabras);
            revistas.add(r);

        } catch (SQLException ex) {
            Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
        }

        Gson response = new Gson();

        return response.toJson(revistas);

    }

    @GET
    @Path("buscarClaves")
    public String buscarPorPalabrasClaves(@QueryParam("palabras") String palabras) throws SQLException, ClassNotFoundException {

        return "";

    }

    @POST
    @Path("agregar")
    public void agregar(@FormParam("nombre") String nombre) throws SQLException, ClassNotFoundException {

        Connection con = utils.Constants.OpenConnection();

        //Revista
        PreparedStatement preparedStmt = con.prepareStatement(utils.Constants.query_revista_nueva);
        preparedStmt.setString(1, nombre);

        preparedStmt.execute();
    }

    @POST
    @Path("/articulo/agregar")
    public void agregarArticulo(@FormParam("resumen") String resumen,
            @FormParam("nombre_resumen") String nombre_resumen,
            @FormParam("estado") String estado,
            @FormParam("id_revista") String id_revista,
            @FormParam("palabras") String palabras_claves) throws SQLException, ClassNotFoundException {

        Connection con = utils.Constants.OpenConnection();

        //Articulo
        PreparedStatement prepared_articulo = con.prepareStatement(utils.Constants.query_articulo_nuevo);
        prepared_articulo.setString(1, resumen);
        prepared_articulo.setString(2, nombre_resumen);
        prepared_articulo.setString(3, estado);
        prepared_articulo.setInt(4, Integer.parseInt(id_revista));
        prepared_articulo.execute();

        //Buscar Articulo
        ResultSet buscar_articulo_result = null;
        Integer id_articulo = null;

        try {

            PreparedStatement articuloQuery = con
                    .prepareStatement(utils.Constants.query_articulo_buscar);

            articuloQuery.setString(1, nombre_resumen);

            buscar_articulo_result = articuloQuery.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            while (buscar_articulo_result.next()) {
                id_articulo = buscar_articulo_result.getInt("id_articulo");

            }

        } catch (SQLException ex) {
            Logger.getLogger(AgenteExterno.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Revista_Articulo
        PreparedStatement preparedRevista_Articulo = con.prepareStatement(utils.Constants.query_revista_articulo_nuevo);
        preparedRevista_Articulo.setInt(1, Integer.parseInt(id_revista));
        preparedRevista_Articulo.setInt(2, id_articulo);

        preparedRevista_Articulo.execute();

    }

}
