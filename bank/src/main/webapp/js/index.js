$('#loginForm').form({    
    url:"login/do",    
    onSubmit: function(){    
    },    
    success:function(data){    
        alert(JSON.stringify(data))    
    }    
},"json");    
function a(){
	alert($('.username'));
	$.post("login/do",$("#addFavForm").serialize(), function(data){
		alert(data);
	},"json");
	
}
alert("11");