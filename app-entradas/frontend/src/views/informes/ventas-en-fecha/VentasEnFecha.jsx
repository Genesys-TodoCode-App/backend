import { useState } from 'react'
import Footer from '../../../components/footer/Footer'
import Navbar from '../../../components/navbar/Navbar'
import './ventasEnFechaStyles.scss'

const VentasEnFecha = () => {

    const [date, setDate] = useState('')
    const [responseData, setResponseData] = useState("")

    const handleSubmit = (e) => {
        e.preventDefault()

        const getVentasenFechaURL = `http://localhost:8080/informes/sumatoria-monto-venta-por-dia?fecha=${date}`

        fetch(getVentasenFechaURL, {
            method: 'GET',
            headers: { "Content-Type": "application/json" },
        })
        .then(response => response.json())
        .then( data => {
            if(data) {
                setResponseData('$' + data)
            }
        })
        .catch( error => {
            if(error) {
                const responseError = "No hay datos para la fecha buscada"
                setResponseData(responseError)
            }
        });
    }

    return (
        <main className="ventasEnFecha_container">
            <Navbar type={"empleadoAdministrativo"} />
            <h1>Ventas en la fecha</h1>
            <section>
                <form className="ventasEnFecha_form">
                    <label htmlFor="date">Fecha:</label>
                    <input
                        className='form_field'
                        id='date'
                        name='date'
                        value={date}
                        onChange={ e => setDate(e.target.value)}
                        type="date"
                    />
                    <button className="btn" type='submit' onClick={ e => handleSubmit (e)}>Buscar</button>
                </form>
                <span>
                    {responseData}
                </span>
            </section>
            <Footer />
        </main>
    )
}

export default VentasEnFecha