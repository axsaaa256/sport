<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2022/12/2
  Time: 上午10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row">
    <a class="flex-sm-fill text-sm-center nav-link"  href="shopService">查看订单</a>
    <a class="flex-sm-fill text-sm-center nav-link active" href="orderService?method=detect">查看订单</a>
    <a class="flex-sm-fill text-sm-center nav-link " href="cardService">购物车</a>
    <a class="flex-sm-fill text-sm-center nav-link  " href="user.jsp">个人信息</a>
</nav>
<div class="container">
    <c:forEach var="order" items="${requestScope.orders}">
        <div class="card">
            <h5 class="card-header">
                <div class="row">
                    <div class="col-md-1">订单号:</div>
                    <div class="col-md-2">
                            ${order.id}
                    </div>
                    <div class="col-md-5"></div>
                    <div class="col-md-1">日期:</div>
                    <div class="col-md-2">
                            ${order.date}
                    </div>
                </div>
            </h5>
            <div class="card-body">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">名称</th>
                        <th scope="col">数量</th>
                        <th scope="col">价格</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="food" items="${order.foods}">
                        <tr>
                            <th scope="row"></th>
                            <td>${food.name}</td>
                            <td>${food.count}</td>
                            <td>${food.price}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <div class="container ">
                    <div class="row justify-content-start">
                        <div class="col-2">状态：</div>
                        <div class="col-2">${order.status}</div>
                    </div>
                    <div class="row justify-content-end">
                        <div class="col-2">总价格：</div>
                        <div class="col-2">${order.price}</div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    <a href="foodService?name=${food.name}" class="link-primary">${food.name}</a>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
