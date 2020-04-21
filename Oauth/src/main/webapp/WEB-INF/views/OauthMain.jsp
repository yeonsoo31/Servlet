<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="565794567467-1e0j5ii6huph37ua8rfkoc94bqj83ivs.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    
<title>OauthMain</title>
<body>
<!-- 구글 OAuth -->
	<div class="g-signin2" data-onsuccess="onSignIn" data-theme="light" data-width="250" data-height="40" data-longtitle="true"></div>
    <script>
    var Gid = '';
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());
        Gid = profile.getId();
        location.href="signUpForm?Gid="+Gid;
        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
      }
    </script>

<!-- 페이스북 OAuth -->
<script>
	window.fbAsyncInit = function() {
		FB.init({
			appId : '2543885372552103',
			cookie : true, // enable cookies to allow the server to access the session
			xfbml : true, // parse social plugins on this page
			version : 'v6.0' // use graph api version 2.8
		});
    	FB.getLoginStatus(function(response) {
		statusChangeCallback(response);
		});
	};

	(function(d, s, id){
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) {return;}
			js = d.createElement(s); js.id = id;
			js.src = "https://connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

	function statusChangeCallback(response) { 
		console.log('statusChangeCallback');
      	if (response.status === 'connected') {
	        console.log(response.authResponse.accessToken);
        	// Logged into your app and Facebook.
        	testAPI();
      	} else if (response.status === 'not_authorized') {
	        document.getElementById('status').innerHTML = 'Please log ' + 'into this app.';
      	} else {
	        document.getElementById('status').innerHTML = 'Please log ' + 'into Facebook.';
     	}
 	}
	function checkLoginState() {
		FB.getLoginStatus(function(response) {
		statusChangeCallback(response);
		});
	}
  	var Fid = '';
	function testAPI() {
		console.log('Welcome! Fetching your information.... ');
  		FB.api(
    		'/me',
    		{"fields":"id,name,email"},
    			function(response) {
      				console.log('Successful login for: ' + response.name);
      				Fid = response.id;
      				location.href="signUpForm2?Fid="+Fid;
    			}
  		);
	}
</script>
	<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v6.0&appId=1660742084088243&autoLogAppEvents=1"></script>
<div class="fb-login-button" data-size="large" data-button-type="login_with" data-layout="default" data-auto-logout-link="false" data-use-continue-as="false" data-width="250" scope="public_profile,email"
  onlogin="checkLoginState();"></div>
	
</body>
</html>