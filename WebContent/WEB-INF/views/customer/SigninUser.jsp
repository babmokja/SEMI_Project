<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/signin_user.css">
</head>
<body>
   
      <center>
        <jsp:include page="/WEB-INF/views/common/customer/header.jsp" />
      </center>

        <center>
        <div id= 'signin1' style="margin-top: 80px;">
          <label class="bigbtn" value="밥묵자 회원가입" >밥묵자회원가입	</label>
           <form name="form" id = "form" method="post" action="${ pageContext.servletContext.contextPath }/member/user/signin">
            <table style="margin-top: 70px;margin-left: 50px;" >
             <tr>
              <th><label id="font">아이디</label> </th>
               <td><input type="text" id="userId" name ="userId" size = "25"style="font-size:13px;border-radius: 10px; ">
                 <input type="button" id="overlap" style="display:none;">
                 <label for="overlap" id="checkId" >중복확인</label>
               </td>
             </tr>
           
             <tr>
              <th>비밀번호 </th>
               <td><input type="password" name="userPwd" id="pw" onchange="check_pw()"name="pw" class="chk" size="25" placeholder="영문소문자와숫자만입력하세요" style="padding:4px;font-size:13px;border-radius: 10px;"> </td>
             </tr>
          
             <tr> 
              <th>비밀번호확인 </th>
               <td><input type="password"  name="userPwd" id="pw2"  onchange="check_pw()" name ="pw_ck" class= "chk" size="25" style="padding:4px;font-size:13px;border-radius: 10px;">
                <span id="check" ></span>
               </td>
             </tr>
          
             <tr>
              <th>이 름</th>
                <td><input type="text" id="name"name ="userName" size="25" style="padding:4px;font-size:13px;border-radius: 10px;"> </td>
             </tr>
          
             <tr> 
              <th>주민번호</th>
                <td><input type="text" id="userNo" name ="userNo" size="25"
                       maxlength="13" placeholder="숫자만입력하세요" style="padding:4px;font-size:13px;border-radius: 10px;"></td>
             </tr>

             <tr> 
               <th>휴대전화</th>
                <td><input type="text" id= "userPhone"name="userPhone" size="25"
                       maxlength="13" placeholder="숫자만입력하세요" style="padding:4px;font-size:13px;border-radius: 10px;"></td>
             </tr>
         
             <tr>
               <th>우편번호</th>
                 <td><input type="text" name="zip" size="25" style="padding:4px;font-size:13px;border-radius: 10px;"> 
                 <button type="button"  style="width:60px; background-color: #ffcc00; border: 1px solid #d9e1e8; height:32px; border-radius: 20px; font-weight: 600; font-size: 15px; cursor: pointer;" id="searchZipCode">검색</button></td>
             </tr>
          
             <tr>
               <th>주소</th>
                <td><input type="text"size="25" name="addr1" style="padding:4px;font-size:13px;border-radius: 10px;" readonly /> </td>
             </tr> 
             <tr>
               <th>상세주소</th>
                 <td><input type="text"size="25" name="addr2" style="padding:4px;font-size:13px;border-radius: 10px;"/> </td>
             </tr>

             <tr>
              <th>이메일</th>
                <td><input type="text" id="mail" name="userEmail" size="25" style="padding:4px;font-size:13px;border-radius: 10px;"></td>   
             </tr>
 
         </table>
           <br>
           <br>
            
            <input type="submit" class="btn" value="제 출" style="margin-bottom: 50px;">
            
        </center>    
        </form>
        </div>

   
                 
        <footer>
            <div id="footlim">
                <small>
                    <br>㈜ 지금 배고프조<br><br>
                    서울특별시 강남구 강남동 000, 타워 5층 | 사업자 등록번호: 000-00-00000 [사업자정보확인]<br>
                    통신판매업 신고번호: 2021-서울강남-04026 | 개인정보 담당자 : babmokja@babmokja.co.kr | 제휴문의 :
                    babmokja@babmokja.co.kr | 고객 만족센터 : babmokja@babmokja.co.kr<br><br>

                    (유)지금 배고프조는 통신판매중개자이며 통신판매의 당사자가 아닙니다. <br> 따라서 상품/ 거래정보 및 거래와 관련하여 밥먹자에 등록된 판매자의 고의
                    또는 과실로 소비자에게 발생하는 손해에 대해 (유)지금 배고프조는 책임을 지지 않습니다.<br>
                    상품 및 거래에 관하여 보다 정확한 정보는 해당 판매자에게 직접 확인하여 주시기 바랍니다. Copyright BABMOKJA. All
                    Rights Reserved.<br><br>

                    고객센터: 02-123-4567 (24시간, 연중무휴)
                    <br>
                    <address>
                        Copyright &copy; BABMOKJA All Right Reserved.</address>
                </small>
            </div>
        </footer>
