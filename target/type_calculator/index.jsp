<html>
<head>
<%@include file="configuracionesHead.jspf"%>
</head>
<body>
	<div class="container">
		<header
			class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
			<a href="/"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
				<svg class="bi me-2" width="40" height="32">
                    <use xlink:href="#bootstrap"></use></svg> <span
				class="fs-4">Pokemon Type Calculator</span>
			</a>

			<ul class="nav nav-pills">
				<li class="nav-item"><a href="#" class="nav-link active"
					aria-current="page">Calculadora</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Configuración</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Info</a></li>
			</ul>
		</header>
	</div>
	<h1>Elige hasta dos tipos de Pokémon</h1>
	<div id="pokemon-types">
    <button class="btn Agua" onclick="selectType('Agua', event)">Agua</button>
    <button class="btn Fuego" onclick="selectType('Fuego', event)">Fuego</button>
    <button class="btn Planta" onclick="selectType('Planta', event)">Planta</button>
    <button class="btn Eléctrico" onclick="selectType('Eléctrico', event)">Eléctrico</button>
    <button class="btn Tierra" onclick="selectType('Tierra', event)">Tierra</button>
    <button class="btn Hielo" onclick="selectType('Hielo', event)">Hielo</button>
    <button class="btn Psíquico" onclick="selectType('Psíquico', event)">Psíquico</button>
    <button class="btn Roca" onclick="selectType('Roca', event)">Roca</button>
    <button class="btn Bicho" onclick="selectType('Bicho', event)">Bicho</button>
    <button class="btn Siniestro" onclick="selectType('Siniestro', event)">Siniestro</button>
    <button class="btn Hada" onclick="selectType('Hada', event)">Hada</button>
    <button class="btn Fantasma" onclick="selectType('Fantasma', event)">Fantasma</button>
    <button class="btn Vuelo" onclick="selectType('Vuelo', event)">Vuelo</button>
    <button class="btn Acero" onclick="selectType('Acero', event)">Acero</button>
    <button class="btn Lucha" onclick="selectType('Lucha', event)">Lucha</button>
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

            fetch('/type_calculator/calDefensa', { // Usa la ruta correcta aquí
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
            .then(data => {
                console.log('Respuesta del servidor:', data);
            })
            .catch(error => {
                console.error('Error al enviar los tipos:', error);
            });
        }
    </script>
</body>
</html>
