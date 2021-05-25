<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_board/Owner_Seggestion_Board.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_board/main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_board/bootstrap.min.css">
    <title>Document</title>

    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
    <aside class="aside">
        <div class="aside_top2">BABMOKJA </div>
        <div class="aside_top">건의 게시판 </div>
    </aside>
  
    <section class="section">

        <div class="row">
            <span class="col-2 menu-item menu-item-selected">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_board/item1.png" />
                &nbsp;&nbsp;&nbsp;주문확인
              </span>
              <span class="col-2 menu-item  ">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_board/item2.png" />
                &nbsp;&nbsp;&nbsp; 내 정보관리
              </span>
              <span class="col-2 menu-item">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_board/item3.png" />
                
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board_sales/company/Owner_Sales_day_Board.html">내 업소 관리</a>
              </span>
              <span class="col-2 menu-item">
                <img class="img-fluid" src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_board/computer.png" />
                &nbsp;&nbsp;&nbsp;<a class="text-dark" href="../../front_semi_store/views/delivery.html">pc주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_board/item4.png" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../company/Owner_Comment_Board.html">리뷰관리</a>
                </span>
  
                <span class="col-2 menu-item">
                  <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_board/item4.svg" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../company/Owner_Seggestion_Board.html">1:1 문의하기</a>
                </span>
          </div>
     
        <div class="top-1">
        
              <div class="top">
                카테고리,제목
                <select class="form-select" >
                  <option selected>카테고리 선택</option>
                  <option value="1">카테고리</option>
                  <option value="2">제목</option>
                </select>
              </div>

              <div class="top">
                카테고리,제목 입력
                <input class="form-control" type="text" >
                
              </div>
              
              <div class="top">
                <br>
                <button type="button" class="btn btn-outline-secondary">검색하기</button>
              </div>
        </div>

            <table> 
                <thead>
                    <tr class="contest_top">
                        <th class="section_contest section_contest_1">번호</th>
                        <th class="section_contest section_contest_2">카테고리</th>
                        <th class="section_contest section_contest_3">제목</th>
                        <th class="section_contest section_contest_5">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="section_contest_first section_contest_1">1</td>
                        <td class="section_contest_first section_contest_2">공지</td>
                        <td class="section_contest_first section_contest_3"><a href="Owner_SeggestionWrite_Board.html">글제목 예시입니다.</a></td>
                        <td class="section_contest_first section_contest_5">2021-01-01 11:11:11</td>
                    </tr>
                    <tr>
                        <td class="section_contest_two section_contest_1">2</td>
                        <td class="section_contest_two section_contest_2">건의</td>
                        <td class="section_contest_two section_contest_3">글제목 예시입니다.</td>
                        <td class="section_contest_two section_contest_5">2021-01-01 11:11:11</td>
                    </tr>
                    <tr>
                        <td class="section_contest_two section_contest_1">3</td>
                        <td class="section_contest_two section_contest_2">건의</td>
                        <td class="section_contest_two section_contest_3">글제목 예시입니다.</td>
                        <td class="section_contest_two section_contest_5">2021-01-01 11:11:11</td>
                    </tr>
                    <tr>
                        <td class="section_contest_two section_contest_1">4</td>
                        <td class="section_contest_two section_contest_2">건의</td>
                        <td class="section_contest_two section_contest_3">글제목 예시입니다.</td>
                        <td class="section_contest_two section_contest_5">2021-01-01 11:11:11</td>
                    </tr>
                    <tr>
                        <td class="section_contest_two section_contest_1">5</td>
                        <td class="section_contest_two section_contest_2">건의</td>
                        <td class="section_contest_two section_contest_3">글제목 예시입니다.</td>
                        <td class="section_contest_two section_contest_5">2021-01-01 11:11:11</td>
                    </tr>
                    <tr>
                        <td class="section_contest_two section_contest_1">6</td>
                        <td class="section_contest_two section_contest_2">건의</td>
                        <td class="section_contest_two section_contest_3">글제목 예시입니다.</td>
                        <td class="section_contest_two section_contest_5">2021-01-01 11:11:11</td>
                    </tr>
                    <tr>
                        <td class="section_contest_two section_contest_1">7</td>
                        <td class="section_contest_two section_contest_2">건의</td>
                        <td class="section_contest_two section_contest_3">글제목 예시입니다.</td>
                        <td class="section_contest_two section_contest_5">2021-01-01 11:11:11</td>
                    </tr>
                    
                </tbody>
            </table>
            <div class="center clearfix">
                <div class="button button_space">1</div>
                <div class="button button_space">2</div>
                <div class="button button_space">3</div>
                <div class="button button_space">4</div>
                <div class="button">5</div>
                <div class="button3"><a href="Owner_SeggestionWrite2_Board.html"><button>글작성</button></a></div>
            </div>

            
            

    </section>

    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
</body>
</html>