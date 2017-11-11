


function init() {
	$('#app').empty().load('app/templates/home.html');
	$('body').attr('style',`
		background-image : url("/app/images/travel.jpg");
		background-size: 100% 120%;
	`);	

	addHandlers();
}


function addHandlers() {
	$(document).on('click', '#infoImage', function(e) {
		openFancyBox();
	})
}

function openFancyBox() {
	let content = `
		<div class="tophometour">
            <div class="titleimghometour">
	            <p class="titlehometour">YUCATAN - MEXICO</p>
	            <img alt="" class="imghometour" src="img/tours/tour2.jpg">
	        </div>
	        <div class="datedescriptionhometour">
	            <div class="datedayhometour">
	                <p class="datehometour">
	                    JANUARY - 3 to 17
	                </p>
	                <div class="dayhometour">
	                    <p>15</p>
	                    <span>DAYS</span>
	                </div>
	            </div>
	            <div class="descriptionhometour" style="overflow: hidden; height: 141px;" tabindex="5001">
	                <p><strong class="titledescriptionhometour">Title description</strong><br>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla rhoncus ultrices purus, volutpat malesuada sapien sollicitudin vitae.</p>
	            </div>	
	        </div>	
        </div>
	`
	$(document).on('click', '#trip-open').fancybox({
	  content : 'sdsds',
	  closeBtn: true,
			closeClick: false,
			height: 400,
			width: 400,
			autoSize: false,
	  helpers: {
	      overlay: {
	          closeClick: false
	      }
	  },
	  keys: {
	      close: null
	  }
	}).trigger('click');
	$.fancybox.open();

	$('#trip-out').click(function () {
	    $.fancybox.close();
	});
}