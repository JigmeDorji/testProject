<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page session="false" %>
<html>
<head>
    <title><sitemesh:write property="title"/></title>
    <link rel="shortcut icon" href="<c:url value='/resources/images/' />"/>
    <jsp:include page="include/css.jsp"/>
    <jsp:include page="include/js.jsp"/>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<jsp:include page="include/menu.jsp"/>
<sitemesh:write property="body"/>
</body>
<jsp:include page="include/footer.jsp"/>
</html>