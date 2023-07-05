import { useState } from 'react'
import Footer from '../../../components/footer/Footer'
import Navbar from '../../../components/navbar/Navbar'
import './EntradasPorJuegoYFechaStyles.scss'

const EntradasPorJuegoYFecha = () => {

  const [juego, setJuego] = useState('')
  const [response, setResponse] = useState('')
  const [isLoaded, setIsLoaded] =  useState(false)
  const [juegoIDSearch, setJuegoIDSearch]  = useState('')
  const [dateSearch, setDateSearch]  = useState('')


  const handleSubmit = async (e) => {
    e.preventDefault()

    // const newDate = dateSearch
    // cambiar la hora
    // console.log('date', dateSearch)
    // console.log('juegoIDSearch', juegoIDSearch)


    const EntradasPorJuegoyFechaURL = `http://localhost:8080/informes/cantidad-entradas-vendidas-por-juego-y-fecha?juego=${juegoIDSearch}&fecha=${dateSearch}`

    if(dateSearch && juegoIDSearch) {
      fetch(EntradasPorJuegoyFechaURL, {
        method: 'GET',
        headers: { "Content-Type": "application/json" }
      })
      .then( async response => {
        const res = await response.json()
        setResponse(res)
        setIsLoaded(true)
      })
      .catch( error => {
        console.log('hubo un error: ', error)
      });
    } else {
      alert('Por favor complete ambos campos')
    }

    const getJuegoURL = `http://localhost:8080/juegos/${juegoIDSearch}`

    fetch(getJuegoURL, {
        method: "GET",
        headers: { "Content-Type": "application/json" }
    })
    .then( async (response) => {
        if(response.ok) {
          const res = await response.json()
          setJuego(res)
          console.log(res);
        } else {
          console.log('Hay un error en la respuesta')
        }
      })
    .catch((err) => {
      console.log('Error: ', err)
    })

  }

  return (
    <main className='EntradasPorJuegoYFecha_container'>
      <Navbar type={'empleadoAdministrativo'}/>
      <h1>Entradas Vendidas Por Juego Y Fecha</h1>
      <section>
        <form className='EntradasPorJuegoYFecha_form'>
          <label htmlFor="juego_id">Juego ID</label>
          <input className='form_field' required={true} type="text" name='juego_id' id='juego_id' min={1} max={12} value={juegoIDSearch} onChange={e => setJuegoIDSearch(e.target.value)} />

          <label htmlFor="fecha">fecha</label>
          <input className='form_field' required={true} type="date" name='fecha' id='fecha' value={dateSearch} onChange={e => setDateSearch(e.target.value)} />

          <button className='btn' type='submit' onClick={e => handleSubmit(e)}>Buscar</button>
        </form>

        {isLoaded && 
          <div className='response'>
            <span>Fecha: {dateSearch}</span>
            <br />
            <span>Cantidad de entradas vendidas: {response}</span>
            <br />
            <span>Juego: {juego["Nombre Juegos"]}</span>
          </div>
        }
      </section>
      <Footer />
    </main>
  )
}

export default EntradasPorJuegoYFecha