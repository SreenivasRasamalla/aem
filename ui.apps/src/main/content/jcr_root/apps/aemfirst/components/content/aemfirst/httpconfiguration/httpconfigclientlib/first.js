 $(document).ready(function(){
	alert('http config node Jquery is called');
	$("#submit").click(function(){
		alert('onClick called');

		$.ajax({
			type: 'GET',

			url:'/bin/demo/httpcall',

			 success: function(result){
				alert(result);	
       
				},
			error: function(err){
				alert("Unable to retrieve data"+err);
			}
		}); 
	});
});

