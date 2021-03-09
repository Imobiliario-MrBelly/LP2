package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-br\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Home</title>\n");
      out.write("        <link rel=\"icon\" href=\"./css/img/Fav icon.svg\" type=\"image/svg\" />\n");
      out.write("        <link rel='stylesheet' href='./css/utilities/bootstrap.css'>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/main.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body style=\"background-color: #f0f0f0;\">\n");
      out.write("\n");
      out.write("        <!--Menus-->\n");
      out.write("        <nav class=\"navbar nav-personalizado px-5 py-4\">\n");
      out.write("            <a class=\"navbar-brand\"><img src=\"../client/css/img/Logo home.png\" alt=\"\"></a>\n");
      out.write("\n");
      out.write("            <div class=\"dropdown\">\n");
      out.write("                <button class=\"btn dropdown-toggle\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                    Seu Barriga\n");
      out.write("                </button>\n");
      out.write("                <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">Sair</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"sidenav px-4 d-inline\">\n");
      out.write("            <h5 class=\"quickBold mt-4\">MENU</h5>\n");
      out.write("            <div class=\"my-5\">\n");
      out.write("                <div class=\"mb-4\"><a href=\"index.jsp\" class=\"quickBold  ativo\">INDEX</a></div>\n");
      out.write("                <div class=\"mb-4\"><a href=\"pesquisaLoginController\" class=\"quickBold  \">LOGINS</a></div>\n");
      out.write("                <div class=\"mb-4\"><a href=\"pesquisaContrato\" class=\"quickBold \">CONTRATOS</a></div>\n");
      out.write("                <div class=\"mb-4\"><a href=\"pesquisaEndereco\" class=\"quickBold \">ENDEREÇOS</a></div>\n");
      out.write("                <div class=\"mb-4\"><a href=\"pesquisaImovel\" class=\"quickBold \">IMOVEIS</a></div>\n");
      out.write("                <div class=\"mb-4\"><a href=\"pesquisaLocador\" class=\"quickBold  \">LOCADORES</a></div>\n");
      out.write("                <div class=\"mb-4\"><a href=\"pesquisaLocatario\" class=\"quickBold \">LOCATARIOS</a></div>\n");
      out.write("                <div class=\"mb-4\"><a href=\"pesquisaPessoa\" class=\"quickBold \">PESSOAS</a></div>\n");
      out.write("                <div class=\"mb-4\"><a href=\"pesquisaTelefone\" class=\"quickBold \">TELEFONES</a></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--Fim Menus-->\n");
      out.write("\n");
      out.write("        <!--Content-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--Fim Content-->\n");
      out.write("\n");
      out.write("        <script src='./js/utilities/bootstrap.js'></script>\n");
      out.write("        <script src='./js/utilities/jquery-3.5.1.js'></script>\n");
      out.write("        <script src='./js/main.js'></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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
