/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gottgried
 */
public class SecondServlet extends HttpServlet {

    
//    private int count;
//    private List<String> list = new ArrayList();
    
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

            Map<String, List<String>> allUsersOperationsHolder = (LinkedHashMap) request.getServletContext().getAttribute("map");
            if(allUsersOperationsHolder == null || allUsersOperationsHolder.isEmpty()){
                allUsersOperationsHolder = new LinkedHashMap<String, List<String>>();
            }
            
            java.util.Enumeration<String> en = request.getParameterNames();
            int requestsCount = 0;
            List<String> dataHolder;
            String sessionId = request.getSession().getId();
            
            StringBuffer buffer = new StringBuffer();
            int first = 0, second = 0;
            
            if(request.getSession().isNew()){
                dataHolder = new ArrayList<>();
                allUsersOperationsHolder.put(sessionId, dataHolder);
            }else{
                dataHolder = (List) request.getSession().getAttribute("list");
                requestsCount = (Integer) request.getSession().getAttribute("count");
            }
          
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SecondServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SecondServlet at " + request.getContextPath() + "     " + requestsCount  + "</h1>");
            
//            for(String s : dataHolder){
//                out.println("<h1> " + s +"</h1>");
//            }
            
            
//            for(String id : allUsersOperationsHolder.keySet()){
//            
//                out.println("<p align=\"right\">" + id +"</p>");
//                for(String operation : allUsersOperationsHolder.get(id)){
//                    out.println("<h1><p align=\"right\">" + operation +"</p><h1/>");
//                }
//        }
            
            while(en.hasMoreElements()){
                requestsCount++;
                String element = en.nextElement();
                if(element.equals("first")){
                    first = Integer.parseInt(request.getParameter(element));
                }else if(element.equals("second")){
                    second = Integer.parseInt(request.getParameter(element));
                }else {
                    String result = mathematic(first, second, request.getParameter(element));
                    //out.println("<h1> " + result +"</h1>");
                    dataHolder.add(result);
                    insertDataToMap(sessionId, result, allUsersOperationsHolder);
                }
            } 
            
            for(String s : dataHolder){
                out.println("<h1> " + s +"</h1>");
            }
            
//            for(String id : allUsersOperationsHolder.keySet()){
//            
//                out.println("<p align=\"right\">" + id +"</p>");
//                for(String operation : allUsersOperationsHolder.get(id)){
//                    out.println("<h1><p align=\"right\">" + operation +"</p><h1/>");
//                }
//        }
            
            out.println("</body>");
            out.println("</html>");
            request.getSession().setAttribute("count", requestsCount);
            request.getSession().setAttribute("list", dataHolder);
            request.getServletContext().setAttribute("map", allUsersOperationsHolder);
            
        }
        
            
    }
    
    private void insertDataToMap(String sessionId, String data, Map<String, List<String>> map){
        
        for(String id : map.keySet()){
            if(id.equals(sessionId)){
                map.get(id).add(data);
            }
        }
    }
    
    
    private String mathematic(int first, int second, String function)
    {
        String result = "HZ";
        

        switch(function){
            case "plus":
                result = first +" + " + second + " = " + (first + second);
                break;
            case "mines":
                result = first +" - " + second + " = " + (first - second);
                break;
            case "mn":
                result = first +" * " + second + " = " + (first * second);
                break;
            case "dil":
                result = first +" / " + second + " = " + (first / second);
                break;
            }
        
        return result;
    };
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
