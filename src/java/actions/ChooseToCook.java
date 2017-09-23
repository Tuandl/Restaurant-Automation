/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.OrderDetailDAO;
import dtos.CookedFoodDTO;
import dtos.FoodDTO;
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
public class ChooseToCook extends HttpServlet {

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
            String chefId = (String) request.getSession().getAttribute("id");
            ArrayList<FoodDTO> foodList = (ArrayList<FoodDTO>) request.getServletContext().getAttribute("FOOD-LIST");
            ArrayList<OrderDTO> list = (ArrayList<OrderDTO>) request.getServletContext().getAttribute("ORDER-LIST");
            OrderDTO order = null;
            for (OrderDTO dto : list) {
                if (dto.getId().equals(orderId)) {
                    order = dto;
                    break;
                }
            }
            ArrayList<OrderDetailDTO> orderDetailList = (ArrayList<OrderDetailDTO>) order.getListDetail();
            ArrayList<CookedFoodDTO> cookingList = (ArrayList<CookedFoodDTO>) request.getSession().getAttribute("COOKING-LIST");
            if (cookingList == null) {
                cookingList = new ArrayList<>();
            }
            for (OrderDetailDTO dto : orderDetailList) {
                if (dto.getCode().equals(orderDetailCode)) {
                    dto.setQuantity(dto.getQuantity() + 1);
                    dto.setCooking(dto.getCooking() + 1);
                    dto.setWaiting(dto.getWaiting() - 1);
                    if (dto.getChefId() == null) {
                        dto.setChefId(chefId);
                    }
                    OrderDetailDAO dao = new OrderDetailDAO();
                    dao.update(dto);
                    CookedFoodDTO cookingFood = null;
                    for(CookedFoodDTO cooking : cookingList){
                        if(cooking.getOrderDetailId().equals(dto.getCode())){
                            cookingFood = cooking;
                            break;
                        }
                    }
                    if(cookingFood == null){
                        cookingFood = new CookedFoodDTO();
                        cookingFood.setFoodId(dto.getFoodId());
                        cookingFood.setOrderDetailId(dto.getCode());
                        cookingFood.setQuantity(1);
                        cookingFood.setOrderID(orderId);
                        String foodName = "";
                        for (FoodDTO foodDTO : foodList) {
                            if(foodDTO.getId().equals(dto.getFoodId())){
                                foodName = foodDTO.getName();
                                break;
                            }
                        }
                        cookingFood.setFoodName(foodName);
                        cookingList.add(cookingFood);
                    }else{
                        cookingFood.setQuantity(cookingFood.getQuantity()+1);
                    }
                    break;
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
