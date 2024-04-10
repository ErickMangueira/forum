package br.com.erick.forum.config

import br.com.erick.forum.model.Role
import br.com.erick.forum.service.UsuarioService
import com.auth0.jwt.JWT
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.Date
import com.auth0.jwt.algorithms.Algorithm


@Component
data class JWTUtil(
    private val usuarioService: UsuarioService
) {
    private val expiration: Long = 60000

    @Value("\${jwt.secret}")
    private var secret: String = "secret"
    private val key = Algorithm.HMAC256(secret.toByteArray())

    fun generateToken(username: String, authorities: List<Role>): String? {
        val rolesAsStringList = authorities.map { it.authority}
            return JWT.create()
            .withSubject(username)
            .withClaim("roles", rolesAsStringList)
            .withExpiresAt(Date(System.currentTimeMillis() + expiration))
            .sign(key)
    }

    fun isValid(jwt: String?): Boolean {
        return try {
            JWT.require(key)
                .build()
                .verify(jwt)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAuthentication(jwt: String?): Authentication {
        val username = JWT.require(key)
            .build()
            .verify(jwt)
            .subject
       val user = usuarioService.loadUserByUsername(username)
        return UsernamePasswordAuthenticationToken(username, null, user.authorities)
    }


}

