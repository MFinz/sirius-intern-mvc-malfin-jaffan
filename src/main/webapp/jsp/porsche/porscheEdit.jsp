<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> CRUD Porsche </title>
    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"> 
    <link href="/webjars/bootstrap-icons/1.11.2/font/bootstrap-icons.css" rel="stylesheet">
</head>

<body>
    
    <nav class="navbar navbar-expand-lg bg-primary">
        <div class="container-fluid">
          <a class="navbar-brand text-white" href="/porsche">CRUD Porsche</a>
          
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="container-fluid"></div>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">

        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="/mobil/view">Mobil</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="/sedan/view">Sedan</a>
        </li>

        <li class="nav-item">
            <a class="nav-link active" href="/porsche/view">Porsche</a>
          </li>
      </ul>
          </div>
        </div>
      </nav>

      <div class="container">
        <br>    
        <h4> Edit Porsche</h4>
        <div>
          <form method="post" action="<c:url value='/porsche/update'/>">
                
                <input type="hidden" class="form-control bg-light" name="id" value="${porsche.id}">
                
                <div class="form-group">
                  <label>Pilih Mobil</label>
                  <select class="form-control bg-light" name="mobil.id">
                      <c:forEach var="mobil" items="${mobils}">
                          <option value="${mobil.id}" <c:if test="${mobil.id eq porsche.mobil.id}">selected</c:if>>
                              <c:out value="${mobil.merek}" />&nbsp;<c:out value="${mobil.model}" />&nbsp;<c:out value="${mobil.tahunProduksi}" />
                          </option>
                      </c:forEach>
                  </select>
              </div>
              <br>


                <div class="form-group">
                    <label>Kecepatan Maksimal</label>
                    <input type="number" class="form-control bg-light" name="kecepatanMaksimal" value="${porsche.kecepatanMaksimal}" min="1" max="999">
                </div>
                <br>

                <div class="form-group">
                    <label>Tipe Mesin</label>
                    <input type="text" class="form-control bg-light" name="tipeMesin" value="${porsche.tipeMesin}" maxlength="5">
                </div>
                <br>

                <p align="right">
                    <a class="btn btn-dark" href="/porsche/view">Kembali</a>
                    <button class="btn btn-primary" type="submit">Kirim</button>
                </p>

            </form>

           
        </div>
      </div>

    <script src="/webjars/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</body>
</html>