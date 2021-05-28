function setTime1() {

	checkAndMove(1);

	var t = document.getElementById("t1").innerHTML;

	document.getElementById("setT").innerHTML = t;
}

function setTime2() {

	checkAndMove(1);

	var t = document.getElementById("t2").innerHTML;

	document.getElementById("setT").innerHTML = t;
}

function setTime3() {

	checkAndMove(1);

	var t = document.getElementById("t3").innerHTML;

	document.getElementById("setT").innerHTML = t;
}

function setTime4() {

	checkAndMove(1);

	var t = document.getElementById("t4").innerHTML;

	document.getElementById("setT").innerHTML = t;
}

function setTime5() {

	checkAndMove(1);

	var t = document.getElementById("t5").innerHTML;

	document.getElementById("setT").innerHTML = t;
}

function setTime6() {

	checkAndMove(1);

	var t = document.getElementById("t6").innerHTML;

	document.getElementById("setT").innerHTML = t;
}

function setTime7() {

	checkAndMove(1);

	var t = document.getElementById("t7").innerHTML;

	document.getElementById("setT").innerHTML = t;
}

function setTime8() {

	checkAndMove(1);

	var t = document.getElementById("t8").innerHTML;

	document.getElementById("setT").innerHTML = t;
}

function setTime9() {

	checkAndMove(1);

	var t = document.getElementById("t9").innerHTML;

	document.getElementById("setT").innerHTML = t;
}

function setTime10() {

	checkAndMove(1);

	var t = document.getElementById("t10").innerHTML;

	document.getElementById("setT").innerHTML = t;
}

// 페이지 이동
function checkAndMove(value) {

	var container = document.getElementById("bt2");

	if (value == 1) {
	
		console.log(value);
	
		container.disabled = false;
		
		value = 0;
		
	} else if (value == 0) {
	    var reserveMenu = document.getElementsByClassName("maketable")[0];
	    
	    var data1 = [];
	    
	    var check = 0;
	    var check1 = 1;
	    for(var i = 0; i < document.getElementsByClassName("maketable")[0].childNodes.length/2; i++){
	    	var menuCode = document.getElementsByClassName("maketable")[0].childNodes[check1].children[4].innerText;
	    	var menuName = document.getElementsByClassName("maketable")[0].childNodes[check].children[0].innerText;
	    	var amount = document.getElementsByClassName("maketable")[0].childNodes[check1].children[3].innerText;
	    	var price = document.getElementsByClassName("maketable")[0].childNodes[check1].children[1].innerText;
	    	var storeCode = document.getElementsByClassName("storeId")[0].innerText;
	    	var reServeTime = document.getElementById("setT").innerText;
	    	
	    	var total = {
	    		menuCode : menuCode,
	    		menuName : menuName,
	    		amount : amount,
	    		price : price,
	    		storeCode : storeCode,
	    		reServeTime : reServeTime,
	    	}
	    	
	    	check+=2;
	    	check1+=2;
	    	
	    	data1.push(total);
	    }
	    
	    
	    const jsonString = JSON.stringify(data1);
	    const root = '/BoB';
	    $.ajax({
	    	url:"/BoB/order/pay",
	    	type:"post",
	    	data: {jsonString},
	    	success:function(data,statusText, xhr){
	    		console.log(data);
	    		var code = data.split(',')[1];
	    		location.href = root+'/order/select?code='+code;
	    	},
	    	error:function(xhr,status,error){
	    		console.log(error);
	    		location.href = root +"/WEB-INF/views/common/customer/failed.jsp";
	    		
	    	}
	    });
		
	}
	
}