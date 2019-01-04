<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>index</title>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <link rel="stylesheet" href="../static/css/signin.css">
    <link rel="stylesheet" href="../static/css/ie10-viewport-bug-workaround.css">
    <script src="../static/js/jquery-3.3.1.js"></script>
    <script src="../static/js/bootstrap.bundle.min.js"></script>
    <script src="../static/js/app.js"></script>
    <script src="../static/js/ie10-viewport-bug-workaround.js"></script>
</head>

<body>
    <div class="container">

        <form class="form-signin" action="/user/login">
            <h2 class="form-signin-heading">Huido搜房</h2> 
            <br>
            <span id="error"></span>
            <label for="inputName" class="sr-only">用户名</label>
            <input type="text" id="inputName" class="form-control" placeholder="用户名" oninvalid="this.setCustomValidity('请输入用户名')"
                required autofocus>
            <label for="inputPassword" class="sr-only">密码</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="密码" oninvalid="this.setCustomValidity('请输入密码')"
                required>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> 记住密码
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="show() ;return false;">登陆</button>
        </form>

    </div>



</body>
<script>
function show() {

$.post(
    "http://192.168.89.138:8080/user/login",{

      userName: $("#inputName").val(),
      password: $("#inputPassword").val()
    }).done(function(data){
            console.log(data);
            if(data.code === 0){
                 $("#inputName").val("");
                 $("#inputPassword").val("");
                $("#error").text(data.msg);
            }else{
                console.log("redirect ----");
                window.location.href = "index.html";
            }

    })


}




</script>

</html>