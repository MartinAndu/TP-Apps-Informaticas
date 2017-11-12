

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
		<div class="landscape">
			<div class="row">
				  <div class="col-xs-6 col-md-6">
						<img src="/app/images/desert.jpg" style="width: 107%;margin-right: 45%;">
				</div>	
						<div class="col-xs-6 col-md-6" >
							(Aca iria la descripción del lugar)
						</div>
						
			        </div>
			<button class="btn btn-primary bottom-space" style="">Reservar Lugar</button></div>
		</div>
		`;

		// Set custom style, close if clicked, change title type and overlay color
		$("#trip-open").fancybox({
		 	content :  content,
			wrapCSS    : 'fancybox-custom',
			closeClick : true,
			closeBtn : true,
			arrows : true,

			height : 250,
			width : 250,
			autoCenter : true,
			helpers : {
				title : {
					type : 'inside'
				},
				overlay : {
					css : {
						'background' : 'rgba(238,238,238,0.85)'
					}
				}
			}
		}).trigger('click').trigger('click');

}
