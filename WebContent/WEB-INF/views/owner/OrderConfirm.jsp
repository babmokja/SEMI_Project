<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문확인</title>
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/order.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/semi_store/bootstrap.min.css">
</head>
<body>
    <aside class="aside">
       <div class="aside_top2"><a href="${ pageContext.servletContext.contextPath }/main" 
        style="text-decoration: none;
   		color: black;
    	font-style: normal;
    	font-weight: bolder;}"> babmokja </a></div>
        <div class="aside_top">주문확인</div>
       
    </aside>

    <section class="section">

          <div class="row">
            <span class="col-2 menu-item menu-item-selected">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item1.svg" />
                &nbsp;&nbsp;&nbsp;<a href="order.html">주문확인</a>
              </span>
              <span class="col-2 menu-item  ">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item2.png" />
                &nbsp;&nbsp;&nbsp; 내 정보관리
              </span>
              <span class="col-2 menu-item">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item3.png" />
                
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/menu/all">내 업소 관리</a>
              </span>
              <span class="col-2 menu-item">
                <img class="img-fluid" src="${ pageContext.servletContext.contextPath }/resources/image/owner/computer.png" />
                &nbsp;&nbsp;&nbsp;<a class="text-dark" href="${ pageContext.servletContext.contextPath }/owner/delivery">PC주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="${ pageContext.servletContext.contextPath }/image/owner/item4.svg" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board (업체용 게시판)/company/Owner_Comment_Board.html">리뷰관리</a>
                </span>
  
                <span class="col-2 menu-item">
                  <img src="${ pageContext.servletContext.contextPath }/image/owner/item4.svg" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/suggestion/list">1:1 문의하기</a>
                </span>
        </div>

        <div class="section_top">
            

       
        <div class="space"></div>


            <table> 
                <thead>
                    <tr>
                        <th class="section_contest section_contest_1">주문번호</th>
                        <th class="section_contest section_contest_2">고객아이디(고객명)</th>
                        <th class="section_contest section_contest_3">주문일자</th>
                        <th class="section_contest section_contest_4">결제일자</th>
                        <th class="section_contest section_contest_4">주문상태</th>
                        <th class="section_contest section_contest_4">금액</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>
                        <td class="section_contest_first section_contest_1">IVV-1001</td>
                        <td class="section_contest_first section_contest_2">A</td>
                        <td class="section_contest_first section_contest_3">2010/05/19</td>
                        <td class="section_contest_first section_contest_4">2020/10/24</td>
                        <td class="section_contest_first section_contest_3">완료</td>
                        <td class="section_contest_first section_contest_4">16,000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">IVV-1002</td>
                        <td class="section_contest_first section_contest_2">B</td>
                        <td class="section_contest_first section_contest_3">2010/05/19</td>
                        <td class="section_contest_first section_contest_4">2020/10/24</td>
                        <td class="section_contest_first section_contest_3">완료</td>
                        <td class="section_contest_first section_contest_4">16,000원</td>
                    </tr>
                    <tr>
                        <td class="section_contest_first section_contest_1">IVV-1003</td>
                        <td class="section_contest_first section_contest_2">C</td>
                        <td class="section_contest_first section_contest_3">2010/05/19</td>
                        <td class="section_contest_first section_contest_4">2020/10/24</td>
                        <td class="section_contest_first section_contest_3">완료</td>
                        <td class="section_contest_first section_contest_4">16,000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">IVV-1004</td>
                        <td class="section_contest_first section_contest_2">D</td>
                        <td class="section_contest_first section_contest_3">2010/05/19</td>
                        <td class="section_contest_first section_contest_4">2020/10/24</td>
                        <td class="section_contest_first section_contest_3">완료</td>
                        <td class="section_contest_first section_contest_4">16,000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">IVV-1005</td>
                        <td class="section_contest_first section_contest_2">E</td>
                        <td class="section_contest_first section_contest_3">2010/05/19</td>
                        <td class="section_contest_first section_contest_4">2020/10/24</td>
                        <td class="section_contest_first section_contest_3">완료</td>
                        <td class="section_contest_first section_contest_4">16,000원</td>
                    </tr>

                    <tr class="board_bottom">
                        <td class="section_contest_first section_contest_1">IVV-1006</td>
                        <td class="section_contest_first section_contest_2">F</td>
                        <td class="section_contest_first section_contest_3">2010/05/19</td>
                        <td class="section_contest_first section_contest_4">2020/10/24</td>
                        <td class="section_contest_first section_contest_3">완료</td>
                        <td class="section_contest_first section_contest_4">16,000원</td>
                    </tr>
                    
                </tbody>
            </table>
        <!-- </div> -->

            <div class="center clearfix">
                <div class="button button_space">1</div>
                <div class="button button_space">2</div>
                <div class="button button_space">3</div>
                <div class="button button_space">4</div>
                <div class="button">5</div>
               
            </div>
            
        </div>
    </section>

    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
</body>
</html>