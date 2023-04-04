<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1 class="bg-info rounded text-white">Giỏ Hàng</h1>

<c:if test="${carts1 == null}">
    <h4 class="text-danger"> Không có sản phẩm nào trong giỏ</h4>
</c:if>
<c:if test="${carts1 != null }">
    <table class="table">
        <tr>
            <th>Mã Sản phẩm</th>
            <th>Tên Sản phẩm</th>
            <th>Đơn gía</th>
            <th>Số lượng</th>
            <th></th>
        </tr>
        <c:forEach items="${carts1}" var="d">
            <tr>
                <td>${d.idchuyenxe}</td>
                <td>${d.tenchuyenxe}</td>
                <td>${d.giave}VNĐ</td>
                <td>
                        ${d.count}
                </td>
                <td>
                    <input type="button" value="Xoa" class="btn btn-danger"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" value="Thanh toán" class="btn btn-danger"/>
</c:if>