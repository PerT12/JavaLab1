import java.io.*;
import java.util.ArrayList;
import java.util.List;

import bo.Item;
import bo.UserHandler;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ui.ItemInfo;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
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
