package Controller;

import DAO.AdminDAO;
import Entity.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterAdminController", value = "/RegisterAdminController")
public class RegisterAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminDAO adminDAO= new AdminDAO();
        admin user =adminDAO.checkExistedAccount(username);
        request.setAttribute("msg", "");
        if(user ==null)
        {
            try
            {
                adminDAO.RegisterAdmin(username,password);
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
            response.sendRedirect("authentication-login.jsp");
            request.removeAttribute("msg");
        }else { //deny to signup
            request.setAttribute("msg", "Your account has already existed!");
            request.getRequestDispatcher("authentication-register.jsp").forward(request, response);
        }
    }
}
