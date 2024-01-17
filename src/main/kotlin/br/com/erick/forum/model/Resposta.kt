package br.com.erick.forum.model

import java.time.LocalDateTime

data class Resposta (
        val id: Long?,
        val menssagem: String,
        val dataCriacao: LocalDateTime = LocalDateTime.now(),
        val autor: Usuario,
        val topico: Topico,
        val solucao: Boolean

)
