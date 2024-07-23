

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit</title>
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
<link href="css/manager.css" rel="stylesheet" type="text/css" />
<style>
img {
	width: 200px;
	height: 120px;
}

[type=radio]:checked, [type=radio]:not(:checked), [type=checkbox]:checked,
	[type=checkbox]:not(:checked) {
	position: static !important;
	pointer-events: auto !important;
	opacity: 1 !important;
}
</style>
<body>

	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Edit <b>Product</b>
						</h2>
					</div>
					<div class="col-sm-6"></div>
				</div>
			</div>
		</div>

		<c:if test="${error!=null }">
			<div id="errorAlert" class="alert alert-danger" role="alert">${error}</div>
		</c:if>

		<div id="editProduct">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="edit" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Edit Product</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<!-- Hidden field to store product ID -->
							<input type="hidden" name="id" value="${product.id}">

							<div class="form-group">
								<label for="productName">Name</label> <input id="productName"
									name="name" type="text" class="form-control"
									value="${product.name}" required>
							</div>
							<div class="form-group">
								<label for="productImage">Image URL</label> <input
									id="productImage" name="image" type="text" class="form-control"
									value="${product.image}">
							</div>
							<div class="form-group">
								<label for="productPrice">Price</label> <input id="productPrice"
									name="price" type="number" class="form-control"
									value="${product.price}">
							</div>
							<div class="form-group">
								<label for="retailPrice">Retail Price</label> <input
									id="retailPrice" name="retailPrice" type="number"
									class="form-control" value="${product.retailPrice}">
							</div>
							<div class="form-group">
								<label for="gender">Gender</label>
								<div>
									<input id="men" type="radio" name="gender" value="1"
										${product.gender == 1 ? 'checked' : ''}> <label
										for="men">Men</label> <input id="women" type="radio"
										name="gender" value="0"
										${product.gender == 0 ? 'checked' : ''}> <label
										for="women">Women</label> <input id="unisex" type="radio"
										name="gender" value="-1"
										${product.gender == -1 ? 'checked' : ''}> <label
										for="unisex">Unisex</label>
								</div>
							</div>
							<div class="form-group">
								<label for="description">Description</label>
								<textarea id="description" name="description"
									class="form-control">${product.description}</textarea>
							</div>
							<div class="form-group">
								<label for="brandID">Brand</label> <select id="brandID"
									name="brandID" class="form-select" required>
									<c:forEach items="${listBrand}" var="brand">
										<option value="${brand.id}"
											${product.brandID.id == brand.id ? 'selected' : ''}>${brand.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="categoryID">Category</label> <select id="categoryID"
									name="categoryID" class="form-select" required>
									<c:forEach items="${listCategory}" var="category">
										<option value="${category.id}"
											${product.categoryID.id == category.id ? 'selected' : ''}>${category.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="supplierID">Supplier</label> <select id="supplierID"
									name="supplierID" class="form-select" required>
									<c:forEach items="${listSupplier}" var="supplier">
										<option value="${supplier.id}"
											${product.supplierID.id == supplier.id ? 'selected' : ''}>${supplier.name}</option>
									</c:forEach>
								</select>
							</div>
							<!-- Product Variants -->
							<div class="form-group">
								<h2>Product Variants</h2>
								<div id="variants">
									<c:forEach items="${listVariant}" var="variant"
										varStatus="status">
										<div class="variant form-group" data-color="${variant.color}"
											data-size="${variant.size}">
											<hr>

											<h5 style="color: black;">Variant: ${variant.color}
												(${variant.size})</h5>
											
											<input name="color_${variant.color}_size_${variant.size}"
												type="hidden" class="form-control" value="${variant.color}">
											<input name="size_${variant.color}_size_${variant.size}"
												type="hidden" class="form-control" value="${variant.size}">
											<label>Quantity</label> <input
												name="quantity_${variant.color}_size_${variant.size}"
												type="number" class="form-control"
												value="${variant.quantity}"> <label>Image
												URL 1</label> <input
												name="image1_${variant.color}_size_${variant.size}"
												type="text" class="form-control" value="${variant.image1}">
											<label>Image URL 2</label> <input
												name="image2_${variant.color}_size_${variant.size}"
												type="text" class="form-control" value="${variant.image2}">
											<label>Image URL 3</label> <input
												name="image3_${variant.color}_size_${variant.size}"
												type="text" class="form-control" value="${variant.image3}">
											<label>Image URL 4</label> <input
												name="image4_${variant.color}_size_${variant.size}"
												type="text" class="form-control" value="${variant.image4}">
										</div>
									</c:forEach>
								</div>
							</div>

							<div class="form-group">
								<input type="button" class="btn btn-default" value="Cancel"
									onclick="window.location.href='manager'"> <input
									type="submit" class="btn btn-success" value="Save">
							</div>


						</div>

					</form>
				</div>
			</div>
		</div>

	</div>

	<script>
		setTimeout(function() {
			var errorAlert = document.getElementById('errorAlert');
			if (errorAlert) {
				errorAlert.style.display = 'none';
			}
		}, 3000);
	</script>

	<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>