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
    <title> CRUD Mobil </title>
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
            <a class="nav-link" href="/porsche/view">Porsche</a>
          </li>
      </ul>
          </div>
        </div>
      </nav>

      <div class="container">
        <br>
            <a class="btn btn-outline-dark" href="/mobil/add">Tambah</a>
            <a class="btn btn-outline-primary" href="/warna/view"> Halaman Warna</a>
        <br>
        <br>

        <c:if test="${empty mobils}">
          <p class="alert alert-danger">Tidak ada data mobil</p>
        </c:if>

        <c:if test="${not empty mobils}">
        <table class="table table-sm table-hover caption-top">
          <caption> Tabel Mobil</caption>
            <thead>
                <tr>
                    <th>No</th>
                    <th>Merek</th>
                    <th>Model</th>
                    <th>Tahun Produksi</th>
                    <th>Jumlah Pintu</th>
                    <th>Harga</th>
                    <th>Aksi</th>
                </tr>
            </thead>
            <tbody>
              <c:forEach items="${mobils}" var="mobil" varStatus="iterStat">
                <tr>
                    <td>${iterStat.count}</td>
                    <td>${mobil.merek}</td>
                    <td>${mobil.model}</td>
                    <td>${mobil.tahunProduksi}</td>
                    <td>${mobil.jumlahPintu}</td>
                    <td>Rp <fmt:formatNumber value="${mobil.harga}" pattern="#,##0" /></td>
                    <td>
                        <a class="btn btn-primary" href="/mobil/edit/${mobil.id}"><i class="bi bi-pencil-square"></i></a> <!-- Ini belum diubah -->
                        <a class="btn btn-danger" onclick="showConfirmation('${mobil.id}','${mobil.merek}','${mobil.model}','${mobil.tahunProduksi}')"><i class="bi bi-trash-fill"></i></a>
                        <a class="btn btn-dark" href="/mobil/view/${mobil.id}"><i class="bi bi-info-circle-fill"></i></a>  <!-- Ini belum diubah -->
                    </td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
        </c:if>

         <!-- Notifikasi bahwa data berhasil di tambah atau di update -->
        <div class="fixed-bottom">
          <div class="container-fluid">
              <c:if test="${not empty successMessage}">
                  <div class="alert alert-success alert-dismissible fade show" role="alert">
                    ${successMessage}
                      <button type="button" class="btn-close float-end" data-bs-dismiss="alert" onclick="closeAlert()"></button>
                  </div>
              </c:if>
          </div>
        </div>

         <!-- Notifikasi bahwa data berhasil dihapus -->
        <div class="fixed-bottom">
          <div class="container-fluid">
              <c:if test="${not empty deleteMessage}">
                  <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    ${deleteMessage}
                      <button type="button" class="btn-close float-end" data-bs-dismiss="alert" onclick="closeAlert()"></button>
                  </div>
              </c:if>
          </div>
        </div>

      </div>

      <div class="modal fade" id="deleteConfirmationModal" tabindex="-1" aria-labelledby="deleteConfirmationModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteConfirmationModalLabel">Konfirmasi Hapus</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Apakah Anda yakin ingin menghapus data ini?</p>
                    <p><b id="dataToDelete"></b></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Batal</button>
                    <a id="deleteLink" class="btn btn-danger">Hapus</a>
                </div>
            </div>
        </div>
    </div>

    <script src="/webjars/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script>
      function showConfirmation(mobilId, merekMobil, modelMobil,tahunproduksiMobil) {
          var deleteLink = document.getElementById('deleteLink');
          deleteLink.href = '/mobil/delete/' + mobilId;

          var dataToDelete = document.getElementById('dataToDelete');
          dataToDelete.innerText = 'ID Mobil: ' + mobilId + ' | ' + merekMobil + ' ' + modelMobil + ' ' + tahunproduksiMobil ;

          var deleteConfirmationModal = new bootstrap.Modal(document.getElementById('deleteConfirmationModal'));
          deleteConfirmationModal.show();
      }
    </script>
</body>
</html>