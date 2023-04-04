<%-- 
    Document   : headers
    Created on : Mar 11, 2023, 3:12:14 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/Cart.js" />"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdnjs.com/libraries/font-awesome">
<header>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/qlxe" style="width: 100px; height: 50px;font-size: 2rem;padding-left:20px;">Logo</a>

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
                         
                    </div>
                </ul>
                <form class="d-flex" >
                     <a href="<c:url value="/cart"/>" class="nav-link text-primary">
                                <i class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i>

                                <div id="cartCouter">${cartCouter}</div>
                            </a>
                        </ul>
                    <input class="form-control me-2" name="kw" type="text" placeholder="Search......">
                    <button class="btn btn-primary" type="submit">Search</button>
                </form>

            </div>
        </div>
    </nav>
</header>
