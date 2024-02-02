package br.com.erick.forum.repository

import br.com.erick.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}