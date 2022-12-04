<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2022/12/2
  Time: 上午10:32
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
    <a class="flex-sm-fill text-sm-center nav-link active "  href="listOfCompetition.jsp">查看比赛</a>
    <a class="flex-sm-fill text-sm-center nav-link " href="listOfCompetitionAdd.jsp">参加比赛</a>
    <a class="flex-sm-fill text-sm-center nav-link " href="listOfCompetitionDelete.jsp">退出比赛</a>
</nav>
<div class="container">
    <div class="card">
        <h5 class="card-header">
            <div class="row">
                <div class="col">
                    个人参加的比赛项目
                </div>
            </div>
        </h5>
        <div class="card-body">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">名称</th>
                    <th scope="col">详细信息</th>
                    <th scope="col">地点</th>
                    <th scope="col">开始时间</th>
                    <th scope="col">结束时间</th>
                    <th scope="col">运动员</th>
                    <th scope="col">分数</th>
                </tr>
                </thead>
                <tbody>

                <%int i=0;%>
                <% List<Competition> projects = (List<Competition>)session.getAttribute("competitions");
                    for(Competition project:projects){%>
                <tr>
                    <th scope="row"><%=++i%></th>
                    <td><%=project.getProject().getName()%></td>
                    <td><%=project.getProject().getDetail()%></td>
                    <td><%=project.getProject().getPostion()%></td>
                    <td><%=project.getProject().getStartTime()%></td>
                    <td><%=project.getProject().getEndTime()%></td>
                    <td><%=project.getAthlete().getName()%></td>
                    <td><%=project.getScore()%></td>
                </tr>
                <%}%>
                </tbody>
            </table>
            <div class="container ">
                <div class="row justify-content-end">
                    <div class="col-2">总数：</div>
                    <div class="col-2"><%=i%></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>