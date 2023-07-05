import { useEffect, useState } from 'react'
import Footer from '../../../components/footer/Footer'
import Navbar from '../../../components/navbar/Navbar'
import './EmpleadosConJuegosAsignadosStyles.scss'

const EmpleadosConJuegosAsignados = () => {

    const [empleadosConJuegosAsignados, setEmpleadosConJuegosAsignados] = useState ('')

    useEffect(() => {
        getEmpleadosConJuegosAsignados()
    }, [empleadosConJuegosAsignados])

    const getEmpleadosConJuegosAsignadosURL = 'http://localhost:8080/informes/lista-empleados-con-juegos-asignados'

    const getEmpleadosConJuegosAsignados = () => {
        fetch(getEmpleadosConJuegosAsignadosURL, {
            method: "GET",
            headers: { "Content-Type": "application/json" }
        })
        .then(async response => {
            if(response.ok) {
                const res = await response.json()
                setEmpleadosConJuegosAsignados(res)
            } else {
                console.log('Hay un error en la respuesta')
            }
        })
        .catch(error => {
            console.log(error)
        })
    }

    return (
        <main className='EmpleadosConJuegosAsignados_container'>
            <Navbar type={'empleadoAdministrativo'}/>
            <h1>Empleados Con Juegos Asignados</h1>

            {empleadosConJuegosAsignados && (
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Juego</th>
                        </tr>
                    </thead>
                    <tbody>
                        {empleadosConJuegosAsignados.map((e, index)=> (
                            <tr key={index}>
                                <th>{e[0]}</th>
                                <th>{e[1]}</th>
                                <th>{e[2]}</th>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
            <Footer />
        </main>
    )
}

export default EmpleadosConJuegosAsignados