<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Almacén</title>
    <style>
        body {
            background-color: #013220; /* Color petróleo */
            color: #ffffff; /* Texto en blanco */
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            background-color: rgba(255, 255, 255, 0.1); /* Fondo semitransparente */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.2);
        }
        h2 {
            margin-bottom: 15px;
        }
        table {
            margin: auto;
            border-collapse: collapse;
            width: 100%;
        }
        td {
            padding: 10px;
            font-size: 18px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #028A3D; /* Verde oscuro */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            transition: background 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #02632A; /* Verde más oscuro */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>ERP-SOLUTIONPERU S.A.C </h2>
        <h3>Versión 1.0</h3>
        <h2>Ingresar al Sistema</h2>

        <form method="post" action="ControladorLoing">
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="usuario" required></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type="password" name="password" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Ingresar al sistema">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>