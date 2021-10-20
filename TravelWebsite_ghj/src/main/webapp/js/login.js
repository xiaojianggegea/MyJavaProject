/**
 * 账号验证
 */

function checkUser() {
	var username = document.getElementById("username3").value;
	var img = document.getElementById("tishi_user");
	if (username.trim().length == 0) {
		img.src = "images/cuowu.png";
		alert("账号不能为空！");
		return false;
	} else if (username.length < 2 || username.length > 6) {
		img.src = "images/cuowu.png";
		alert("账号只能是2~6位！");
		return false;
	} else {
		img.src = "images/icon-test.png";
		return true;
	}
}
/**
 * 密码验证
 */
function checkPwd() {
	var password = document.getElementById("password3").value;
	var img = document.getElementById("tishi_pwd");
	if (password.trim().length == 0) {
		img.src = "images/cuowu.png";
		alert("密码不能为空！");
		return false;
	}else if(password.length < 3 || password.length > 12){
		img.src = "images/cuowu.png";
		alert("密码只能是3~12位！");
	} else {
		img.src = "images/icon-test.png";
		return true;
	}
}

function checkAll() {
	if (checkUser() == true && checkPwd() == true) {
		return true;
	}
	return false;
}
