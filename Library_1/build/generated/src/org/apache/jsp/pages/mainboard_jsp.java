package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mainboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--\r\n");
      out.write("To change this license header, choose License Headers in Project Properties.\r\n");
      out.write("To change this template file, choose Tools | Templates\r\n");
      out.write("and open the template in the editor.\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Main Board Screen</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div style=\"background-color: #F2F2F2; border: 4px solid #A4A4A4; height: 800px; margin: 20px 200px\">\r\n");
      out.write("            \r\n");
      out.write("            <div style=\"background: gray; text-align: center; padding: 20px; margin: 20px 200px\">\r\n");
      out.write("                My Title\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div style=\"position:relative; margin-left: 200px; margin-right: 200px; padding: 20px\">\r\n");
      out.write("                <form>\r\n");
      out.write("                    \r\n");
      out.write("<!--                    <img src=\"\"/>-->\r\n");
      out.write("                    \r\n");
      out.write("                    <input style=\" \r\n");
      out.write("                           width: 55%; \r\n");
      out.write("                           padding: 5px;\" type=\"search\" name=\"search\">\r\n");
      out.write("                    <input style=\"  \r\n");
      out.write("                           width: 10%; \r\n");
      out.write("                           margin-left:  70px;\r\n");
      out.write("                           background-color: coral;\r\n");
      out.write("                           border: activeborder;\r\n");
      out.write("                           border-radius: 8px;\r\n");
      out.write("                           padding: 5px;\r\n");
      out.write("                           font-style: initial\"\r\n");
      out.write("                           type=\"submit\" value=\"Search\">\r\n");
      out.write("                    <select style=\" \r\n");
      out.write("                            position: absolute; \r\n");
      out.write("                            width: 10%;\r\n");
      out.write("                            padding: 5px;\r\n");
      out.write("                            margin-left: 10px\"\r\n");
      out.write("                            id=\"select_data\">\r\n");
      out.write("                        <option value=\"\">Author name</option>\r\n");
      out.write("                        <option value=\"1\">Value 1</option>\r\n");
      out.write("                        <option value=\"2\">Value 2</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div style=\"margin-left: 200px; position: relative\">\r\n");
      out.write("            \r\n");
      out.write("                <div style=\"width: 30%; float: left; background-color: activeborder\">\r\n");
      out.write("                    <h2>Authors list</h2>\r\n");
      out.write("                <!-- todo add list-->\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div style=\"width: 60%; float: right; background-color: aqua\">\r\n");
      out.write("                <h2>Detail information</h2>\r\n");
      out.write("                \r\n");
      out.write("               <!-- todo add info-->\r\n");
      out.write("                \r\n");
      out.write("                </div>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
