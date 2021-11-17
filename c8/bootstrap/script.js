const seccionInicio = `
<div id="home">
      <section class="container mt-4 text-center">
        <h1 class="color-miPrincipal display-2 titulo">hola mundo</h1>
        <p class="lead">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit.
          Ea culpa, consequatur quia officiis sapiente minus eius
          tempora voluptatibus delectus possimus error perspiciatis,
          quibusdam consequuntur necessitatibus voluptatum voluptatem
          aliquam corporis laborum.
        </p>
        <button class="btn btn-primary btn-miPrincipal">boton1</button>
        <button class="btn btn-outline-primary">boton2</button>
      </section>
  
      <div class="table-responsive">
        <table class="container mt-5 table table-light table-striped table-hover table-bordered">
          <tr class="table-dark titulo">
            <th>col1</th>
            <th>col2</th>
            <th>col3</th>
            <th>col4</th>
            <th>col3</th>
            <th>col4</th>
          </tr>
          <tr>
            <td>Lorem ipsum dolor sit amet consectetur adipisicing elit. Rerum nihil repellendus ex. Tenetur, eum ratione
              quod nisi assumenda, perspiciatis iusto adipisci exercitationem reprehenderit nihil enim velit? Praesentium,
              debitis? Numquam, sapiente.</td>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
          </tr>
          <tr>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
          </tr>
          <tr>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
            <td>valor1</td>
          </tr>
        </table>
      </div>
    </div>
`;
const username = "igna";
const seccionIngresar = `
<div id="login">
    <form class="container">
        <div class="mb-3">
            <label for="username" class="form-label">Ingrese su nombre de usuario</label>
            <input type="email" class="form-control" id="username" aria-describedby="emailHelp" value="${username}">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Ingrese su contraseña</label>
            <input type="password" class="form-control" id="password">
        </div>
        <button type="submit" class="btn btn-primary">Ingresar</button>
    </form>
</div>
`;

const appRoot = document.querySelector("#app-root");

const btnToInicio = document.querySelector("#goToInicio");
const btnToLogin = document.querySelector("#goToIngresar");

appRoot.innerHTML = seccionInicio

btnToInicio.addEventListener("click", () => {
    btnToInicio.className = "nav-link active"
    btnToLogin.className = "nav-link"

    appRoot.innerHTML = seccionInicio
});

btnToLogin.addEventListener("click", () => {
    btnToInicio.className = "nav-link"
    btnToLogin.className = "nav-link active"

    appRoot.innerHTML = seccionIngresar
});