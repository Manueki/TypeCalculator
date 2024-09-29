<html>
<head>
    <%@include file="configuracionesHead.jspf"%>
    <%@ page import="com.pokemontypecalculator.model.CombType"%>
    <link rel="stylesheet" href="styles.css"> <!-- Enlace al archivo CSS -->
</head>
<body>
    <div class="header">
        <header class="d-flex flex-wrap justify-content-center mt-1 mb-0">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                <svg class="bi me-2" width="40" height="32">
                    <use xlink:href="#bootstrap"></use>
                </svg>
                <span class="tituloApp">Pokemon Type Calculator</span>
            </a>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="/type_calculator" class="nav-link active" aria-current="page">Calculadora</a></li>
                <!-- <li class="nav-item"><a href="#" class="nav-link">Configuraci�n</a></li> -->
                <li class="nav-item"><a href="/type_calculator/versiones" class="nav-link">Versiones</a></li>
            </ul>
        </header>
    </div>
    <h1> &emsp; Pok�mon Type Calculator - Historial de versiones.</h1>
    <div class="container mt-4">

    <h2>Versi�n 0.1.0-beta - "Calculadora de Tipos Pok�mon"</h2>

    <p><strong>Fecha de lanzamiento:</strong> 29/09/2024</p>

    <h3>Nuevas caracter�sticas:</h3>
    <ul>
        <li><strong>Creaci�n de la Aplicaci�n Web:</strong> Se ha desarrollado y lanzado la primera versi�n de la aplicaci�n web "Calculadora de Tipos Pok�mon", dise�ada para ofrecer una experiencia de usuario intuitiva y accesible.</li>
        <li><strong>C�lculo de Efectividades de Tipos:</strong> Los usuarios pueden calcular las efectividades de los tipos Pok�mon, lo que incluye la selecci�n de un �nico tipo o la combinaci�n de dos tipos para obtener resultados sobre sus interacciones defensivas y ofensivas.</li>
        <li><strong>Cobertura de Tipos:</strong> La aplicaci�n proporciona a los usuarios informaci�n sobre las coberturas de tipos Pok�mon, detallando las fortalezas y debilidades de los tipos seleccionados.</li>
    </ul>

    <h3>Notas:</h3>
    <p>Esta versi�n beta es una fase inicial, y se anima a los usuarios a proporcionar comentarios y sugerencias para futuras mejoras y correcciones.</p>
    	
    <br><br><p> By Manuel Pardal</p>
	
	</div>

</body>
</html>