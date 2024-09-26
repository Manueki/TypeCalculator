<html>
<head>
    <%@include file="configuracionesHead.jspf"%>
    <%@ page import="DAO.CombType"%>
    <link rel="stylesheet" href="styles.css"> <!-- Enlace al archivo CSS -->
</head>
<body>
    <div class="header">
        <header class="d-flex flex-wrap justify-content-center mt-1 mb-0">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                <svg class="bi me-2" width="40" height="32">
                    <use xlink:href="#bootstrap"></use>
                </svg>
                <span class="tituloApp">Pokemon Type Calculator    </span>
            </a>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="#" class="nav-link active" aria-current="page">Calculadora</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Configuración</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Info</a></li>
            </ul>
        </header>
    </div>
    <h1>Elige hasta dos tipos de Pokémon</h1>
    
    <div class="container mt-4">
    <div class="row" id="pokemon-types">
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Normal w-100 text-truncate" onclick="selectType('Normal', event)">Normal</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Agua w-100 text-truncate" onclick="selectType('Agua', event)">Agua</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Fuego w-100 text-truncate" onclick="selectType('Fuego', event)">Fuego</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Planta w-100 text-truncate" onclick="selectType('Planta', event)">Planta</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Eléctrico w-100 text-truncate" onclick="selectType('Eléctrico', event)">Eléctrico</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Tierra w-100 text-truncate" onclick="selectType('Tierra', event)">Tierra</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Hielo w-100 text-truncate" onclick="selectType('Hielo', event)">Hielo</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Psíquico w-100 text-truncate" onclick="selectType('Psíquico', event)">Psíquico</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Roca w-100 text-truncate" onclick="selectType('Roca', event)">Roca</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Bicho w-100 text-truncate" onclick="selectType('Bicho', event)">Bicho</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Siniestro w-100 text-truncate" onclick="selectType('Siniestro', event)">Siniestro</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Hada w-100 text-truncate" onclick="selectType('Hada', event)">Hada</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Fantasma w-100 text-truncate" onclick="selectType('Fantasma', event)">Fantasma</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Volador w-100 text-truncate" onclick="selectType('Volador', event)">Volador</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Acero w-100 text-truncate" onclick="selectType('Acero', event)">Acero</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Lucha w-100 text-truncate" onclick="selectType('Lucha', event)">Lucha</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Veneno w-100 text-truncate" onclick="selectType('Veneno', event)">Veneno</button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-2">
            <button class="btn Dragón w-100 text-truncate" onclick="selectType('Dragón', event)">Dragón</button>
        </div>
    </div>
	</div>
    <p id="selected-types"></p>

    <script>
        let selectedTypes = [];

        function selectType(type, event) {
            const index = selectedTypes.indexOf(type);
            const button = event.target;

            if (index === -1) {
                if (selectedTypes.length < 2) {
                    selectedTypes.push(type);
                    button.classList.add('selected');
                } else {
                    alert("Ya has seleccionado dos tipos.");
                }
            } else {
                selectedTypes.splice(index, 1);
                button.classList.remove('selected');
            }

            document.getElementById('selected-types').innerText = "Tipos seleccionados: " + selectedTypes.join(', ');

            // Enviar tipos seleccionados (uno o dos)
            enviarTipos(selectedTypes);
        }

        // Función para enviar los tipos seleccionados al servidor
        function enviarTipos(selectedTypes) {
            let dataToSend = {};

            if (selectedTypes.length === 1) {
                dataToSend = { tipo1: selectedTypes[0] };
            } else if (selectedTypes.length === 2) {
                dataToSend = { tipo1: selectedTypes[0], tipo2: selectedTypes[1] };
            }

            fetch('/type_calculator/calDefensa', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataToSend)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta de la red');
                }
                return response.json();
            })
            .then(combType => {
                // Actualiza la interfaz de usuario con los datos recibidos
                let output = "Tipo: ";
                
                if (combType.tipo2 && combType.tipo2 === combType.tipo1) {
                    output += generarListaDeTipos([combType.tipo1]);
                } else {
                    output += generarListaDeTipos([combType.tipo1, combType.tipo2]);
                }

                output += "<div class='row' id='pokemon-types'><div class='col-md-1'></div><div class='col-md-5'>";
                output += "<br><br>Defensivamente:<br>";
                output += " <div class='container'> <h2> Sufre x4: </h2><div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.superDebilidades) + "<br></div></div>";
                output += "<div class='container'> <h2> Sufre x2: </h2><div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.debilidades) + "<br></div></div>";
                output += "<div class='container'>Daño normal:   <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.danoNormal) + "<br></div></div>";
                output += "Resiste x0.5: <div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.resistencias) + "<br></div></div>";
                output += "Resiste x0.25: <div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.superResistencias) + "<br></div></div>";
                output += "Inmune: <div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.inmunidades) + "<br></div></div></div>";

                output += "<div class='col-md-5'>";
                output += "<br><br>Ofensivamente:<br>";
                output += "Fuerte contra:  <div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.fuerteContra) + "<br></div></div>";
                output += "Débil contra:  <div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.debilContra) + "<br></div></div>";
                output += "Inmune contra:  <div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.inmuneContra) + "<br></div></div>";
                output += "Normal contra:  <div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.normalContra) + "<br></div></div></div><div class='col-md-1'></div></div>";

                document.getElementById('selected-types').innerHTML = output;
            })
            .catch(error => {
                console.error('Error al enviar los tipos:', error);
            });
        }

        // Función para generar los botones o spans estilizados con las clases de tipo
        function generarListaDeTipos(tipos) {
        	if (tipos.length === 0) return "Ninguna";

            return tipos.map(tipo => {
                if (tipo) { // Asegura que el tipo no sea undefined o null
                    return `<div class="col-12 col-sm-6 col-md-4 col-lg-2"> <span class="btn ${tipo} w-100 text-truncate">${tipo}</span> </div>`;
                }
            }).join(' ');
        }
    </script>
</body>
</html>