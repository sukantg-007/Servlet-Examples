<%@page import="com.proj1.entity.ContactUs"%>
<%@page import="com.proj1.entity.Feedback"%>
<%@page import="com.proj1.entity.Order"%>
<%@page import="com.proj1.service.CakeServiceImpl"%>
<%@page import="com.proj1.service.ICakeService"%>
<%@page import="java.util.List"%>
<%@page import="com.proj1.entity.Cake"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.File"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%!ICakeService service=new CakeServiceImpl();%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Online Cake Shop System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Zen+Antique+Soft&display=swap"
	rel="stylesheet">
<!-- font awesome cdn link  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<!-- custom css file link  -->
<link rel="stylesheet" href="style.css">
<style>
th, td, btn {
	font-family: 'Zen Antique Soft', serif;
	font-weight: bold;
	font-size: 16px;
}

.card-title {
	font-family: 'Zen Antique Soft', serif;
	font-weight: bold;
	font-size: 30px;
	color: green;
}
</style>
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
            <a href="./showOrder.jsp">Order</a>
            <a href="./showFeedback.jsp">Feedback</a>
            <a href="./showContactus.jsp">Contactus</a>
            <a href="index.html">log-Out</a>
        </nav>

	</header>

	<!-- header section ends -->

	<!-- home section starts  -->
	<div style="height: 50px;"></div>
	<div>
		<div class="jumbotron mt-5">
			<div class="row mt-5">
				<div class="col mt-5">
					<div class="card" style="min-height: 40rem; min-width: 1200px;">
						<div class="card-body">
							<h2 class="card-title text-center">ContactUs Data</h2>
							<table class="table table-bordered border-primary table-hover">
								<thead class="table-dark" border="2">
									<tr>
										<th>CONTACTUS ID</th>
										<th>CUSTOMER NAME</th>
										<th>CUSTOMER EMAIL</th>
										<th>CUSTOMER MOBILE</th>
										<th>MESSAGE</th>										
										<th>ACTION</th>
										<th>ACTION</th>
									</tr>
								</thead>
								<tbody>
									<%
										List<ContactUs> list = service.getAllContactUs();
										Iterator<ContactUs> it = null;
										if (list != null) {
											it = list.iterator();
											while (it.hasNext()) {
												ContactUs cus = it.next();
												int cusid = cus.getCusid();												
									%>
									<tr>
										<td><%=cusid%></td>
										<td><%=cus.getCusname()%></td>
										<td><%=cus.getCusemail()%></td>
										<td><%=cus.getCusmobile()%></td>
										<td><%=cus.getCusmsg()%></td>
										
										<td><a class='btn' href='./update?id="+cusid+"'>Update</a></td>
										<td><a class='btn' href='./delete?id="+cusid+"'>Delete</a></td>
									</tr>
									<%
										}
										} else {
									%>
									<h1>List is Empty</h1>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<nav aria-label="...">
			<ul class="pagination pagination-sm">
				<%
					//int pages =studentService.getTotalStudent()/10;
					int pages = 1;
					int showPages = pages > 10 ? 10 : pages;
					for (int i = 1; i <= showPages; i++) {
				%>
				<li class="page-item"><a class="page-link"
					href="showCake.do?page=<%=i%>"><%=i%></a></li>
				<%
					}
				%>

			</ul>
		</nav>
	</div>

	<!-- footer section  -->

	<section class="footer">

		<div class="box-container">

			<div class="box">
				<img src="logo.jpg" alt="">
				<p>"You have to have really wide reading habits and pay
					attention to the news and just everything that’s going on in the
					world: You need to. If you get this right, then the writing is a
					piece of cake.”</p>
			</div>

			<div class="box">
				<h3>contact details</h3>
				<p>
					<i class="fas fa-phone"></i> +123-456-7890.
				</p>
				<p>
					<i class="fas fa-envelope"></i> example@gmail.com
				</p>
				<p>
					<i class="fas fa-map-marker-alt"></i> Daund, India - 400104.
				</p>
			</div>

			<div class="box">
				<h3>follow us</h3>
				<a href="#" class="fab fa-facebook"></a> <a href="#"
					class="fab fa-instagram"></a> <a href="#" class="fab fa-whatsapp"></a>
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
</body>

</html>