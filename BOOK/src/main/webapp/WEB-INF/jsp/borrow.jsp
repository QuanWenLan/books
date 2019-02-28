<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅</title>
</head>
<body>
	<form action="doBorrow" method="get" name="borrow">
		<table class="form-table">
			<tr>
				<th width="20%">用户名：</th>
				<td width="35%"><input type="hidden" name="userId"
					value="${user.userId }"> <input type="text"
					class="input-text" readonly="readonly" name="username"
					value="${user.xm }" /></td>
				<th width="20%">部门：</th>
				<td><input type="text" class="input-text" readonly="readonly"
					name="bm" value="${user.bm }" /></td>
			</tr>
			<tr>
				<th width="20%">手机号：</th>
				<td width="35%"><input type="text" class="input-text"
					name="lxfs" value="${user.lxfs }" readonly="readonly" /></td>
				<th width="20%">邮箱：</th>
				<td><input type="text" class="input-text" name="email"
					value="${user.email }" readonly="readonly" /></td>
			</tr>
			<tr><th width="20%">图书编号：</th>
				<td width="35%">
				 <input type="text" class="input-text"
					readonly="readonly" name="isbn" value="${book.tStore.id }" /></td>
				<th width="20%">isbn：</th>
				<td width="35%">
				 <input type="text" class="input-text"
					readonly="readonly" name="isbn" value="${book.isbn }" /></td>
				
			</tr>
			<tr>
			<th width="20%">书名：</th>
				<td><input type="text" class="input-text" readonly="readonly"
					value="${book.sm }" name="sm" /></td>
				<th width="20%">图书类型：</th>
				<td width="35%"><input type="text" class="input-text"
					value="${book.tType.lxmc }" readonly="readonly" name="lxmc" /></td>
				
			</tr>
			<tr>
			<th width="20%">状态：</th>
				<td><input type="hidden" class="input-text" readonly="readonly"
					value="${book.tStore.status }" name="status" /> <input type="text"
					class="input-text" readonly="readonly" value="${book.tStore.status }"
					name="status" /></td>
				<th width="20%">出版社：</th>
				<td width="35%"><input type="text" class="input-text"
					value="${book.cbsmc }" readonly="readonly"
					name="pub_name" /></td>
				
			</tr>
			<tr>
				<%
					Date d = new Date();
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String now = df.format(d);
				%>
				<th width="20%">出版日期：</th>
				<td><input type="text" class="input-text" readonly="readonly"
					value="${book.cbrq }" name="cbrq" /></td>
				<th width="20%">借阅日期：</th>
				<td width="35%"><input type="text" class="input-text"
					readonly="readonly" value="<%=now%>" name="jyrq" /></td>
				
			</tr>
			<tr>
			<th width="20%">借阅周期：</th>
				<td><select class="select" name="jhghrq">
						<option value="7">一周</option>
						<option value="15">半个月</option>
						<option value="30">一个月</option>
				</select></td>
				
			</tr>
			<tr>
			
				<th width="20%"><input type="submit" value="提交"></th>
			</tr>
		</table>
	</form>
</body>
</html>