package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=Shift_JIS");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

//�u���E�U�̃L���b�V���𖳌��ɂ���B
// Last-Modified(�ŏI�X�V��) : �{��
// Expires(�L������)         : �ߋ���(1970/01/01)
// pragma no-cache           : HTTP1.0�d�l�Ɋ�Â��u�L���b�V�������w���v
// Cache-Control no-cache    : HTTP1.1�d�l�Ɋ�Â��u�L���b�V�������w���v

//java.util.Calendar objCal1=java.util.Calendar.getInstance();
//java.util.Calendar objCal2=java.util.Calendar.getInstance();
//objCal2.set(1970,0,1,0,0,0);
//response.setDateHeader("Last-Modified",objCal1.getTime().getTime());
//response.setDateHeader("Expires",objCal2.getTime().getTime());
    Object status = session.getAttribute("status");

    if(status == "Login_out")
    {
        response.sendRedirect("/Java_DB/Servlet_Login");
        return;
    }


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=Shift_JIS\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <div>���i�̓o�^</div>\n");
      out.write("         <form action=\"Servlet_InsertData\" method=\"post\">\n");
      out.write("         ���i���F<input type=\"text\" name=\"NAME\">\n");
      out.write("         ���iID�F<input type=\"text\" name=\"ID\">\n");
      out.write("         ���ɁF<input type=\"text\" name=\"INITEM\">\n");
      out.write("         �o�ɁF<input type=\"text\" name=\"OUTITEM\">\n");
      out.write("         �݌ɁF<input type=\"text\" name=\"STOCK\">\n");
      out.write("         ���t�F<input type=\"text\" name=\"DATE\">\n");
      out.write("         <input type=\"submit\" value=\"���M\">\n");
      out.write("     </form>\n");
      out.write("     <div>���i�ꗗ�̕\��</div>\n");
      out.write("     <form action=\"Servlet_AllList\" method=\"post\">\n");
      out.write("         <input type=\"submit\" value=\"�ꗗ�\��\">\n");
      out.write("         <br>\n");
      out.write("     </form>\n");
      out.write("     <form action=\"Servlet_Login\" method=\"post\">\n");
      out.write("         <input type=\"submit\" value=\"���O�A�E�g\">\n");
      out.write("     </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
