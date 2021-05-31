<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Menu Manage</title>
  

  <link href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/bootstrap.min.css" rel="stylesheet">
  <link href="${ pageContext.servletContext.contextPath }/resources/css/owner/main_order3.css" rel="stylesheet">
  
  <style>

    td {
      position: relative;
    }
  </style>
  
  <body>
    
    <div class="container-fluid root">
      <div class="row main">
        <nav class="col-md-2 d-none d-md-block bg-yellow sidebar sidebar-bapmakja">
          <div class="sidebar-sticky">
              <aside class="aside">
                 <div class="aside_top2"><a href="${ pageContext.servletContext.contextPath }/main" 
        style="text-decoration: none; color: black; font-style: normal; font-weight: bolder;}"> babmokja </a></div>
        		 <div class="aside_top">내 업소 관리</div>
                 <div class="aside_top3"><a href="${ pageContext.servletContext.contextPath }/menu/all">메뉴 관리</a></div>
                 <div class="aside_top4"><a href="${ pageContext.servletContext.contextPath }/owner/sales/day">매출 관리</a></div>
             </aside>
            
            
          </div>
        </nav>
        
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4 main-scroll">
          
          <div class="row">
            <span class="col-2 menu-item menu-item-selected">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item1.svg" />
                &nbsp;&nbsp;&nbsp;<a href="${ pageContext.servletContext.contextPath }/order/confirm">주문확인</a>
              </span>
              <span class="col-2 menu-item  ">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item2.png" />
                &nbsp;&nbsp;&nbsp; 내 정보관리
              </span>
              <span class="col-2 menu-item">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item3.png" />
                
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/menu/all">내 업소 관리</a>
              </span>
              <span class="col-2 menu-item">
                <img class="img-fluid" src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/PC주문관리.png" style="width:45px; height:45px;" />
                &nbsp;&nbsp;&nbsp;<a class="text-dark" href="${ pageContext.servletContext.contextPath }/owner/delivery">PC주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="${ pageContext.servletContext.contextPath }/image/owner/semi_store/item4.svg" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board (업체용 게시판)/company/Owner_Comment_Board.html">리뷰관리</a>
                </span>
  
                <span class="col-2 menu-item">
                  <img src="${ pageContext.servletContext.contextPath }/image/owner/semi_store/item4.svg" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/suggestion/list">1:1 문의하기</a>
                </span>
        </div>
          
          <br>
          <br>
          <br>
          
          <div class="row">
            <div class="table-responsive col-10 offset-md-1">
              
             
              <br>
              
              <table class="table  table-sm  text-center">
                <thead>
                  <tr>
                    <th></th>
                    <th>메뉴</th>
                    <th>메뉴가격</th>
                    <th>상태</th>
                    <th>메뉴설명</th>
                    <th>사진 수정</th>
                    <th>등록된 사진</th>
                    <th>삭제</th>
                  </tr>
                </thead>
                
                <form action="${pageContext.servletContext.contextPath}/menu/insert" method="post"  encType="multipart/form-data">
                
                <c:forEach items="${ requestScope.menuList }" var="menu">
                <tbody>
                  <tr>
                    <td><input class="form-control" name="menuCode" style="display: none;" type="text" value=<c:out value="${menu.menuCode}"/>><c:out value="${menu.menuCode}"></c:out></td>
                    <td><input class="form-control" type="text" name="menuName" value=<c:out value="${menu.menuName}"/> readonly></td>
                    <td><input type="text" class="form-control text-right" name="price"  style="display:inline-block; width:150px;" value="<c:out value="${menu.price}"/>원"></td>
                    <td>               
                      <select class="form-select" name="salesYN"> 
                      <c:if test="${ menu.salesYN eq 'Y' }">
                            <option value="Y" selected>판매중</option>
                         <option value="N">품절</option>
                       
                      </c:if>
                   
                       <c:if test="${ menu.salesYN eq 'N' }">
                        <option value="Y">판매중</option>
                       <option value="N" selected>품절</option>
                       </c:if>
                     </select>
                   </td>
                    <td><input class="form-control" name="menuExplain" type="text" value=<c:out value ="${menu.menuExplain}"/>></td>
                    
                    <td><input type="file" name="singlefile" multiple="multiple" value="111" ></td>
                    <td><input type="text" name="originName" value=<c:out value="${menu.pictureCode.originName}"/>></td>
