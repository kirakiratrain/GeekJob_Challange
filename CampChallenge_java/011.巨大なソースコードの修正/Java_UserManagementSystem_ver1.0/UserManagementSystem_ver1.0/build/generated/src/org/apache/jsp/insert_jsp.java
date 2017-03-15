package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;
import jums.UserDataBeans;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession hs = request.getSession();
    UserDataBeans userdataBeans = new UserDataBeans();
    if(hs.getAttribute("name") != null) userdataBeans.setName((String)hs.getAttribute("name"));
    if(hs.getAttribute("year") != null ) userdataBeans.setYear((String)hs.getAttribute("year"));
    if(hs.getAttribute("month") != null) userdataBeans.setMonth((String)hs.getAttribute("month"));
    if(hs.getAttribute("day") != null) userdataBeans.setDay((String)hs.getAttribute("day"));
        
    if(hs.getAttribute("year") != null && hs.getAttribute("month") != null && hs.getAttribute("day") != null)
    {
        userdataBeans.setBirthday(hs.getAttribute("year")+"年"+hs.getAttribute("month")+"月"+hs.getAttribute("day")+"日");
    }
    if(hs.getAttribute("type") != null) userdataBeans.setType((String)hs.getAttribute("type"));
    if(hs.getAttribute("tell") != null) userdataBeans.setTell((String)hs.getAttribute("tell"));
    if(hs.getAttribute("comment") != null)
    {
        userdataBeans.setComment((String)hs.getAttribute("comment"));
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS登録画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <form action=\"insertconfirm\" method=\"POST\">\n");
      out.write("        名前:\n");
      out.write("        <input type=\"text\" name=\"name\" value=\"");
      out.print(userdataBeans.getName());
      out.write("\">\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        生年月日:　\n");
      out.write("        <select name=\"year\">\n");
      out.write("            ");

            String valueYear = "----";
            if(!userdataBeans.getYear().equals(""))
            {
                valueYear = userdataBeans.getYear();
            }
            
      out.write("\n");
      out.write("            <option value=\"");
      out.print(valueYear);
      out.write('"');
      out.write('>');
      out.print(valueYear);
      out.write("</option>\n");
      out.write("1            ");

            for(int i=1950; i<=2010; i++){ 
      out.write("\n");
      out.write("            <option value=\"");
      out.print(i);
      out.write("\"> ");
      out.print(i);
      out.write(" </option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </select>年\n");
      out.write("        <select name=\"month\">\n");
      out.write("            ");

            String valueMonth = "--";
            if(!userdataBeans.getMonth().equals(""))
            {
                valueMonth = userdataBeans.getMonth();
            }
            
      out.write("\n");
      out.write("            <option value=\"");
      out.print(valueMonth);
      out.write('"');
      out.write('>');
      out.print(valueMonth);
      out.write("</option>\n");
      out.write("            ");

            for(int i = 1; i<=12; i++){ 
      out.write("\n");
      out.write("            <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </select>月\n");
      out.write("        <select name=\"day\">\n");
      out.write("            ");

            String valueDay = "--";
            if(!userdataBeans.getDay().equals(""))
            {
                valueDay = userdataBeans.getDay();
            }
            
      out.write("\n");
      out.write("            <option value=\"");
      out.print(valueDay);
      out.write('"');
      out.write('>');
      out.print(valueDay);
      out.write("</option>\n");
      out.write("            ");

            for(int i = 1; i<=31; i++){ 
      out.write("\n");
      out.write("            <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </select>日\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        種別:\n");
      out.write("        <br>\n");
      out.write("        ");

            String chkVal1,chkVal2,chkVal3;
            chkVal1 = chkVal2 = chkVal3 = "";   //初期化
            if(userdataBeans.getType().equals("1"))     chkVal1 = "checked";
            else if(userdataBeans.getType().equals("2"))     chkVal2 = "checked";
            else if(userdataBeans.getType().equals("3"))   chkVal3 = "checked";
            else chkVal1 = "checked";
        
      out.write("\n");
      out.write("        <input type=\"radio\" name=\"type\" value=\"1\" ");
      out.print(chkVal1);
      out.write(">エンジニア<br>\n");
      out.write("        <input type=\"radio\" name=\"type\" value=\"2\" ");
      out.print(chkVal2);
      out.write(">営業<br>\n");
      out.write("        <input type=\"radio\" name=\"type\" value=\"3\" ");
      out.print(chkVal3);
      out.write(">その他<br>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        電話番号:\n");
      out.write("        <input type=\"text\" name=\"tell\" value=\"");
      out.print(userdataBeans.getTell());
      out.write("\">\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        自己紹介文\n");
      out.write("        <br>\n");
      out.write("        <textarea name=\"comment\" value=\"\" rows=10 cols=50 style=\"resize:none\" wrap=\"hard\">");
      out.print(userdataBeans.getComment());
      out.write("</textarea><br><br>\n");
      out.write("        \n");
      out.write("        <input type=\"hidden\" name=\"ac\"  value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("        <input type=\"submit\" name=\"btnSubmit\" value=\"確認画面へ\">\n");
      out.write("    </form>\n");
      out.write("        <br>\n");
      out.write("        ");
      out.print(JumsHelper.getInstance().home());
      out.write("\n");
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
