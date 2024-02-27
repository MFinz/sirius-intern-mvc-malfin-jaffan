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
    <title> CRUD Warna </title>
    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"> 
    <link href="/webjars/bootstrap-icons/1.11.2/font/bootstrap-icons.css" rel="stylesheet">
</head>

<body>
    
    <nav class="navbar navbar-expand-lg bg-primary">
        <div class="container-fluid">
          <a class="navbar-brand text-white" href="/warna/view">CRUD Warna</a>
          
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="container-fluid"></div>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">

      </ul>
          </div>
        </div>
      </nav>

      <div class="container">
        <br>    
        <h4> Edit Warna</h4>
        <div>
          <form method="post" action="<c:url value='/warna/update'/>">

                <input type="hidden" class="form-control bg-light" name="id" value="${warna.id}">

                <div class="form-group">
                    <label>Warna</label>
                    <input type="text" class="form-control bg-light" name="namaWarna" value="${warna.namaWarna}" max="100">
                </div>
                <br>

                <p align="right">
                  <a class="btn btn-dark" href="/warna/view">Kembali</a>
                    <button class="btn btn-primary" type="submit">Kirim</button>
                </p>

            </form>

        </div>
      </div>

    <script src="/webjars/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</body>
</html>