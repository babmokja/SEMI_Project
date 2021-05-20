<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src="js/join_check.js?v=<%=new java.util.Date().getTime()%>"></script>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel="stylesheet" href="resources/css/customer/main.css">
    <link rel="stylesheet" href="resources/css/customer/modifyInfo_user.css">
</head>
<body>
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

<body>  
    <center>
        <!-- 헤더 -->
		<jsp:include page="/WEB-INF/views/common/customer/header.jsp" />
    </center>
    <center>
        <div id= 'signin1'>
        <h1>밥묵자 회원정보 수정</h1><br>
        <form>
        <table cellpadding="10" cellspacing="15" style="margin-top: 20px;">
           <tr>
             <td>아이디 </td>
             <td><input type="text" class="settingbox" size = "25"style="padding:4px;font-size:13px;border-radius: 10px;"readonly>
             </td>
           </tr>
           <tr>
            <td>비밀번호 </td>
            <td><input type="password" id="pw" onchange="check_pw()"name="pw" class="chk" size="25" placeholder="영문소문자와숫자만입력하세요" style="padding:4px;font-size:13px;border-radius: 10px;"> </td>
          </tr>
          <tr> 
              <td>비밀번호확인 </td>
              <td><input type="password" id="pw2"  onchange="check_pw()" name ="pw_ck" class= "chk" size="25" style="padding:4px;font-size:13px;border-radius: 10px;">
                <span id="check" ></span>

          
            </td>
          </tr>
          <tr>
            <td>이 름</td>
            <td><input type="text" class="settingbox" size="25" style="padding:4px;font-size:13px;border-radius: 10px;"readonly> </td>
          </tr>
          <tr> 
            <td>휴대전화</td>
            <td><input type="text" size="25"
                       maxlength="13" placeholder="숫자만입력하세요" style="padding:4px;font-size:13px;border-radius: 10px;"></td>
          </tr>

          <tr>
            <td>이메일</td>
            <td><input type="text"size="25" id="mail" style="padding:4px;font-size:13px;border-radius: 10px;"> </td>
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
            <td>우편번호</td>
            <td><input type="text" name="zip" size="25" style="padding:4px;font-size:13px;border-radius: 10px;"> 
            <button type="button"  style="width:60px; background-color: #ffcc00; border: 1px solid #d9e1e8; height:32px; border-radius: 20px; font-weight: 600; font-size: 15px; cursor: pointer;" onclick="openZipSearch()">검색</button></td>
          </tr> 
          <tr>
            <td>주소</td>
            <td><input type="text"size="25" name="addr1" style="padding:4px;font-size:13px;border-radius: 10px;" readonly /> </td>
          </tr> 
          <tr>
            <td>상세주소</td>
            <td><input type="text"size="25" name="addr2" style="padding:4px;font-size:13px;border-radius: 10px;"/> </td>
          </tr>
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
        </table>        

          <div class="modal_layer4"></div>
          <script>
            $(document).ready(function(){
               $('.modal_open_btn4').click(function(){
               $('.modal4').show();
               $('modal_layer3').show();
             });
               $('.modal_yes').click(function(){
               $('.modal4').hide();
               $('modal_layer4').hide();
              });
               $('.modal_no').click(function(){
               $('.modal4').hide();
               $('modal_layer4').hide();
              });
    
            });
    
        </script>
        
        <center>
            <input type="submit" class="btn" value="제 출">
        </center>  
            <input type="button"  value="회원탈퇴"  class="modal_open_btn4"  >
      
            <div class="modal4">
               <div class="modal_content4">
                   <label align= "center">탈퇴하시겠습니까?</label>
                   <div class="btn_float">
                     <button type="button" class="modal_yes">예</button>
                     <button type="button" class="modal_no">아니요</button>
                  </div>
              
               </div>
            </div>
        </div>  
     </form>
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


</body>
</html>