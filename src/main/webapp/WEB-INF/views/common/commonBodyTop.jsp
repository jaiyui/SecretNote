<script type="text/javascript">
var topMenu = "${topMenu}";
var middleMenu = "${middleMenu}";
var lowMenu = "${lowMenu}";
var id = "${id}";
var idx = "${idx}";
var nickname = "${nickname}";

$(document).ready(function() {
	setMenu();	
});

function setMenu()
{
	$("#menu" + topMenu).addClass("active");
	
	if (id != "") 
	{
		$("#menuFellow").html("<a href='#'>" + nickname + "</a>");
		$("#menuLogin").html("<a href='/session/logout'>Log out</a>");
	}
}

</script>
<div id="wait_box" class="wait_box">
	<div style="padding-bottom:20px"><span class="space_right">data retrieving...</span></div>
	<div><img alt="Progress" src="/images/loading_32.gif" /></div>
</div>

<div class="navbar navbar-fixed-top">
<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/dashboard/view">Secret Note</a>
    </div>
    <div class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
        	<li id="menuIndex"><a href="/dashboard/view">Home</a></li>
        	<li id="menuNote"><a href="/note/index">My Note</a></li>
        	<li id="menuContact"><a href="/contact/index">Contact</a></li>
		</ul>
        <ul class="nav navbar-right">
        	<li id="menuLogin"><a href="/session/index">Log In/Sign Up</a></li>
		</ul>
        <ul class="nav navbar-right">
        	<li id="menuFellow"></li>
		</ul>
    </div>
</div>
</div>
