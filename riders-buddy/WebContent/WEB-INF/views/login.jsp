<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Riders Buddy</title>

    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/img/favicon.ico" />
    <link rel="stylesheet" href="assets/sign-in.css">

</head>
<body>
    <div class="loading">
        <div id="lottie"></div>
    </div>
    <img src="assets/icons/main-logo.svg" alt="" class="logo">
    <div class="wrapper">
        <div>  
            <img src="assets/img/banner-login.png" alt="">
        </div>
        <div>
            <img src="assets/img/form.png" alt="">
            <div class="form__sign-in">
                <form action="<%= request.getContextPath() %>/login" method="post">
                    <div>
                        <h2>Login</h2>
                        <p class="text">Username</p>
                        <input type="text" name="username" id="" class="input-text" placeholder="Ex: ridersbuddy@gmail.com" required>
                    </div>
                    <div>
                        <p class="text">Password</p>
                        <input type="password" name="password" id="" class="input-text" placeholder="Password" required>
                    </div>
                    <div>
                        <div>
                            <button type="submit" class="log-in" name="submit">Log in</button>
                            <p class="link">Don't have an account?<a href="#">Sign up</a></p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
</body>
<script language="JavaScript"  src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.0/jquery.min.js"></script>
<script>
    $(window).on("load",function(){
          $(".loading").fadeOut(2200);
        });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bodymovin/5.7.4/lottie.min.js"></script>
<script>
      var animation = bodymovin.loadAnimation({
 
      container: document.getElementById('lottie'), // required
      path: 'assets/json/data.json', // required
      renderer: 'svg', // required
      loop: true, // optional
      autoplay: true, // optional
      name: "Demo Animation", // optional
    });

    let hamburger = document.querySelector('#hamburger-icon');

    var hamburger_animation = bodymovin.loadAnimation({

      container: document.getElementById('hamburger-icon'), // required
      path: 'assets/json/hamburger-icon.json', // required
      renderer: 'svg', // required
      loop: false, // optional
      autoplay: false, // optional
      name: "Demo Animation", // optional
    });

    hamburger.addEventListener('click', function() {
        hamburger = !hamburger
        if(hamburger) {
            bodymovin.setDirection(-1);
            hamburger_animation.play();
        } else {
            bodymovin.setDirection(1);
            hamburger_animation.play();
        }
    });

    document.querySelector('#arrow-head').addEventListener('click', function() {
        this.classList.toggle("rotate__arrow");
    });
</script>

</html>