<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shopperPurchaseCompletedList</title>
<link href="css/pkw/myPage.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="/WEB-INF/views/base/header.jsp" flush="true">
	<jsp:param value="" name=""/>
</jsp:include>
<jsp:include page="/WEB-INF/views/myPagePkw/myPageTopLine.jsp" flush="true">
	<jsp:param value="" name=""/>
</jsp:include>

<!--	
	OrderList :	총결제번호(pay_tot_num), 상품판매번호(pro_num), 수량(quantity), 구매확정상태(purchase_status)
	결제(주문) :	총결제 금액(pay_tot), 결제일자(pay_date)
	상품판매 :		판매자아이디(user_id), 상품판매글제목(pro_title)
-->
	<section>
	<div align="center">
	<div id="myPage">
	 	<h3><i class="fa-solid fa-pipe" ></i>쇼퍼 구매완료내역</h3>
			 <table class="table table-hover" id="myPageTbl">
				<tr>
					<th>결제번호</th>
					<th>상품번호</th>
					<th>상품이미지</th>
					<th>상품제목</th>
					<th>판매자(ID)</th>
					<th>수량</th>
					<th>총 결제금액</th>
					<th>결제일자</th>
					<th>구매확정상태</th>
				</tr>
				<c:choose>
					<c:when test="${listSize > 0}">
					  <c:forEach var="item" items="${listShopperPurchaseCompleted}">
						<tr>
							<td>${item.pay_tot_num}</td>
							<td>${item.pro_num}</td>
							<td><img alt="" id="photoImg" src="${pageContext.request.contextPath}/upload/${item.pro_photo}"></td>
							<td>${item.pro_title}</td>
							<td>${item.user_id}</td>
							<td>${item.quantity}</td>
							<td>${item.pay_tot}</td>
							<td>${item.pay_date}</td>
							<td>${item.order_status_nm}</td>
						</tr>
					  </c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="9">최근 구매완료한 상품이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
	</section>


<jsp:include page="/WEB-INF/views/base/footer.jsp" flush="true">
	<jsp:param value="" name=""/>
</jsp:include>
</body>
</html>