<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- resources/templates/mobil/detail.html -->
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Detail Mobil</title>
        <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="/webjars/bootstrap-icons/1.11.2/font/bootstrap-icons.css" rel="stylesheet"> 
    </head>
    <body>

        <nav class="navbar navbar-expand-lg bg-primary">
            <div class="container-fluid">
            <a class="navbar-brand text-white" href="/mobil/view">CRUD Mobil</a>
            
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="container-fluid"></div>
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">

            <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/mobil/view">Mobil</a>
            </li>

            <li class="nav-item">
            <a class="nav-link" href="/sedan/view">Sedan</a>
            </li>

            <li class="nav-item">
                <a class="nav-link"  href="/porsche/view">Porsche</a>
            </li>
        </ul>
            </div>
            </div>
        </nav>

        <div class="container">
            <br>
            <h3><c:out value="Detail ${mobil.merek} ${mobil.model} ${mobil.tahunProduksi}" /></h3>

            <c:if test="${not empty detailMobils}">
                <table class="table table-hover caption-top">
                    <caption> Tabel Detail Mobil </caption>
                    <thead>
                        <tr class="table-dark">
                            <td> No </td>
                            <td> Warna</td>
                            <td> Tipe Warna </td>
                            <td> Deskripsi </td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="detailMobil" items="${detailMobils}" varStatus="iterStat">
                            <tr>
                                <td><c:out value="${iterStat.count}" /></td>
                                <td><c:out value="${detailMobil.warna.namaWarna}" /></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${empty detailMobil.tipeWarna}">
                                          -
                                        </c:when>
                                        <c:otherwise>
                                            <c:out value="${detailMobil.tipeWarna}" />
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td><c:out value="${detailMobil.deskripsi}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <c:if test="${empty detailMobils}">
                <p class="alert alert-danger">Tidak ada data detail mobil.</p>
            </c:if>

            <p align="right">
                <a class="btn btn-dark" href="/mobil/view">Kembali</a>
            </p>
        </div>

        <script src="/webjars/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
    </html>