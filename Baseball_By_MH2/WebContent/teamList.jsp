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
<title>Baseball Teams</title>
</head>
<body>
	<!-- Main Navigation ================================================================================= -->
<%@ include file="header/mainNavigation.jspf" %>

	<!-- Header ========================================================================================== -->

<%@ include file="header/header.jspf" %>

	<!-- Container ======================================================================================= -->
	<div class="container">
		<div class="row">

			<div class="col-sm-12 col-lg-12">
				<div>
					<h3>야구팀 목록</h3>
				</div>

				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<colgroup>
							<col width="100" />
							<col width="*" />
							<col width="200" />
							<col width="200" />
							<col width="300" />
						</colgroup>
						<thead>
							<tr>
								<th class="text-center">번호</th>
								<th class="text-center">팀명</th>
								<th class="text-center">연고지</th>
								<th class="text-center">감독</th>
								<th class="text-center">홈구장</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${teams eq null || empty teams }">
							<tr>
								<th colspan="5" class="text-center">구단정보가 존재하지 않습니다.</th>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${teams }" var="team" varStatus = "sts">
							<tr>
								<td class="text-center">${sts.count }</td>
								<td><a href="teamDetail.do?teamId=${team.teamId }">${team.name }</a></td>
								<td class="text-center">${team.region }</td>
								<td class="text-center">${team.manager }</td>
								<td>${team.stadium }</td>
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