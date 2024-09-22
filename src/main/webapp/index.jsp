<html>
<head>
	<%@include file="configuracionesHead.jspf" %>
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
        <span class="fs-4"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Pokemon Type Calculator</font></font></span>
      </a>

      <ul class="nav nav-pills">
        <li class="nav-item"><a href="#" class="nav-link active" aria-current="page"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Calculadora</font></font></a></li>
        <li class="nav-item"><a href="#" class="nav-link"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Configuración</font></font></a></li>
        <li class="nav-item"><a href="#" class="nav-link"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Info</font></font></a></li>
      </ul>
    </header>
  </div>
  
  <html lang="es">
<head>

    <h1>Elige hasta dos tipos de Pokémon</h1>
    <div id="pokemon-types">
         <button class="btn Agua" onclick="selectType('Agua')">Agua</button>
        <button class="btn Fuego" onclick="selectType('Fuego')">Fuego</button>
        <button class="btn Planta" onclick="selectType('Planta')">Planta</button>
        <button class="btn Eléctrico" onclick="selectType('Eléctrico')">Eléctrico</button>
        <button class="btn Tierra" onclick="selectType('Tierra')">Tierra</button>
        <button class="btn Hielo" onclick="selectType('Hielo')">Hielo</button>
        <!-- Agrega más tipos según sea necesario -->
    </div>
    <p id="selected-types"></p>

    <script>
        let selectedTypes = [];

        function selectType(type) {
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
        }
    </script>
</body>
</html>

