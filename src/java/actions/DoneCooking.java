/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import dtos.CookedFoodDTO;
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
public class DoneCooking extends HttpServlet {

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
            String orderId = request.getParameter("OrderId");
            String orderDetailCode = request.getParameter("OrderDetailCode");
            ArrayList<OrderDTO> list = (ArrayList<OrderDTO>) request.getServletContext().getAttribute("ORDER-LIST");
            ArrayList<CookedFoodDTO> cookingList = (ArrayList<CookedFoodDTO>) request.getSession().getAttribute("COOKING-LIST");
            OrderDTO order = null;
            for (OrderDTO dto : list) {
                if (dto.getId().equals(orderId)) {
                    for(OrderDetailDTO detail : dto.getListDetail()){
                        if(detail.getCode().equals(orderDetailCode)){
                            detail.setCooked(detail.getCooked()+1);
                            detail.setCooking(detail.getCooking()-1);
                        }
                    }
                }
            }
            if(cookingList == null) cookingList = new ArrayList<>();
//            for(CookedFoodDTO dto : cookingList){
//                if(dto.getOrderDetailId().equals(orderDetailCode)){
//                    dto.setQuantity(dto.getQuantity()-1);
//                    if(dto.getQuantity() == 0){
//                        cookingList.remove(dto);
//                    }
//                }
//            }
            for (int i = 0; i < cookingList.size(); i++) {
                CookedFoodDTO dto = cookingList.get(i);
                if(dto.getOrderDetailId().equals(orderDetailCode)){
                    dto.setQuantity(dto.getQuantity()-1);
                    if(dto.getQuantity() == 0){
                        cookingList.remove(dto);
                        i--;
                    }
                }
            }
            request.getSession().setAttribute("COOKING-LIST", cookingList);
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
