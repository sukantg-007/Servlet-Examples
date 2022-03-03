<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
try{
	String name=(String)session.getAttribute("name");
	if(name.equals("")){
		response.sendRedirect("./index.html");
	}
}catch(Exception e){
	response.sendRedirect("./index.html");
}
	
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous">
    </script>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous">
    </script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.green.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&display=swap" rel="stylesheet">

    <title>Document</title>
    <style>
        body {
            margin: 0px;
            padding: 1px;
            box-sizing: border-box;
        }

        #main_header {
            margin-top: 0%;
            margin-bottom: 20px;
            margin-right: 20px;
            padding: 0px 10px 5px 0px;
            position: fixed;
            z-index: 2;
            overflow: hidden;
            top: 0;
            width: 100vw;
        }

        #main {
            margin-top: 100px;
        }

        .icon-button__badge {
            top: -10px;
            right: -15px;
            background-color: #544179;
        }

        .icon-button__logo {
            top: 10px;
            left: 50px;
        }

        .icon-button:hover {
            background-image: radial-gradient(circle farthest-corner at -25.1% 53.5%, rgba(252, 175, 23, 1) 0%, rgba(242, 101, 34, 1) 48.8%, rgba(133, 0, 88, 1) 100.2%);
        }


        .logo-font {
            font-family: 'Pacifico', cursive;
            color: rgb(4, 243, 252);
            font-size: 20px;
        }

        nav {
            background-image: linear-gradient(178.9deg, rgba(176, 57, 105, 1) 5.1%, rgba(229, 113, 159, 1) 109.3%);
            border-radius: 150px 10px 10px 10px;
            padding: 0%;
            box-shadow: 5px 5px 3px 0px rgba(176, 57, 105, 1);
        }

        .item {
            background-color: white;
            height: 150px;
            padding: 10px;
            border-radius: 10px;
        }

        .item2 img {
            width: 60px;
            height: 200px;
            padding: 10px;
            border-radius: 10px;
        }

        .item3 {
            height: 200px;
            padding: 10px;
            border-radius: 10px;
        }

        .outer-container {
            background-image: radial-gradient(circle 685.3px at 47.8% 55.1%, rgba(255, 99, 152, 1) 0%, rgba(251, 213, 149, 1) 90.1%);
            padding: 15px 20px 0px 20px;
            border-radius: 10px;
        }

        .carousel-wrapper {
            width: 1200px;
            margin: auto;
            position: relative;
            text-align: center;
            font-family: sans-serif;
        }

        .owl-carousel .owl-nav {
            overflow: hidden;
            height: 0px;
        }

        .owl-theme .owl-dots .owl-dot.active span,
        .owl-theme .owl-dots .owl-dot:hover span {
            background: #5110e9;
        }


        .owl-carousel .item {
            text-align: center;
        }

        .owl-carousel .nav-button {
            height: 40px;
            width: 25px;
            cursor: pointer;
            position: absolute;
            top: 50px !important;
        }

        .owl-carousel .owl-prev.disabled,
        .owl-carousel .owl-next.disabled {
            pointer-events: none;
            opacity: 0.25;
        }

        .owl-carousel .owl-prev {
            left: -15px;
        }

        .owl-carousel .owl-next {
            right: -15px;
        }

        .owl-theme .owl-nav [class*=owl-] {
            color: #ffffff;
            font-size: 13px;
            font-weight: bold;
            background: #f06204;
            width: 30px;
            height: 30px;
            border-radius: 50%;
        }

        .owl-carousel .prev-carousel:hover {
            background-position: 0px -40px;
        }

        .owl-carousel .next-carousel:hover {
            background-position: -24px -53px;
        }



        .card {
            margin: 3px;
            border-radius: 5px;
        }

        .card:hover {
            cursor: pointer;
            margin: 3px;
            border-radius: 5px;
            box-shadow: -2px -2px 2px 1px rgba(176, 57, 105, 1), 2px 2px 2px 1px rgba(176, 57, 105, 1);
        }

        .btn-circle {
            width: 50px;
            height: 50px;
            padding: 10px 16px;
            font-size: 18px;
            line-height: 1.33;
            border-radius: 25px;
        }

        #three,
        #four,
        #five {
            border: 2px solid white;
            padding: 5px;
            border-radius: 5px;
        }

        .col {
            margin: 5px;

        }

        label {
            font-family: 'Mochiy Pop One', sans-serif;
        }

        img {
            border-radius: 10px;
        }

        ul {
            margin: 0%;
            padding: 0%;
            list-style: none;

        }
    </style>
