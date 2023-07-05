import { useState } from "react"
import Footer from "../../../components/footer/Footer"
import Navbar from "../../../components/navbar/Navbar"
import './ventasMesAñoStyles.scss'

const VentasMesAño = () => {

    const [mes, setMes] = useState("")
    const [anio, setAnio] = useState("")

    const [responseData, setResponseData] = useState("")

    const handleSubmit = async (e) => {
        e.preventDefault()

        const getVentasMesAnioURL = `http://localhost:8080/informes/sumatoria-montos-ventas-por-mes-anio?mes=${mes}&anio=${anio}`
        
        fetch(getVentasMesAnioURL, {
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
        <main className="ventasMesAño_container">
            <Navbar type={'empleadoAdministrativo'} />
            <h1>Ventas Mes Año</h1>
            <section>
                <form className="ventasMesAño_form">
                    <label htmlFor="mes">Mes:</label>
                    <input
                        className="form_field"
                        type="number"
                        id='mes'
                        name="mes"
                        min={1}
                        max={12}
                        value={mes}
                        onChange={(e) => setMes(e.target.value)}
                    />
                    
                    <label htmlFor="anio">Año:</label>
                    <input
                        className="form_field"
                        type="number"
                        id="anio"
                        name="anio"
                        min={2020}
                        max={2023}
                        value={anio}
                        onChange={(e) => setAnio(e.target.value)}
                    />

                    <button className="btn" type="submit" onClick={e => handleSubmit(e)}>buscar</button>
                </form>

                <br />

                <span className="respuesta">
                    {responseData}
                </span>
            </section>
            <Footer />
        </main>
    )
}

export default VentasMesAño