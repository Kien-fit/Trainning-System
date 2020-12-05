
var x="---Từ khóa---";
var y="";

function setFirstTime() {
	// window.document.frmSearch.txtKeyword.value=x;
	document.frmSearch.txtKeyword.value = x;
}

function setFirstTime(fn) {
	fn.txtKeyword.value = x;
}

function setKeyword(fn, isClick) {
	var val=fn.txtKeyword.value;
	
	if(isClick){
		if(val.trim()==x){
			fn.txtKeyword.value = y;
		}
	} else {
		if(val.trim()==y){
			fn.txtKeyword.value = x;
		}
	}
	
}

function checkValueKeyword(){
	var a = fn.txtKeyword.value ;
	
	var messager="hãy nhập từ khóa!";
	
	if(a==""){
		window.alert(messager);
		fn.txtKeyword.focus;
		fn.txtKeyword.select;
	} else {
		return true;
	}
}

// Form2
function setSecondsTime(){
	// Lấy về giá trị
	var email = window.document.forms[1].txtEmail.value;
	var pass = document.forms[1].txtPass.value;
	var add1 = document.forms[1].txtAddress01.value;
	var add2 = document.forms[1].txtAddress02.value;
	var city = document.forms[1].txtCity.value;
	var state = document.forms[1].txtState.value;
	var zip = document.forms[1].txtZip.value;
	
}

function setSecondsTime(fn){
	// Lấy về giá trị
	var email = fn.txtEmail.value;
	var pass = fn.txtPassword.value;
	var add1 = fn.txtAddress01.value;
	var add2 = fn.txtAddress02.value;
	var city = fn.txtCity.value;
	var state = fn.txtState.value;
	var zip = fn.txtZip.value;
	
	
	// Giá trị trả về
	var valueEmail = true;
	var valuePassword = true;
	var valueAddress01 = true;
	var valueAddress02 = true;
	var valueCity = true;
	var valueState = true;
	var valueZip = true;
	
	// Thông báo
	var message = "";
	
	email = email.trim();
	if(email==""){
		valueEmail = false;
		message = "Thiếu email.";	
	}else {
		if(email.length <6){
			valueEmail = false;
			message = "Tên email không hợp lệ.";
		}else{
			//kiểm tra hộp thư
			if(email.indexOf("@")!=-1){
				var parttern = /\w+@\w+[.]+\w/;
				if(!email.match(parttern)){
					valueEmail = false;
					message = "Không đúng cấu trúc hộp thư!";
				}
			}
		}
	}
	
	pass = pass.trim();
	if(pass==""){
		valuePassword = false;
		message += "\nThiếu mật khẩu.";	
	}else {
		if(pass.length <8){
			valuePassword = false;
			message += "\nTên mật khẩu không hợp lệ.";
		}else{
			
		}
	}
	
	add1 = add1.trim();
	if(add1==""){
		valueAddress01 = false;
		message += "\nThiếu địa chỉ.";	
	}else {
		
	}
	
	add2 = add2.trim();
	if(add2==""){
		valueAddress02= false;
		message += "\nThiếu địa chỉ.";	
	}else {
		
	}
	
	city = city.trim();
	if(city==""){
		valueCity = false;
		message = "\nThiếu thành phố.";	
	}else {
		
	}
	
	city = city.trim();
	if(city==""){
		valueZip = false;
		message = "\nThiếu mã xác nhận.";	
	}else {
		
	}
	
	// Đưa ra thông báo
	if(message !=""){
		window.alert(message);
		//di chuyển con trỏ vào
		if(!valueEmail){
			fn.txtEmail.focus;
			fn.txtEmail.select;
		}
		if(!valuePassword){
			fn.txtPassword.focus;
			fn.txtPassword.select;
		}
		if(!valueAddress01){
			fn.txtAddress01.focus;
			fn.txtAddress01.select;
		}
		if(!valueAddress02){
			fn.txtAddress02.focus;
			fn.txtAddress02.select;
		}
		if(!valueCity){
			fn.txtCity.focus;
			fn.txtCity.select;
		}
		if(!valueZip){
			fn.txtZip.focus;
			fn.txtZip.select;
		}
		
	}
	
	//Trả về kết quả
	return valueEmail && valuePassword && valueAddress01 && valueAddress02 && valueCity && valueState && valueZip;
	
	
}







