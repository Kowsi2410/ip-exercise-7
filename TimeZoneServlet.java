import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TimeZoneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get selected timezone from the form
        String timezone = request.getParameter("timezone");

        // Create a cookie to store the selected timezone
        Cookie cookie = new Cookie("user_timezone", timezone);
        cookie.setMaxAge(24 * 60 * 60); // Cookie expires in 1 day
        response.addCookie(cookie);

        // Redirect to the page that displays the current time in the selected timezone
        response.sendRedirect("DisplayTimeServlet");
    }
}
