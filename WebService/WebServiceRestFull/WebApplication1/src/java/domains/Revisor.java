package domains;

import clases.*;
import clases.RevisorMensaje;
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
@Path("revisor")
public class Revisor {

    @GET
    @Path("listarMensjes")
    public String listar() throws SQLException, ClassNotFoundException {

        ArrayList<RevisorMensaje> revisores = new ArrayList<>();

        Connection con = utils.Constants.OpenConnection();
        Statement query = con.createStatement();

        ResultSet revisor_query = null;

        try {
            revisor_query = query.executeQuery(utils.Constants.query_revisores);

        } catch (SQLException ex) {

        }
        try {

            while (revisor_query.next()) {
                RevisorMensaje r = null;
                try {

                    r = new RevisorMensaje(revisor_query.getInt("id"), revisor_query.getString("mensaje"), revisor_query.getString("username"));
                } catch (SQLException ex) {

                }
                revisores.add(r);
            }

        } catch (SQLException ex) {

        }

        Gson response = new Gson();

        return response.toJson(revisores);

    }

}
