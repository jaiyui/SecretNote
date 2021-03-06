<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/common/commonHeader.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	$(".alert").hide();
});

var SignUp = {
	    check: function (id) {
	    	var verify = true;
	    	
	    	var value = $.trim($("#" + id)[0].value); 
	        if (value == '') {
	    		verify = false;
	        };

	        switch (id)
	        {
		        case "id":
		        	if (!IsEmail(value)) verify = false;
		        	break;
		        case "pwd":
		        	if (value.length < 8 || value.length > 15) verify = false;
			        if ($("#pwd")[0].value != $("#repeatpwd")[0].value) {
			            $("#repeatpwd")[0].focus();
			            $("#repeatpwd_alert").show();

			            verify = false;
			        }
		        	break;
	        }
	        if (!verify)
        	{
	            $("#" + id)[0].focus();
	            $("#" + id + "_alert").show();
        	} else
        		$("#" + id + "_alert").hide();
	        return verify;
	    },
	    validate: function () {
	        if (SignUp.check("nickname") == false) {
	            return false;
	        }
	        if (SignUp.check("id") == false) {
	            return false;
	        }
	        if (SignUp.check("pwd") == false) {
	            return false;
	        }
	        $("#fellows")[0].submit();
	    }
	}
</script>
<jsp:include page="/WEB-INF/views/common/commonBodyTop.jsp" />

<div class="container">
	<div class="row">
		<div class="page-header">
		    <h2>Register for WHO NEED HELP?</h2>
			<form id="Fellows" name="Fellows" role="form" onbeforesubmit="return false" method="post" action="/session/register">    
		        <div class="form-group">
		            <label class="control-label" for="nickname">nickname (Nick)</label>
		            <div class="row">
		                <div class="col-md-3"><input class="form-control" name="nickname" id="nickname" value="" type="text" /></div>                
		                <div class="col-md-9"><p class="help-block">(required)</p></div>
		            </div>
		            <div class="row">
		                <div class="alert text-danger" id="nickname_alert">
		                    <strong>Warning!</strong> Please enter your desired user name
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label" for="id">Email Address (ID)</label>
		            <div class="row">
		                <div class="col-md-3"><input class="form-control" name="id" id="id" value="" type="text" /></div>                
		                <div class="col-md-9"><p class="help-block">(required)</p></div>
		            </div>
		            <div class="row">
		                <div class="alert text-danger" id="id_alert">
		                    <strong>Warning!</strong> Please enter your valid email
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label" for="pwd">pwd</label>
		            <div class="row">
		                <div class="col-md-3"><input class="form-control" name="pwd" id="pwd" value="" type="password" /></div>                
		                <div class="col-md-9"><p class="help-block">(required, minimum 8 and maximum 15 characters)</p></div>
		            </div>
		            <div class="row">
		                <div class="alert text-danger" id="pwd_alert">
		                    <strong>Warning!</strong> Please provide a valid pwd
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="control-label" for="repeatpwd">Repeat pwd</label>
		            <div class="row">
		                <div class="col-md-3"><input class="form-control" name="repeatpwd" id="repeatpwd" value="" type="password" /></div>                
		                <div class="col-md-9"></div>
		            </div>
		            <div class="row">
		                <div class="alert text-danger" id="repeatpwd_alert">
		                    <strong>Warning!</strong> The password does not match
		                </div>
		            </div>
		        </div>
		        <div class="form-group">By signing up, you accept terms of use and privacy policy.</div>
		        <div class="form-group">
		            <input class="btn btn-primary btn-large" onclick="return SignUp.validate();" value="Register" type="submit" />        
		        </div>
			</form>
		</div>
	</div>
</div>

	

<jsp:include page="/WEB-INF/views/common/commonBodyBottom.jsp" />
<jsp:include page="/WEB-INF/views/common/commonFooter.jsp" />
