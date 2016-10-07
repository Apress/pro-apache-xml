
/**XML2PDFServlet-accepts XMLFile as its first argument
 * and XSLfilename as second argument.
 * This program transforms the XMLFile and produces the result
 * in the PDF file.The result is based on the data in the XML file and 
 * the transformation instructions defined in XSL file.
 */


/**
 *
 * @author Dr Sarang
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.xml.sax.InputSource;
import org.apache.fop.apps.Driver;
import org.apache.fop.apps.XSLTInputHandler;

public class XML2PDFServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException {
    String xmlParam = request.getParameter("xml");
    String xsltParam = request.getParameter("xsl");
      try {
        if ((xmlParam != null) && (xsltParam != null)) {
          XSLTInputHandler input =
            new XSLTInputHandler(new File(xmlParam),
              new File(xsltParam));
        try {
          ByteArrayOutputStream out = new ByteArrayOutputStream();

            response.setContentType("application/pdf");

            Driver driver = new Driver();
            driver.setRenderer(Driver.RENDER_PDF);
            driver.setOutputStream(out);
            driver.render(input.getParser(), input.getInputSource());

            byte[] content = out.toByteArray();
            response.setContentLength(content.length);
             response.getOutputStream().write(content);
            response.getOutputStream().flush();
          } catch (Exception ex) {
          throw new ServletException(ex);
        }

            } else {
              PrintWriter out = response.getWriter();
              out.println("<html><head><title>Error</title></head>\n"+
                "<body><h1>XML2PDFServlet Error</h1><h3>"+
                "request params not proper.</h3></body></html>");
            }
        }catch (ServletException ex) {
          throw ex;
        }
        catch (Exception ex) {
          throw new ServletException(ex);
        }
    }
}
