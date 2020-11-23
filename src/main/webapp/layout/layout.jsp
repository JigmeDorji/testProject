    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <%@page session="false" %>
        <html>
        <head>
        <title><sitemesh:write property="title"/></title>
        <link rel="shortcut icon" href=""/>
        <jsp:include page="include/css.jsp"/>
        <jsp:include page="include/js.jsp"/>
        </head>
        <body class="page-top">
        <div id="wrapper">
        <jsp:include page="include/sideBar.jsp"/>
        <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">
        <!---top bar----->
        <jsp:include page="include/topBar.jsp"/>
        <!--end of topbar -->
        <sitemesh:write property="body"/>
        </div>
        </div>
        </div>
        <!-- footer -->
        <jsp:include page="include/footer.jsp"/>
        <!--- end of footer -->


        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">×</span>
        </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
        <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
        </div>
        </div>
        </div>
        </body>
        </html>