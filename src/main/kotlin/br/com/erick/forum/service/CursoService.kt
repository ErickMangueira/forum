package br.com.erick.forum.service

import br.com.erick.forum.model.Curso
import br.com.erick.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso{
        return repository.getReferenceById(id)
    }

}
