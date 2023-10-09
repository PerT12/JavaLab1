import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String a = request.getParameter("dataToAdd");

        System.out.println(a);

        List<String> shoppingCart = (List<String>) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new ArrayList<>();
        }
        shoppingCart.add(a);

        session.setAttribute("cart", shoppingCart);
        for (String element : shoppingCart) {
            System.out.println(element);
        }
        response.sendRedirect("items.jsp");
    }
}