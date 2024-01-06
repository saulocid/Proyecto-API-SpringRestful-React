import React, { useEffect, useState } from "react";
import { deletePersona, listarPersonas } from "../servicios/PersonaServicio";
import Persona from "./Persona";

function ListaPersonas() {

    const [personas, setPersonas] = useState([])

    useEffect(() => {
        listarPersonas().then(data => setPersonas(data))
    }, [])

    async function eliminarPersona(persona) {
        await deletePersona(persona.id)
        const newPersonas = personas.filter((p) => p.id !== persona.id)
        setPersonas(newPersonas)
    }

    return (
        <>
            <h2>Lista de personas</h2>
            {personas  && personas.length > 0 ? 
            <table>
                <thead>
                    <tr>
                        <th>Id Persona</th>
                        <th>Nombre</th>
                        <th>DNI</th>
                        <th>Edad</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    {personas.map((persona) => <Persona key={persona.id} persona={persona} eliminar={eliminarPersona} />)}
                </tbody>
            </table> : <p>No hay personas en la lista</p>}
        </>
    )
}

export default ListaPersonas;