</head>

<body>
    <div id="main_header">
        <div class="container-fluid">
            <nav class="navbar navbar-light justify-content-between">
                <a class="navbar-brand text-danger d-inline-flex ">
                    <span class="icon-button__logo material-icons position-absolute rounded-circle text-white">
                        cake
                    </span><span class="logo-font">&nbspBake & Cake</span></a>
                <ul class="d-inline-flex">
                    <li class="mx-2">
                        <button type="button"
                            class="icon-button rounded-circle my-3 pt-2 d-flex justify-content-center text-warning position-relative">
                            <span class="material-icons" id="cart-button">
                                shopping_cart
                            </span>
                            <span id="count" name="count"
                                class="icon-button__badge position-absolute w-75 h-75 rounded-circle text-white">1</span>
                        </button>

                    </li>
                    <li>
                        <button type="button"
                            class="icon-button rounded-circle my-3 pt-2 position-relative d-flex justify-content-center text-warning">
                            <span class="material-icons">
                                perm_identity
                            </span>
                        </button>                        
                    </li>
                </ul>
            </nav>
        </div>
    </div>

    <div id="main">
        <div class="container">
            <div class="outer-container">
                <h3 class="mb-3 mt-2 text-white">What do you looking for?</h3>
                <div class="owl-one owl-carousel owl-theme">

                    <div class="item">
                        <img src="img/type1.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="img/type2.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="img/type3.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="img/type4.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="img/type5.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="img/type1.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="img/type1.jpg" alt=""> </div>
                    <div class="item">
                        <img src="img/type1.jpg" alt=""> </div>
                    <div class="item">
                        <img src="img/type1.jpg" alt=""> </div>
                    <div class="item">
                        <img src="img/type1.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="img/type1.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="img/type1.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>

        <div class="container mt-3" style="height: 300px;">
            <h3 class="">Promos for you</h3>
            <div class="bg-white">
                <div class="owl-two owl-carousel owl-theme">
                    <div class="item2">
                        <img src="img/add1.jpg" width="50" height="160" alt=""><span>Pastry</span> </div>

                    <div class="item2">
                        <img src="img/add2.jpg" width="50" height="160" alt=""><span>Pastry</span> </div>

                    <div class="item2">
                        <img src="img/add3.jpg" width="50" height="160" alt=""><span>Pastry</span> </div>

                    <div class="item2">
                        <img src="img/add4.jpg" width="50" height="160" alt=""><span>Pastry</span> </div>

                    <div class="item2">
                        <img src="img/add5.jpg" width="50" height="160" alt=""><span>Pastry</span> </div>

                    <div class="item2">
                        <img src="img/add1.jpg" width="50" height="160" alt=""><span>Pastry</span> </div>

                    <div class="item2">
                        <img src="img/add6.jpg" width="50" height="160" alt=""><span>Pastry</span> </div>

                    <div class="item2">
                        <img src="img/add2.jpg" width="50" height="160" alt=""><span>Pastry</span> </div>

                    <div class="item2">
                        <img src="img/add3.jpg" width="50" height="160" alt=""><span>Pastry</span> </div>

                    <div class="item2">
                        <img src="img/add4.jpg" width="50" height="160" alt=""><span>Pastry</span>

                    </div>
                    <div class="item2">
                        <img src="img/add4.jpg" width="50" height="160" alt=""><span>Pastry</span>

                    </div>
                    <div class="item2">
                        <img src="img/add5.jpg" width="40" height="160" alt=""><span>Pastry</span>

                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="main">
                <div class="row">
                    <div class="col-3">
                        <div class="card" style="min-width: 12rem;">

                            <img src="img/cake7.jpg" class="card-img-top position-relative" alt="...">
                            <span class="material-icons position-absolute" style="color: green;right:-1px;">
                                task_alt
                            </span>
                            <div class="card-body">
                            <form action="addtocart.do" method="get">
                            <input type="hidden" name="pid" value="101">
                            <input type="hidden" name="pname" value="Black-Forest">
                            <input type="hidden" name="prise" value="150">
                                <h5 class="card-title text-start m-2"
                                    style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
                                    Black-forest</h5>
                                <div class="d-inline-flex justify-content-between w-100">
                                    <div class="mb-1 w-75">
                                        <select name="qty" class="form-select border-1 rounded-pill h-100"
                                            aria-label="Default select example">
                                            <option selected>Choos..</option>
                                            <option value="0.5">0.5Kg</option>
                                            <option value="1">1Kg</option>
                                            <option value="1.5">1.5kg</option>
                                            <option value="2">2kg</option>
                                            <option value="2.5">2.5kg</option>
                                            <option value="3">3kg</option>
                                            <option value="3.5">3.5kg</option>
                                            <option value="4">4kg</option>
                                            <option value="4.5">4.5kg</option>
                                            <option value="5">5kg</option>
                                        </select>
                                    </div>
                                    <div>
                                        <button type="subit" class="btn btn-warning btn-circle"><i
                                                class="fas fa-plus"></i></button>
                                    </div>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="card" style="min-width: 12rem;">
                            <img src="img/cake6.jpg" class="card-img-top" alt="...">
                            <span class="material-icons position-absolute" style="color: green;right:-1px;">
                                task_alt
                            </span>
                            <div class="card-body">
                                <h5 class="card-title text-start m-2"
                                    style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
                                    Blac-forest</h5>
                                <div class="d-inline-flex justify-content-between w-100">
                                    <div class="mb-1 w-75">
                                        <select class="form-select border-1 rounded-pill h-100"
                                            aria-label="Default select example">
                                            <option selected>Choos..</option>
                                            <option value="0.5">0.5Kg</option>
                                            <option value="1">1Kg</option>
                                            <option value="1.5">1.5kg</option>
                                            <option value="2">2kg</option>
                                            <option value="2.5">2.5kg</option>
                                            <option value="3">3kg</option>
                                            <option value="3.5">3.5kg</option>
                                            <option value="4">4kg</option>
                                            <option value="4.5">4.5kg</option>
                                            <option value="5">5kg</option>
                                        </select>
                                    </div>
                                    <div>
                                        <button type="button" class="btn btn-warning btn-circle"><i class='fas fa-plus'
                                                style='font-size:14px;'></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="card" style="min-width: 12rem;">
                            <img src="img/cake5.jpg" class="card-img-top" alt="...">
                            <span class="material-icons position-absolute" style="color: green;right:-1px;">
                                task_alt
                            </span>
                            <div class="card-body">
                                <h5 class="card-title text-start m-2"
                                    style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
                                    Blac-forest</h5>
                                <div class="d-inline-flex justify-content-between w-100">
                                    <div class="mb-1 w-75">
                                        <select class="form-select border-1 rounded-pill h-100"
                                            aria-label="Default select example">
                                            <option selected>Choos..</option>
                                            <option value="0.5">0.5Kg</option>
                                            <option value="1">1Kg</option>
                                            <option value="1.5">1.5kg</option>
                                            <option value="2">2kg</option>
                                            <option value="2.5">2.5kg</option>
                                            <option value="3">3kg</option>
                                            <option value="3.5">3.5kg</option>
                                            <option value="4">4kg</option>
                                            <option value="4.5">4.5kg</option>
                                            <option value="5">5kg</option>
                                        </select>
                                    </div>
                                    <div>
                                        <button type="button" class="btn btn-warning btn-circle"><i class='fas fa-plus'
                                                style='font-size:14px;'></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="card" style="min-width: 12rem;">
                            <img src="img/cake1.jpg" class="card-img-top" alt="...">
                            <span class="material-icons position-absolute" style="color: green;right:-1px;">
                                task_alt
                            </span>
                            <div class="card-body">
                                <h5 class="card-title text-start m-2"
                                    style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
                                    Blac-forest</h5>
                                <div class="d-inline-flex justify-content-between w-100">
                                    <div class="mb-1 w-75">
                                        <select class="form-select border-1 rounded-pill h-100"
                                            aria-label="Default select example">
                                            <option selected>Choos..</option>
                                            <option value="0.5">0.5Kg</option>
                                            <option value="1">1Kg</option>
                                            <option value="1.5">1.5kg</option>
                                            <option value="2">2kg</option>
                                            <option value="2.5">2.5kg</option>
                                            <option value="3">3kg</option>
                                            <option value="3.5">3.5kg</option>
                                            <option value="4">4kg</option>
                                            <option value="4.5">4.5kg</option>
                                            <option value="5">5kg</option>
                                        </select>
                                    </div>
                                    <div>
                                        <button type="button" class="btn btn-warning btn-circle"><i class='fa  fa-plus'
                                                style='font-size:14px;'></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-3">
                        <div class="card" style="min-width: 12rem;">
                            <img src="img/cake4.jpg" class="card-img-top" alt="...">
                            <span class="material-icons position-absolute" style="color: green;right:-1px;">
                                task_alt
                            </span>
                            <div class="card-body">
                                <h5 class="card-title text-start m-2"
                                    style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
                                    Blac-forest</h5>
                                <div class="d-inline-flex justify-content-between w-100">
                                    <div class="mb-1 w-75">
                                        <select class="form-select border-1 rounded-pill h-100"
                                            aria-label="Default select example">
                                            <option selected>Choos..</option>
                                            <option value="0.5">0.5Kg</option>
                                            <option value="1">1Kg</option>
                                            <option value="1.5">1.5kg</option>
                                            <option value="2">2kg</option>
                                            <option value="2.5">2.5kg</option>
                                            <option value="3">3kg</option>
                                            <option value="3.5">3.5kg</option>
                                            <option value="4">4kg</option>
                                            <option value="4.5">4.5kg</option>
                                            <option value="5">5kg</option>
                                        </select>
                                    </div>
                                    <div>
                                        <button type="button" class="btn btn-warning btn-circle"><i class='fas fa-plus'
                                                style='font-size:14px;'></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="card" style="min-width: 12rem;">
                            <img src="img/cake3.jpg" class="card-img-top" alt="...">
                            <span class="material-icons position-absolute" style="color: green;right:-1px;">
                                task_alt
                            </span>
                            <div class="card-body">
                                <h5 class="card-title text-start m-2"
                                    style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
                                    Blac-forest</h5>
                                <div class="d-inline-flex justify-content-between w-100">
                                    <div class="mb-1 w-75">
                                        <select class="form-select border-1 rounded-pill h-100"
                                            aria-label="Default select example">
                                            <option selected>Choos..</option>
                                            <option value="0.5">0.5Kg</option>
                                            <option value="1">1Kg</option>
                                            <option value="1.5">1.5kg</option>
                                            <option value="2">2kg</option>
                                            <option value="2.5">2.5kg</option>
                                            <option value="3">3kg</option>
                                            <option value="3.5">3.5kg</option>
                                            <option value="4">4kg</option>
                                            <option value="4.5">4.5kg</option>
                                            <option value="5">5kg</option>
                                        </select>
                                    </div>
                                    <div>
                                        <button type="button" class="btn btn-warning btn-circle"><i class='fas fa-plus'
                                                style='font-size:14px;'></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="card" style="min-width: 12rem;">
                            <img src="img/cake2.jpg" class="card-img-top" alt="...">
                            <span class="material-icons position-absolute" style="color: green;right:-1px;">
                                task_alt
                            </span>
                            <div class="card-body">
                                <h5 class="card-title text-start m-2"
                                    style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
                                    Blac-forest</h5>
                                <div class="d-inline-flex justify-content-between w-100">
                                    <div class="mb-1 w-75">
                                        <select class="form-select border-1 rounded-pill h-100"
                                            aria-label="Default select example">
                                            <option selected>Choos..</option>
                                            <option value="0.5">0.5Kg</option>
                                            <option value="1">1Kg</option>
                                            <option value="1.5">1.5kg</option>
                                            <option value="2">2kg</option>
                                            <option value="2.5">2.5kg</option>
                                            <option value="3">3kg</option>
                                            <option value="3.5">3.5kg</option>
                                            <option value="4">4kg</option>
                                            <option value="4.5">4.5kg</option>
                                            <option value="5">5kg</option>
                                        </select>
                                    </div>
                                    <div>
                                        <button type="button" class="btn btn-warning btn-circle"><i class='fas fa-plus'
                                                style='font-size:14px;'></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="card" style="min-width: 12rem;">
                            <img src="img/cake1.jpg" class="card-img-top" alt="...">
                            <span class="material-icons position-absolute" style="color: green;right:-1px;">
                                task_alt
                            </span>
                            <div class="card-body">
                                <h5 class="card-title text-start m-2"
                                    style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
                                    Blac-forest</h5>
                                <div class="d-inline-flex justify-content-between w-100">
                                    <div class="mb-1 w-75">
                                        <select class="form-select border-1 rounded-pill h-100"
                                            aria-label="Default select example">
                                            <option selected>Choos..</option>
                                            <option value="0.5">0.5Kg</option>
                                            <option value="1">1Kg</option>
                                            <option value="1.5">1.5kg</option>
                                            <option value="2">2kg</option>
                                            <option value="2.5">2.5kg</option>
                                            <option value="3">3kg</option>
                                            <option value="3.5">3.5kg</option>
                                            <option value="4">4kg</option>
                                            <option value="4.5">4.5kg</option>
                                            <option value="5">5kg</option>
                                        </select>
                                    </div>
                                    <div>
                                        <button type="button" class="btn btn-warning btn-circle"><i class='fas fa-plus'
                                                style='font-size:14px;'></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container mt-5">
            <h3>Recommend for You</h3>
            <div class="row mt-5">
                <div id="three" class="col-4">
                    <div class="bg-white">
                        <div class="owl-three owl-carousel owl-theme">
                            <div class="item3">
                                <img src="img/rec1.jpg" alt="">
                            </div>
                            <div class="item3">
                                <img src="img/rec2.jpg" alt="">
                            </div>
                            <div class="item3">
                                <img src="img/rec3.jpg" alt="">
                            </div>
                        </div>
                    </div>
                    <div>
                        <h5 class="card-title">Straubary Cake</h5>
                        <h4 style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">200/kg
                        </h4>
                        <div class="d-inline-flex justify-content-between">
                            <select class="form-select w-75 border-1 rounded-pill" aria-label="Default select example">
                                <option selected>Choos..</option>
                                <option value="0.5">0.5Kg</option>
                                <option value="1">1Kg</option>
                                <option value="1.5">1.5kg</option>
                                <option value="2">2kg</option>
                                <option value="2.5">2.5kg</option>
                                <option value="3">3kg</option>
                                <option value="3.5">3.5kg</option>
                                <option value="4">4kg</option>
                                <option value="4.5">4.5kg</option>
                                <option value="5">5kg</option>
                            </select>
                            <button type="button" class="btn btn-warning btn-circle"><i class='fas fa-plus'
                                    style='font-size:14px;'></i></button>
                        </div>
                    </div>
                </div>
                <div id="four" class="col-4">
                    <div class="bg-white">
                        <div class="owl-three owl-carousel owl-theme">
                            <div class="item3">
                                <img src="img/rec4.jpg" alt="">
                            </div>
                            <div class="item3">
                                <img src="img/rec5.jpg" alt="">
                            </div>
                            <div class="item3">
                                <img src="img/rec6.jpg" alt="">
                            </div>
                        </div>
                    </div>
                    <div>
                        <h5 class="card-title">Straubary Cake</h5>
                        <h4 style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">200/kg
                        </h4>
                        <div class="d-inline-flex justify-content-between">
                            <select class="form-select w-75 border-1 rounded-pill" aria-label="Default select example">
                                <option selected>Choos..</option>
                                <option value="0.5">0.5Kg</option>
                                <option value="1">1Kg</option>
                                <option value="1.5">1.5kg</option>
                                <option value="2">2kg</option>
                                <option value="2.5">2.5kg</option>
                                <option value="3">3kg</option>
                                <option value="3.5">3.5kg</option>
                                <option value="4">4kg</option>
                                <option value="4.5">4.5kg</option>
                                <option value="5">5kg</option>
                            </select>
                            <button type="button" class="btn btn-warning btn-circle"><i class='fas fa-plus'
                                    style='font-size:14px;'></i></button> </div>
                    </div>
                </div>
                <div id="five" class="col-4">
                    <div class="bg-white">
                        <div class="owl-three owl-carousel owl-theme">
                            <div class="item3">
                                <img src="img/rec7.jpg" alt="">
                            </div>
                            <div class="item3">
                                <img src="img/rec8.jpg" alt="">
                            </div>
                            <div class="item3">
                                <img src="img/rec9.jpg" alt="">
                            </div>
                        </div>
                    </div>
                    <div>
                        <h5 class="card-title">Straubary Cake</h5>
                        <h4 style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">200/kg
                        </h4>
                        <div class="d-inline-flex justify-content-between">
                            <select class="form-select w-75 border-1 rounded-pill" aria-label="Default select example">
                                <option selected>Choos..</option>
                                <option value="0.5">0.5Kg</option>
                                <option value="1">1Kg</option>
                                <option value="1.5">1.5kg</option>
                                <option value="2">2kg</option>
                                <option value="2.5">2.5kg</option>
                                <option value="3">3kg</option>
                                <option value="3.5">3.5kg</option>
                                <option value="4">4kg</option>
                                <option value="4.5">4.5kg</option>
                                <option value="5">5kg</option>
                            </select>
                            <button type="button" class="btn btn-warning btn-circle"><i class='fas fa-plus'
                                    style='font-size:14px;'></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $("#outer-container").ready(function () {
                	var owl = $('.owl-carousel');
                    $('.owl-one').owlCarousel({
                        items: 8,
                        margin: 10,
                        loop: true,
                        nav: true,
                        navText: ["<div class='nav-button owl-prev'>‹</div>",
                            "<div class='nav-button owl-next'>›</div>"
                        ],
                        responsive: {
                            0: {
                                items: 1
                            },
                            600: {
                                items: 5
                            },
                            1000: {
                                items: 8
                            }
                        }
                    });
                });
                $('#outer-container2').ready(function () {
                    $('.owl-two').owlCarousel({
                        items: 3,
                        margin: 10,
                        loop: true,
                        nav: true,
                        navText: ["<div class='nav-button owl-prev'>‹</div>",
                            "<div class='nav-button owl-next'>›</div>"
                        ]

                    });
                });
                $('.owl-three').owlCarousel({
                    items: 1,
                    stagePadding: 50,
                    loop: true,
                    margin: 10,
                    autoplay: true,
                    autoplayTimeout: 1000,
                    autoplayHoverPause: true
                })
                $('.owl-four').owlCarousel({
                    items: 1,
                    stagePadding: 50,
                    loop: true,
                    margin: 10,
                    autoplay: true,
                    autoplayTimeout: 1000,
                    autoplayHoverPause: true
                })
                $('.owl-five').owlCarousel({
                    items: 1,
                    stagePadding: 50,
                    loop: true,
                    margin: 10,
                    autoplay: true,
                    autoplayTimeout: 1000,
                    autoplayHoverPause: true
                })
                owl.on('mousewheel', '.owl-stage', function (e) {
                    if (e.deltaY > 0) {
                        owl.trigger('next.owl');
                    } else {
                        owl.trigger('prev.owl');
                    }
                    e.preventDefault();
                });
            });
        </script>
</body>

</html>