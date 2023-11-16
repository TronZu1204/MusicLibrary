
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
<html>
<head>
  <title>Forget your password</title>
</head>

<body>
  <h1>Forget your password</h1>

  <p>Did you forget your password? Please note your email and we will send you password recovery instructions.</p>

  <form action="forgot-password.do" method="post">
    <input type="email" name="email" placeholder="Email">
    <input type="submit" value="Send">
  </form>
</body>
</html>

// Nhập mật khẩu mới và xác nhận mật khẩu


<html lang="en">
<head>
    <title>Forgot Password</title>
</head>
<body>

<h1>Forgot Password</h1>

<form action="forgotpassword.jsp" method="post">
    <input type="email" name="email" placeholder="Email">
    <input type="password" name="password" placeholder="New Password">
    <input type="password" name="confirmPassword" placeholder="Confirm Password">
    <input type="submit" value="Send">
</form>

<%

    // Nhận dữ liệu từ form
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String confirmPassword = request.getParameter("confirmPassword");

    // Kiểm tra mật khẩu nhập lại có khớp với mật khẩu nhập trước đó không
    if (password.equals(confirmPassword)) {

        // Gửi email xác nhận đổi mật khẩu
        String message = "Your password has been successfully changed.";
        sendEmail(email, message);

        // Hiển thị thông báo gửi qua email thành công
        out.println("<div class='alert alert-success'>Sent successfully!</div>");

    } else {

        // Hiển thị thông báo mật khẩu không khớp
        out.println("<div class='alert alert-danger'>Passwords do not match!</div>");

    }

%>

</body>
</html>


        
</body>
</html>
