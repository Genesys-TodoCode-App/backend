import { useState } from 'react'
import './agregarcompradorstyles.scss'
import Navbar from '../../components/navbar/Navbar'
import Footer from '../../components/footer/Footer'

const AgregarComprador = () => {
  
  const initialState = {
    "Id Comprador": 0,
    "Nombre Comprador": "",
    "Apellido Comprador": "",
    "DNI Comprador": "",
    "Correo Electronico Comprador": "",
    "Pase de Oro": false
  }

  const [comprador, setComprador] = useState(initialState)

  const  handleChange = (e) => {
    setComprador({
      ...comprador,
      [e.target.name]: e.target.value
    })
  }

  const postComprador = 'http://localhost:8080/compradores'

  const handleSubmit = (e) => {
    e.preventDefault()

    try {
      fetch(postComprador, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(comprador)
      })
      .then( async (response) => {
        if(response.ok) {
          setComprador(initialState)
          alert('Se agrego el comprador: ' + comprador["Nombre Comprador"] + ' ' + comprador["Apellido Comprador"])
        } else {
          console.log('Hay un error no se donde')
        }
      })
      .catch((err) => {
        console.log('Error: ', err)
      })  
    } catch (error) {
      console.log('Hubo un error: ', error)
    }
  }

  return (
    <main className='agregarComprador_container'>
      <Navbar type={'empleadoAdministrativo'}/>
      <h1>Agregar Comprador</h1>
      <form className='agregarComprador_form' onSubmit={e => handleSubmit(e)}>
        <label htmlFor="nombreComprador">Nombre:</label>
        <input className='form_field' type="text" id="nombreComprador" name="Nombre Comprador" value={comprador["Nombre Comprador"]} onChange={ e => handleChange(e)} />

        <label htmlFor="apellidoComprador">Apellido:</label>
        <input className='form_field' type="text" id="apellidoComprador" name="Apellido Comprador" value={comprador["Apellido Comprador"]} onChange={ e => handleChange(e)} />

        <label htmlFor="dniComprador">DNI:</label>
        <input className='form_field' type="number" id="dniComprador" name="DNI Comprador" value={comprador["DNI Comprador"]} onChange={ e => handleChange(e)} />

        <label htmlFor="correoElectronicoComprador">Email:</label>
        <input className='form_field' type="email" id="correoElectronicoComprador" name="Correo Electronico Comprador" value={comprador["Correo Electronico Comprador"]} onChange={ e => handleChange(e)} />

        <label htmlFor="paseDeOro">Pase de Oro:</label>
        <input className='form_field' type="checkbox" id="paseDeOro" name="Pase de Oro" value={comprador["Pase de Oro"]} onChange={ e => handleChange(e)} />

        <button className='btn' type='submit'>Agregar Comprador</button>
      </form>
      <Footer />
    </main>
  )
}

export default AgregarComprador