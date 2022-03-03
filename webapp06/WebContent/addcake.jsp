<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Cake Shop System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="style.css">

</head>

<body>

    <!-- header section starts  -->

    <header>

        <a href="#" class="logo"><i class="fas fa-utensils"></i>Cake</a>

        <div id="menu-bar" class="fas fa-bars"></div>

        <nav class="navbar">
            <a href="./admin">home</a>
            <a href="./addcake.jsp">Add-Cake</a>
            <a href="./showCake.jsp">Cakes</a>
            <a href="./showorder.jsp">Order</a>
            <a href="./showfeedback">Feedback</a>
            <a href="./showcontactus">Contactus</a>
            <a href="index.html">log-Out</a>
        </nav>

    </header>

    <!-- header section ends -->

    <!-- home section starts  -->

    <div style="height: 50px;"></div>

    <div class="conatainer">

        <form style="min-width: 800px; min-height: 300px;" class="card m-5 p-3 border-dark form-horizontal"
            action="./add.do" method="POST" enctype="multipart/form-data">
            <h1 class="text-center p-3 bg-success text-white fs-1 bold" style="height: 50px;font-weight: bold;">Add Cake
                Entry</h1>
            <hr>
            <div class="form-group row m-1">
                <label class="control-label col-md-2 col-sm-2 fs-3" for="name">Name :</label>
                <div class="col-md-10 col-sm-10">
                    <input style="height: 40px;font-size: 20px;" type="text" class="form-control" name="cname"
                        placeholder="Enter Name">
                </div>
            </div>
            <div class="form-group row m-1">
                <label class="control-label col-md-2 col-sm-2 fs-3" for="addr">Price :</label>
                <div class="col-md-10 col-sm-10">
                    <input style="height: 40px;font-size: 20px;" class="form-control" type="number" name="prise"
                        placeholder="Enter price">
                </div>
            </div>

            <div class="form-group row m-1">
                <label class="control-label col-sm-2 fs-3" for="photo">Upload Photo:</label>
                <input style="height: 40px;font-size: 20px;" type="file" class="col-sm-10 form-control-file"
                    name="cimg_path" accept="image/*">
            </div>

            <hr>
            <div class="form-group row m-1">
                <div class="col-offiset-8 col-4">
                    <button style="height: 40px;font-size: 15px;font-weight: bold;" type="submit"
                        class=" btn btn-success w-50">Submit</button>
                </div>
            </div>
        </form>
    </div>



    <!-- footer section  -->

    <section class="footer">

        <div class="box-container">

            <div class="box">
                <img src="logo.jpg" alt="">
                <p>"You have to have really wide reading habits and pay attention to the news and just everything that’s
                    going on in the world: You need to. If you get this right, then the writing is a piece of cake.”</p>
            </div>

            <div class="box">
                <h3>contact details</h3>
                <p> <i class="fas fa-phone"></i> +123-456-7890. </p>
                <p> <i class="fas fa-envelope"></i> example@gmail.com </p>
                <p> <i class="fas fa-map-marker-alt"></i> Daund, India - 400104. </p>
            </div>

            <div class="box">
                <h3>follow us</h3>
                <a href="#" class="fab fa-facebook"></a>
                <a href="#" class="fab fa-instagram"></a>
                <a href="#" class="fab fa-whatsapp"></a>
            </div>

        </div>

    </section>

    <!-- footer ends-->

    <!-- scroll top button  -->
    <a href="#home" class="fas fa-angle-up" id="scroll-top"></a>

    <!-- loader  -->
    <!-- <div class="loader-container">
        <img src="loader.gif" alt="">
    </div> -->




















    <!-- custom js file link  -->
    <script src="script.js"></script>

    <script>
        const loginText = document.querySelector(".title-text .login");
        const loginForm = document.querySelector("form.login");
        const loginBtn = document.querySelector("label.login");
        const signupBtn = document.querySelector("label.signup");
        const signupLink = document.querySelector("form .signup-link a");
        signupBtn.onclick = (() => {
            loginForm.style.marginLeft = "-50%";
            loginText.style.marginLeft = "-50%";
        });
        loginBtn.onclick = (() => {
            loginForm.style.marginLeft = "0%";
            loginText.style.marginLeft = "0%";
        });
        signupLink.onclick = (() => {
            signupBtn.click();
            return false;
        });
    </script>


</body>

</html>