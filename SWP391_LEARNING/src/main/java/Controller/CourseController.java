package Controller;

import DAO.CourseDAO;
import Entity.course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseController extends HttpServlet {
    private static final String CourseTable ="course_tables.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");



    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        CourseDAO courseDAO = new CourseDAO();
        ArrayList<course> courses = new ArrayList<>();
        courses=courseDAO.GetCourses();
        request.setAttribute("courses",courses);
        request.getRequestDispatcher(CourseTable).forward(request, response);



    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String action = request.getParameter("action");
        CourseDAO courseDao= new CourseDAO();

        if (action != null && action.equals("CreateCourse"))
        {
            String courseId = request.getParameter("courseId");
            String courseName = request.getParameter("courseName");
            String courseImage = request.getParameter("courseImage");
            String courseLevel = request.getParameter("courseLevel");

            course course = new course(courseId,courseName,courseImage,courseLevel);
            try {
                courseDao.addCourse(course);
                response.sendRedirect("CourseController");
            } catch (SQLException e) {
                request.setAttribute("error", "Error adding course: " + e.getMessage());
                request.getRequestDispatcher("CreateCourseForm.jsp").forward(request, response);           }

        }else         if (action != null && action.equals("DeleteCourse"))
        {
            String courseId = request.getParameter("courseId");
            courseDao.deleteCourse(courseId);
            response.sendRedirect("CourseController");
        }else         if (action != null && action.equals("UpdateCourse"))
        {
            String courseId = request.getParameter("courseId");
            String courseName = request.getParameter("courseName");
            String courseImage = request.getParameter("courseImage");
            String courseLevel = request.getParameter("courseLevel");
            course course = new course(courseId,courseName,courseImage,courseLevel);

            try {
                courseDao.updateCourse(course);
                response.sendRedirect("CourseController");
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
