/* các sử lý kịch bản chp provider.html*/

function checkValidProvider(fn){
	//Lấy thông tin 
	var  name = document.getElementById("inputName").value;
	var check = document.getElementById("chkAgree").checked;
	
	// nút bấm
	var reg = document.getElementById("btnRegister");
	
	if(name.trim()!="" && check){
		reg.disabled = false;
	}else{
		reg.disabled = true;
	}
	
	
	
	
}






