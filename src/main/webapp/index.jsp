<html>
<head>
<%@include file="configuracionesHead.jspf"%>
<%@ page import="com.pokemontypecalculator.model.CombType"%>
<link rel="stylesheet" href="styles.css">
<!-- Enlace al archivo CSS -->

</head>
<body>
	<div class="header">
		<header class="d-flex flex-wrap justify-content-center mt-1 mb-0">
			<a href="/"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
				<svg class="bi me-2" width="40" height="32">
                    <use xlink:href="#bootstrap"></use>
                </svg> <span class="tituloApp">Pokemon Type Calculator</span>
			</a>

			<ul class="nav nav-pills">
				<li class="nav-item"><a href="/type_calculator"
					class="nav-link active" aria-current="page">Calculadora</a></li>
				<!-- <li class="nav-item"><a href="#" class="nav-link">Configuración</a></li> -->
				<li class="nav-item"><a href="/type_calculator/versiones"
					class="nav-link">Versiones</a></li>
			</ul>
			<script>
        // Función para cargar los Pokémon usando PokeAPI y ordenarlos alfabéticamente
        async function cargarPokemon() {
            try {
                const response = await fetch('https://pokeapi.co/api/v2/pokemon?limit=1200');
                const data = await response.json();
                
                // Ordenar los resultados alfabéticamente
                const pokemonOrdenado = data.results.sort((a, b) => {
                    return a.name.localeCompare(b.name);
                });

                // Seleccionar el dropdown en el HTML
                const pokemonDropdown = document.getElementById("pokemon");

                // Iterar sobre los resultados ordenados y agregar opciones al dropdown
                pokemonOrdenado.forEach(pokemon => {
                    let option = document.createElement("option");
                    option.value = pokemon.name;
                    option.text = pokemon.name.charAt(0).toUpperCase() + pokemon.name.slice(1);
                    pokemonDropdown.appendChild(option);
                });
            } catch (error) {
                console.error("Error al cargar los Pokémon: ", error);
            }
        }

        function traducirTipo(tipoIngles) {
    	    let tipoEspanol;
    	    switch (tipoIngles.toLowerCase()) {  // Convertimos el tipo a minúsculas para asegurar coincidencias
    	        case 'normal':
    	            tipoEspanol = 'Normal';
    	            break;
    	        case 'fire':
    	            tipoEspanol = 'Fuego';
    	            break;
    	        case 'water':
    	            tipoEspanol = 'Agua';
    	            break;
    	        case 'electric':
    	            tipoEspanol = 'Eléctrico';
    	            break;
    	        case 'grass':
    	            tipoEspanol = 'Planta';
    	            break;
    	        case 'ice':
    	            tipoEspanol = 'Hielo';
    	            break;
    	        case 'fighting':
    	            tipoEspanol = 'Lucha';
    	            break;
    	        case 'poison':
    	            tipoEspanol = 'Veneno';
    	            break;
    	        case 'ground':
    	            tipoEspanol = 'Tierra';
    	            break;
    	        case 'flying':
    	            tipoEspanol = 'Volador';
    	            break;
    	        case 'psychic':
    	            tipoEspanol = 'Psíquico';
    	            break;
    	        case 'bug':
    	            tipoEspanol = 'Bicho';
    	            break;
    	        case 'rock':
    	            tipoEspanol = 'Roca';
    	            break;
    	        case 'ghost':
    	            tipoEspanol = 'Fantasma';
    	            break;
    	        case 'dragon':
    	            tipoEspanol = 'Dragón';
    	            break;
    	        case 'dark':
    	            tipoEspanol = 'Siniestro';
    	            break;
    	        case 'steel':
    	            tipoEspanol = 'Acero';
    	            break;
    	        case 'fairy':
    	            tipoEspanol = 'Hada';
    	            break;
    	        default:
    	            tipoEspanol = 'null';
    	    }
    	    return tipoEspanol;
    	}
        
     // Función para mostrar el Pokémon seleccionado y su tipo
        async function mostrarPokemonSeleccionado() {
            const pokemonSeleccionado = document.getElementById("pokemon").value;
            const resultadoDiv = document.getElementById("resultado");

            if (pokemonSeleccionado) {
                try {
                    // Hacer otra solicitud para obtener los detalles del Pokémon seleccionado
                    const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonSeleccionado}`);
                    const data = await response.json();
                    
                    let selectedTypes = [];
                    
                    // Obtener los tipos del Pokémon y almacenarlos en variables
                    let tipo1 = null;
                    let tipo2 = null;

                    if (data.types.length > 0) {
                        selectedTypes.push(traducirTipo(data.types[0].type.name)); // Primer tipo
                    }
                    if (data.types.length > 1) {
                        selectedTypes.push(traducirTipo(data.types[1].type.name)); // Segundo tipo (si lo tiene)
                    }
                    
                    mostrarImagen(data.sprites.front_default);
                    enviarTipos(selectedTypes);
                    
                } catch (error) {
                    console.error("Error al obtener detalles del Pokémon: ", error);
                    resultadoDiv.innerHTML = `<p>Error al cargar los detalles del Pokémon.</p>`;
                }
            } else {
                resultadoDiv.innerHTML = "<p>No has seleccionado ningún Pokémon.</p>";
            }
        }

        // Cargar Pokémon cuando el documento está listo
        document.addEventListener("DOMContentLoaded", cargarPokemon);

    </script>
		</header>
	</div>
	<h1>&emsp; Elige hasta dos tipos de Pokémon</h1>
	<div class="container mt-4">

		<div class="row" id="pokemon-types">
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Normal w-100 text-truncate"
					onclick="selectType('Normal', event)">Normal</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Fuego w-100 text-truncate"
					onclick="selectType('Fuego', event)">Fuego</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Agua w-100 text-truncate"
					onclick="selectType('Agua', event)">Agua</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Eléctrico w-100 text-truncate"
					onclick="selectType('Eléctrico', event)">Eléctrico</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Planta w-100 text-truncate"
					onclick="selectType('Planta', event)">Planta</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Hielo w-100 text-truncate"
					onclick="selectType('Hielo', event)">Hielo</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Lucha w-100 text-truncate"
					onclick="selectType('Lucha', event)">Lucha</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Veneno w-100 text-truncate"
					onclick="selectType('Veneno', event)">Veneno</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Tierra w-100 text-truncate"
					onclick="selectType('Tierra', event)">Tierra</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Volador w-100 text-truncate"
					onclick="selectType('Volador', event)">Volador</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Psíquico w-100 text-truncate"
					onclick="selectType('Psíquico', event)">Psíquico</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Bicho w-100 text-truncate"
					onclick="selectType('Bicho', event)">Bicho</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Roca w-100 text-truncate"
					onclick="selectType('Roca', event)">Roca</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Fantasma w-100 text-truncate"
					onclick="selectType('Fantasma', event)">Fantasma</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Dragón w-100 text-truncate"
					onclick="selectType('Dragón', event)">Dragón</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Siniestro w-100 text-truncate"
					onclick="selectType('Siniestro', event)">Siniestro</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Acero w-100 text-truncate"
					onclick="selectType('Acero', event)">Acero</button>
			</div>
			<div class="col-12 col-sm-6 col-md-4 col-lg-2">
				<button class="btn Hada w-100 text-truncate"
					onclick="selectType('Hada', event)">Hada</button>
			</div>
		</div>
	</div>

	<h1>Selecciona tu Pokémon</h1>
	<!-- Formulario para elegir un Pokémon -->
	<form id="pokemonForm"
		onsubmit="event.preventDefault(); mostrarPokemonSeleccionado();">
		<label for="pokemon">Elige un Pokémon:</label> <select id="pokemon"
			name="pokemon">
			<option value="">--Selecciona un Pokémon--</option>
			<!-- Las opciones serán llenadas dinámicamente por JavaScript -->
		</select> <br>
		<br> <input type="submit" value="Mostrar">
	</form>

	<!-- Div donde se mostrará el resultado -->
	<div id="resultado"></div>
	<img id="pokemonImg">	
	<p id="selected-types"></p>
<body>


	<!-- SCRIPT ELEGIR TIPOS -->
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

    fetch('/type_calculator/calType', {
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
        // Verifica si tipo1 es null
        if (combType.tipo1 === "null") {
            // Si tipo1 es null, muestra un mensaje en el HTML
            document.getElementById('selected-types').innerHTML = "<h1>No se ha seleccionado ningún tipo.</h1>";
            return; // Sale de la función para no continuar
        }

        // Actualiza la interfaz de usuario con los datos recibidos
        let output = "<br> <div class='row' id='nombreTipos'>";

        if (combType.tipo2 && combType.tipo2 === combType.tipo1) {
            output += generarListaDeTipos(['<h1>Tipo:</h1>', combType.tipo1]);
        } else {
            output += generarListaDeTipos(['<h1>Tipo:</h1>', combType.tipo1, combType.tipo2]);
        }
        
        output += "<br></div>";
        output += "<div class='row' id='pokemon-types'><div class='col-md-1'></div><div class='col-md-5'>";
        output += "<br><br><h1>Defensivamente:</h1>";
        output += "<br><h2>Sufre x4: </h2><div class='container'><div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.superDebilidades) + "<br></div></div>";
        output += "<br><h2>Sufre x2: </h2><div class='container'><div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.debilidades) + "<br></div></div>";
        output += "<br><h2>Resiste x0.5: </h2><div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.resistencias) + "<br></div></div>";
        output += "<br><h2>Resiste x0.25: </h2><div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.superResistencias) + "<br></div></div>";
        output += "<br><h2>Inmune: </h2><div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.inmunidades) + "<br></div></div>";
        output += "<br><h2>Daño normal: </h2><div class='container'><div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.danoNormal) + "<br></div></div></div>";

        output += "<div class='col-md-5'>";
        output += "<br><br><h1>Ofensivamente:</h1>";
        output += "<br><h2>Muy eficaz contra:  </h2><div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.fuerteContra) + "<br></div></div>";
        output += "<br><h2>Poco Eficaz contra:  </h2><div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.debilContra) + "<br></div></div>";
        output += "<br><h2>Inmune contra:  </h2><div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.inmuneContra) + "<br></div></div>";
        output += "<br><h2>Eficaz contra:  </h2><div class='container'> <div class='row' id='pokemon-types'>" + generarListaDeTipos(combType.normalContra) + "<br></div></div></div><div class='col-md-1'></div></div>";

        document.getElementById('selected-types').innerHTML = output;
    })
    .catch(error => {
        console.error('Error al enviar los tipos:', error);
    });
}

        // Función para generar los botones o spans estilizados con las clases de tipo
        function generarListaDeTipos(tipos) {
        	if (tipos.length === 0) return "No presenta";

            return tipos.map(tipo => {
                if (tipo) { // Asegura que el tipo no sea undefined o null
                    return `<div class="col-12 col-sm-6 col-md-4 col-lg-2"> <span class="btn ${tipo} w-100 text-truncate">${tipo}</span> </div>`;
                }
            }).join(' ');
        }
    </script>
    <script>
    function mostrarImagen(url) {
        // Crear un nuevo elemento de imagen
        const imagen = document.getElementById("pokemonImg");

        // Establecer la fuente de la imagen a la URL proporcionada
        imagen.src = url;
    }
    </script>

</body>
</html>