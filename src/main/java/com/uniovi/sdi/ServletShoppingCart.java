package com.uniovi.sdi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
@WebServlet(name = "ServletShoppingCart", value = "/AddToShoppingCart")
public class ServletShoppingCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<String, Integer> cart =
                (HashMap<String, Integer>) session.getAttribute("cart");
        // No hay carrito, creamos uno y lo insertamos en sesión
        if (cart == null) {
            cart = new HashMap<String, Integer>();
            session.setAttribute("cart", cart);
        }
        String product = request.getParameter("product");
        if (product != null) {
            addToShoppingCart(cart, product);

            // Retornar la vista con parámetro "selectedItems"
            request.setAttribute("selectedItems", cart);

            //este servlet lo está llevando a otro servlet
            // forward: se pasa el control de manera interna de un servlet a otro servlet
            getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);

            // Eliminado al aplicar el patrón MVC
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<HTML>");
//            out.println("<HEAD><TITLE>Tienda SDI: Cesta de la compra</TITLE></HEAD>");
//            out.println("<BODY>");
//            out.println(shoppingCartToHtml(cart) + "<br>");
////            out.println("<a href=\"shop.html\">Volver</a></BODY></HTML>");
//            out.println("<a href=\"index.jsp\">Volver</a></BODY></HTML>");

        }
    }

    private void addToShoppingCart(Map<String, Integer> cart, String productKey){
        if(cart.get(productKey) == null) cart.put(productKey, 1);
        else{
            int productCount = cart.get(productKey);
            cart.put(productKey, productCount + 1);
        }
    }

    private String shoppingCartToHtml(Map<String, Integer> cart){
        StringBuilder shoppingCartToHtml = new StringBuilder();

        for(String key : cart.keySet())
            shoppingCartToHtml.append("<p>[").append(key).append("],").append(cart.get(key)).append(" unidades</p>");

        return shoppingCartToHtml.toString();
    }
}