<!--                     <td><input type="checkbox" name="delete" value="delete"></td> -->                
				    <td><img id="delete" src="${pageContext.servletContext.contextPath}/resources/image/owner/delete.png" /></a></td>
                     <%-- <img src="${pageContext.servletContext.contextPath}/resources/image/owner/pic.png" /> --%>
                  </tr>
                  </tbody>
                </c:forEach>
            
            
            <!--  추가할 부분 -->
              <%-- <form action="${pageContext.servletContext.contextPath}/menu/insert" method="post" encType="multipart/form-data"> --%>
              	<tbody>
                     <tr>
                        <td><input class="form-control" name="menuCode" type="text" value="" style="display: none;" /></td>
                       <td><input class="form-control" type="text" name="menuName" placeholder="메뉴이름"/></td>
                       <td><input type="text" class="form-control text-right" name ="price" style="display:inline-block;width:150px;" placeholder="숫자만 입력하세요"></td>
                       <td><select class="form-select" name="salesYN">
                         <option>판매여부 선택</option>
                         <option value="Y">판매중</option>
                         <option value="N" selected>품절</option>
                       </select></td>
                       <td><input class="form-control" name="menuExplain" type="text" placeholder="메뉴설명"></td>
                  <td colspan="1"><input type="file" name="singlefile" multiple="multiple" value="111"></td>
                       <%-- <td><a href="#"><img src="${pageContext.servletContext.contextPath}/resources/image/owner/delete.png" /></a></td> --%>
                     </tr>
                     
                     </tbody>
                    </table>
                    
                    <div class="row">
                     <span class="col-10"></span>
                     
                     <%-- <span class="col-1"><a href="${pageContext.servletContext.contextPath}/menu/new"><img src="${pageContext.servletContext.contextPath}/resources/image/owner/config.png" /></a></span>
                     <span class="col-1"><a href="#"><img src="${pageContext.servletContext.contextPath}/resources/image/owner/backpage.png" /></a></span> --%>
                     <button type="submit">메뉴 추가하기</button>
                     
                   </div>
                  </form>
  
            </div>
          </div>
          
        </main>
        
      </div>
      
      <div class="footer text-right align-middle" style="background-color:#EF9309;">
        <a class="text-dark footer-text text-decoration-none">Copyright &copy; BABMOKJA All Right Reserved.&nbsp;</a>
      </div>
      
    </div>
    <script>
		if(document.getElementsByTagName("td")) {
		
		const $tds = document.getElementsByTagName("td");
		for(let i = 7; i < $tds.length; i+=8) {
			
			/* $tds[i].onmouseenter = function() {
				this.parentNode.style.backgroundColor = "orangered";
				this.parentNode.style.cursor = "pointer";
			}
			
			$tds[i].onmouseout = function() {
				this.parentNode.style.backgroundColor = "black";
			} */
			
			 $tds[i].onclick = function() {
				/* alert(this.parentNode.children[0].innerText); */
				 /* var menuCode = $tds[i-7].innerText; */
				  var MENUCode = this.parentNode.children[0].innerText; 
    			
				/* location.href = "${ pageContext.servletContext.contextPath }/menu/delete?menuCode="+ menuCode; */
				location.href = "${ pageContext.servletContext.contextPath }/menu/delete?MENUCode="+ MENUCode;
			} 
			
		}
		
	}
    </script>
    
    
  </body></html>