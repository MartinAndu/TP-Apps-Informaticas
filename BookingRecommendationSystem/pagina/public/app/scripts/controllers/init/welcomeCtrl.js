


function init() {
	$('#app').empty().load('app/templates/home.html');
	$('body').attr('style',`
		background-image : url("/app/images/travel.jpg");
		background-size: cover;
	`);	
}

