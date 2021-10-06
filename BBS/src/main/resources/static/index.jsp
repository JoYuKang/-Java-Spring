

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <!-- 한글 깨짐 방지-->
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <title>Joint Purchase Site</title>
  
  <!-- core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

  <!-- Custom fonts  -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  
  <!-- core CSS -->
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
 
  <!-- Custom styles  -->
  <link href="css/clean-blog.css" rel="stylesheet">

</head>

<body>
	<%
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
	%>

    <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">Joint Purchase Site</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link active" href="index.jsp">Home</a>
          </li>
          
          <%
          if(userID ==null){   	  
        	  %>
        	  <li class="nav-item">
            <a class="nav-link" href="login.jsp">Login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="signup.jsp">Sign Up</a>
          </li>
        	  
        	  <%
        	  }else{
        		%>
        		
        		  <li class="nav-item">
            <a class="nav-link" href="mypage.jsp">MyPage</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="logoutAction.jsp">Logout</a>
          </li>
        		<%
        	  }      
          %>
          
          
          
          <li class="nav-item">
            <a class="nav-link" href="shop.jsp">Shop</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about.jsp">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact.jsp">Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
            <h1>Joint Purchase Site</h1>
             <!--<span class="subheading"></span>-->
          </div>
        </div>
      </div>
    </div>
  </header>

  <!-- Main Content 

        <hr>
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <div class="post-preview">
          <a href="shop.jsp">
            <h2 class="post-title">
              판매 게시글 예시 1
            </h2>
            <h3 class="post-subtitle">
              삼성 2021 50인치 QLED 4K TV KQ50QA65AFXKR 125cm 빅스비
            </h3>
          </a>
          <p class="post-meta">Posted by
            <a href="#">Samsung</a>
            on September 24, 2019</p>
        </div>
        <hr>
        <div class="post-preview">
          <a href="shop.jsp">
            <h2 class="post-title">
              판매 게시글 예시 2
            </h2>
            <h3 class="post-subtitle">
              [디어마] 샤오미 디어마 분무형 물걸레 청소기 TB500
            </h3>
          </a>
          <p class="shop-meta">Posted by
            <a href="#">Xiaomi</a>
            on September 18, 2019</p>
        </div>
        <hr>
        <div class="post-preview">
          <a href="shop.jsp">
            <h2 class="post-title">
              판매 게시글 예시 3
            </h2>
            <h3 class="post-subtitle">
              애플 에어팟 2세대 무선충전 MRXJ2KH/A
            </h3>
          </a>
          <p class="post-meta">Posted by
            <a href="#">Apple</a>
            on August 24, 2019</p>
        </div>
        <hr>
        <div class="post-preview">
          <a href="shop.jsp">
            <h2 class="post-title">
              판매 게시글 예시 4
            </h2>
            <h3 class="post-subtitle">
              한성컴퓨터 TFX133T DEX 포터블 HDR 멀티터치 모니터
            </h3>
          </a>
          <p class="post-meta">Posted by
            <a href="#">Hansung</a>
            on July 8, 2019</p>
        </div>
        <hr>
        -->
        <!-- Pager -->
        <div class="clearfix text-center">
          <a class="btn btn-primary float" href="shop.jsp">Go to Shopping &rarr;</a>
        </div>
      </div>
    </div>
  </div>

  <hr>

  <!-- Footer -->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <ul class="list-inline text-center">
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
          </ul>
          <p class="copyright text-muted"> Joint Purchase Site &copy; Graduation project </p>
        </div>
      </div>
    </div>
  </footer>

  <!-- core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts -->
  <script src="js/clean-blog.min.js"></script>

</body>

</html>
