package org.daniel.cdiproductos.controllers;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.daniel.cdiproductos.config.qualifier.ProductoBeanPrincipal;
import org.daniel.cdiproductos.models.Carro;
import org.daniel.cdiproductos.models.ItemCarro;
import org.daniel.cdiproductos.models.Producto;
import org.daniel.cdiproductos.services.ProductoService;
import org.daniel.cdiproductos.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {

    @Inject
    private Carro carro;

    @Inject
    @ProductoBeanPrincipal
    private ProductoService productoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
//        Connection conn = (Connection) req.getAttribute("conn");
//        ProductoService service = new ProductoServiceJdbcImpl(conn);
        Optional<Producto> producto = productoService.porId(id);
        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath() + "/carro/ver");
    }
}
