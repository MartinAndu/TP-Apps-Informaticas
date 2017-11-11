function MotorRecomendaciones(){
	this.obtenerRecomendacionPredictiva(user) = function(){
		//Algoritmo de prediccion
	}
		this.pedirRecomendacion(fbToken) =  function(){
		//Llamada a Api de facebook
	}
}

//Es un singleton
var Recomendador = function (){
	this.motor = new MotorRecomendaciones()
	this.obtenerRecomendacionPredictiva(user) = this.motor.obtenerRecomendacionPredictiva(user);
	this.pedirRecomendacion(fbToken) = this.motor.pedirRecomendacion(fbToken);
}
