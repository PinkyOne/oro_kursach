package web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/functions")
public class FunctionController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String functions = "";
        for (Function function :
                Function.values()) {
            functions += "<a href=attributes?func=" + function + " >" + function + "</a><br/>";
        }
        request.setAttribute("functions", functions);
        request.getRequestDispatcher("/functions.jsp").forward(request, response);
    }
}
