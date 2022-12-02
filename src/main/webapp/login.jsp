<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2022/12/2
  Time: 上午8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <style>
        body {
            margin: 0px;
        }

        #docker {
            background-image: url("1267999.jpg");
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 1000px;
            justify-content: center;
        }

        #sub_docker {
            background-color: white;
            border: 2px solid;
            border-radius: 5%;
            height: 400px;
            width: 400px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .component {
            margin: 25px;
        }
    </style>
</head>

<body>
<article id="docker">
    <div id="sub_docker">
        <section style="font-size:25px ;">注册用户</section>
        <form action="loginServlet" method="post">
            <div class="container">
                <div class="row gy-1">
                    <div class="col-md-12">
                        <label for="account_id" class="form-label">账号:</label>
                    </div>
                    <div class="col">
                        <input type="text" id="account_id" class="form-control" name="account" placeholder="请输入账户名">
                    </div>
                </div>
                <div class="row gy-1">
                    <div class="col-md-12">
                        <label for="password_id" class="form-label">密码:</label>
                    </div>
                    <div class="col">
                        <input type="password" id="password_id" class="form-control" name="password"
                               placeholder="请输入密码">
                    </div>
                </div>
                <br><br>
                <div class="row">
                    <div class="form-check col-md-4">
                        <input class="form-check-input" type="radio" name="role" value="referee" id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                            裁判员
                        </label>
                    </div>
                    <div class="form-check col-md-4">
                        <input class="form-check-input" type="radio" name="role" value="athlete" id="flexRadioDefault2" checked>
                        <label class="form-check-label" for="flexRadioDefault2">
                            运动员
                        </label>
                    </div>
                    <div class="form-check col-md-4">
                        <input class="form-check-input" type="radio" name="role" value="volunteer" id="flexRadioDefault2" checked>
                        <label class="form-check-label" for="flexRadioDefault2">
                            志愿者
                        </label>
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col">
                        <div class="form-text">
                            <span>${requestScope.error_info}</span>
                        </div>
                    </div>
                    <div class="col-md-4 justify-content-end">
                        <a href="register.jsp">注册用户</a>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-4 ">
                        <button type="submit" class="btn btn-primary mx-auto">提交</button>
                    </div>
                </div>
            </div>
        </form>
        </section>
    </div>
</article>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>

</html>