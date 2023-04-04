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
    <script src="<c:url value="/resources/js/Cart.js" />"></script>
    <link href="https://cdnjs.com/libraries/font-awesome">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <c:url value="/api/cart" var="endpoint" />
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
                        <a href="#" class="btn btn-primary" onclick="addToCart('${endpoint}',${cx.idchuyenxe},'${cx.tenchuyenxe}',${cx.giave})">Đặt hàng</a>
                    </div>
                    <img class="card-img-bottom" src="${cx.hinhanh}" alt="Card image" style="padding:20px;">
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<a href="<c:url value="/cart"/>" class="nav-link text-primary">
                                <i class="fa fa-car fa-3x" aria-hidden="true"></i>

                                <div id="cartCouter">${cartCouter}</div>
                            </a>
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(countCX/9)}" var="i">   
        <c:url value="/" var="c">
            <c:param value="${i}" name="page" />
        </c:url>
        <li class="page-item"><a class="page-link" href="${c}">${i}</a></li>
    </c:forEach>
</ul>
</body>
</html>
