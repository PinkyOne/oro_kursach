package web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/computer")
public class ComputerController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Function func = Function.SIN.getFunc(request.getParameter("func"));
        String results = "Results of calculation " + func + ":<br/>";
        switch (func) {
            case POLYNOMIAL: {
                double a = Double.valueOf(request.getParameter("a"));
                double b = Double.valueOf(request.getParameter("b"));
                double c = Double.valueOf(request.getParameter("c"));
                double x = Double.valueOf(request.getParameter("x"));
                results += String.valueOf((a * x * x + b * x + c));
            }
            break;
            case SIN: {
                double x = Double.valueOf(request.getParameter("x"));
                results += String.valueOf(Math.sin(x));
            }
            break;
            case COS: {
                double x = Double.valueOf(request.getParameter("x"));
                results += String.valueOf(Math.cos(x));
            }
            break;
            case TG: {
                double x = Double.valueOf(request.getParameter("x"));
                results += String.valueOf(Math.tan(x));
            }
            break;
            case CTG: {
                double x = Double.valueOf(request.getParameter("x"));
                results += String.valueOf(1.0 / Math.tan(x));
            }
            break;
            case EXP: {
                double x = Double.valueOf(request.getParameter("x"));
                results += String.valueOf(Math.exp(x));
            }
            break;
            case LOG: {
                double x = Double.valueOf(request.getParameter("x"));
                results += String.valueOf(Math.log(x));
            }
            break;
        }
        request.setAttribute("results", results);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
