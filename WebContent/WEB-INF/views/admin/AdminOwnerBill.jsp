<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!DOCTYPE html>
<html lang="ko">
<head>
   <title>untitled</title>
   <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/OwnerBill.css">
</head>

<body> 
 
<table width='778' cellpadding='0' cellspacing='0' align='center'>
 <tr>
  <td width='100%'><br><br><br>
  
<table width='700' cellpadding='0' cellspacing='0' align='center' class='border_all'>
 <tr>
  <td width='100%'>
    <table cellpadding='0' cellspacing='0' height='65' width='100%'><tr>
      <td rowspan='2' align='center' width='360' class='border_tit'><font size='6'><b>세 금 계 산 서</b></font></td>
      <td rowspan='2' width='5' align='center' class='border_tit'><font size='4'><b>[</b></font></td>
      <td rowspan='2' width='70' align='center' class='border_tit'>공급받는자&nbsp;<br>보 &nbsp;관 &nbsp;용&nbsp;</td>
      <td rowspan='2' width='5' align='center' class='border_tit'><font size='4'><b>]</b></font></td>
      <td align='right' width='85' class='border_tit'>책 번 호&nbsp;&nbsp;</td>
      <td colspan='3' align='right' class='border_both'>권 &nbsp;</td>
      <td colspan='4' align='right' class='border_tit'>호 &nbsp;</td>
     </tr>
     <tr>
      <td width='85' align='right' class='border_tit'>일련번호&nbsp;</td>
      <td colspan='1' class='border_back ' width='25'>&nbsp;</td>
      <td colspan='1' class='border_up' width='25'>&nbsp;</td>
      <td colspan='1' class='border_up' width='25'>&nbsp;</td>
      <td colspan='1' class='border_up' width='25'>&nbsp;</td>
      <td colspan='1' class='border_up' width='25'>&nbsp;</td>
      <td colspan='1' class='border_up' width='25'>&nbsp;</td>
      <td colspan='1' class='border_top' width='25'>&nbsp;</td>  <!-- 책,권 -->
     </tr>
    </table>
   </td>
  </tr>
  <tr> 
   <td>
    <table cellpadding='0' cellspacing='0' width='700'>

     <tr>
      <td class='border_up' align='center' width='17' rowspan='4'>공<br><br><br>급<br><br><br>자</td>
      <td class='border_up' align='center' width='55' height='33'>등록번호</td>
      
      <td class='border_up' align='center' width='278' colspan='5'>
      
       <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      <c:out value="${ oneFee.ownerNo }"/>
      </c:forEach>
      </td>
      
      <td class='border_up' align='center' width='17' rowspan='4'>공<br>급<br>받<br>는<br>자</td>
      <td class='border_up' align='center' width='55'>등록번호</td>
      <td class='border_top' align='center' width='278' colspan='5'>000-00-00000</td>
     </tr>
    
     <tr>
      <td class='border_up' align='center' width='55' height='33'>상 호<br>(법인명)</td>
      <td class='border_up' align='center' width='160' colspan='3'>
       <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      <c:out value="${ oneFee.storeName }"/>
      </c:forEach>
      </td>
      <td class='border_up' align='center' width='12' colspan='1'>성<br>명</td>
      <td class='border_up' align='center' width='94' colspan='1'>
      <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      <c:out value="${ oneFee.userName }"/>
      </c:forEach>
      </td>
      <td class='border_up' align='center' width='55'>상 호<br>(법인명)</td>
      <td class='border_up' align='center' width='160' colspan='3'>㈜ 지금 배고프조</td>
      <td class='border_up' align='center' width='12' colspan='1'>성<br>명</td>
      <td class='border_top' align='center' width='94' colspan='1'>babmokja</td>
     </tr>
     <tr>
      <td class='border_up' align='center' width='55' height='33'>사업장<br>주  소</td>
      
      <td class='border_up' align='center' width='278' colspan='5'>
      <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      <c:out value="${ oneFee.storeAddress }"/>
      </c:forEach>
      </td>
      <td class='border_up' align='center' width='55'>사업장<br>주  소</td>
      <td class='border_top' align='center' width='278' colspan='5'>서울특별시 강남구 강남동 000, 타워 5층</td>
     </tr>
     <tr>
      <td class='border_up' align='center' width='55' height='33'>업  태</td>
      <td class='border_up' align='center' width='148' colspan='1'>
      <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      <c:out value="${ oneFee.company }"/>
      </c:forEach>
      </td>
      <td class='border_up' align='center' width='12' colspan='1'>종<br>목</td>
      <td class='border_up' align='center' width='106' colspan='3'>
      <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      <c:out value="${ oneFee.item }"/>
      </c:forEach>
      </td>
      <td class='border_up' align='center' width='55'>업 &nbsp; 태</td>
      <td class='border_up' align='center' width='148' colspan='1'>사업서비스</td>
      <td class='border_up' align='center' width='12' colspan='1'>종<br>목</td>
      <td class='border_top' align='center' width='106' colspan='3'>온라인정보제공</td>
     </tr>
