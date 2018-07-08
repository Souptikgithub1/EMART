var _js = _js || {
	utils : this.utils || {},
	services : this.services || {},
	globals : this.globals || {}
};

(function(document , window , $ , _js , undefined) {

	_js.services.User = {
			
		showUserName : function() {
			if(typeof(localStorage.getItem('userName'))!='undefined' && localStorage.getItem('userName')!=null && localStorage.getItem('userName')!=''){
				$("#user-nav").html('<div class="nav navbar-nav dropdown">' +
										'<div class="dropbtn"><a style="text-decoration: none;" href="#"><span class="glyphicon glyphicon-user"></span>' + localStorage.getItem('userName') + '</a></div>' +
										  '<div class="dropdown-content">' +
										    '<a href="#">Link 1</a>' +
										    '<a href="#">Link 2</a>' +
										    '<a id="logout-btn" href="#">Log Out</a>' +
										  '</div>' +
									'</div>');
			}
		}
	};
	
	
	$(document).ready(function() {
		//signup script
		$("#signup-btn").on("click" , function(e){
			$.ajax({ type: "GET",
					  url: _js.globals.ctx + "/UserController/SignUp",
					 data: "userName=" + $("#signup-name").val() + "&userEmail=" + $("#signup-email").val() + "&userPassword=" + $("#signup-password").val()
			}).done(function(response){
				var result = JSON.parse(response);
				if(result.statusCode == '1'){
					
					localStorage.setItem('userName' , $("#signup-name").val());
					_js.services.User.showUserName();
					$('[data-dismiss="modal"]').click();
					
					console.log(result.data);
					
				}else if(result.statusCode == '0'){
					
					$("#js-signup-msg").text(result.msg);
					console.log("unable to register");
				}
			}).fail(function(response){
				console.log("ajax call failed");
				console.log(response);
			});
		});
		
		//login script
		$(document).on("click", "#login-btn" , function(){
			console.log('login');
			console.log(_js.globals.deviceType);
		});
		
		
		//logout script
		$(document).on("click" , "#logout-btn" , function(){
			//console.log('hello');
			$.ajax({ type: "GET",
					  url: _js.globals.ctx + "/UserController/Logout"
					 	
			}).done(function(resp){
				if(resp == "1"){
					localStorage.removeItem('userName');
					$("#user-nav").html('<ul class="nav navbar-nav ">' +
											'<li><a href="#" data-toggle="modal" data-target="#signup-login-modal"><span class="glyphicon glyphicon-user"></span> Register/Login</a></li>' +
											//'<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>' +
										'</ul>');
					console.log("User logged out");
				}
			}).fail(function(resp){
					
			});
		});
		
		_js.services.User.showUserName();
	});
	
	
	
})(document , window , jQuery , _js);