<script>
  function check_pw(){
      var pw = document.getElementById('pw').value;
      var SC = ["!","@","#","$","%"];
      var check_SC = 0;

      if(pw.length < 6 || pw.length>16){
          window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
          document.getElementById('pw').value='';
      }
      for(var i=0;i<SC.length;i++){
          if(pw.indexOf(SC[i]) != -1){
              check_SC = 1;
          }
      
         if(check_SC == 1){
          document.getElementById('check').innerHTML='비밀번호에 특수문자가 포함되어 있습니다.';
          document.getElementById('check').style.color='red';  
        }
      }
      if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
          if(document.getElementById('pw').value==document.getElementById('pw2').value){
              document.getElementById('check').innerHTML='비밀번호가 일치'
              document.getElementById('check').style.color='blue';
             
          }
          else{
              document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
              document.getElementById('check').style.color='red';
              
             
          }
      }
  }
</script>

<script>
     const $searchZipCode = document.getElementById("searchZipCode");
     
     $searchZipCode.onclick = function() {
                new daum.Postcode({
                    oncomplete: function(data) {
                        $('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
                        $('[name=addr1]').val(data.address);
                        $('[name=addr2]').val(data.buildingName);
                    }
                }).open();
            }      
</script> 


<script>
function joinform_check() {
	  //변수에 담아주기
	  var uid = document.getElementById("userId");
	  var pwd = document.getElementById("UserPwd");
	  var uname = document.getElementById("userName");
	  var mobile = document.getElementById("userPhone");
	  var mail = document.getElementById("mail");
	  var emailRegExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
	  var userNo = document.getElementById("userNo"); 
	  if (!emailRegExp.test(mail)) {
	               window.alert("이메일 형식이 올바르지 않습니다!");
	               form.mail.value = "";
	               form.mail.focus();
	               return false;
	    }

	  if (uid.value == "") { 
	    alert("아이디를 입력하세요.");
	    uid.focus(); 
	    return false; 
	  };

	  if (pwd.value == "") {
	    alert("비밀번호를 입력하세요.");
	    pwd.focus();
	    return false;
	  };


	  if (uname.value == "") {
	    alert("이름을 입력하세요.");
	    uname.focus();
	    return false;
	  };

	  if (!female.checked && !male.checked) { //둘다 미체크시
	    alert("성별을 선택해 주세요.");
	    female.focus();
	    return false;
	  }

	  var reg = /^[0-9]+/g; //숫자만 입력하는 정규식

	  if (!reg.test(mobile.value)) {
	    alert("전화번호는 숫자만 입력할 수 있습니다.");
	    mobile.focus();
	    return false;
	  }
	  if (!reg.test(userNo.value)) {
		    alert("주민번호는 숫자만 입력할 수 있습니다.");
		    mobile.focus();
		    return false;
		  }


	  if (email_id.value == "") {
	    alert("이메일 주소를 입력하세요.");
	    email_id.focus();
	    return false;
	  }



	 
	  document.form.submit();    
	}




</script> 
<script>
	$("#checkId").click(function(){
			         
	const userId = document.getElementById("userId").value;
			    	
			         
	$.ajax({
	url: "${ pageContext.servletContext.contextPath }/user/check",
	type: "get",
	data : { userId: userId },
	success: function(data, textStatus, xhr) {
	     console.table(data);
	     if(data == "1"){
	     alert("중복된 아이디입니다.");
	     }else {
		 alert("사용가능한 아이디입니다.");
			}
		},
		error: function(xhr, status, error) {
		console.log(error);	            }
			         });
			      });
			      
			      
</script>   


</body>
</html>