<%--      </c:forEach> --%>
    </table>
   </td>
  </tr>
  <tr>
   <td width='100%'>
    <table cellpadding='0' cellspacing='0' width='700'>
     
    </table>
   </td>
  </tr>
  <tr>
   <td width='100%'>
    <table cellpadding='0' cellspacing='0' width='700'>
     <tr>
      <td class='border_up' align='center' width='50' height='21' colspan="4">항목</td>
      
      <td class='border_up' align='center' width='55' colspan="4">총 액</td>
     
     </tr>
     <c:set var="intArray" value="0" />
     <tr>
      <td class='border_up' align='center' width='50' height='25' colspan="4">
      월이용료
      </td>
      <td class='border_up' align='center' width='55' colspan="4">
     <c:out value="${ fee.totalAmount }"/>
      <c:forEach var="fee" items="${ requestScope.OwnerFeeList }" >
      <c:set var="intArray" value="${intArray+fee.totalAmount}" />
      </c:forEach>
      <c:out value="${ intArray }원"/>
      </td>
     </tr>

    </table>
   </td>
  </tr>
  
  <tr>
   <td width='100%'>
    <table cellpadding='0' cellspacing='0' width='700'>
     <tr align='justify'>
      <td class='border_up' align='center' width='122' height='2'>합계금액</td>
      <td class='border_up' align='center' width='108'>현 &nbsp; &nbsp; 금</td>
      <td class='border_up' align='center' width='108'>수 &nbsp; &nbsp; 표</td>
      <td class='border_up' align='center' width='108'>어 &nbsp; &nbsp; 음</td>
      <td class='border_up' align='center' width='108'>외상미수금</td>
      <td class='border_top' rowspan='2' align='center' width='143'>이 금액을 &nbsp;(청구) &nbsp;함</td>
     </tr>
     <tr>
      <td class='border_up' align='center' width='122' height='25'><c:out value="${ intArray }원"/></td>
      <td class='border_up' align='center' width='108'></td>
      <td class='border_up' align='center' width='108'>&nbsp;</td>
      <td class='border_up' align='center' width='108'>&nbsp;</td>
      <td class='border_up' align='center' width='108'>&nbsp;</td>
     </tr>
    </table>
   </td>
  </tr>
 
</table>

<br><br>
<!------------------------------ 절취선 ------------------------------------------------->
<table width='700' cellpadding='0' cellspacing='0' align='center'>
   <tr>
      <td height='1' colspan=2 background='<?echo("$skin_dir/dot.gif")?>' border='0'></td>
   </tr>
</table>
<!------------------------------ 절취선 ------------------------------------------------->

<br><br>

