<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-main-style">
	<h2>회원 정보 상세 보기</h2>
	<table>
		<tr>
			<th>회원 번호</th>
			<td>${memberVO.mem_num}</td>
		</tr>
		<tr>
			<th>회원 이메일</th>
			<td><a href="mailto:">${memberVO.email}</a></td>
		</tr>
		<tr>
			<th>회원 닉네임</th>
			<td>${memberVO.nickname}</td>
		</tr>
		<tr>
			<th>회원 전화번호</th>
			<td>${memberVO.phone}</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${memberVO.birth}</td>
		</tr>
		<tr>
			<th>회원가입일</th>
			<td>${memberVO.mem_regdate}</td>
		</tr>
		<tr>
			<th>이용권 구매일</th>
			<c:if test ="${not empty memberVO.purchase_date}">
			<td>구입일 : ${memberVO.purchase_date} / 만료일 : ${memberVO.expire_date}</td>
			</c:if>
			<c:if test ="${empty memberVO.purchase_date}">
			<td>이용권 구매내역이 없습니다.</td>
			</c:if>
		</tr>
	</table>
</div>