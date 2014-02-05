<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/common/commonHeader.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	$(".alert").hide();
});
</script>
<body>
<jsp:include page="/WEB-INF/views/common/commonBodyTop.jsp" />

<div class="container">

	<div class="page-header">
	    <h2>Your Privatly Diary</h2>
	</div>
	
	<jsp:include page="/WEB-INF/views/common/commonBodyBottom.jsp" />
</div>
</body>
<jsp:include page="/WEB-INF/views/common/commonFooter.jsp" />
	