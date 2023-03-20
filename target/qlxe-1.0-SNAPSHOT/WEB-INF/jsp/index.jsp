<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
    
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)" style="width: 100px; height: 50px;font-size: 2rem;padding-left:20px;">Logo</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">

                <div class="dropdown" style="margin:16px 0 24px 0;;">
                    <button type="button" class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                        Tuyến xe
                    </button>
                    <ul class="dropdown-menu" style="">
                        <c:forEach items="${tx}" var="tx">
                            <c:url value="/" var="url">
                                <c:param name="idTX" value="${tx.idTX}" />
                            </c:url>
                            <li class="nav-item">
                                <a class="nav-link" style="color: black;" href="${url}">${tx.diemdi}- ${tx.diemden}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </ul>
            <form class="d-flex" >
                <input class="form-control me-2" name="kw" type="text" placeholder="Search......">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
          
        </div>
    </div>
</nav>
<section class="container">
    <c:if test="${cx.size()==0}">
        <strong>Chuyến xe này sắp sửa vào hoạt động!</strong>
    </c:if>
    <div class="row">
        <c:forEach items="${cx}" var="cx">
            <div class="col-md-4 col-xs-12" style="padding:1rem;text-align:center">
                <div class="card" style="width:400px">
                    <div class="card-body">
                        <h4 class="card-title">${cx.tenchuyenxe}</h4>
                         <p class="card-text">${cx.idTX.diemdi} - ${cx.idTX.diemden}</p>
                         <p class="card-text">
                        <fmt:formatNumber value="${cx.giave}" maxFractionDigits="3" type = "number" /> VND
                    </p>
                        <a href="#" class="btn btn-primary">Xem chi tiết</a>
                    </div>
                    <img class="card-img-bottom" src="https://tse3.mm.bing.net/th?id=OIP.hpyVY0Y7Bnv4wj2IRj_YeQAAAA&pid=Api&P=0" alt="Card image" style="padding:20px;">
                </div>
            </div>
            </c:forEach>
        </div>
    </section>
</body>
</html>
