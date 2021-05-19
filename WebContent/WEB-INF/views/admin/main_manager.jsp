<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>������ ���� ����Ʈ</title>
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/reset.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/common.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/button.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/main_manager.css">
</head>
<body>


        <div class="header">
            <span>babmokja</span>
            <p>������ ����Ʈ</p>
        </div>

        <div class="wrap">
            <div class="main_menu">
                <li><a href="${pageContext.servletContext.contextPath}/admin/order"><img src="/SEMI_Project/resources/image/admin/�ֹ�Ȯ��.png" alt="�ֹ�Ȯ��">�ֹ�Ȯ��</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/customer"><img src="/SEMI_Project/resources/image/admin/������.png" alt="������">������</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/owner"><img src="/SEMI_Project/resources/image/admin/����������.png" alt="����������">���Ұ���</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/customer/board"><img src="/SEMI_Project/resources/image/admin/�������.png" alt="�������">�Խ���</a></li>
            </div>

            <div class="side_word">
                <div class="word1">���,�Ⱦ�,�ڸ�������� �ѹ���!</div>
                <div class="word2">�������� �ֹ� �÷���</div>
                <div class="word3">�乬��</div>
            </div>

            <div class="login">
                <input type="text" class="id" placeholder="���̵� �Է����ּ���"><br>
                <input type="text" class="pw" placeholder="��й�ȣ�� �Է����ּ���"><br>

                <button type="submit" id="login_btn">�α���</button>

            </div>
        
        </div>


</body>
</html>