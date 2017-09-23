/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.OrderDAO;
import daos.TableDAO;
import daos.TableStatusChangeDAO;
import dtos.StaffDTO;
import dtos.TableDTO;
import dtos.TableStatusChangeDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luattlgse62386
 */
public class ChangeTableStatus extends HttpServlet {

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
            String tableID = request.getParameter("tableId");
            String status = request.getParameter("status");
            String empId = (String) request.getSession().getAttribute("id");
            Date now = new Date();
            Timestamp time = new Timestamp(now.getTime());
//            TableDAO dao = new TableDAO();
//            dao.changeTableStatus(empId, tableID, status, time);
            
            List<TableDTO> list = (List<TableDTO>) request.getServletContext().getAttribute("TABLE-LIST");
            ArrayList<TableDTO> notifyDirty = (ArrayList<TableDTO>) request.getServletContext().getAttribute("DIRTY-LIST");
            ArrayList<TableDTO> notifyOrdering = (ArrayList<TableDTO>) request.getServletContext().getAttribute("ORDERING-LIST");
            String preStatus = null;
            HttpSession session = request.getSession();
            String role = (String)session.getAttribute("role");
//            System.out.println(role);
            if(role != null && role.equals("busboy") && !(
                    status.equals(TableDTO.READY_STATUS))){
                System.out.println("Cant change");
                return;
            }
            for (TableDTO dto : list) {
                if (dto.getId().equals(tableID)) {
                    preStatus = dto.getStatus();
                    dto.setStatus(status);
                    new TableDAO().update(dto);
                    break;
                }
            }
            new TableStatusChangeDAO().insertChange(
                    new TableStatusChangeDTO(empId, tableID, status, 
                            new Timestamp(new Date().getTime())));
            if (preStatus.equals(TableDTO.ORDERING_STATUS)) {
                for (TableDTO dto : notifyOrdering) {
                    if (dto.getId().equals(tableID)) {
                        notifyOrdering.remove(dto);
                        break;
                    }
                }
            }
            if (preStatus.equals(TableDTO.DIRTY_STATUS)) {
                for (TableDTO dto : notifyDirty) {
                    if (dto.getId().equals(tableID)) {
                        notifyDirty.remove(dto);
                        break;
                    }
                }
            }
            if (status.equals(TableDTO.ORDERING_STATUS)) {
                TableDTO table = new TableDTO();
                table.setId(tableID);
                table.setStatus(TableDTO.ORDERING_STATUS);
                notifyOrdering.add(table);
            }
            if (status.equals(TableDTO.DIRTY_STATUS)) {
                TableDTO table = new TableDTO();
                table.setId(tableID);
                table.setStatus(TableDTO.DIRTY_STATUS);
                notifyDirty.add(table);
            }
            request.getServletContext().setAttribute("DIRTY-LIST", notifyDirty);
            request.getServletContext().setAttribute("ORDERING-LIST", notifyOrdering);
            request.getServletContext().setAttribute("TABLE-LIST", list);
            String isWaiter = request.getParameter("waiter");
            if (isWaiter == null || isWaiter.length() == 0) {
//                do nothting
            } else {
                response.sendRedirect(request.getContextPath() + "/staff/waiter.jsp");
            }
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
