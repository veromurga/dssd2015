package domains;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jorge
 */
@Path("operacion")

public class Multiplicacion {

    @GET
    @Path("suma")
    public String suma(@QueryParam("num1") int n1, @QueryParam("num2") int n2) {

        return "La suma es:"+String.valueOf(n1 + n2);
    }
    
    @GET
    @Path("multiplicacion")
    public String multiplicacion(@QueryParam("num1") int n1, @QueryParam("num2") int n2) {

        return "La multiplicacion es:"+String.valueOf(n1 * n2);
    }

    @GET
    @Path("resta")
    public String resta(@QueryParam("num1") int n1, @QueryParam("num2") int n2) {

        return "La resta es:"+String.valueOf(n1 - n2);
    }
    
    @GET
    @Path("division")
    public String division(@QueryParam("num1") int n1, @QueryParam("num2") int n2) {

        return "La division es:"+String.valueOf(n1 / n2);
    }
     
     
}
