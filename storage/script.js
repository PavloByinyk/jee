$(document).ready(function(){
	
		//$('body').append('<a href="http://google.com"> Go to google!</a>');
		
		$("#countBtn").click(function(){
			alert('you clicked');
		});
		
		$('#countBtn2').click(function(){
			var text = $('#idP').html();
			alert(text);
			$('#idP').html("new text");
		});
		
		
		//comments functions
		$(document).on("click", "#add_comment", function(){
			var form = $("form[name='form']");
			form.css("display", "block");
			$("#add_comment").replaceWith(form);
		});
		
		$(document).on("click", "input[name='send']", function(){
			var comment = $("#text_area").val();
			$("<p>" + comment + "</p>").appendTo("#comments")
			//$(".comment").value(comment);
			
		});
		
		$("#hide").bind("click", hideComments);
		$("#show").bind("click", showComments);
		
		function hideComments(){
			//alert("123");
			//$("#comments").css("display", "none");
			$("#comments").slideUp(1000, function(){
				$("#hide").hide();
				$("#show").show();
			});
			//var showField = $("#show");
			//showField.css("display", "block");
			//$("#hide").replaceWith( showField );
		};
		
		function showComments(){
			//alert("123");
			//$("#comments").css("display", "block");
			$("#hide").show();
			$("#show").hide();
			$("#comments").show(1000);
			//var hideField = $("#hide");
			//hideField.css("display", "block");
			//$("#show").replaceWith( hideField );
		};
		
});