/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gottgried
 */
public class TryServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>\n" +
"    <head>\n" +
"        <title>First page</title>\n" +
"       <meta name=\"description\" content=\"Сайт об HTML и создании сайтов\">\n" +
"  <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\n" +
"    </head>\n" +
"    <body>\n" +
"                <table width=\"450\" cellpadding=\"4\" cellspacing=\"0\" align=\"center\" >\n" +
"    <tr>\n" +
"        <td colspan=\"3\" align=\"center\"><strong><font color=\"#FF0000\" size=\"5\">Секретний документ</font></strong></td>\n" +
"    </tr>\n" +
"   <tr>\n" +
"       <td rowspan=\"4\"> <img src=\"mimage.jpg\" alt=\"альтернативный текст\" width=\"300\" height=\"300\"></td>\n" +
"    <th>Имя</th>\n" +
"    <th>Телефон</th>\n" +
"   </tr>\n" +
"   <tr align=\"center\" >\n" +
"    <th>Петров</th><th>222-333-444</th>\n" +
"   </tr>\n" +
"   <tr align=\"center\">\n" +
"    <th>Иванов</th><th>222-333-444</th>\n" +
"   </tr>\n" +
"   <tr align=\"center\">\n" +
"       <td colspan=\"2\"> \n" +
"     <ul>\n" +
"     <li>Текстовий документ1</li>\n" +
"     <li>Текстовий документ2</li>\n" +
"     <li>Текстовий документ3</li>\n" +
"     </ul> \n" +
"     </td>\n" +
"   </tr>\n" +
"  </table>\n" +
"        <p> <h3 align=\"center\">Тестовий проект 2018</h3></p>\n" +
"   \n" +
"    </body>\n" +
"</html>");
            
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
