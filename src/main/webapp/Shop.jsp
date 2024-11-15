<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Arrays"%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Shop</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
<!-- MDB -->
<link rel="stylesheet" href="css/mdb.min.css" />
<!-- Custom styles -->
<link rel="stylesheet" href="css/style.css" />
<!-- Roboto Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
<!-- Material Design Bootstrap Ecommerce -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
<!-- Your custom styles (optional) -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="css/style.css" rel="stylesheet" type="text/css" />

<style>
.equal-image {
	height: 220px; /* Đặt chiều cao cố định */
	object-fit: cover; /* Cắt ảnh để vừa khít khung chứa */
	width: 100%; /* Đảm bảo chiều rộng ảnh chiếm hết khung chứa */
}

/* Mục mặc định */
.card-link-secondary {
    color: #6c757d;
    text-decoration: none;
    cursor: pointer;
}

/* Mục đang được chọn (active) */
.card-link-secondary.active {
    color: #007bff;
    font-weight: bold;
    border-bottom: 2px solid #007bff;
    text-decoration: none;
    font-size: 1.2em;
}

/* Thêm một chút khoảng cách và phong cách cho mục được chọn */
.text-muted .mb-3 {
    margin-bottom: 1rem;
}

/* Màu sắc của các nút */
.btn.color-option {
    position: relative;
    display: inline-block;
    width: 40px;
    height: 40px;
    cursor: pointer;
}

.btn.color-option input[type="radio"] {
    display: none; /* Ẩn nút radio */
}

/* Dấu tích */
.btn.color-option .color-check {
    display: none;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    font-size: 24px;
    color: #B385F2;
}

/* Hiển thị dấu tích khi được chọn */
.btn.color-option.active .color-check {
    display: block;
}

/* Định dạng cho các nút active */
.btn.color-option.active {
    border: 2px solid #007bff;
}



</style>

</head>

