import { useState } from 'react'
import Navbar from '../../../components/navbar/Navbar'
import './EntradasVendidasEnFechaStyles.scss'
import Footer from '../../../components/footer/Footer'

const EntradasVendidasEnFecha = () => {

    const [date, setDate] = useState('')
    const [response, setResponse] = useState(0)
    const [isLoaded, setIsLoaded] = useState(false)


    const handleSubmit = (e) => {
        e.preventDefault()

        const inputDate = date
        const parts = inputDate.split("-")
        const date2 = new Date(parts[0], parts[1] - 1, parts[2]);
        const formattedDate = `${date2.getDate()}/${date2.getMonth() + 1}/${date2.getFullYear()}`;

        console.log('formattedDate', formattedDate)

        const getEntradasVendidasEnFecha = `http://localhost:8080/informes/entradas-vendidas-en-fecha?fecha=${formattedDate}`

        fetch(getEntradasVendidasEnFecha, {
            method: "GET",
            headers: { "Content-Type": "application/json" }
        })
        .then( async (response) => {
            console.log('response', response);
            if(response.ok) {
              const res = await response.json()
              setResponse(res)
              setIsLoaded(true)
            } else {
              console.log('Hay un error en la respuesta')
            }
          })
        .catch((err) => {
          console.log('Error: ', err)
        })
    }

    return (
        <main className='EntradasVendidasEnFecha_container'>
            <Navbar type={'empleadoAdministrativo'} />
            <h1>Entradas Vendidas En Fecha</h1>
            <section>
                <form className='EntradasVendidasEnFecha_form' onSubmit={handleSubmit}>
                    <label htmlFor="date">Fecha: </label>
                    <input className='form_field' type="date" id='date' name='date' value={date} onChange={e => setDate(e.target.value)} />

                    <button className='btn' type='submit'>Buscar</button>
                </form>
                <br />
                {(response && isLoaded) ? (
                    <div>
                        <span>Entradas Vendidas el {date}: {response}</span>
                    </div>
                ) : (
                    isLoaded && <span>No hay registro de entradas vendidas</span>
                )}
            </section>
            <Footer />
        </main>
    )
}

export default EntradasVendidasEnFecha