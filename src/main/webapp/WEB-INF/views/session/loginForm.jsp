<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/common/commonHeader.jsp" />
<script type="text/javascript">
var result = "${result}";
var url = "${url}";
var queryString = "${queryString}";

$(document).ready(function() {
	$("#email").focusin(function() { if ($(this).val() == "member@whoneedhelp.com") $(this).val(""); });
	$("#email").focusout(function() { if ($(this).val() == "") $(this).val("member@whoneedhelp.com"); });

	$("#password").focusin(function() { if ($(this).val() == "whoneedhelp") $(this).val(""); });
	$("#password").focusout(function() { if ($(this).val() == "") $(this).val("whoneedhelp"); });
	
	$("#url").val(url);
	$("#queryString").val(queryString);
	if (result != "failure") $("#login_alert").hide();
});
</script>
<jsp:include page="/WEB-INF/views/common/commonBodyTop.jsp" />

<div class="container">
	<div class="col-md-1"></div>
	<div class="col-md-3">
		<div class="page-header">
			<h2>Log In</h2>
		</div>
		<form role="form" action="/session/start" method="post">
       		<input id="url" class="input-xlarge" type="hidden" value="" name="url"></input>
       		<input id="queryString" class="input-xlarge" type="hidden" value="" name="queryString"></input>
			<div class="alert text-danger" id="login_alert">
				<strong>Error!</strong> Please enter your Id and password correctly
			</div>
            <div class="form-group">
				<label class="control-label" for="email">Username/Email</label>
				<div class="controls">
					<input id="email" class="form-control" type="text" value="member@whoneedhelp.com" name="email" size="30"></input>
				</div>
             </div>
             <div class="form-group">
					<label class="control-label" for="password">Password</label>
					<div class="controls">
						<input id="password" class="form-control" type="password" value="whoneedhelp" name="password" size="30"></input>
					</div>
			</div>
			<div class="form-group">
				<input class="btn btn-primary btn-lg" type="submit" value="Login"></input>
			</div>
        </form>
	</div>
	<div class="col-md-2"></div>
	<div class="col-md-6">
           <div class="page-header">
               <h2>Don't have an account yet?</h2>
           </div>

           <p>Create an account offers the following advantages:</p>
           <ul>
               <li>Create, track and export your invoices online</li>
               <li>Gain critical insights into how your business is doing</li>
               <li>Stay informed about promotions and special packages</li>
           </ul>

           <div class="clearfix center">
               <a class="btn btn-primary btn-lg btn-success" href="/session/register">Sign Up</a>
           </div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/common/commonBodyBottom.jsp" />
<jsp:include page="/WEB-INF/views/common/commonFooter.jsp" />
