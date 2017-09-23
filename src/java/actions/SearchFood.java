/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.google.gson.Gson;
import dtos.FoodDTO;
import dtos.OrderDTO;
import dtos.OrderDetailDTO;
import dtos.SameFoodDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TUANDASE62310
 */
public class SearchFood extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String tableId = request.getParameter("tableId");
            String foodName = request.getParameter("search");
            ArrayList<OrderDTO> orderList = (ArrayList<OrderDTO>) request.getServletContext().getAttribute("ORDER-LIST");
            ArrayList<FoodDTO> foodList = (ArrayList<FoodDTO>) request.getServletContext().getAttribute("FOOD-LIST");
            List<SameFoodDTO> searchResult = new ArrayList<>();
            OrderDTO order = null;
            for (OrderDTO dto : orderList) {
                if (dto.getTableId().equals(tableId)) {
                    order = dto;
                    break;
                }
            }
            for (FoodDTO dto : foodList) {
                if (dto.getName().toLowerCase().contains(foodName.toLowerCase())) {
                    SameFoodDTO food = new SameFoodDTO();
                    food.setId(dto.getId());
                    food.setName(dto.getName());
                    food.setPrice(dto.getPrice());
                    food.setServed(0);
                    food.setPending(0);
                    for (OrderDetailDTO detail : order.getListDetail()) {
                        if (detail.getFoodId().equals(food.getId())) {
                            food.setServed(detail.getQuantity());
                            food.setPending(detail.getWaiting());
                            break;
                        }
                    }
                    searchResult.add(food);
                }
            }
//            request.setAttribute("SEACH-LIST", searchResult);
            String json = new Gson().toJson(searchResult);
            out.write(json);
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
