<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src="${ pageContext.servletContext.contextPath }//js/join_check.js?v=<%=new java.util.Date().getTime()%>"></script>
    <script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }//resources/css/customer/main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }//resources/css/customer/modifyInfo_user.css">
        <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/main.css">
<%--     <link href="${ pageContext.servletContext.contextPath }/resources/css/customer/reset.css" type="text/css"
	rel="stylesheet"> --%>
   <link href="${ pageContext.servletContext.contextPath }/resources/css/customer/common_ah.css" type="text/css"
	rel="stylesheet">


</head>
<body>
 



<body> 
      <center>
        <header>
		<div class="head">
			<div class="right">
				<div>
					<a href="${ pageContext.servletContext.contextPath }" class="logo">babmokja</a>
				</div>
				<div class="sq">

					<!-- 로그인이 필요한 경우 -->
					<c:if test="${ empty sessionScope.loginUser }">

						<!-- 로그인 폼 -->
						<form id="loginForm" method="post">
							<div class="btns" align="right">
								<div class="join">
									<a href="${ pageContext.servletContext.contextPath }/member/user/signin"class="join_icon">회원가입</a>
								</div>
								<div class="login">
									<a href="${ pageContext.servletContext.contextPath }/user/login" class="login_icon">로그인</a>
								</div>
							</div>
						</form>

					</c:if>

					<c:if test="${ !empty sessionScope.loginUser }">
						<!-- 로그인 되어 있는 경우 -->
						<div class="btns">
							<div class="mypage">
								<a href="${ pageContext.servletContext.contextPath}/user/mypage" class="mypage_icon"> 
									<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/user.png" alt="이미지없음">
								</a>
							</div>
							<div class="logout">
								<a href="${ pageContext.servletContext.contextPath }/user/logout" class="logout_icon">로그아웃</a>
							</div>
						</div>
					</c:if>
					
				</div>
			</div>
			
			<div>
				<a href="${ pageContext.servletContext.contextPath }" class="title">너의
					밥먹는건 우리가 책임진다</a>
			</div>
			<div class="searchbox">
				<a href="${ pageContext.servletContext.contextPath }/store/list">
					<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/magnifying.png" alt="이미지없음"
					id="icon">
				</a> <input type="text" class="searchpoint">
			</div>
			<div class="nav">
				<span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=kor&type=1&order=congestion&currentPage=1"
					class="a" id="kor">한식</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=fra&type=1&order=congestion&currentPage=1"
					class="a" id="fra">프랜차이즈</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=chi&type=1&order=congestion&currentPage=1"
					class="a" id="chi">중식</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=jap&type=1&order=congestion&currentPage=1"
					class="a" id="jap">일식</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=ame&type=1&order=congestion&currentPage=1"
					class="a" id="ame">양식</a>
				</span>
			</div>
		</div>
	</header>
      </center>
    <center>
        <div id= 'signin1' style="height:  785px;">
        <label value="정보수정" style="width: 300px;height: 10px;background-color: #ffcc00; border: 0;color: black;font-size: 30px;border-radius: 60px;font-weight: 600;padding: 20px 400px 20px 400px;margin-left: 70px;margin-top: 30px;
    margin-bottom: 9px;" >정보수정	</label>
        <form action="${ pageContext.servletContext.contextPath }/member/user/modify" method="post">
        <table style="margin-top: 70px;margin-left: 50px; border-collapse: separate;
               border-spacing: 17px 14px;">
           <tr>
             <td><label style="font-size: 25px">아이디 </td>
             <td><input type="text" name="id" value="${ sessionScope.loginUser.id }" class="settingbox" size = "25"style="padding:4px;font-size:13px;border-radius: 10px;"readonly>
             </td>
           </tr>
           <tr>
            <td><label style="font-size: 25px">비밀번호 </td>
            <td><input type="password" <%-- value="${ sessionScope.loginUser.pwd }"  --%>id="pw" onchange="check_pw()"name="pw" class="chk" size="25" placeholder="영문소문자와숫자만입력하세요" style="padding:4px;font-size:13px;border-radius: 10px;"> </td>
          </tr>
          <tr> 
              <td><label style="font-size: 25px">비밀번호확인 </td>
              <td><input type="password" <%-- value="${ sessionScope.loginUser.pwd }" id="pw2"  --%> onchange="check_pw()" name ="pw_ck" class= "chk" size="25" style="padding:4px;font-size:13px;border-radius: 10px;">
                <span id="check" ></span>

          
            </td>
          </tr>
          <tr>
            <td><label style="font-size: 25px">이 름</label></td>
            <td><input type="text" name="name" value="${ sessionScope.loginUser.name }"class="settingbox" size="25" style="padding:4px;font-size:13px;border-radius: 10px;"readonly> </td>
          </tr>
          <tr> 
            <td><label style="font-size: 25px">휴대전화</label></td>
            <td><input type="text" name="userPhone" value="${ sessionScope.loginUser.phone }"size="25"
                       maxlength="13" placeholder="숫자만입력하세요" style="padding:4px;font-size:13px;border-radius: 10px;"></td>
          </tr>

          <tr>
            <td><label style="font-size: 25px">이메일</label></td>
            <td><input type="text" name="email" value="${ sessionScope.loginUser.email }"size="25" id="mail" style="padding:4px;font-size:13px;border-radius: 10px;"> </td>
          </tr>
          <script>
                   
            var mail= document.getElementById("mail").value;
                 
            var emailRegExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;

            if (!emailRegExp.test(mail)) {
                 window.alert("이메일 형식이 올바르지 않습니다!");
                 form.mail.value = "";
                 form.mail.focus();
                 return false;
                 }
          </script>
  
          <tr>
            <td><label style="font-size: 25px">우편번호</label></td>
            <td><input type="text" name="zip" size="25" value="${ requestScope.zip }" style="padding:4px;font-size:13px;border-radius: 10px;"> 
            <button type="button"  style="width:60px; background-color: #ffcc00; border: 1px solid #d9e1e8; height:32px; border-radius: 20px; font-weight: 600; font-size: 15px; cursor: pointer;" onclick="openZipSearch()">검색</button></td>
          </tr> 
          <tr>
            <td><label style="font-size: 25px">주소</label></td>
            <td><input type="text"size="25" name="addr1"value="${ requestScope.add1 }" style="padding:4px;font-size:13px;border-radius: 10px;" readonly /> </td>
          </tr> 
          <tr>
            <td><label style="font-size: 25px">상세주소</label></td>
            <td><input type="text"size="25" name="addr2" value="${ requestScope.add2 }" style="padding:4px;font-size:13px;border-radius: 10px;"/> </td>
          </tr>

        </table>        


        
        <center>
            <input type="submit" class="btn" value="제 출">
        </center>  
         </form>
          <script>
            function openZipSearch() {
                new daum.Postcode({
                    oncomplete: function(data) {
                        $('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
                        $('[name=addr1]').val(data.address);
                        $('[name=addr2]').val(data.buildingName);
                    }
                }).open();
            }
            
            </script> 
<!--             <input type="button"  value="회원탈퇴"  class="modal_open_btn4"  > -->
      
            <div class="modal4">
               <div class="modal_content4">
                   <label align="center">탈퇴하시겠습니까?</label>
                   <div class="btn_float">
                     <button type="button" class="modal_yes">예</button>
                     <button type="button" class="modal_no">아니요</button>
                  </div>
              
               </div>
            </div>
        </div>  
   
     <footer>
     
        <div id="footlim" >
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
              document.getElementsById('img').innerHTML=imgg;
             
          }
      }
  }

</script>   


</body>
</html>