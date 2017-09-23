/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import dtos.CookedFoodDTO;
import dtos.FoodDTO;
import dtos.SameFoodDTO;
import dtos.OrderDTO;
import dtos.OrderDetailDTO;
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

/**
 *
 * @author luattlgse62386
 */
public class CreateBill extends HttpServlet {

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
            OrderDTO order = null;
            ArrayList<OrderDTO> list = (ArrayList<OrderDTO>) request.getServletContext().getAttribute("ORDER-LIST");
            ArrayList<FoodDTO> foodList = (ArrayList<FoodDTO>) request.getServletContext().getAttribute("FOOD-LIST");
            List<SameFoodDTO> bill = new ArrayList<>();
            int total = 0;
            for (OrderDTO dto : list) {
                if (dto.getTableId().equals(tableId)) {
                    order = dto;
                    break;
                }
            }
            for(OrderDetailDTO detail : order.getListDetail()){
                for(FoodDTO food : foodList){
                    if(food.getId().equals(detail.getFoodId())){
                        SameFoodDTO newFood = new SameFoodDTO(food.getName(), 
                                food.getId(), detail.getWaiting(), 
                                detail.getQuantity(), food.getPrice());
                        bill.add(newFood);
                        break;
                    }
                }
            }
            request.setAttribute("bill", bill);
            request.setAttribute("orderId", order.getId());
            request.setAttribute("tableId", order.getTableId());
            request.getRequestDispatcher("/staff/waiter-orderdetail.jsp").forward(request, response);
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
