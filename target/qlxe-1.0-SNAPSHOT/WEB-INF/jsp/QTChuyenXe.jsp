<%-- 
    Document   : QTChuyenXe
    Created on : Mar 27, 2023, 1:15:25 PM
    Author     : NC
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-info text-center">Chi tiết Tuyến Xe</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if> 
<c:url value="/admin/chuyenxe" var="action" />
<form:form method="POST" action="${action}" modelAttribute="chuyenxe" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="tenchuyenxe"  placeholder="Tên Chuyến Xe" path="tenchuyenxe" name="tenchuyenxe" />
        <label for="tenchuyenxe">Tên Chuyến Xe</label>
    </div>
        
        
   <div class="form-floating">
        <form:select class="form-select" id="idTX" name="idTX" path="idTX">
            <c:forEach items="${tx}" var="cx">

                         <option value="${cx.idTX}">${cx.diemdi}-${cx.diemden}</option>
                
            </c:forEach>
        </form:select>
        <label for="idTX" class="form-label">Tuyến xe:</label>
    </div>
        <c:forEach items="${cx}" var="c">

                         <option value="${c.idTX}">${cx.tenchuyenxe}</option>
                
            </c:forEach>
        
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="giave"  placeholder="Giá Vé" path="giave" name="giave" value="0"/>
        <label for="giave">Giá Vé</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="slve"  placeholder="Số Lượng Vé" path="slve" name="slve" value="0"/>
        <label for="slve">Số Lượng Vé</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="slvedaban"  placeholder="Số Lượng Vé Đã bán" path="slvedaban" name="slvedaban" value="0" />
        <label for="tenchuyenxe">Số Vé Đã Bán</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" type="file" id="file"  placeholder="Tên Chuyến Xe" path="file" name="file" />
        <label for="file">Ảnh</label>
    </div> 
    <div class="form-floating mt-2">
        <input type="submit" value="Thêm Chuyến" class="btn btn-danger" />
    </div>
</form:form>
                      
