<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menú Principal</title>
    <style>
        body {
            background-color: #013220; /* Color petróleo */
            color: #ffffff;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            background-color: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.2);
        }
        h1 {
            margin-bottom: 20px;
        }
        nav {
            margin-top: 20px;
        }
        nav a {
            display: block;
            background-color: #028A3D;
            color: white;
            text-decoration: none;
            padding: 10px;
            border-radius: 5px;
            margin: 10px 0;
            font-size: 18px;
            transition: background 0.3s;
        }
        nav a:hover {
            background-color: #02632A;
        }
    </style>
</head>
<body>
<div class="container">
        <h1>Bienvenido a ERP-SOLUTIONPERU S.A.C</h1>
        <h3>Proveedor</h3>
        <nav>
            <a href="ControladorProveedor?accion=Registrar">Registrar Proveedor</a>
            <a href="ControladorProveedor?accion=Listar">Listar Proveedores</a>
            <a href="ControladorProveedor?accion=Buscar">Editar Proveedor</a>
            <a href="ControladorProveedor?accion=Actualizar">Actualizar Proveedor</a>
            <a href="ControladorProveedor?accion=Eliminar">Eliminar Proveedor</a>
            <a href="index.jsp">Menu Principal</a>
        </nav>

</body>
</html>