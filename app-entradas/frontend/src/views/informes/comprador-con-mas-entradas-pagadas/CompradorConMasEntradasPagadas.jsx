import { useState } from 'react'
import Footer from '../../../components/footer/Footer'
import Navbar from '../../../components/navbar/Navbar'
import './CompradorConMasEntradasPagadasStyles.scss'

const CompradorConMasEntradasPagadas = () => {

    const [compradores, setCompradores] = useState('')
    const [mes, setMes] = useState('')
    const [anio, setAnio] = useState('')
    const [isLoaded, setIsLoadead] = useState(false)

    const handleGetCompradores = (e) => {
        e.preventDefault()

        const getCompradorConMArEntradasPagadasURL =`http://localhost:8080/informes/comprador-con-mas-entradas-compradas?mes=${mes}&anio=${anio}`

        fetch(getCompradorConMArEntradasPagadasURL, {
            method: "GET",
            headers: { "Content-Type": "application/json" }
        })
        .then( async (response) => {
            if(response.ok) {
                const res = await response.json()
                if(res.length === 0) {
                    alert(`No hay resultados para la fecha ingresada: ${mes}-${anio}`)
                } else {
                    setCompradores(res)
                    setIsLoadead(true)
                }
            } else {
                console.log('Hay un error no se donde')
            }
        })
        .catch((err) => {
            console.log('Error: ', err)
        })

    }    

    return (
        <main className='CompradorConMasEntradasPagadas_container'>
            <Navbar type={'empleadoAdministrativo'}/>
            <h1>Comprador Con Mas Entradas Pagadas</h1>
            <section>
                <form className='CompradorConMasEntradasPagadas_form'>
                    <label htmlFor="mes">Mes:</label>
                    <input className='form_field' type="text" min={1} max={12} name={mes} id={mes} value={mes} onChange={e => setMes(e.target.value)} />

                    <label htmlFor="anio">Año:</label>
                    <input className='form_field' type="number" min={2020} max={2023} name={anio} id={anio} value={anio} onChange={e => setAnio(e.target.value)} />

                    <button className='btn' type='submit' onClick={(e) => handleGetCompradores(e)}>Buscar</button>
                </form>
                {(compradores && isLoaded) ? (
                    <table className='reponse'>
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>DNI</th>
                                <th>Correo Electronico</th>
                                <th>Pase de Oro</th>
                            </tr>
                        </thead>
                        <tbody>
                            {compradores.map(c => (
                                <tr key={c["Id Comprador"]}>
                                    <th>{c["Nombre Comprador"]}</th>
                                    <th>{c["Apellido Comprador"]}</th>
                                    <th>{c["DNI Comprador"]}</th>
                                    <th>{c["Correo Electronico Comprador"]}</th>
                                    <th>{c["Pase de Oro"].toString()}</th>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                ) : (
                    isLoaded && <span>No hay resultados para la fecha ingresada</span>
                )}
            </section>
            <Footer />
        </main>
    )
}

export default CompradorConMasEntradasPagadas