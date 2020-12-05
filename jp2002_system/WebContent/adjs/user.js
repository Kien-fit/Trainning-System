/* Các sử lý kịch bản cho user.html*/

function checkName(fn){
	//Lấy tên
	var name = document.getElementById("inputName").value;
	document.getElementById("inputEmail").dissabled = false;
	// Lưu thông báo
	var message = "";
	
	//kiểm tra
	name = name.trim();
	if(name == ""){
		message = "Thiếu tài khoản.";
	}else{
		if(name.length <6||name.length>50){
			message = "Tên tài khoản có độ dài từ 6 đến 50 ký tự.";
		}else{
			if(name.indexOf(" ")!=-1){
				message = "Tên tài khoản không được có dấu cách, hãy nhập lại.";
			}else{
				//kiểm tra hộp thư
				if(name.indexOf("@")!=-1){
					var parttern = /\w+@\w+[.]+\w/;
					if(!name.match(parttern)){
						message = "Không đúng cấu trúc hộp thư!";
					}else{
						document.getElementById("inputEmail").dissabled = true;
					}
				}
			}
		}
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

function checkPass(fn){
	//Lấy giá trị
	var pass1 = document.getElementById("inputPass1").value;
	var pass2 = document.getElementById("inputPass2").value;
	
	var isOke = false;
	
	//
	message ="";
	
	//
	pass1 = pass1.trim();
	if(pass1==""){
		message += "\nThiếu mật khẩu.";
	}else {
		if(pass1.length>=8){
			if(pass2 != pass1){
				message ="mật khẩu không khơp.";
			}else{
				message ="<i class=\"fas fa-check\"></i>";
				isOke = true;
			}
		} else{
			message ="mất khẩu cần lớn hơn 8 ký tự.";
		}
	}
	
	
	// Tham chiếu đối tượng hiển thị lỗi
	var view2 = document.getElementById("viewValidPass2");
	view2.innerHTML = message;
	if(!isOke){
		view2.style.color = "red";
		return false;
	}else{
		view2.style.color = "blue";
		return true;
	}
	
}

function generatePermis(fn){
	//khai bái danh sách quyên thực thi
	var permis = new Array();
	permis[0]="---Select---";
	permis[1]="Members (Thành viên)";
	permis[2]="Authods (tác giả)";
	permis[3]="Managers (Quản lý)";
	permis[4]="Administrators (Quản trị)";
	permis[5]="Supper Admin (Quản trị cao cấp)";
	
	var opt = "";
	
	opt += "<select class=\"form-control\" id=\"inputPermis\" name=\"slcPermis\" onchange=\"refreshPermis(this.form)\">";
	for(var i=0; i<permis.length; i++){
		opt += "<option value=\""+i+"\">"+permis[i]+"</option>";
	}
	opt += "</select>";
	
	// In ra màn hình
	document.write(opt);
}

function generateRole(fn){
	var roles = new Array();
	roles[0] = "<i class=\"fas fa-user\"/></i> User managerments";
	roles[1] = "<i class=\"fas fa-user\"/></i> Section managerments";
	roles[2] = "<i class=\"fas fa-user\"/></i> Category managerments";
	roles[3] = "<i class=\"fas fa-user\"/></i> Article managerments";
	roles[4] = "<i class=\"fas fa-user\"/></i> Produck  managerments";
	roles[5] = "<i class=\"fas fa-user\"/></i> Category managerment";
	roles[6] = "<i class=\"fas fa-user\"/></i> User managerment";
	roles[7] = "<i class=\"fas fa-user\"/></i> Section managerment";
	roles[8] = "<i class=\"fas fa-user\"/></i> Category managerment";
	roles[9] = "<i class=\"fas fa-user\"/></i> User managerment";
	
	var role ="";
	
	role += "<div class=\"role role1\">";
	
	for(var i=0; i<roles.length; i++){
		if(i%3==0){
			role += "<div class=\"row row1\">";
		}
		
		role += "<div class=\"col-md-4\">";
		role += "<input class=\"form-check-input\" type=\"checkbox\" id=\"chk"+i+"\" disabled name=\"chkCheck\" onclick=\"checkPermis(this.form)\">";
		role += "<label class=\"form-check-label\" for=\"chk"+i+"\">";
		role += roles[i];
		role += "</label>";
		role += "</div>";
			
		if(i%3==2 || i==roles.length-1){
			role += "</div>";
		}
	}
	
	role += "</div>";
	
	document.write(role);
}

function setCheckBox(fn, dis, check){
	//Duyệt các phần tử của form
	for(var i=0; i<fn.elements.length; i++){
		if(fn.elements[i].type == "checkbox" && fn.elements[i].name == "chkCheck"){
			fn.elements[i].disabled = dis;
			fn.elements[i].checked = check;
		}
	}	
}

function refreshPermis(fn){
	//Lấy giá trị quyền thực thi
	var permis = parseInt(document.getElementById("inputPermis").value);
	
	if(permis==4||permis==5){
		this.setCheckBox(fn, true, true);
	}else{
		if(permis==3){
			this.setCheckBox(fn, false, true);
		}else{
			if(permis==2){
				this.setCheckBox(fn, false, false);
			}else{
				this.setCheckBox(fn, true, false);
			}
		}
	}
	checkPermis(fn);
}

//Kiểm tra check permis 
function checkPermis(fn){
	//Kiểm tra quyền thực thi
	var permis = parseInt(document.getElementById("inputPermis").value);
	var validPermis = false;
	if(permis==2||permis==3){
		for(var i=0; i<fn.elements.length; i++){
			if(fn.elements[i].type == "checkbox" && fn.elements[i].name == "chkCheck"){
				if(fn.elements[i].checked){
					validPermis = true;
					break;
				}else{
					validPermis = false;
				}
			}	
		}
	}
	
	var message = "";
	var view = document.getElementById("validPermis");
	if(!validPermis){
		message = "Can chon it nhat 1 o";
		view.innerHTML = message;
		view.style.color = "red";
	}else{
		view.innerHTML = "";
	}
	
	
	return validPermis;
}

//Kiem tra toan the
function checkValidUser(fn){
	
	var validName = checkName(fn);
	var validPass = checkPass(fn); 
	var validPermis = checkPermis(fn);
	if(!validName){
		document.getElementById("inputName").focus();
		document.getElementById("inputName").select();
	}else{
		if(!validPass){
			document.getElementById("inputPass1").focus();
			document.getElementById("inputPass1").select();
		}else{
			if(!validPermis){
				document.getElementById("inputPermis").focus();
				document.getElementById("inputPermis").select();
			}
		}
	}
	
	return validName && validPass & validPermis;
}

function saveUser(fn){
	if(this.checkValidUser(fn)){
		fn.method = "POST";
		fn.action = "/adv/user/ae";
		fn.submit();
	}
}




