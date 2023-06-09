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
        <c:forEach items="${tx}" var="tx">
            <c:choose>
                <c:when test="${chuyenxe.idTX.idTX == tx.idTX}">
                    <option value="${tx.idTX}" selected>${tx.diemdi}-${tx.diemden}</option>
                </c:when>
                <c:otherwise>
                    <option value="${tx.idTX}">${tx.diemdi}-${tx.diemden}</option>

                </c:otherwise>
            </c:choose>

        </c:forEach>
    </form:select>
    <label for="idTX" class="form-label">Tuyến xe:</label>
</div>
<div class="form-floating mb-3 mt-3">
    <form:input class="form-control" id="giave"  placeholder="Giá Vé" path="giave" name="giave" />
    <label for="giave">Giá Vé</label>
</div>
<div class="form-floating mb-3 mt-3">
    <form:input class="form-control" id="slve"  placeholder="Số Lượng Vé" path="slve" name="slve"/>
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
<c:if test="${chuyenxe.hinhanh != null && chuyenxe.hinhanh != ''}">
    <div class="form-floating mb-3 mt-3">
        <img src="${chuyenxe.hinhanh}" width="300" />
    </div>
</c:if>
<div class="form-floating mt-2">
    <c:choose>
        <c:when test="${chuyenxe.idchuyenxe > 0}">
            <form:hidden path="idchuyenxe" />
            <form:hidden path="hinhanh" />
            <input type="submit" value="Cập nhật sản phẩm" class="btn btn-success" />
        </c:when>
        <c:otherwise>
            <input type="submit" value="Thêm sản phẩm" class="btn btn-success" />
        </c:otherwise>
    </c:choose>

</div>
</form:form>

<table class="table">
    <tr>
        <th></th>
        <th>Id</th>
        <th>Tên Chuyến</th>
        <th>Tuyến</th>
        <th>Gía Vé</th>
        <th>Ngày/giờ</th>
        <th>Số lượng vé tối đa</th>
        <th>Số lượng vé đã bán</th>
        <th></th>
    </tr>
    <c:forEach items="${cx}" var="cx">
        <tr id="chuyenxe${cx.idchuyenxe}">
            <td id="chuyenxe${cx.idchuyenxe}">
                <img src="${cx.hinhanh}" width="180" />
            </td>
            <td>${cx.idchuyenxe}</td>
            <td>${cx.tenchuyenxe}</td>
            <td>${cx.idTX.diemdi} -${cx.idTX.diemden}</td>
            <td>${cx.giave} VNĐ</td>
            <td>-</td>
            <td>${cx.slve}</td>
            <td>${cx.slvedaban}</td>

            <td>
               <div id="spinner${cx.idchuyenxe}" style="display:none" class="spinner-border text-primary"></div>
                <c:url value="/api/chuyenxe/${cx.idchuyenxe}" var="endpoint" />
                <input  type="button" onclick="delCX('${endpoint}', ${cx.idchuyenxe})" value="Xóa" class="btn btn-danger" />
             

                <a href="<c:url value="/admin/chuyenxe/${cx.idchuyenxe}" />" class="btn btn-info">Cập nhật</a>

            </td>
        </tr>
    </c:forEach>
</table>

<script src="<c:url value="/js/chuyenxe.js" />"></script>