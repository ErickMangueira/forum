package br.com.erick.forum.repository

import br.com.erick.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico,Long> {
}