<body class="skin-light" onload="loadAmountCart()">

	<!--Main Navigation-->
	<header>

		<jsp:include page="Menu.jsp"></jsp:include>

	</header>
	<!--Main Navigation-->

	<!--Main layout-->
	<main>

		<div class="container" style="margin-top: 100px">

			<!--Grid row-->
			<div class="row mt-5">

				<!--Grid column-->
				<div class="col-md-4 mb-4">

					<!-- Section: Sidebar -->
					<section>

						<!-- Section: Gender -->
						<section>
							<h5>Gender</h5>

							<div class="form-check pl-0 mb-3">
								<input type="radio" name="gender" value="1" class="form-check-input" id="genderMen"
									onchange="filterByGender()" <% if(session.getAttribute("gender") != null && Arrays.asList((String[]) session.getAttribute("gender")).contains("1")) { %> checked <% } %>> <label
									class="form-check-label small text-uppercase card-link-secondary"
									for="genderMen">Men</label>
							</div>
							<div class="form-check pl-0 mb-3">
								<input type="radio" name="gender" value="0" class="form-check-input" id="genderWomen"
									onchange="filterByGender()" <% if(session.getAttribute("gender") != null && Arrays.asList((String[]) session.getAttribute("gender")).contains("0")) { %> checked <% } %>> <label
									class="form-check-label small text-uppercase card-link-secondary"
									for="genderWomen">Women</label>
							</div>
							<div class="form-check pl-0 mb-3">
								<input type="radio" name="gender" value="-1" class="form-check-input"
									id="genderUnisex" onchange="filterByGender()"  <% if(session.getAttribute("gender") != null && Arrays.asList((String[]) session.getAttribute("gender")).contains("-1")) { %> checked <% } %>>
								<label
									class="form-check-label small text-uppercase card-link-secondary"
									for="genderUnisex">Unisex</label>
							</div>

						</section>
						<!-- Section: Gender -->

						<!-- Section: Brand -->
						<section>
							<h5>Brand</h5>

							<div class="text-muted small text-uppercase mb-5">
								<c:forEach items="${listBrand }" var="o">
									<p class="mb-3">
										<a onclick="loadBrand(${o.id})" class="card-link-secondary ${sessionScope.brand == o.id ? 'active' : ''}">${o.name }</a>
									</p>

								</c:forEach>

							</div>
						</section>
						<!-- Section: Brand -->

						<!-- Section: Categories -->
						<section>

							<h5>Categories</h5>

							<div class="text-muted small text-uppercase mb-5">
								<c:forEach items="${listCategory}" var="o">
									<p class="mb-3">
										<a onclick="loadCategory(${o.id})" class="card-link-secondary ${sessionScope.category == o.id ? 'active' : ''}">${o.name}</a>
									</p>
								</c:forEach>
							</div>

						</section>
						<!-- Section: Categories -->

						<!-- Section: Filters -->
						<section>

							<h5 class="pt-2 mb-4">Filters</h5>

							<section class="mb-4">

								<div
									class="md-form md-outline mt-0 d-flex justify-content-between align-items-center">
									<input id="searchInput" value="${sessionScope.txtS}" name="txt"
										type="text" class="form-control mb-0" placeholder="Search..."
										onkeypress="handleKeyPress(event)">
									<a href="#!" class="btn btn-flat btn-md px-3 waves-effect" onclick="searchByName()"><i
										class="fas fa-search fa-lg"></i></a>
								</div>

							</section>


							<!-- Section: Price -->
							<section class="mb-4">

								<h6 class="font-weight-bold mb-3">Price</h6>

								<div class="form-check pl-0 mb-3">
									<input onchange="searchByPriceUnder100()" type="radio"
										class="form-check-input" id="under100"
										name="materialExampleRadios" ${sessionScope.price eq 'under100' ? 'checked' : ''}> <label
										class="form-check-label small text-uppercase card-link-secondary"
										for="under100">Under $100</label>
								</div>
								<div class="form-check pl-0 mb-3">
									<input onchange="searchByPrice100To200()" type="radio"
										class="form-check-input" id="100to200"
										name="materialExampleRadios" ${sessionScope.price eq '100to200' ? 'checked' : ''}> <label
										class="form-check-label small text-uppercase card-link-secondary"
										for="100to200">$100 to $200</label>
								</div>
								<div class="form-check pl-0 mb-3">
									<input onchange="searchByPriceAbove200()" type="radio"
										class="form-check-input" id="200above"
										name="materialExampleRadios" ${sessionScope.price eq '200above' ? 'checked' : ''}> <label
										class="form-check-label small text-uppercase card-link-secondary"
										for="200above">$200 & Above</label>
								</div>
								<form>
									<div class="d-flex align-items-center mt-4 pb-1">
										<div class="md-form md-outline my-0">
											<input id="priceMin"
												type="text" class="form-control mb-0" value="${sessionScope.priceMin}"> <label
												for="priceMin">$ Min</label>
										</div>
										<p class="px-2 mb-0 text-muted">-</p>
										<div class="md-form md-outline my-0">
											<input id="priceMax"
												type="text" class="form-control mb-0" value="${sessionScope.priceMax}" onkeypress="handleMinToMax(event)"> <label
												for="priceMax">$ Max</label>
										</div>
									</div>
								</form>

							</section>
							<!-- Section: Price -->




							<!-- Section: Color -->
							<section class="mb-4">

								<h6 class="font-weight-bold mb-3">Color</h6>

								<div
									class="btn-group btn-group-toggle btn-color-group d-block mt-n2 ml-n2"
									data-toggle="buttons">
									<c:forEach var="color" items="${colors}">
										<label
											class="btn color-option rounded-circle ${color} border-inset-grey p-3 m-2 ${sessionScope.color eq color ? 'active' : ''}">
											<input onchange="filterByColor('${color}')" type="radio"
											autocomplete="off" ${sessionScope.color eq color ? 'checked' : ''}>
											<span class="color-check">&#10003;</span>
										</label>
									</c:forEach>
								</div>

							</section>
							<!-- Section: Color -->

						</section>
						<!-- Section: Filters -->

					</section>
					<!-- Section: Sidebar -->

				</div>
				<!--Grid column-->

				<!--Grid column-->
				<div class="col-md-8 mb-4">

					<!-- Section: Block Content -->
					<section class="mb-3">

						<div class="row d-flex justify-content-around align-items-center">
							<div class="col-12 col-md-3 text-center text-md-left">
								<a href="#!" class="text-reset"><i
									class="fas fa-th-list fa-lg mr-1"></i></a href="#!"> <a href="#!"
									class="text-reset"><i class="fas fa-th-large fa-lg"></i></a href="#!">
							</div>
							<div class="col-12 col-md-5">
								<div class="d-flex flex-wrap">	
									<h5>All products</h5>
								</div>
							</div>
							<div class="col-12 col-md-4 text-center">
								<nav aria-label="Page navigation example">
									<ul
										class="pagination pagination-circle justify-content-center float-md-right mb-0">
										<c:if test="${index != 1}">
											<li class="page-item"><a href="shop?index=${index-1 }"
												class="page-link"><i class="fas fa-chevron-left"></i></a></li>
										</c:if>
										
										<c:forEach begin="1" end="${lastPage }" var="i">
											<li class="${index==i?"page-item active":"page-item" }"><a
												href="shop?index=${i }" class="page-link">${i }</a></li>
										</c:forEach>
										<c:if test="${index != lastPage}">
											<li class="page-item"><a href="shop?index=${index+1 }"
												class="page-link"><i class="fas fa-chevron-right"></i></a></li>
										</c:if>
									</ul>
								</nav>
							</div>
						</div>

					</section>
					<!-- Section: Block Content -->

					<!--Section: Block Content-->
					<section>

						<!-- Grid row -->
						<div class="row" id="content">


							<c:forEach items="${listProduct}" var="o">
								<!-- Grid column -->
								<div class="col-md-4 mb-5">

									<!-- Card -->
									<div class="">

										<div class="view zoom overlay rounded z-depth-2">
											<img class="img-fluid w-100 equal-image" src="${o.image }"
												alt="Sample"> <a href="detail?pid=${o.id}">
												<div class="mask">
													<img class="img-fluid w-100 equal-image" src="${o.image }">
													<div class="mask rgba-black-slight"></div>
												</div>
											</a>
										</div>

										<div class="text-center pt-4">

											<h5>${o.name }</h5>
											<p>
												<span class="mr-1"><strong>${o.retailPrice }$</strong></span>
											</p>

										</div>

									</div>
									<!-- Card -->

								</div>
								<!-- Grid column -->
							</c:forEach>

						</div>
						<!-- Grid row -->
					</section>
					<!--Section: Block Content-->

				</div>
	</main>
	<!--Main layout-->

	<!-- Footer -->


	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Footer -->



	<!-- SCRIPTS -->
	<!-- JQuery -->
	<script
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
	<!-- MDB Ecommerce JavaScript -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>

	<script>
	
	function searchByName() {
		const input = document.getElementById("searchInput");
		const searchTerm = input.value;
		const url = "shop?txt=" + searchTerm;
		window.location.href = url;
	}
	
	function handleKeyPress(event) {
	    if (event.key === 'Enter') {
	        searchByName();
	    }
	}
	
	function handleMinToMax(event) {
        if (event.key === 'Enter') {
            searchByPriceMinToMax();
        }
    }

	function searchByPriceUnder100() {
		const url = "shop?price=under100";
		window.location.href = url;
	}

	function searchByPrice100To200() {
		const url = "shop?price=100to200";
		window.location.href = url;
	}

	function searchByPriceAbove200() {
		const url = "shop?price=200above";
		window.location.href = url;
	}

	function searchByPriceMinToMax() {
		const priceMin = document.getElementById("priceMin").value;
		const priceMax = document.getElementById("priceMax").value;
		const url = "shop?priceMin="+priceMin+"&priceMax="+priceMax;
		
		window.location.href = url;
	}

	function filterByGender() {
		const genderMen = document.getElementById("genderMen").checked;
		const genderWomen = document.getElementById("genderWomen").checked
		const genderUnisex = document.getElementById("genderUnisex").checked;
		const genders = []; // Lúc đầu sài checkbox, Tính lấy tất cả giới tính luôn nhưng không được
		if(genderMen) {
			genders.push("1");
		}
		
		if(genderWomen){
			genders.push("0");
		}
		if(genderUnisex){
			genders.push("-1");
		}
		
		const url = "shop?gender=" + genders;
		window.location.href = url;
	}

	function loadBrand(brandId) {
		const url = "shop?brand=" + brandId;
		window.location.href = url;
	}

	function loadCategory(categoryId) {
		const url = "shop?category=" + categoryId;
		window.location.href = url;
	}

	function filterByColor(color) {
		const url = "shop?color=" + color;
		window.location.href = url;
	}
	function loadAmountCart(){
   	 $.ajax({
            url: "/WebBanGiayDep/loadAllAmountCart",
            type: "get", //send it through get method
            data: {
                
            },
            success: function (responseData) {
                document.getElementById("amountCart").innerHTML = responseData;
            }
        });
   } 
	
	
	
	
	
	
	
	
	
	
	
	</script>


	<!-- MDB -->
	<script type="text/javascript" src="js/mdb.min.js"></script>
	<!-- Custom scripts -->
	<script type="text/javascript" src="js/script.js"></script>
</body>

</html>