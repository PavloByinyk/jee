package org.apache.jsp.WEB_002dINF.jspf;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import pojo.Genre;
import data.GenreList;

public final class left_005fmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div style=\"margin-left: 200px; position: relative\">\n");
      out.write("            \n");
      out.write("                <div style=\"width: 30%; float: left; background-color: activeborder\">\n");
      out.write("                    <h2>Genre list:</h2>\n");
      out.write("                    <!-- todo add list-->\n");
      out.write("                    <ul>\n");
      out.write("                        ");
 
                            GenreList genreList = new GenreList();
                            for(Genre genre : genreList.getGenresList()){
                        
      out.write("\n");
      out.write("                        <li>  <a  href='#' style=\"color: #008000; text-decoration: none\"> <p> ");
      out.print( genre.getName() );
      out.write(" </p> </a>  </li>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div style=\"width: 60%; float: right; background-color: aqua\">\n");
      out.write("                <h2>Detail information</h2>\n");
      out.write("                \n");
      out.write("               <!-- todo add info-->\n");
      out.write("                \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
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
