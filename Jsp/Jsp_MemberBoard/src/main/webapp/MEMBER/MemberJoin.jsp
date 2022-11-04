<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/CSS/Main.css">

<style type="text/css">
table>caption {
	font-weight: bold;
}

th, td {
	padding: 8px;
}

input[type=text], input[type=date] {
	width: 220px;
	font-size: 18px;
	border: 0px;
	border-bottom: 3px solid gray;
}

input[type=text]:focus {
	outline: none;
}

div.contents>form>table {
	margin-left: auto;
	margin-right: auto;
	width: 680;
}

input[type=submit] {
	font-size: 15px;
	padding: 10px;
	background-color: white;
	border-color: gray;
	font-weight: bold;
}

input[type=submit]:hover {
	cursor: pointer;
	background-color: gray;
	color: white;
}
</style>
</head>

<body>

	<div class="header">
		<h1>MemberJoin.jsp</h1>
	</div>

	<%@ include file="/Menu.jsp"%>

	<div class="contents">

		<h3 style="text-align: center;">회원가입</h3>
		<form action="${pageContext.request.contextPath}/memberJoin"
			method="post" onsubmit="return joinFormCheck(this)">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid">
						<p style="margin-top: 2px; margin-bottom: 0px; font-size: 8px;"></p>
					</td>

					<td><button type="button">중복확인</button></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="mpw"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="mbirth"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="maddr"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="emailId" placeholder="이메일 아이디"></td>
					<td>@ &nbsp; <input type="text" name="emailDomain"
						id="eDomain" placeholder="이메일 도메인"> <select
						onchange="selectDomain(this.value)">
							<option value="">직접입력</option>
							<option value="gmail.com">구글</option>
							<option value="naver.com">네이버</option>
							<option value="daum.com">다음</option>
					</select>
					</td>
				</tr>
				<tr>
					<th colspan="3"><input type="submit" value="회원가입"></th>
				</tr>
			</table>
		</form>
	</div>

	<div class="footer">
		<h2>회원게시판</h2>
	</div>


	<script type="text/javascript">
		function joinFormCheck(formObj) {
			var mid = formObj.mid;
			if (mid.value.length == 0) {
				alert('아이디를 입력해주세요!');
				mid.focus();
				return false;
			}

			var mpw = formObj.mpw;
			if (mpw.value.length == 0) {
				alert('비밀번호를 입력해주세요!');
				mpw.focus();
				return false;
			}

			var mname = formObj.mname;
			if (mname.value.length == 0) {
				alert('이름을 입력해주세요!');
				mname.focus();
				return false;
			}

			var mbirth = formObj.mbirth;
			if (mbirth.value.length == 0) {
				alert('생년월일을 입력해주세요!');
				mbirth.focus();
				return false;
			}

			var maddr = formObj.maddr;
			if (maddr.value.length == 0) {
				alert('주소를 입력해주세요!');
				maddr.focus();
				return false;
			}

			var emailId = formObj.emailId;
			if (emailId.value.length == 0) {
				alert('이메일을 입력해주세요!');
				emailId.focus();
				return false;
			}

			var emailDomain = formObj.emailDomain;
			if (emailDomain.value.length == 0) {
				alert('도메인을 입력해주세요!');
				emailDomain.focus();
				return false;
			}
		}

		function selectDomain(selectVal) {
			document.getElementById('eDomain').value = selectVal;
		}
	</script>
</body>

</html>