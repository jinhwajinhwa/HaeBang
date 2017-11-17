<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>

<head>
<meta charset="utf-8">
<title>Moderna - Bootstrap 3 flat corporate template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<!-- css -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="resources/css/jcarousel.css" rel="stylesheet" />
<link href="resources/css/flexslider.css" rel="stylesheet" />
<link href="resources/css/style.css" rel="stylesheet" />


<!-- Theme skin -->
<link href="resources/skins/default.css" rel="stylesheet" />

<!-- =======================================================
    Theme Name: Moderna
    Theme URL: https://bootstrapmade.com/free-bootstrap-template-corporate-moderna/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
	======================================================= -->
<style>
.form-control {
	clear: both;
	width: 200px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
				
				
				$("#btnLogin").click(function() {
						alert("!");
						var m_id = $("#m_id").val();
						var m_password = $("#m_password").val();
						if (m_id == "") {
							alert("아이디를 입력해주세요.");
							$("#m_id").focus();
							return;
						}
						if (m_password == "") {
							alert("비밀번호를 입력하세요");
							$("#m_password").focus();
							return;
						}

						document.form1.action = "${ pageContext.request.contextPath }/member/loginCheck"
						document.form1.submit();

					});
				
			function btnLogin() {
				alert("!");
				var m_id = $("#m_id").val();
				var m_password = $("#m_password").val();
				if (m_id == "") {
					alert("아이디를 입력해주세요.");
					$("#m_id").focus();
					return false;
				}
				if (m_password == "") {
					alert("비밀번호를 입력하세요");
					$("#m_password").focus();
					return false;
				}
				
				return true;
			};	 
	});
</script>
</head>

<body>
	<div id="wrapper">
		<!-- start header -->
		<header> <jsp:include
			page="/WEB-INF/view/member_include/topmenu.jsp" /> </header>
		<!-- end header -->
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<h4>
						<strong>해방에 로그인 해주세요</strong>
					</h4>

					<form action="${ pageContext.request.contextPath }/member/login" name="form1" method="post" role="form">
						<div class="form-group">
							
								<input type="text" name="m_id" class="form-control" id="m_id"
									placeholder="ID"  />
								<div class="validation"></div>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="m_password"
								id="m_password" placeholder="PASSWORD" />
							<div class="validation"></div>
						</div>
						<input type="submit" value="로그인" onsubmit="btnLogin()"/>
						<%-- <div>
							<input type="submit" id="btnLogin" value="로그인"/>
							<c:if test="${ msg == 'failure' }">
								<div style="color: red">아이디 또는 비밀번호가 일치하지 않습니다.</div>
							</c:if>
							<c:if test="${ msg == 'logout' }">
								<div style="color: red"></div>
							</c:if>
						</div> --%>
					</form>
				</div>
			</div>
		</div>
	</div>
	<footer> <jsp:include
		page="/WEB-INF/view/member_include/bottom.jsp" /> </footer>
	
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	<!-- javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/jquery.easing.1.3.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.fancybox.pack.js"></script>
	<script src="resources/js/jquery.fancybox-media.js"></script>
	<script src="resources/js/google-code-prettify/prettify.js"></script>
	<script src="resources/js/portfolio/jquery.quicksand.js"></script>
	<script src="resources/js/portfolio/setting.js"></script>
	<script src="resources/js/jquery.flexslider.js"></script>
	<script src="resources/js/animate.js"></script>
	<script src="resources/js/custom.js"></script>
	
	<script src="resources/contactform/contactform.js"></script>

</body>

</html>