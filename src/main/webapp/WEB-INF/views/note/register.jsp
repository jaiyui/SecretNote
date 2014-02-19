<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/common/commonHeader.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	$(".alert").hide();
	
	$("#userIdx").val(idx);
});

var Note = {
	    check: function (id) {
	    	var verify = true;
	    	
	    	var value = $.trim($("#" + id)[0].value); 
	        if (value == '') {
	    		verify = false;
	        };

	        if (!verify)
        	{
	            $("#" + id)[0].focus();
	            $("#" + id + "_alert").show();
        	} else
        		$("#" + id + "_alert").hide();
	        return verify;
	    },
	    validate: function () {
	        if (Note.check("subject") == false) {
	            return false;
	        }
	        $("#note")[0].submit();
	    }
	}
</script>
<body>
<jsp:include page="/WEB-INF/views/common/commonBodyTop.jsp" />

<div class="container">

	<div class="page-header">
	    <h2>Create New NoteBook</h2>
	</div>

	<form id="note" name="note" class="form-horizontal" onbeforesubmit="return false" method="post" action="/note/register">    
		<fieldset>
		<input type="hidden" name="userIdx" id="userIdx" value="" />
        <div class="control-group">
            <label class="control-label" for="nickname">Subject</label>
            <div class="controls">
                <input class="input-xlarge" name="subject" id="subject" value="" type="text" />                
                <p class="help-block">(required)</p>
                <div class="alert" id="nickname_alert">
                    <strong>Warning!</strong> Please enter your desired note subject
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="id">Can everyone use</label>
            <div class="controls">
                <input name="isPublic" id="isPublic_No" value="0" type="radio" checked /> No                
                <input name="isPublic" id="isPublic_Yes" value="1" type="radio" /> Yes                
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="pwd">Note type</label>
            <div class="controls">
				<select id="noteType" name="noteType">
					<option value="diary">Diary</option>
					<option value="ediary">Exchange diary</option>
					<option value="novel">Novel</option>
				</select>             	
            </div>
        </div>
        <p></p>
        <div class="form-actions">
            <input class="btn btn-primary btn-large" onclick="return Note.validate();" value="Create" type="submit" />        
        </div>
    </fieldset>
	</form>

	<jsp:include page="/WEB-INF/views/common/commonBodyBottom.jsp" />
</div>
</body>
<jsp:include page="/WEB-INF/views/common/commonFooter.jsp" />
	