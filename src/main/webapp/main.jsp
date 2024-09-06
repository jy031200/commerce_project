<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         import="dto.User,dto.Searchhistory"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>온라인 커머스</title>
    <script src="/resource/js/index.js" defer></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        header {
            width: 100%;
            background-color: #333;
            color: white;
            padding: 20px 0;
            text-align: center;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header-title {
            flex-grow: 1;
            text-align: center;
            margin-left: 4%;
        }
        .header-container {
            display: flex;
            align-items: center;
        }
        .header-container button {
            background-color: transparent;
            border: none;
            cursor: pointer;
            margin-left: -100%;
        }
        .header-container img {
            width: 60px;
            height: 50px;
            border-radius: 50%;
        }
        .search-container {
            margin: 20px 0;
            text-align: center;
            display: flex;
            border: 2px solid #333;
            border-radius: 25px;
            width: 370px;
            background-color: white;
        }
        .search-container input[type="text"] {
            width: 270px;
            height: 40px;
            margin-left: 20px;
            padding-left: 10px;
            padding-right: 5px;
            font-size: 16px;
            border: none;
            place-content: center;
            outline: none;

        }
        .search-container button {
            width: 40px;
            height: 40px;
            margin-left: 10px;
            background-color: white;
            margin-top: 1px;
            border: none;
        }
        .search-container img {
            width: 30px;
            height: 34px;
            margin-top: -2px;
            margin-left: -5px;
        }
        .posts-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            max-width: 1200px;
            margin: 20px 0;
        }

        .post {
            background-color: white;
            width: 280px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        .post img {
            width: 100%;
            border-radius: 10px;
        }

        .post h3 {
            font-size: 18px;
            margin: 10px 0;
        }

        .post p {
            font-size: 14px;
            color: #555;
        }

        .pagination {
            display: flex;
            justify-content: center;
            margin: 20px 0;
        }

        .pagination a {
            color: #333;
            padding: 10px 20px;
            text-decoration: none;
            margin: 0 5px;
            border-radius: 5px;
            border: 1px solid #ddd;
        }

        .pagination a.active {
            background-color: #333;
            color: white;
        }

        .pagination a:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<header>
    <h1 class="header-title">온라인 커머스</h1>
    <div class="header-container">
        <button type="button" id="btn_mypage" onclick="mypage()">
            <img src="${pageContext.request.contextPath}/image/profile.png" alt="User">
        </button>
    </div>
</header>

<div class="search-container">
    <form action="search_history" method="post"> <%-- id는 html,css에서 구분, namedms 서블릿에서 구분--%>
        <input type="text" id="search_text" name="search_text" placeholder="찾으시는 상품을 검색해보세요!">
        <button type="submit" id="btn_search"> <%-- 검색기록 저장 및 페이지 이동--%>
            <img src="${pageContext.request.contextPath}/image/search_img.jpg">
        </button>
    </form>
</div>

<div class="posts-container">
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 1</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 2</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 3</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 4</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 5</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 6</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 7</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 8</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 9</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 10</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 11</h3>
        <p>Product description goes here.</p>
    </div>
    <div class="post">
        <img src="https://via.placeholder.com/280x150" alt="Product Image">
        <h3>Product Title 12</h3>
        <p>Product description goes here.</p>
    </div>
</div>

<div class="pagination">
    <a href="#">&lt;</a>
    <a href="#" class="active">1</a>
    <a href="#">2</a>
    <a href="#">3</a>
    <a href="#">4</a>
    <a href="#">5</a>
    <a href="#">&gt;</a>
</div>
</body>
</html>
