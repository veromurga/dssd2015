/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import clases.Revista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author jorge
 */
public class Constants {

    public static String database = "garc";
    public static String user = "root";
    public static String pass = "root";

    public static String query_revisores = "SELECT r.id AS id,r.mensaje AS mensaje,r.username AS username FROM revisor_respuesta AS r";
    public static String query_puedo_publicar = " SELECT "
            + "  r.id AS id_revista, "
            + "  r.nombre AS nombre_revista "
            + "FROM revista AS r "
            + "WHERE r.puede_publicar=? ";

    public static String query_mensaje_pasantes = "SELECT p.id AS id,p.mensaje AS mensaje,p.username_pasante AS username FROM pasante_respuesta AS p";
    public static String query_mensaje_pasante = "SELECT p.id AS id,p.username_pasante AS username,p.mensaje AS mensaje FROM pasante_respuesta AS p WHERE p.username_pasante=? AND p.nombre_proyecto=?";
    public static String query_mensaje_pasante_nueva = "INSERT INTO pasante_respuesta (username_pasante,mensaje,nombre_proyecto) VALUES (?,?,?)";

    public static String query_articulo_buscar = "SELECT a.id AS id_articulo FROM articulo AS a WHERE a.nombre_resumen=?";

    public static String query_revista_articulo_nuevo = "INSERT INTO revista_articulo (id_revista,id_articulo) VALUES (?,?)";

    public static String query_articulo_nuevo = "INSERT INTO articulo (resumen,nombre_resumen,estado,id_revista) VALUES (?,?,?,?)";

    public static String query_revista_nueva = "INSERT INTO revista (nombre) VALUES (?)";

    public static String query_palabras_de_revista = "SELECT  r.nombre AS nombre_revista,r.id AS id_revista,pc.id AS id_palabra_clave,pc.descripcion AS descripcion, pc.palabra_clave AS key_valor \n"
            + "FROM Revista AS r \n"
            + "INNER JOIN revista_palabra_clave AS rpc   \n"
            + "INNER JOIN palabra_clave AS pc ON  pc.id=rpc.id_palabra_clave \n"
            + "WHERE pc.palabra_clave=? AND r.id=rpc.id_revista";

    public static String query_revista_nombre = "SELECT  r.nombre AS nombre_revista,r.id AS id_revista \n"
            + "FROM Revista AS r \n"
            + "WHERE r.nombre=? ";

    public static String query_articulos_de_revista = "SELECT a.id AS id_articulo, a.resumen AS resumen , a.nombre_resumen AS nombre_resumen, a.estado AS estado FROM articulo AS a WHERE a.id_revista=?";

    public static String query_revista = "SELECT r.id AS id_revista , r.nombre AS nombre_revista FROM revista AS r WHERE r.id=?";

    public static String query_revistas = " SELECT r.id AS id_revista ,r.nombre AS nombre_revista,pc.descripcion AS descripcion_revist FROM revista AS r INNER JOIN revista_palabra_clave AS rpc INNER JOIN palabra_clave AS pc  ON r.id  = rpc.id_revista WHERE pc.id  = rpc.id_palabra_clave";

    public static String query_revistas_buscar = " SELECT r.id AS id_revista ,r.nombre AS nombre_revista,pc.descripcion AS descripcion_revist FROM revista AS r INNER JOIN revista_palabra_clave AS rpc INNER JOIN palabra_clave AS pc  ON r.id  = rpc.id_revista WHERE  r.id=? AND pc.id  = rpc.id_palabra_clave";

    public static Connection OpenConnection() throws SQLException, ClassNotFoundException {

        Connection con = null;
        Statement stat = null;

        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost/" + utils.Constants.database,
                utils.Constants.user, utils.Constants.pass);

        return con;
    }

    public static void CloseConnection(Connection con) throws SQLException {

        con.close();

    }

}
