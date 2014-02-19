<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/common/commonHeader.jsp" />
<script type="text/javascript">
var noteIdx = "${noteIdx}";

$(document).ready(function() {
	getNote();
});

function getNote()
{
	$.ajax({
		type: 'POST',
		url: '/note/getnote',
		data: { 
		    "noteIdx" : noteIdx
	    },
	    dataType : "json",
		success: function(note){
			$("#diarySubject").html(note.subject);
		},
		error: function(){
			alert('선택한 요청의 정보를 가져오는 중 오류가 발생했습니다.');
		}
	});	
	
}
</script>
<body>
<jsp:include page="/WEB-INF/views/common/commonBodyTop.jsp" />

<div class="container">

	<div class="page-header">
	    <h2 id="diarySubject"></h2>
	</div>

	날짜
	 <span id="today"></span>
	<form id="note" name="note" class="form-horizontal" onbeforesubmit="return false" method="post" action="/note/register">    
		<fieldset>
		<input type="hidden" name="idx" id="idx" value="" />
		<textarea id="content" name="content">
		</textarea>
		</fieldset>
	</form>	
	
	<div id="diaryList">
	</div>

	<jsp:include page="/WEB-INF/views/common/commonBodyBottom.jsp" />
</div>
</body>
<jsp:include page="/WEB-INF/views/common/commonFooter.jsp" />
	