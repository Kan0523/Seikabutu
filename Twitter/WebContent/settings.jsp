<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${loginUser.account }の設定</title>
<link href="css/style.css" rel="stylesheet" type ="text/css">
</head>
<body>
<div class ="main-contents">
<h1>Setting</h1>

<c:if test="${not empty errorMessages }">
	<div class="errorMessages">
	<ul>
	  <c:forEach items = "${errorMessages }" var ="message">
	     <li><c:out value="${message }" />
	  </c:forEach>
   </ul>
</div>
	  <c:remove var = "errorMessages" scope="session" />
</c:if>

<form action ="settings" method ="post" enctype ="multipart/form-date"><br />
	<label for ="name">名前</label>
	<input name ="name" value="${editUser.name }" id ="name" />(名前はあなたの公開プロフィールに表示されます)<br />

	<label for = "account">アカウント名</label>
	<input name = "account" value="${editUser.account }"  />(あなたの公開プローフィール：http//localhost:8080/?account=アカウント名)<br />

	<label for="password">パスワード</label>
	<input name = "password" type ="password" id ="password" /> <br />

	<label for="eamil">メールアドレス</label>
	<input name="email" value ="${eitUser.email }" id ="email"/> <br />

	 <label for ="icon">アイコン</label> <br />
	 <input type ="submit" value ="登録" /> <br />
	 <a href="./">戻る</a>
</form>
<div class ="copyright">Copyright(c)Mikio Kan</div>
</div>
</body>
</html>