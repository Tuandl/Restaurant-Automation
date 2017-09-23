/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.OrderDetailDAO;
import dtos.OrderDTO;
import dtos.OrderDetailDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luattlgse62386
 */
public class AddOrderDetail extends HttpServlet {

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
            String tableId = request.getParameter("tableId");
            String foodId = request.getParameter("foodId");
            ArrayList<OrderDTO> list = (ArrayList<OrderDTO>) request.getServletContext().getAttribute("ORDER-LIST");
            OrderDTO order = null;
            for (OrderDTO dto : list) {
                if (dto.getTableId().equals(tableId)) {
                    order = dto;
                    break;
                }
            }
//            System.out.println(order + " " + tableId + " " + foodId);
            ArrayList<OrderDetailDTO> orderDetailList = (ArrayList<OrderDetailDTO>) order.getListDetail();
            OrderDetailDTO orderDetail = null;
            for (OrderDetailDTO dto : orderDetailList) {
                if (dto.getFoodId().equals(foodId)) {
                    orderDetail = dto;
                    break;
                }
            }
            OrderDetailDAO dao = new OrderDetailDAO();
            if(orderDetail == null){
                orderDetail = new OrderDetailDTO();
                orderDetail.setOrderId(order.getId());
                orderDetail.setFoodId(foodId);
                orderDetail.setCode(orderDetail.regenCode());
                orderDetail.setStatus(OrderDetailDTO.WAITING_STATUS);
                orderDetail.setWaiting(1);
                dao.insertOD(orderDetail);
                orderDetailList.add(orderDetail);
            }
            else{
                orderDetail.setWaiting(orderDetail.getWaiting()+1);
            }
            request.getServletContext().setAttribute("ORDER-LIST", list);
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
