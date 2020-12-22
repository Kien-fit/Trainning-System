/* Các sử lý kịch bản cho section.html*/

function checkName(fn){
	//Lấy tên
	var name = document.getElementById("inputName").value;
	// Lưu thông báo
	var message = "";
	
	//kiểm tra
	name = name.trim();
	if(name == ""){
		message = "Thiếu tên bài viết.";
	}else{
		
	}
	
	// Tham chiếu đối tượng hiển thị lỗi
	var view = document.getElementById("viewValidName");
	if(message !=""){
		view.innerHTML = message;
		view.style.color = "red";
		return false;
	}else{
		view.innerHTML = "";
		return true;
	}
}

//Kiem tra toan the
function checkValidArticle(fn){
	
	var validName = checkName(fn);
	if(!validName){
		document.getElementById("inputName").focus();
		document.getElementById("inputName").select();
	}else{
	}
	
	return validName;
}

function saveArticle(fn){
	if(this.checkValidArticle(fn)){
		fn.method = "POST";
		fn.action = "/adv/article/ae";
		fn.submit();
	}
}




