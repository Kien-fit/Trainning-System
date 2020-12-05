// Xử lý cho login

function checkValidLogin(fn) {
	//lấy thông tin đăng nhập
	var name = fn.txtUsername.value;
	var pass = fn.txtPassword.value;
	
	//giá trị trả về
	var valueUsername = true;
	var valuePassword = true;
	
	//thông báo
	var message= "";
	
	//
	name=name.trim();
	if(name==""){
		valueUsername = false;
		message = "Thiếu tên đăng nhập.";
		
	}else {
		if(name.length < 4||name.length > 30){
			valueUsername = false;
			message = "Tên đăng nhập có độ dài từ 4 đến 30 ký tự.";
		}else{
			
			if(name.indexOf(" ")!=-1){
				valueUsername = false;
				message = "Tên đăng nhập không được có dấu cách, hãy nhập lại.";
			}else{
				//kiểm tra hộp thư
				if(name.indexOf("@")!=-1){
					var parttern = /\w+@\w+[.]+\w/;
					if(!name.match(parttern)){
						valueUsername = false;
						message = "Không đúng cấu trúc hộp thư!";
					}
				}
			}
		}
	}
	
	pass = pass.trim();
	if(pass==""){
		valuePassword = false;
		message += "\nThiếu mật khẩu.";
	}else {
		if(pass.length<6){
			valuePassword = false;
			message += "\nMật khẩu không hợp lệ.";
		}else{
			
		}
	}
	
	// Lưu tài khoản
	var isSave = fn.chkSave.checked;
	if(isSave){
		message += "\nBạn có thật sự muốn lưu tài khoản trên máy này."
	}
	
	//thông báo
	if(message != ""){
		window.alert(message);
		//di chuyển con trỏ vào
		if(!valueUsername){
			fn.txtUsername.focus;
			fn.txtUsername.select;
		}
		if(!valuePassword){
			fn.txtPassword.focus;
			fn.txtPassword.select;
		}
	}
	
	//Trả về kết quả
	return valueUsername && valuePassword;
	
}

function login(fn){
	if(this.checkValidLogin(fn)){
		fn.method = "POST";//Gọi  vào phương thức doPost
		fn.action = "/adv/user/login";//đường dẫn thực thi của servlet
		fn.submit();
	}
}


