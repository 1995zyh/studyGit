<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>删除记录成功</title>
<script type="text/javascript">
function closewindow(){
	window.returnValue = true;
	window.close();
}

function clock(){
	i=i-1;
	if(document.getElementById("info")){
		document.getElementById("info").innerHTML="本窗口将在"+i+"秒后自动关闭!";
	}
	if(i>0)
		setTimeout("clock();",1000);
	else 
		closewindow();
}
	var i=4;
	clock();
</script>
</head>
<body>
<center>
	删除成功！ <p>
	<div id="info">本窗口将在3秒后自动关闭!</div>
	<input type="button" value="关闭窗口" onclick="closewindow();">
</center>

</body>
</html>