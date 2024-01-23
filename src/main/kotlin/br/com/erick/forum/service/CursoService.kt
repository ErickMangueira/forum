package br.com.erick.forum.service

import br.com.erick.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CursoService(var cursos: List<Curso>) {

    init {
        val curso = Curso(
            id =1,
            nome = "Kotlin",
            categoria = "Programacao"
        )
        cursos = Arrays.asList(curso)
    }

    fun buscarPorId(id: Long): Curso{
        return cursos.stream().filter { c -> c.id == id }
            .findFirst().get()
    }

}
