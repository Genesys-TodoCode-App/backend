import { useEffect, useState } from 'react'
import Navbar from '../../components/navbar/Navbar'
import Footer from '../../components/footer/Footer'
import './ventasStyles.scss'

const Ventas = () => {

    const [ventas, setVentas] = useState([])

    useEffect(() => {
        handleGetVentas()
    }, [])

    const handleGetVentas = () => {

        const getVentasURL = 'http://localhost:8080/ventas-entradas?page=1&size=20'

        try {
            fetch(getVentasURL, {
                method: "GET",
                headers: { "Content-Type": "application/json" }
            })
            .then( async (response) => {
                console.log('response', response);

                if(response.ok) {
                    const res = await response.json()
                    setVentas(res.content)
                    console.log('res', res);
                } else {
                    console.log('Hay un error')
                }
            })
            .catch((err) => {
                console.log('Error .then: ', err)
            })
        } catch (error) {
            console.log('Error: ', error)
        }
    }

    return (
        <main className='ventas_container'>
            <Navbar type={'empleadoAdministrativo'} />
            <h1>Ventas</h1>
            <table>
                <thead>
                    <tr>
                        <th>Fecha de Venta</th>
                        <th>Juego</th>
                        <th>Precio de juego</th>
                        <th>Monto de venta</th>
                    </tr>
                </thead>
                <tbody>
                    {console.log('ventas', ventas)}
                    {ventas.map( i => (
                        <tr key={i["Id Venta Entradas"]}>
                            <td>{i.entrada["Fecha y Hora Utilizacion"]}</td>
                            <td>{i.entrada.juego["Nombre Juegos"]}</td>
                            <td>{i.entrada.juego["Precio Juegos"]}</td>
                            <td>{i["Monto Venta"]}</td>
                            
                        </tr>
                    ))}
                </tbody>
            </table>
            <Footer />
        </main>
    )
}

export default Ventas
