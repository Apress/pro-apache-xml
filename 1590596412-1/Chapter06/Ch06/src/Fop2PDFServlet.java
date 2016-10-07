
/**FO2PDFServlet-accepts FO file as its argument
 * and transforms the FO file to produces the result
 * in the PDF file.
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

public class Fop2PDFServlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException {
  try {
    String foParam = request.getParameter("fo");

		if (foParam != null) {
      FileInputStream file = new FileInputStream(foParam);

      try {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        response.setContentType("application/pdf");

        Driver driver = new Driver(new InputSource(file), out);
        driver.setRenderer(Driver.RENDER_PDF);
        driver.run();

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
            "<body><h1>Fop2PDFServlet Error</h1><h3>No 'fo' "+
            "request param given.</body></html>");
    }
  } catch (ServletException ex) {
    throw ex;
  }
  catch (Exception ex) {
    throw new ServletException(ex);
  }
  }
}
