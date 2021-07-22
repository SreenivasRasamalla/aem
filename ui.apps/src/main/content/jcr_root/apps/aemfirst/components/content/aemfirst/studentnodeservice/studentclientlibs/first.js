 $(document).ready(function(){
	alert('Student node Jquery is called');
	$("#submit").click(function(){
		alert('onClick called');

		$.ajax({
			type: 'GET',

			url:'/bin/studentnodeservlet',

			 success: function(result){
				alert(result);	
       
				},
			error: function(err){
				alert("Unable to retrieve data"+err);
			}
		}); 
	});
});

