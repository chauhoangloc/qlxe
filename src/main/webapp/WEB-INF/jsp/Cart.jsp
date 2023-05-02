<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                <td><fmt:formatNumber value="${d.giave}" maxFractionDigits="3" type = "number" /> VND</td>
                <td>
                    <c:url value="/api/cart" var="update" />
                    <input type="number" value="${d.count}" onblur="updateCart('${update}',this,${d.idchuyenxe})" class="form-control" />

                </td>
                <td>
                    <c:url value="/api/cart/${d.idchuyenxe}" var="del" />
                    <input type="button" value="Xóa"
                           onclick="deleteCart('${del}',${d.idchuyenxe}, '${d.tenchuyenxe}')" class="btn btn-danger"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div><p>Tổng tiền bạn cần thanh toán : <span id="amountCart"> <fmt:formatNumber value="${cartStats.amount}" maxFractionDigits="3" type = "number" />  </span>VNĐ</p></div>
    <div>   
     <c:url value="/api/payment" var="pUrl" />
                <input type="button" onclick="payment('${pUrl}')" value="Thanh toán" class="btn btn-success" />
    </div>
    <div>
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name == null}">
                <c:url value="/login" var="loginUrl" />
                <p>Vui lòng <a href="${loginUrl}">đăng nhập</a> để thanh toán!</p>
            </c:when>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <c:url value="/api/payment" var="pUrl" />
                <input type="button" onclick="payment('${pUrl}')" value="Thanh toán" class="btn btn-success" />
            </c:when>
        </c:choose>
    </div>
</c:if>
<script>
    window.onload = function () {

    }
</script>

<script src="<c:url value="/resources/js/Cart.js" />"></script>