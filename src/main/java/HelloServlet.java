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
        List<ItemInfo> shoppingCart = (List<ItemInfo>) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new ArrayList<>();
        }

        // Lägg till objekt i sessionsvariabeln (i detta fall en sträng)
        shoppingCart.add(new ItemInfo(21, "name", "blue", 21));

        // Spara den uppdaterade sessionsvariabeln
        session.setAttribute("cart", shoppingCart);

        // Gå tillbaka till en annan sida eller svara med ett meddelande
        response.sendRedirect("log-in.jsp");
    }
}
