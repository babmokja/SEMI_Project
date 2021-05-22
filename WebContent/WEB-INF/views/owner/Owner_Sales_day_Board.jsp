<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>매출 관리</title>
 <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store_css/Owner_Sales_day_Board.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store_css/main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/bootstrap.min.css">
  

</head>
<body>
    <aside class="aside">
        <div class="aside_top2">BABMOKJA </div>
        <div class="aside_top">내 업소 관리</div>
        <div class="aside_top3"><a href="${ pageContext.servletContext.contextPath }/owner/menu/all">메뉴 관리</a></div>
        <div class="aside_top4"><a href="${ pageContext.servletContext.contextPath }/owner/sales/day">매출 관리</a></div>
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
                
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/resources/owner/menu/all">내 업소 관리</a>
              </span>
              <span class="col-2 menu-item">
                <img class="img-fluid" src="${ pageContext.servletContext.contextPath }/resources/image/owner/computer.png" />
                &nbsp;&nbsp;&nbsp;<a>PC주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="${ pageContext.servletContext.contextPath }/image/owner/item4.svg" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board (업체용 게시판)/company/Owner_Comment_Board.html">리뷰관리</a>
                </span>
  
                <span class="col-2 menu-item">
                  <img src="${ pageContext.servletContext.contextPath }/image/owner/item4.svg" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board (업체용 게시판)/company/Owner_Seggestion_Board.html">1:1 문의하기</a>
                </span>
        </div>

        <div class="section_top">
            
       
        <div class="button01">일별</div>
        <div class="button02"><a href="${ pageContext.servletContext.contextPath }/owner/sales/month">월별</a></div>

       
        <div class="space"></div>


            <table> 
                <thead>
                    <tr>
                        <th class="section_contest section_contest_1">주문번호</th>
                        <th class="section_contest section_contest_2">주문시간</th>
                        <th class="section_contest section_contest_3">서비스 유형</th>
                        <th class="section_contest section_contest_4">결제금액</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>
                        <td class="section_contest_first section_contest_1">1</td>
                        <td class="section_contest_first section_contest_2">20:00</td>
                        <td class="section_contest_first section_contest_3">픽업</td>
                        <td class="section_contest_first section_contest_4">16,000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">2</td>
                        <td class="section_contest_first section_contest_2">20:30</td>
                        <td class="section_contest_first section_contest_3">배달</td>
                        <td class="section_contest_first section_contest_4">10,000원</td>
                    </tr>
                    <tr>
                        <td class="section_contest_first section_contest_1">3</td>
                        <td class="section_contest_first section_contest_2">21:00</td>
                        <td class="section_contest_first section_contest_3">픽업</td>
                        <td class="section_contest_first section_contest_4">15,000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">4</td>
                        <td class="section_contest_first section_contest_2">21:30</td>
                        <td class="section_contest_first section_contest_3">배달</td>
                        <td class="section_contest_first section_contest_4">18,000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">5</td>
                        <td class="section_contest_first section_contest_2">22:00</td>
                        <td class="section_contest_first section_contest_3">픽업</td>
                        <td class="section_contest_first section_contest_4">19,000원</td>
                    </tr>

                    <tr class="board_bottom">
                        <td class="section_contest_first section_contest_1">6</td>
                        <td class="section_contest_first section_contest_2">20:00</td>
                        <td class="section_contest_first section_contest_3">배달</td>
                        <td class="section_contest_first section_contest_4">13,000원</td>
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
                <p class="total">오늘 총 [---,---,---]원<br>판매 하셨습니다.</p>
            </div>
            
        </div>
    </section>

    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
</body>
</html>