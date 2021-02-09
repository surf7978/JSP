<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="frm" name="frm"  action="../FileUpload" method="post" enctype="multipart/form-data">
		파일 : <input type="file"  name="imagesrc" name="file"><br>
		<input type="hidden" value="3.jpg">
		<input type="submit" value="업로드"><br>
	</form>
</body>
</html>