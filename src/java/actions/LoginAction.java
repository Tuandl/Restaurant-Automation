/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.StaffDAO;
import dtos.StaffDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luattlgse62386
 */
public class LoginAction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("username");
            StaffDAO dao = new StaffDAO();
            StaffDTO dto = dao.checkLogin(username);
            if(dto == null){
                request.setAttribute("ERROR", "ID is invalid");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
            HttpSession session = request.getSession();
            session.setAttribute("name", dto.getName());
            session.setAttribute("id", dto.getId());
//            session.setMaxInactiveInterval(-1);
//            System.out.println(dto.getRole());
            if(dto.getRole().equalsIgnoreCase(StaffDTO.WAITER_ROLE)){
                response.sendRedirect("staff/waiter.jsp");
                return;
            }
            if(dto.getRole().equalsIgnoreCase(StaffDTO.BUS_BOY_ROLE)){
                session.setAttribute("role", "busboy");
                response.sendRedirect("staff/view-table.jsp");
                return;
            }
            if(dto.getRole().equalsIgnoreCase(StaffDTO.HOST_ROLE)){
                session.setAttribute("role", "host");
                System.out.println((String)session.getAttribute("role"));
                response.sendRedirect("staff/view-table.jsp");
                return;
            }
            if(dto.getRole().equalsIgnoreCase(StaffDTO.CHEF_ROLE)){
                response.sendRedirect("staff/chef.jsp");
                return;
            }
            if(dto.getRole().equalsIgnoreCase(StaffDTO.MANAGER_ROLE)){
                response.sendRedirect("manager/manager.jsp");
                return;
            }
//            System.out.println(""+dto.getRole());
        }
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
