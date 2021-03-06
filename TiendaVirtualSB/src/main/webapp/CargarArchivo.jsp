<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="Proyecto de entrenamiento en desarrollo web" />
        <meta name="author" content="Ing. Diego Rodriguez" />
        <title>Insertar Usuario</title>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
            crossorigin="anonymous">
        </script>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
    </head>
    
    <body class="sb-nav-fixed sb-sidenav-toggled">
    <div >
        <main>
            <div>
                <h1>Insertar archivo de productos</h1>
            </div>
            <form id="form1">
                <div>
                    <label for="formFileLg">Seleccionar archivo CSV con el inventario de productos</label>
                    </p>
                    <input id="archivo" type="file" accept=".csv">
                    </p>
                    <button type="button" onclick="subirArchivo()">Subir archivo</button>
                </div>
            </form>
        </main>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script>includeHTML();</script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script>
        function subirArchivo() {
            try {
                var csvFile = document.getElementById("archivo");
                var input = csvFile.files[0];
                var reader = new FileReader();
                reader.onload = function(e) {
                    var text = e.target.result;
                    var arrayLineas = text.split("\n");
                    var xhr = new XMLHttpRequest();
                    //xhr.open("DELETE",
                      //    "http://localhost:8080/eliminartodoproducto", true);
                    //xhr.send();
                    
                    
                     for (var i = 0; i < arrayLineas.length; i += 1) {
                        var arraydatos = arrayLineas[i].split(";");
                        if (arrayLineas[i] == "") {
                            continue;
                        }
                        for (var j = 0; j < arraydatos.length; j += 1) {
                            console.log(i + " " + j + "->" + arraydatos[j]);
                        }
                        var formData = new FormData();
                        formData.append("codigo_producto", arraydatos[0]);
                        formData.append("ivacompra", arraydatos[1]);
                        formData.append("nit_proveedor", arraydatos[2]);
                        formData.append("nombre_producto", arraydatos[3]);                        
                        formData.append("precio_compra", arraydatos[4]);                        
                        formData.append("precioventa", arraydatos[5]);
                        var xhr = new XMLHttpRequest();
                        xhr.open("POST",
                                "http://localhost:8080/registrarProducto");
                        xhr.send(formData);
                    }
                    
                    
                    var element = document.getElementById("error");
                    element.classList.add("visually-hidden");
                    var element2 = document.getElementById("correcto");
                    element2.classList.remove("visually-hidden");
                    document.getElementById("archivo").value = "";
                };
                reader.readAsText(input);
            } catch (error) {
                var element = document.getElementById("error");
                element.classList.remove("visually-hidden");
                var element2 = document.getElementById("correcto");
                element2.classList.add("visually-hidden");
                document.getElementById("archivo").value = "";
            }
        }
    </script>
</html>