<table width='700' cellpadding='0' cellspacing='0' align='center' class='border_all_red'>
  <tr>
    <td width='100%'>
      <table cellpadding='0' cellspacing='0' height='65' width='100%'><tr>
        <td rowspan='2' align='center' width='360' class='border_tit_red'><font size='6'><b>세 금 계 산 서</b></font></td>
        <td rowspan='2' width='5' align='center' class='border_tit_red'><font size='4'><b>[</b></font></td>
        <td rowspan='2' width='70' align='center' class='border_tit_red'>공급받는자&nbsp;<br>보 &nbsp;관 &nbsp;용&nbsp;</td>
        <td rowspan='2' width='5' align='center' class='border_tit_red'><font size='4'><b>]</b></font></td>
        <td align='right' width='85' class='border_tit_red'>책 번 호&nbsp;&nbsp;</td>
        <td colspan='3' align='right' class='border_both_red'>권 &nbsp;</td>
        <td colspan='4' align='right' class='border_tit_red'>호 &nbsp;</td>
       </tr>
       <tr>
        <td width='85' align='right' class='border_tit_red'>일련번호&nbsp;</td>
        <td colspan='1' class='border_back_red ' width='25'>&nbsp;</td>
        <td colspan='1' class='border_up_red' width='25'>&nbsp;</td>
        <td colspan='1' class='border_up_red' width='25'>&nbsp;</td>
        <td colspan='1' class='border_up_red' width='25'>&nbsp;</td>
        <td colspan='1' class='border_up_red' width='25'>&nbsp;</td>
        <td colspan='1' class='border_up_red' width='25'>&nbsp;</td>
        <td colspan='1' class='border_up_red' width='25'>&nbsp;</td>  <!-- 책,권 -->
       </tr>
      </table>
     </td>
    </tr>
    <tr> 
     <td>
      <table cellpadding='0' cellspacing='0' width='700'>
       <tr>
        <td class='border_up_red' align='center' width='17' rowspan='4'>공<br><br><br>급<br><br><br>자</td>
        <td class='border_up_red' align='center' width='55' height='33'>등록번호</td>
        <td class='border_up_red' align='center' width='278' colspan='5'>
         <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      		<c:out value="${ oneFee.ownerNo }"/>
      	 </c:forEach>
        </td>
        <td class='border_up_red' align='center' width='17' rowspan='4'>공<br>급<br>받<br>는<br>자</td>
        <td class='border_up_red' align='center' width='55'>등록번호</td>
        <td class='border_top_red' align='center' width='278' colspan='5'>000-00-00000</td>
       </tr>
       <tr>
        <td class='border_up_red' align='center' width='55' height='33'>상 호<br>(법인명)</td>
        <td class='border_up_red' align='center' width='160' colspan='3'>
        <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      		<c:out value="${ oneFee.storeName }"/>
        </c:forEach>
        </td>
        <td class='border_up_red' align='center' width='12' colspan='1'>성<br>명</td>
        <td class='border_up_red' align='center' width='94' colspan='1'>
         <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      		<c:out value="${ oneFee.userName }"/>
      	 </c:forEach>
         </td>
        <td class='border_up_red' align='center' width='55'>상 호<br>(법인명)</td>
        <td class='border_up_red' align='center' width='160' colspan='3'>㈜ 지금 배고프조</td>
        <td class='border_up_red' align='center' width='12' colspan='1'>성<br>명</td>
        <td class='border_top_red' align='center' width='94' colspan='1'>babmokja</td>
       </tr>
       <tr>
        <td class='border_up_red' align='center' width='55' height='33'>사업장<br>주  소</td>
        <td class='border_up_red' align='center' width='278' colspan='5'>
        <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      		<c:out value="${ oneFee.storeAddress }"/>
      	</c:forEach>
        </td>
        <td class='border_up_red' align='center' width='55'>사업장<br>주  소</td>
        <td class='border_top_red' align='center' width='278' colspan='5'>서울특별시 강남구 강남동 000, 타워 5층</td>
       </tr>
       <tr>
        <td class='border_up_red' align='center' width='55' height='33'>업  태</td>
        <td class='border_up_red' align='center' width='148' colspan='1'>
        <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      		<c:out value="${ oneFee.company }"/>
      	</c:forEach>
        </td>
        <td class='border_up_red' align='center' width='12' colspan='1'>종<br>목</td>
        <td class='border_up_red' align='center' width='106' colspan='3'>
        <c:forEach var="oneFee" items="${ requestScope.oneFeeList }" >
      		<c:out value="${ oneFee.item }"/>
      	</c:forEach>
        </td>
        <td class='border_up_red' align='center' width='55'>업 &nbsp; 태</td>
        <td class='border_up_red' align='center' width='148' colspan='1'>사업서비스</td>
        <td class='border_up_red' align='center' width='12' colspan='1'>종<br>목</td>
        <td class='border_top_red' align='center' width='106' colspan='3'>온라인정보제공</td>
       </tr>
      </table>
     </td>
    </tr>
    <tr>
     <td width='100%'>
      <table cellpadding='0' cellspacing='0' width='700'>
       
      </table>
     </td>
    </tr>
    <tr>
     <td width='100%'>
      <table cellpadding='0' cellspacing='0' width='700'>
       <tr>
        <td class='border_up_red' align='center' width='50' height='21' colspan="4">항목</td>
        
        <td class='border_up_red' align='center' width='55' colspan="4">총 액</td>
        
       </tr>
       
       <c:set var="intArray" value="0" />
     <tr>
      <td class='border_up_red' align='center' width='50' height='25' colspan="4">
      월이용료
      </td>
      <td class='border_up_red' align='center' width='55' colspan="4">
     <c:out value="${ fee.totalAmount }"/>
      <c:forEach var="fee" items="${ requestScope.OwnerFeeList }" >
      <c:set var="intArray" value="${intArray+fee.totalAmount}" />
      </c:forEach>
      <c:out value="${ intArray }원"/>
      </td>
     </tr>
       
      </table>
     </td>
    </tr>
    
    <tr>
   <td width='100%'>
    <table cellpadding='0' cellspacing='0' width='700'>
     <tr align='justify'>
      <td class='border_up_red' align='center' width='122' height='2'>합계금액</td>
      <td class='border_up_red' align='center' width='108'>현 &nbsp; &nbsp; 금</td>
      <td class='border_up_red' align='center' width='108'>수 &nbsp; &nbsp; 표</td>
      <td class='border_up_red' align='center' width='108'>어 &nbsp; &nbsp; 음</td>
      <td class='border_up_red' align='center' width='108'>외상미수금</td>
      <td class='border_top_red' rowspan='2' align='center' width='143'>이 금액을 &nbsp;(청구) &nbsp;함</td>
     </tr>
     <tr>
      <td class='border_up_red' align='center' width='122' height='25'><c:out value="${ intArray }원"/></td>
      <td class='border_up_red' align='center' width='108'></td>
      <td class='border_up_red' align='center' width='108'>&nbsp;</td>
      <td class='border_up_red' align='center' width='108'>&nbsp;</td>
      <td class='border_up_red' align='center' width='108'>&nbsp;</td>
     </tr>
    </table>
   </td>
  </tr>
  
  </table>
      

<br><br><br>
</td>
</tr>
</table>
         <!------------------- 세금계산서 태그 여기까지 -------------------->

</td>
</tr>
</table>
         <!------------------- body table 놓이는곳 -------------------->

</body>
</html>