/* Các sử lý kịch bản cho section.html*/

function checkName(fn){
	//Lấy tên
	var name = document.getElementById("inputName").value;
	// Lưu thông báo
	var message = "";	
	//kiểm tra
	name = name.trim();
	if(name == ""){
		message = "Thiếu tên chuyên mục.";
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

function checkNameEn(fn){
	var nameEn = fn.txtNameEn.value;
	var message = "";
	//kiểm tra
	nameEn = nameEn.trim();
	if(nameEn == ""){
		message = "Thiếu tên chuyên mục (Tiếng Anh).";
	}
	// Tham chiếu đối tượng hiển thị lỗi
	var view = document.getElementById("viewValidNameEn");
	if(message !=""){
		view.innerHTML = message;
		view.style.color = "red";
		return false;
	}else{
		view.innerHTML = "";
		return true;
	}
}

function checkManager(fn){
	var manager = parseInt(fn.slcManager.value);
	var message = "";
	//kiểm tra
	if(manager == 0){
		message = "Thiếu người quản lý.";
	}
	// Tham chiếu đối tượng hiển thị lỗi
	var view = document.getElementById("viewValidSlcManager");
	if(message !=""){
		view.innerHTML = message;
		view.style.color = "red";
		return false;
	}else{
		view.innerHTML = "";
		return true;
	}
}

function checkNotes(fn){
	var notes = fn.txtNotes.value;
	var message = "";
	//kiểm tra
	notes = notes.trim();
	if(notes == ""){
		message = "Thiếu ghi chú.";
	}
	// Tham chiếu đối tượng hiển thị lỗi
	var view = document.getElementById("viewValidNotes");
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
function checkValidSection(fn){
	
	var validName = checkName(fn);
	var validNameEn = checkNameEn(fn);
	var validManager = checkManager(fn);
	var validNotes = checkNotes(fn);
	if(!validName){
		document.getElementById("inputName").focus();
		document.getElementById("inputName").select();
	}else if(!validNameEn){
		fn.txtNameEn.focus();
		fn.txtNameEn.select();
	}else if(!validManager){
		fn.slcManager.focus();
		fn.slcManager.select();
	}else if(!validNotes){
		fn.txtNotes.focus();
		fn.txtNotes.select();
	}
	
	return validName && validNameEn && validManager && validNotes;
}

function saveSection(fn){
	if(this.checkValidSection(fn)){
		fn.method = "POST";
		fn.action = "/adv/section/ae";
		fn.submit();
	}
}




