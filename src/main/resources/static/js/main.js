$(document).ready(function(){
	var obj=['id','username','email','password'];
	$('.sel-update').change(function(){
		for(o in obj)$('input[name="'+obj[o]+'"].update').val($(this).find(':selected').data(obj[o]));
	});
});