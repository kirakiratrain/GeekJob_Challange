package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.objectStudy2.Human;
import org.objectStudy2.Dealer;
import org.objectStudy2.User;
import java.util.ArrayList;

public final class blackJackMain_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    out.println("ブラックジャック開始");
    
    out.println("初期化");
    out.println("<br>");
    Dealer dealer = new Dealer();
    User   user   = new User();
    out.println("カードを引く");
    out.println("<br>");
    ArrayList<Integer> cards = new ArrayList<Integer>();
    
    //Userが引く
    cards = dealer.deal();
    user.setCard(cards);
    cards.clear();
    
    //Dealerが引く
    cards = dealer.deal();
    dealer.setCard(cards);
    
    boolean pass = false;
    while(pass == false)
    {
        //checkSum
        boolean isHit = user.checkSum();
        
        //まだ引ける場合
        if(isHit)
        {
            //引くか引かないか判断
            //入力待ち
            user.setCard(dealer.hit());
        }
        else
        {
            pass = true;
        }
    }
    
    int userAns     = 21 - user.open();
    int dealerAns   = 21 - dealer.open();
    int judge = 0;      //0 引き分け　１：勝ち　２：負け
    
    //ブラックジャックの場合
    if(userAns == 0 || dealerAns == 0)
    {
        if(userAns == 0 && dealerAns == 0)
        {
            judge = 0;            //ドロー
        }
        else if(userAns == 0 )
        {
            judge = 1;           //勝ち
        }
        else if( dealerAns == 0)
        {
            judge = 2;          //負け
        }
    }
    //User:Burst  Dealer:Burst
    else if(userAns < 0 || dealerAns < 0)
    {
        //どっちもバースト
        if(userAns < 0 && dealerAns < 0)
        {
            judge = 0;      //ドロー
        }
        else if(userAns < 0)
        {
            judge = 2;      //負け
        }
        else if(dealerAns < 0)
        {
            judge = 1;       //勝ち
        }
    }
    //どちらも２１以下　の場合
    else 
    {
        //比較
        int cmpAns = userAns - dealerAns;
        if(cmpAns > 0)
        {
            judge = 1;  //勝ち
        }
        else
        {
            judge = 2;   //負け
        }
    }
    switch(judge)
    {
        case 0:
            out.println("ドロー");
            out.println("<br>");
            break;
        case 1:
            out.println("勝ち");
            out.println("<br>");
            break;
        case 2:
            out.println("負け");
            out.println("<br>");
    }
    

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
