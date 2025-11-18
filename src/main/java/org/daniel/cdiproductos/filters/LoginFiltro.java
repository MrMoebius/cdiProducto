package org.daniel.cdiproductos.filters;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.daniel.cdiproductos.services.LoginService;
import org.daniel.cdiproductos.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;


@WebFilter({"/carro/*", "/productos/form/*", "/productos/eliminar/*"})
public class LoginFiltro implements Filter {

    @Inject
    private LoginService loginService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImpl();
        Optional<String> username = loginService.getUsername((HttpServletRequest) request);
        if (username.isPresent()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Lo sentimos no estas autorizado para ingresar a esta pagina!");
        }
    }
}
