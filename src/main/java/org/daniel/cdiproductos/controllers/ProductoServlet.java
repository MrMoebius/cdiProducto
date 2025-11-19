package org.daniel.cdiproductos.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.daniel.cdiproductos.config.qualifier.ProductoBeanPrincipal;
import org.daniel.cdiproductos.models.Producto;
import org.daniel.cdiproductos.services.ProductoService;
import org.daniel.cdiproductos.services.ProductoServiceJdbcImpl;
import org.daniel.cdiproductos.services.LoginService;
import org.daniel.cdiproductos.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {

    @Inject
    @ProductoBeanPrincipal
    private ProductoService productoService;

    @Inject
    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtiene la conexión manualmente del atributo request
        // Connection conn = (Connection) req.getAttribute("conn");
        // ProductoService service = new ProductoServiceJdbcImpl(conn);
        List<Producto> productos = productoService.listar();

        // LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = loginService.getUsername(req);

        req.setAttribute("productos", productos);
        req.setAttribute("username", usernameOptional.orElse(null));
        req.setAttribute("title", req.getAttribute("title") + ": Listado de productos");
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
