package com.uniovi.sdi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProducts", value = "/products")
public class ServletProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        //Llamada al servicio correspondiente
        ProductsService service = new ProductsService();
        //Se recupera la lista de products y se guarda en una variable
        List<Product> storeProducts = service.getProducts();
        //Metemos la variable en la request de la petición
        request.setAttribute("storeProducts", storeProducts);
        //La enviamos con forward
        getServletContext().getRequestDispatcher("/products-view.jsp").forward(request, response);
    }
}
