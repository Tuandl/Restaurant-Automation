/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.google.gson.Gson;
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
public class NotifyFood extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String staffId = (String) request.getSession().getAttribute("id");
            System.out.println(staffId);
            ArrayList<OrderDTO> list = (ArrayList<OrderDTO>) request.getServletContext().getAttribute("ORDER-LIST");
            ArrayList<CookedFoodDTO> notify = (ArrayList<CookedFoodDTO>) request.getSession().getAttribute("NOTIFY-LIST");
            ArrayList<FoodDTO> foodList = (ArrayList<FoodDTO>) request.getServletContext().getAttribute("FOOD-LIST");
            notify = new ArrayList<>();
            for (OrderDTO order : list) {
                if (order.getWaiterId().equalsIgnoreCase(staffId)) {
                    for (OrderDetailDTO detail : order.getListDetail()) {
                        if (detail.getCooked() > 0) {
                            CookedFoodDTO food = new CookedFoodDTO();
                            String foodName = "";
                            for (FoodDTO foodDTO : foodList) {
                                if(foodDTO.getId().equals(detail.getFoodId())){
                                    foodName = foodDTO.getName();
                                }
                            }
                            food.setFoodName(foodName);
                            food.setFoodId(detail.getFoodId());
                            food.setQuantity(detail.getCooked());
                            food.setTableId(order.getTableId());
                            food.setOrderID(order.getId());
                            food.setOrderDetailId(detail.getCode());
                            notify.add(food);
                        }
                    }
                }
            }
//            request.getSession().setAttribute("NOTIFY-LIST", notify);
            String json = new Gson().toJson(notify);
//            System.out.println(json);
            out.print(json);
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
