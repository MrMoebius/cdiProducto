package org.daniel.cdiproductos.config;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import jakarta.inject.Qualifier;
import org.daniel.cdiproductos.config.qualifier.ProducerResourceAnnotation;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// Registrar conexion JDBC
public class ProducerResource {

    //Pasamos el name que hace referencia a nuestro codigo -> META-INF/context.xml
    @Resource(name = "jdbc/mysqDB")
    private DataSource ds;

    @Produces // convertir en bean el objeto que devuelve el metodo.
    @RequestScoped
    @ProducerResourceAnnotation
    private Connection connection() throws NamingException, SQLException {

//        Context initContext = null;
//        initContext = new InitialContext();
//        Context envContext = (Context) initContext.lookup("java:/comp/env");
//        DataSource ds = (DataSource) envContext.lookup("jdbc/mysqlDB");
        return ds.getConnection();

    }
}
