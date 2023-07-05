import { useState } from 'react'
import './Login.scss'
import Footer from './components/footer/Footer'

const Login = () => {

  const initialState = {
    "Nombre Usuario": '',
    "Contrasenia Usuario": ''
  }
  const [user, setUser] = useState(initialState)

  const handleChange = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value
    });
  }

  const handleSubmit = (e) => {

    e.preventDefault();

    const loginURL = `http://localhost:8080/login?nombreUsuario=${user["Nombre Usuario"]}&contraseniaUsuario=${user["Contrasenia Usuario"]}`

    fetch(loginURL, {
      method: "POST",
      headers: { "Content-Type": "application/json" }      
    })
    .then( async (response) => {
        if(response.ok) {
          const res = await response.json()  
          setUser(initialState)
          if(res.rolEmpleado == 'EMPLEADO_JUEGO'){
            window.location.href = "juegos"
          } else {
            window.location.href = "add-buyer"
          }
        } else {
          alert('Hay un error en el Usuario o Contraseña')
        }
      })
    .catch((err) => {
      console.log('error: ', err)
    })
  } 

  return(
    <main className='login_container'>
      <h1>Bienvenido a CodeLand!</h1>
      <form className='login_form' onSubmit={handleSubmit}>

        <label htmlFor="Nombre Usuario">Usuario:</label>
        <input className='form_field' type="text" id="Nombre Usuario" name="Nombre Usuario" value={user["Nombre Usuario"]} onChange={e => handleChange(e)} />

        <label htmlFor="Contrasenia Usuario">Contraseña:</label>
        <input className='form_field' type="password" id="Contrasenia Usuario" name="Contrasenia Usuario" value={user["Contrasenia Usuario"]} onChange={e => handleChange(e)} />

        <input className='btn' type="submit" value="Enviar" />
      </form>
      <Footer />
    </main>
  )

}

export default Login
