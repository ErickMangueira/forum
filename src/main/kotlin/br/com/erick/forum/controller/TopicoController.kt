package br.com.erick.forum.controller

import br.com.erick.forum.dto.AtualizacaoTopicoForm
import br.com.erick.forum.dto.NovaTopicoForm
import br.com.erick.forum.dto.TopicoView
import br.com.erick.forum.model.Topico
import br.com.erick.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos")
class TopicoController (private val service: TopicoService) {
    @GetMapping
    fun listar(): MutableList<Topico> {
       return service.listar()
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }
    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid form: NovaTopicoForm,uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoView> {
        val topicoView = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }
    @PutMapping
    @Transactional
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm): ResponseEntity<TopicoView> {
        val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }

}