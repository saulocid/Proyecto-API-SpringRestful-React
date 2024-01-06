export async function listarPersonas() {
    try {
        const res = await fetch('http://localhost:8080/personas')
        const data = await res.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

export async function savePersona(persona) {
    try {
        await fetch('http://localhost:8080/personas/guardar',{
            body: JSON.stringify(persona),
            headers:{
                "Content-type": "application/json"
            },
            method: "POST"
        })
    } catch (error) {
        console.log(error)
    }
}

export async function deletePersona(id) {
    try {
        await fetch(`http://localhost:8080/personas/borrar/${id}`,{
            method: "DELETE"
        })
    } catch (error) {
        console.log(error)
    }
}