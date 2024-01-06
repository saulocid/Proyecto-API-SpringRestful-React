import React, { useState } from "react";
import { savePersona } from "../servicios/PersonaServicio";
import { useNavigate } from "react-router-dom";

function FormularioPersona() {

    const [nombre, setNombre] = useState("")
    const [dni, setDni] = useState(0)
    const [edad, setEdad] = useState(0)
    const navigate = useNavigate()

    async function guardarPersona(e) {
        e.preventDefault()
        const personaNueva = {
            nombre: nombre,
            dni: dni,
            edad: edad
        }
        try {
            await savePersona(personaNueva)
            navigate("/")
        } catch (error) {
            console.log(error)
        }
    }

    return (
        <>
            <h1>Crear Persona</h1>
            <form onSubmit={(e) => guardarPersona(e)}>
                <label name="nombre">Nombre completo</label>
                <input type="text" value={nombre} onChange={(e) => setNombre(e.target.value)} name="nombre" required />
                <label name="dni">DNI</label>
                <input type="number" value={dni} onChange={(e) => setDni(e.target.value)} name="dni" required />
                <label name="edad">Edad</label>
                <input type="number" value={edad} onChange={(e) => setEdad(e.target.value)} name="edad" required />
                <button type="submit">Crear</button>
            </form>
        </>
    )
}

export default FormularioPersona;