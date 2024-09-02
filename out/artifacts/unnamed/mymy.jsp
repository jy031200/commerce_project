<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>마이페이지</title>
  <script src="/resource/js/index.js" defer></script>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .mypage-container{
      background-color: white;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 300px;
    }
    .mypage-container p {
      font-weight: bolder;
      font-size: 18px;
    }
    .myinfo-container {
      margin-top: 10px;
    }
    .myinfo-container button {
      font-size: 13px;
      color: black;
      background-color: white;
      width: 100%;
      padding: 10px;
      border: 2px solid white;
      box-shadow: none;
    }
    .myinfo-container button:hover {
      background-color: #f2f2f2;
    }
    .myinfo-container a {
      display: block;
      margin-top: 10px;
      color: red;
      text-decoration: none;
    }
  </style>
</head>
<body>
<biv class="mypage-container">
  <p id="name">이재은</p>
  <hr class="custom-line">
  <biv class="myinfo-container">
    <p id="label1">나의 정보</p>
    <button type="button" id="btn_info"><span>내 정보</span></button>
    <button type="button" id="btn_post">내 판매글</button>
    <button type="button" id="btn_cart">장바구니</button>
    <a href="http://localhost:8080/index.jsp">회원 탈퇴</a>
  </biv>
</biv>
</body>
</html>
