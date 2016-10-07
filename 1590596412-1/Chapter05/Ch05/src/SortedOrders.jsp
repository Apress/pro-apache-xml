<%@ page language="java" contentType="text/html" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="javax.xml.transform.*"%>
<%@ page import="javax.xml.transform.stream.*"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Orders</title>
    </head>
    <body>

        <h1>Customer Orders</h1>
    
        <%! String FS = System.getProperty("file.separator"); %>
        <%
                
        String xmlFile    = request.getParameter("XML");
        String xslFile    = request.getParameter("XSL");
        
        // get the real path for xml and xsl files;

        String ctx = getServletContext().getRealPath("") + FS;
        xslFile = ctx + xslFile;
        xmlFile = ctx + xmlFile;
        
        TransformerFactory tFactory =
                TransformerFactory.newInstance();
        Transformer transformer =
                tFactory.newTransformer(new StreamSource(xslFile));
//        transformer.transform(
//                new StreamSource(xmlFile), new StreamResult(out));
        %>
    </body>
</html>
