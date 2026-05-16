<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
    body {
	        background: #f0f2f5;
	        display: flex;
	        justify-content: center;
	        align-items: center;
	        height: 100vh;
	        margin: 0;
	        font-family: Arial, sans-serif;
    	}

    	.card {
	        background: white;
	        padding: 40px;
	        border-radius: 8px;
	        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
	        width: 350px;
    	}
    	/* Titulo */
    	h2 {
		    margin-bottom: 24px;
		    font-size: 22px;
		}
		/* Campos usuario y contraseña */
		label {
		    font-size: 13px;
		    color: #555;
		}
		/* Contraseña y texto */
		input[type=text], input[type=password] {
		    width: 100%;
		    padding: 10px;
		    margin: 6px 0 16px 0;
		    border: 1px solid #ccc;
		    border-radius: 4px;
		    font-size: 14px;
		}
		/* Boton ingresar */
		input[type=submit] {
		    width: 100%;
		    padding: 10px;
		    background: #1a73e8;
		    color: white;
		    border: none;
		    border-radius: 4px;
		    font-size: 15px;
		    cursor: pointer;
		}
		/* hover boton */
		input[type=submit]:hover {
		    background: #1558b0;
		}
</style>
</head>

<body>
	<div class="card">
		<h2>Iniciar sesión</h2>
		<form action="ServletUsuario" method="post">
		    <label>Usuario</label>
		    <input type="text" name="txtUsuario" />
    
		    <label>Contraseña</label>
		    <input type="password" name="txtContrasena" />
    
    		<input type="submit" name="btnIngresar" value="Ingresar" />
		</form>
	</div>
</body>
</html> 
