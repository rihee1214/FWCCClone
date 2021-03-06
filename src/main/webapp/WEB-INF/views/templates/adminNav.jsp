<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="grid-row:1/-1; background-color: rgba(128,128,128,0.6); text-align: center; z-index:200;">
	<div style="display:grid; grid-template-rows:11% 1fr 0.8fr 0.8fr;position:sticky; top:0;">
		<div style="padding:12%;">
			<a href="${pageContext.request.contextPath}/admin/adminHome">
				<img alt="" src="${pageContext.request.contextPath}/images/logo_b.png" style="margin:1.5% 3%; transform:scale(1.2);">
			</a>
		</div>
		<div style="padding:2%; font-size: 1.7em; margin-top:3%;">상품관리
			<ul style="list-style: none; padding:0; font-size:1.2rem; margin-top: 5%;">
				<li><a href="${pageContext.request.contextPath}/admin/productInsert">상품등록</a></li>
				<li style="margin-top:5%;"><a href="${pageContext.request.contextPath}/admin/productDivInsert">상품분류등록</a></li>
				<li style="margin-top:5%;"><a href="${pageContext.request.contextPath}/admin/adminAllList">상품정보수정</a></li>
				<li style="margin-top:5%;"><a href="${pageContext.request.contextPath}/admin/orderlistUpdate">배송상태수정</a></li>
			</ul>
		</div>
		<div style="padding:2%; font-size: 1.7rem;">판매현황
			<ul style="list-style: none; padding:0; font-size:1.2rem; margin-top: 5%;">
				<li><a href="${pageContext.request.contextPath}/admin/saleDay">일간판매연황</a></li>
				<li style="margin-top:5%;"><a href="${pageContext.request.contextPath}/admin/saleWeek">주간판매현황</a></li>
				<li style="margin-top:5%;"><a href="${pageContext.request.contextPath}/admin/saleMonth">월간판매현황</a></li>
			</ul>
		</div>
		<div style="padding:2%; font-size: 1.7rem;">쿠폰 &amp; <br>마일리지
			<ul style="list-style: none; padding:0; font-size:1.2rem; margin-top: 5%;">
				<li><a href="${pageContext.request.contextPath}/admin/transmitCoupon">쿠폰전송</a></li>
				<li style="margin-top:5%;"><a href="${pageContext.request.contextPath}/admin/setCouponsp">쿠폰등록</a></li>
				<li style="margin-top:5%;"><a href="${pageContext.request.contextPath}/admin/transmitMile">마일리지전송</a></li>
			</ul>
		</div>
	</div>
</div>
