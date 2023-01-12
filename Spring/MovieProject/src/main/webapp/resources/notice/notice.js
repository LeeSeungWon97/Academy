/**
 * 
 */
 
 var noticeSock = new SockJS('http://' + window.location.hostname + ':'
				+ window.location.port + '/controller/noticeSendPage');
		
		
		noticeSock.onopen = function() {
			console.log("open");
		}
		
		noticeSock.onmessage = function(e) {
			var data = JSON.parse(e.data);
			switch(data.type){
				case 'userConnect':
					Command: toastr["info"](data.userid, '[알림]');
					break;
				case 'notice':
					Command: toastr["success"](data.content, '[알림]');
			}
		}
		
		noticeSock.onclose = function() {
			
		}
		
		
		
		toastr.options = {
			"closeButton" : false,
			"debug" : false,
			"newestOnTop" : false,
			"progressBar" : false,
			"positionClass" : "toast-top-center",
			"preventDuplicates" : false,
			"onclick" : null,
			"showDuration" : "300",
			"hideDuration" : "1000",
			"timeOut" : "5000",
			"extendedTimeOut" : "1000",
			"showEasing" : "swing",
			"hideEasing" : "linear",
			"showMethod" : "fadeIn",
			"hideMethod" : "fadeOut"
		}