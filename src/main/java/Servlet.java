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
        String idString = request.getParameter("itemId");
        String nameString = request.getParameter("itemName");
        String priceString = request.getParameter("itemPrice");
        System.out.println( idString +" her ska de va" + nameString + " " + priceString);
        int iD = Integer.parseInt(request.getParameter("itemId"));


        List<ItemInfo> shoppingCart = (List<ItemInfo>) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new ArrayList<ItemInfo>();
        }
        shoppingCart.add(new ItemInfo(1, "grej", "nått", 4));

        session.setAttribute("cart", shoppingCart);

        response.sendRedirect("items.jsp");
    }
}