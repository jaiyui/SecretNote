<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/common/commonHeader.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	getNoteList();
});

function getNoteList()
{
	$.ajax({
		type: 'POST',
		url: '/note/getlist',
		data: { 
		    "userIdx" : idx,
		    "tag" : ""
	    },
	    dataType : "json",
		success: function(data){
			var colume = 0;
			var colmax = 6;
			var html = "";
			$.each(data, function(index, item) {
				if (colume % colmax == 0) html = "<div class='row'>";
				html = html + "<div class='col-md-2'>" 
					+ 	"<div class='row'>"
					+ 		"<a href='/note/noteview." + item.noteType + "?noteIdx=" + item.idx + "'>" + item.subject + "</a>" 
					+ 		"/" + item.noteType 
					+ 	"</div>"
					+ 	"<div class='row'>"
					+ 		"<a href='/note/notesetting." + item.noteType + "?noteIdx=" + item.idx + "'>설정</a>" 
					+ 	"</div>"
					+ "</div>";
				if (colume % colmax == 5) {
					colume = 0;
					html += "</div>";
				} else
					colume++;
			});
			if (colume < 5) html = html + "<div class='col-md-" + ((colmax - colume) * 2) + "'></div></div>";
			$("#noteList").append(html);
		},
		error: function(){
			alert('선택한 요청의 정보를 가져오는 중 오류가 발생했습니다.');
		}
	});	
}
</script>
<jsp:include page="/WEB-INF/views/common/commonBodyTop.jsp" />

<div class="container">
	<div class="rows">
		<div class="page-header">
		    <h2>Your NoteBooks</h2>
		</div>
	</div>
	<div class="row">
		<a href="create">추가</a>
	</div>
	<div id="noteList" class="row text-center">
	</div>
	<div class="row">
		<a href="create">추가</a>
	</div>
</div>
<jsp:include page="/WEB-INF/views/common/commonBodyBottom.jsp" />
<jsp:include page="/WEB-INF/views/common/commonFooter.jsp" />
	