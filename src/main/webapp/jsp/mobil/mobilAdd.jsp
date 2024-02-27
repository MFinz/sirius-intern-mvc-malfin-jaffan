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
        <h4> Tambah Mobil</h4>
        <div>
          <form method="post" action="<c:url value='/mobil/save'/>">
  
                <div class="form-group">
                  <label>Merek</label>
                  <input type="text" class="form-control bg-light" name="mobil.merek" value="${mobilAdapter.mobil.merek}" maxlength="25" required>
              </div>
              <br>


              <div class="form-group">
                  <label>Model</label>
                  <input type="text" class="form-control bg-light" name="mobil.model" value="${mobilAdapter.mobil.model}" maxlength="25" required>
              </div>
              <br>

              <div class="form-group">
                  <label>Tahun Produksi</label>
                  <input type="number" class="form-control bg-light" name="mobil.tahunProduksi" value="${mobilAdapter.mobil.tahunProduksi}" min="1800" max="2100" required>
              </div>
              <br>

              <div class="form-group">
                  <label>Jumlah Pintu</label>
                  <input type="number" class="form-control bg-light" name="mobil.jumlahPintu" value="${mobilAdapter.mobil.jumlahPintu}" min="1" max="9" required>
              </div>
              <br>

              <div class="form-group">
                  <label>Harga</label>
                  <input type="number" class="form-control bg-light" name="mobil.harga" value="${mobilAdapter.mobil.harga}" maxlength="10" required> 
              </div>
              <br>

              <div class="card">
              <div class="card-header">
                Warna
              </div>
              <br>
              <div class="container-fluid">

            <div class="form-group" id="formGroupWarna">
                
                <div class="d-flex align-items-center mb-2">

                 <input type="hidden" id="indexDetail" value="0">
                  
                  <label class="me-2 ms-2">Nama</label>
                  <select class="form-control bg-light me-2" name="detailMobilAdapters[${fn:length(mobilAdapter.mobil.detailmobils)}].idWarna"  id="idWarnas" required>
                        <c:forEach var="warna" items="${warnas}">
                            <option value="${warna.id}">${warna.namaWarna}</option>
                        </c:forEach>
                  </select>
                    
                  <label class="me-2 ms-2">Tipe</label>
                    <input type="text" class="form-control bg-light me-2" name="detailMobilAdapters[${fn:length(mobilAdapter.mobil.detailmobils)}].tipeWarna" placeholder='Isi "-" apabila tidak ada tipe warna' required>
                   
                    <label class="me-2 ms-2">Deskripsi</label>
                    <input type="text" class="form-control bg-light me-2" name="detailMobilAdapters[${fn:length(mobilAdapter.mobil.detailmobils)}].deskripsi" placeholder='Isi "-" apabila tidak ada deskripsi' required>
                    <button type="button" class="btn btn-primary" onclick="tambahFormWarna()" id="tambahButton"><i class="bi bi-plus-circle-fill"></i></button>

                </div>
                <br>
                
            </div>
            

            <div id="warnaContainer"></div>

          </div>
            </div>
                
              <div class="fixed-bottom">
                <div class="container-fluid">
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            ${error}
                            <button type="button" class="btn-close float-end" data-bs-dismiss="alert" onclick="closeAlert()"></button>
                        </div>
                    </c:if>
                </div>
              </div>

                <p align="right">
                    <a class="btn btn-dark" href="/mobil/view">Kembali</a>
                    <button class="btn btn-primary" type="submit">Kirim</button>
                </p>

            </form>

        </div>
      </div>

    <script src="/webjars/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script>
      function tambahFormWarna() {
          // Mendapatkan elemen form-group warna
          var formGroupWarna = document.getElementById('formGroupWarna');

          var lastIndex = parseInt(document.getElementById('indexDetail').value)

          lastIndex++;

          document.getElementById('indexDetail').value = lastIndex;

          // Label 1
          var newLabel = document.createElement("label");
          newLabel.className = 'me-2 ms-2';
          newLabel.innerText = "Nama";

          // Label 2
          var newLabel2 = document.createElement("label");
          newLabel2.className = 'me-2 ms-2';
          newLabel2.innerText = "Tipe";

          // Label 3 
          var newLabel3 = document.createElement("deskripsi");
          newLabel3.className = 'me-2 ms-2';
          newLabel3.innerText = "Deskripsi";
  
          // Membuat elemen select baru untuk warna
          var newSelect = document.createElement("select");
          newSelect.classList.add("form-control", "bg-light", "me-2");
          newSelect.name = 'detailMobilAdapters[' + lastIndex + '].idWarna';

          var newInput = document.createElement('input');
          newInput.type = 'text';
          newInput.className = 'form-control bg-light me-2';
          newInput.name = 'detailMobilAdapters[' + lastIndex + '].tipeWarna'; 
          newInput.placeholder =  'Isi dengan "-" jika tidak ada tipe warna';
          newInput.setAttribute('maxlength', '100');

          var newInput2 = document.createElement('input');
          newInput2.type = 'text';
          newInput2.className = 'form-control bg-light me-2';
          newInput2.name = "detailMobilAdapters[" + lastIndex + "].deskripsi";
          newInput2.placeholder =  'Isi "-" apabila tidak ada deskripsi';
          newInput2.setAttribute('maxlength', '100');
  
          // Menambahkan opsi warna dari data warnas
          <c:forEach var="warna" items="${warnas}">
            var option = document.createElement("option");
            option.value = "${warna.id}";
            option.text = "${warna.namaWarna}";
            newSelect.appendChild(option);
          </c:forEach>
          ;
  
          // Membuat tombol hapus
          var deleteButton = document.createElement("button");
          deleteButton.type = "button";
          deleteButton.classList.add("btn", "btn-danger");
          deleteButton.innerHTML = '<i class="bi bi-trash-fill"></i>';
          deleteButton.addEventListener("click", function() {
              formGroupWarna.removeChild(newDiv);
              tipeWarnasContainer.removeChild(newDiv2);
          });

          var lineBreak = document.createElement("br");
  
          // Membuat div baru untuk menampung select dan tombol hapus
          var newDiv = document.createElement("div");
          newDiv.classList.add("d-flex","align-items-center", "mb-2");
          newDiv.appendChild(newLabel);
          newDiv.appendChild(newSelect);
          newDiv.appendChild(newLabel2);
          newDiv.appendChild(newInput);
          newDiv.appendChild(newLabel3);
          newDiv.appendChild(newInput2);
          newDiv.appendChild(deleteButton);

          // Menambahkan div baru ke dalam form-group warna
          formGroupWarna.appendChild(newDiv);
          formGroupWarna.appendChild(lineBreak);
      }
  </script>
  <script>
    function closeAlert() {
        window.location.href = "/mobil/add";
    }
  </script>
</body>
</html>
