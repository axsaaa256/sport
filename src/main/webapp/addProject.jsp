<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2022/12/3
  Time: 上午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.cube.pojo.*" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row">
    <a class="flex-sm-fill text-sm-center nav-link "  href="list.jsp">总览</a>
    <a class="flex-sm-fill text-sm-center nav-link " href="projectManage.jsp">管理项目</a>
    <a class="flex-sm-fill text-sm-center nav-link " href="addProject.jsp">添加项目</a>
    <a class="flex-sm-fill text-sm-center nav-link " href="competitionServlet?method=list">公布成绩</a>
</nav>
<div class="container">
    <div class="card">
        <h5 class="card-header">
            <div class="row">
                <div class="col">
                    欢迎来到运动会管理系统
                </div>
            </div>
        </h5>
        <div class="card-body">
            <div class="container">
                <form action="projectServlet?method=add&role=manage" method="post">
                    <div class="row gy-1">
                        <div class="col-md-12">
                            <label  class="form-label">项目名称:</label>
                        </div>
                        <div class="col">
                            <input type="text"  class="form-control" name="name" >
                        </div>
                    </div>
                    <div class="row gy-1">
                        <div class="col-md-12">
                            <label  class="form-label">项目详细规则:</label>
                        </div>
                        <div class="col">
                            <input type="text"  class="form-control" name="detail">
                        </div>
                    </div>
                    <div class="row gy-1">
                        <div class="col-md-12">
                            <label  class="form-label">地点:</label>
                        </div>
                        <div class="col">
                            <input type="text"  class="form-control" name="position">
                        </div>
                    </div>
                    <div class="row gy-1">
                        <div class="col-md-4">
                            <label  class="form-label">开始时间:</label>
                        </div>
                        <div class="col">
                            <input  type="datetime-local" name="startTime" >
                        </div>
                    </div>
                    <div class="row gy-1">
                        <div class="col-md-4">
                            <label  class="form-label">结束时间:</label>
                        </div>
                        <div class="col">
                            <input type="datetime-local" name="endTime" >
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-4 ">
                            <button type="submit" class="btn btn-primary mx-auto">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>