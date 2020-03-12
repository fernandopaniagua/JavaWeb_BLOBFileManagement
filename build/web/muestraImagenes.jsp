<%@page import="java.util.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fernandopaniagua.blobmanagement.model.Imagen"%>
<%
    ArrayList<Imagen> imagenes = (ArrayList<Imagen>)request.getAttribute(("imagenes"));
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Imagenes en la base de datos</title>
    </head>
    <body>
        <%for (Imagen imagen : imagenes) { %>
            <br>
            <%=imagen.getNombre()%>
            <br>
            <%
            String url = "data:image/png;base64," + Base64.getEncoder().encodeToString(imagen.getFichero());
            %>
            <img src="<%=url%>">
        <% } %>
    </body>
</html>
