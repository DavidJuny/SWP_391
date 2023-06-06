<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Modernize Free</title>
  <link rel="shortcut icon" type="image/png" href="Admin/assets/images/logos/favicon.png" />
  <link rel="stylesheet" href="Admin/assets/css/styles.min.css" />
</head>

<body>
<%
  String username1 = "", password1 = "", remember = "";
  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    for (Cookie cook : cookies) {
      if (cook.getName().equals("cookieUsername")) {
        username1 = cook.getValue();
      } else if (cook.getName().equals("cookiePassword")) {
        password1 = cook.getValue();
      } else if (cook.getName().equals("cookieRemember")) {
        remember = cook.getValue();
      }
    }
  }
%>
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="card mb-0">
              <div class="card-body">
                <a href="index_Admin.jsp" class="text-nowrap logo-img text-center d-block py-3 w-100">
                  <img src="Admin/assets/images/logos/dark-logo.svg" width="180" alt="">
                </a>
                <p class="text-center">Your Social Campaigns</p>
                <form action="MainController" method="post">
                  <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Username</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username1" value="<%=username1%>">
                  </div>
                  <div class="mb-4">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password1" value="<%=password1%>>
                  </div>
                  <div class="d-flex align-items-center justify-content-between mb-4">
                    <div class="form-check">
                      <input class="form-check-input primary" type="checkbox" value="" id="flexCheckChecked" checked>
                      <label class="form-check-label text-dark" for="flexCheckChecked">
                        Remeber this Device
                      </label>
                    </div>
                    <a class="text-primary fw-bold" href="index_Admin.jsp">Forgot Password ?</a>
                  </div>
                  <button class=" btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2 " type="submit" name="action" value="LoginAdmin">Login</button>
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">New to Modernize?</p>
                    <a class="text-primary fw-bold ms-2" href="authentication-register.jsp">Create an account</a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="Admin/assets/libs/jquery/dist/jquery.min.js"></script>
  <script src="Admin/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>