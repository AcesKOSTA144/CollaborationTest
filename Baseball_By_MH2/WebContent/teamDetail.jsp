<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Detail</title>
<link href="resources/css/bootstrap_modify.css" rel="stylesheet">
<link href="resources/css/layout.css" rel="stylesheet">
<style>
.feature {
	display: block;
	width: 100%;
	margin: 0;
}

.blog-stripe .block-title {
	background: black;
	width: 100%;
	color: white;
	height: 100px;
	padding-top: 20px;
}

.all-blogs .media {
	margin-left: -40px;
	padding-bottom: 20px;
	border-bottom: 1px solid #CCCCCC;
}
</style>
<script src="resources/js/jquery-2.1.3.js"></script>
</head>
<body>

<%@ include file="header/mainNavigation.jspf" %>

<%@ include file="header/header.jspf" %>

	<div class="container">
		<div class="row">
			<div class="col-md-1 col-lg-1">
			</div>
			<div class="col-md-3 col-lg-3">
				<div class="blog-stripe" >
					<img
						src="http://cfile8.uf.tistory.com/image/270DFF46544268A52033CB"
						alt="SK와이번스" class="feature">
				</div>
			</div>
			<div class="col-md-1 col-lg-1"></div>
			<div class="col-md-7 col-lg-7">
				<ul class="all-blogs">
					<li class="media">
						<div class="media-body">
							<h4 class="media-heading">${team.name }</h4>
						</div>
					</li>
					<li class="media">
						<div class="media-body">
							<h4 class="media-heading">감독 : ${team.manager }</h4>
						</div>
					</li>
					<li class="media">
						<div class="media-body">
							<h4 class="media-heading">연고지 : ${team.region }</h4>
						</div>
					</li>
					<li class="media">
						<div class="media-body">
							<h4 class="media-heading">홈구장 : ${team.stadium }</h4>
						</div>
					</li>
					<li class="media">
						<div class="media-body">
							<h4 class="media-heading">
								등록선수 : <a href="playerList.do?teamId=${team.teamId }">${team.getNumberOfPlayers() }</a>명
							</h4>
						</div>
					</li>
				</ul>
			</div>
			<div class="text-right">
				<a href="teamList.do">
					<button type="button" class="btn btn btn-warning">팀목록</button>
				</a>
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