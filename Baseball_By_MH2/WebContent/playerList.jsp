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
<title>Player List</title>
</head>
<body>

<%@ include file="header/mainNavigation.jspf" %>
<%@ include file="header/header.jspf" %>

	<div class="container">
		<div class="row">

			<div class="col-sm-12 col-lg-12">
				<div>
					<h3>등록 선수 목록</h3>
				</div>

				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<colgroup>
							<col width="100" />
							<col width="200" />
							<col width="100" />
							<col width="200" />
							<col width="200" />
							<col width="*" />
							<col width="100" />
						</colgroup>
						<thead>
							<tr>
								<th class="text-center">번호</th>
								<th class="text-center">이름</th>
								<th class="text-center">등번호</th>
								<th class="text-center">포지션</th>
								<th class="text-center">팀명</th>
								<th class="text-center">트래이드</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${players eq null || empty players }">
							<tr>
								<th colspan="7" class="text-center">등록된 선수 정보가 존재하지 않습니다.</th>
							</tr>
							 </c:when>
							 <c:otherwise>
							 	<c:forEach items="${players }" var="player" varStatus="sts">
								<tr>
									<td class="text-center">${sts.count }</td>
									<td class="text-center">${player.name }</td>
									<td class="text-center">${player.backNumber }</td>
									<td class="text-center">${player.position }</td>
									<td class="text-center"><a href="teamDetail.do?teamId=${player.teamId }">${teamNames.get(player.teamId) }</a></td>
									<td class="text-center"><a href="tradeTargetList.do?playerId=${player.playerId }">트레이드</a></td>
								</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<!-- Footer ========================================================================================== -->
		<footer>
			<hr>
			<p>© NamooBaseball 2016.</p>
		</footer>
	</div>

</body>
</html>