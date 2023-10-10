import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ui.ItemInfo;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("itemId"));
        String name = request.getParameter("itemName");
        String description = request.getParameter("itemDescription");
        double price = Double.parseDouble(request.getParameter("itemPrice"));


        List<ItemInfo> shoppingCart = (List<ItemInfo>) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new ArrayList<ItemInfo>();
        }
        shoppingCart.add(new ItemInfo(id, name, description, price));

        session.setAttribute("cart", shoppingCart);

        response.sendRedirect("items.jsp");
    }
}