

	var imagesList = ['Desert', 'Iceland', 'LightHouse','Tropical','MachuPicchu', 'Mountains', 'Castle'];
	var currentListIndex = 0;


	function init() {
		$('#app').empty().load('templates/home.html');
		$('body').attr('style',`
			background-image : url("/images/travel.jpg");
			background-size: 100% 120%;
		`);	

		addHandlers();
	}


	function addHandlers() {
		$(document).on('click', '#infoImage', function(e) {
			loadImageDetails();
		})

		$(document).on('click', '.arrow-left', function(e) {
			if (currentListIndex > 0) {
				currentListIndex--;
			}
			changeImage(imagesList[currentListIndex]);
		});

		$(document).on('click', '.arrow-right', function(e) {
			if (currentListIndex < imagesList.length - 1) {
				currentListIndex++;
			}
			changeImage(imagesList[currentListIndex]);
		});

	}

	function changeImage(image) {
		$('#welcomeImage').attr('src', '/images/' + image + '.jpg')
	}

	function loadBodyImage() {
	$('body').attr('style',`
			background-image : url("/images/travel.jpg");
			background-size: 100% 120%;
		`);	
	}

	function loadImageDetails() {
		var formURL = "./json/placesToVisitDetails.json";
			$.ajax({
			     url: formURL,
			     type: 'GET',
			     data:  null,
			     mimeType:"multipart/form-data",
			     contentType: false,
			     cache: false,
			     processData:false,
			     success: function(obj)
			     {
			     	openFancyBox(JSON.parse(obj));
			     },
			     error: function(obj)
			     {
			       console.log("No funciono")
			     }
			});
	}

	function openFancyBox(ajaxData) {

		let strLocationName = imagesList[currentListIndex];
		let content = `
		<div class="landscape">
			<div class="row">
				  <div class="col-xs-6 col-md-6">
						<img src="/images/` + strLocationName + `.jpg" style="width: 107%;margin-right: 45%;">
				</div>	
						<div class="col-xs-6 col-md-6" >
							<div class="form-style-3">
								<form>
									<fieldset>
										<legend>` + ajaxData[strLocationName].title + `</legend>
										<div class="row ">
											<span class="required">Nombre</span> ` + ajaxData[strLocationName].name + `
										</div>
										<div class="row ">
											<span class="required">Descripcion</span> ` + ajaxData[strLocationName].description + `
										</div>
										<div class="row ">
											<span class="required">Disponibilidad</span>` + ajaxData[strLocationName].availability + `
										</div>
									</fieldset>
								</form>
							</div>
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


	