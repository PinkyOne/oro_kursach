package web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/attributes")
public class AttributesController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String func = request.getParameter("func");
        String function = "<p>" + func.toLowerCase() + ":</p>";
        StringBuilder inputs = new StringBuilder("<form action=\"/computer?func=" + func + "\" method=\"POST\">");
        switch (func) {
            case "POLYNOMIAL": {
                function += "ax^2+bx+c";
                inputs.append("<p>a=<input type=\"text\" name=\"a\"></p>");
                inputs.append("<p>b=<input type=\"text\" name=\"b\"></p>");
                inputs.append("<p>c=<input type=\"text\" name=\"c\"></p>");
                inputs.append("<p>x=<input type=\"text\" name=\"x\"></p>");
                inputs.append("<p><input type=\"submit\" name=\"func\" value=\"Calculate\"></p>");
            }
            break;
            default: {
                function += func + "(x)";
                inputs.append("<p>x=<input type=\"text\" name=\"x\"></p>");
                inputs.append("<p><input type=\"submit\" name=\"func\" value=\"Calculate\"></p>");
            }
            break;
        }
        inputs.append("</form>");

        request.setAttribute("function", function);
        request.setAttribute("inputs", inputs.toString());
        request.getRequestDispatcher("/attributes.jsp").forward(request, response);
    }
}
