<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>

<head>
<title>My Cart</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
.badge-notify {
	background: red;
	position: relative;
	top: -20px;
	right: 10px;
}

.my-cart-icon-affix {
	position: fixed;
	z-index: 999;
}
</style>
</head>

<body class="container">

	<div class="page-header">
		<h1>
			Products
			<div style="float: right; cursor: pointer;">
				<span class="glyphicon glyphicon-shopping-cart my-cart-icon"><span
					class="badge badge-notify my-cart-badge"></span></span>
			</div>
		</h1>
	</div>
	<c:set var="productservice" value="${new ProductService()}" />
	<c:set var="products" value="${productservice.showAll()}" />
	<div class="row">
		<c:forEach var="product" items="products">
			<div class="col-md-3 text-center">
				<img src="images/${product.getPimg_path()}" width="150px"
					height="150px"> <br> ${product.getPname()}<strong>${product.getPrice()}</strong>
				<br>
				<button class="btn btn-danger my-cart-btn"
					data-id="${product.getPid()}" data-name="${product.getPname()}"
					data-summary="${product.getSummary()}"
					data-price="${product.getPrice()}" data-quantity="1"
					data-image="images/${product.getPimg_path()}">Add to Cart</button>
				<a type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModalScrollable"> Details </a>

				<!-- Modal -->
				<div class="modal fade" id="exampleModalScrollable" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalScrollableTitle"
					aria-hidden="true">
					<div class="modal-dialog modal-dialog-scrollable" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalScrollableTitle">
									${product.getPname()}<strong>${product.getPrice()}</strong>
								</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="card mb-3" style="max-width: 540px;">
									<div class="row g-0">
										<div class="col-md-4">
											<img src="images/${product.getPimg_path()}" width="150px" height="150px"
												class="img-fluid rounded-start" alt="...">
										</div>
										<div class="col-md-8">
											<div class="card-body">
												<h5 class="card-title">${product.getPname()}</h5>
												<p class="card-text">${product.getSummary()}</p>
												<p class="card-text">
													<small class="text-muted">${ new Date()}</small>
												</p>
											</div>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-warning"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


	<script src="js/jquery-2.2.3.min.js"></script>
	<script type='text/javascript' src="js/bootstrap.min.js"></script>
	<script type='text/javascript' src="js/jquery.mycart.js"></script>
	<script type="text/javascript">
		$(function() {
			var goToCartIcon = function($addTocartBtn) {
				var $cartIcon = $(".my-cart-icon");
				var $image = $(
						'<img width="30px" height="30px" src="'
								+ $addTocartBtn.data("image") + '"/>').css({
					"position" : "fixed",
					"z-index" : "999"
				});
				$addTocartBtn.prepend($image);
				var position = $cartIcon.position();
				$image.animate({
					top : position.top,
					left : position.left
				}, 500, "linear", function() {
					$image.remove();
				});
			}

			$('.my-cart-btn')
					.myCart(
							{
								currencySymbol : '???',
								classCartIcon : 'my-cart-icon',
								classCartBadge : 'my-cart-badge',
								classProductQuantity : 'my-product-quantity',
								classProductRemove : 'my-product-remove',
								classCheckoutCart : 'my-cart-checkout',
								affixCartIcon : true,
								showCheckoutModal : true,
								numberOfDecimals : 2,
								cartItems : [],
								clickOnAddToCart : function($addTocart) {
									goToCartIcon($addTocart);
								},
								afterAddOnCart : function(products, totalPrice,
										totalQuantity) {
									console.log("afterAddOnCart", products,
											totalPrice, totalQuantity);
								},
								clickOnCartIcon : function($cartIcon, products,
										totalPrice, totalQuantity) {
									console
											.log("cart icon clicked",
													$cartIcon, products,
													totalPrice, totalQuantity);
								},
								checkoutCart : function(products, totalPrice,
										totalQuantity) {
									var checkoutString = "Total Price: "
											+ totalPrice + "\nTotal Quantity: "
											+ totalQuantity;
									checkoutString += "\n\n id \t name \t summary \t price \t quantity \t image path";
									$.each(products,
											function() {
												checkoutString += ("\n "
														+ this.id + " \t "
														+ this.name + " \t "
														+ this.summary + " \t "
														+ this.price + " \t "
														+ this.quantity
														+ " \t " + this.image);
											});
									alert(checkoutString)
									console.log("checking out", products,
											totalPrice, totalQuantity);
								},
								getDiscountPrice : function(products,
										totalPrice, totalQuantity) {
									console
											.log("calculating discount",
													products, totalPrice,
													totalQuantity);
									return totalPrice * 0.5;
								}
							});
		});
	</script>
</body>

</html>
