import React from "react";

function Persona({persona, eliminar}) {

    return (
        <tr>
            <td>{persona.id}</td>
            <td>{persona.nombre}</td>
            <td>{persona.dni}</td>
            <td>{persona.edad}</td>
            <td onClick={()=>eliminar(persona)}><span className="X">❌</span></td>
        </tr>
    )
}

export default Persona;