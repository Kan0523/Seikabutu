<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored = "false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css ファイルのパス" rel="stylesheet" type="text/css">
<title>Twitter</title>
</head>
<body>
<div class="main-contents">

<div class = "header">
   <c:if test ="${empty loginUser }">
	<a href ="login">ログイン</a>
	<a href ="signup">登録する</a>
   </c:if>
   <c:if test="${not empty loginUser }">
   <a href ="./">ホーム</a>
   <a href ="settings">設定</a>
   <a href ="logout">ロックアウト</a>
   </c:if>
</div>

<c:if test="${not empty loginUser }">
<div class ="profile">
		<div class ="name"><h2><c; out value="${loginUser.name }" /></h2>
</div>
		<div class ="account">
			<c;out value = "${loginUser.account }" />
</div>
		<div class = "account">
			<c:out value=  "${loginUser.description} " />
	   </div>


	   <div class = "form-area">
	   		<c:if test "${isShowMessageForm}">
	   			<form action = "newMessage" method = "post">
	   					いま、どうしてる？<br />
	   					<textarea name = "message" cols = "100" rows = "5" class "tweet-box">
	   					</textarea>
	   					<br />
	   					<input type ="submit" value ="つぶやく"">(140文字まで)
	   					</form>
	   				</c:if>
	   			</div>
</div>
</c:if>

<div class = "messages">
	<c:forEach items="${messages }" var="message">
		<div class ="message-icon">
			<div class ="icon"><img src ="./icon?user_id = ${message.userId }" width = "50" height ="50" />
				<div class = "message">
					<div class ="account-name">
						<span class = "account"><c:out value="${message.account }" /></span>
						</div>
						<div class = "text"><c:out value="${message.text }" /></div>
						<div class ="date"><fmt:formatDate value="${message.insertDate }" pattern="YYYY/MM/dd HH:mm:ss" /></div>
					</div>
				</div>
			</c:forEach>
		</div>
<div class ="copyright">Copyright(c)MIKIO KAN</div>

</div>

</body>
</html>