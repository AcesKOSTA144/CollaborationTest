<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/bootstrap_modify.css" rel="stylesheet">
<link href="resources/css/layout.css" rel="stylesheet">
<script src="resources/js/jquery-2.1.3.js"></script>
<title>Trade Target List</title>
</head>
<body>
<%@ include file="header/mainNavigation.jspf" %>
	<header>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="jumbotron">
						<h2>${sourcePlayer.name } 선수 트레이드</h2>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<ol class="breadcrumb">
						<li>홈</li>
						<li>선수목록</li>
						<li class="active ">트레이드</li>
					</ol>
				</div>
			</div>
		</div>
	</header>

	<!-- Container ======================================================================================= -->
	<div class="container">
		<div class="row">
		<form action="tradePlayer.do" method="post">
			<div class="col-sm-12 col-lg-12">
				<div>
					<h3>트레이드 대상 선수 목록</h3>
				</div>

				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<colgroup>
							<col width="100" />
							<col width="200" />
							<col width="200" />
							<col width="200" />
							<col width="200" />
							<col width="*" />
						</colgroup>
						<thead>
							<tr>
								<th class="text-center">선택</th>
								<th class="text-center">이름</th>
								<th class="text-center">등번호</th>
								<th class="text-center">포지션</th>
								<th class="text-center">팀명</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${targetPlayers eq null || empty targetPlayers }">
							<tr>
								<th colspan="6" class="text-center">등록된 선수 정보가 존재하지 않습니다.</th>
							</tr>
						</c:when>
						<c:otherwise>
						
							<c:forEach items="${targetPlayers }" var="targetPlayer">
							<tr>
								<td class="text-center"><input type="radio"
									name="targetPlayer" value="${targetPlayer.playerId }"></td>
								<td class="text-center">${targetPlayer.name }</td>
								<td class="text-center">${targetPlayer.backNumber }</td>
								<td class="text-center">${targetPlayer.position }</td>
								<td class="text-center">${teamNames.get(targetPlayer.teamId) }</td>
							</tr>
							</c:forEach>
						
						</c:otherwise>
						</c:choose>
						</tbody>
					</table>

				</div>

				<div class="text-right">
					<input type="hidden" name="sourcePlayer" value="${sourcePlayer.playerId }">
					<input type="submit" class="btn btn btn-warning" value="트래이드">
				</div>
			</div>
			</form>
		</div>
		<!-- Footer ========================================================================================== -->
		<footer>
			<hr>
			<p>© NamooBaseball 2016.</p>
		</footer>
	</div>

</body>
</html>