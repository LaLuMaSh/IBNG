package ch.lalumash.IBNG.controllers

import ch.lalumash.IBNG.dtos.AuthResponse
import ch.lalumash.IBNG.entities.JwtRequest
import ch.lalumash.IBNG.helper.JwtTokenUtil
import ch.lalumash.IBNG.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
class JwtAuthenticationController(
        val authenticationManager: AuthenticationManager,
        val jwtTokenUtil: JwtTokenUtil,
        val userService: UserService
) {
    @RequestMapping(value = ["/authenticate"], method = [RequestMethod.POST])
    @Throws(Exception::class)
    fun createAuthenticationToken(@RequestBody authenticationRequest: JwtRequest): AuthResponse {
        authenticate(authenticationRequest.username!!, authenticationRequest.password!!)
        val userDetails = userService
                ?.loadUserByUsername(authenticationRequest.username)
        val token = jwtTokenUtil!!.generateToken(userDetails)
        val userById = userService!!.getUserById(authenticationRequest.username!!)!!
        return AuthResponse(token, userById.username, userById.nickname)
    }

    @Throws(Exception::class)
    private fun authenticate(username: String, password: String) {
        try {
            authenticationManager!!.authenticate(UsernamePasswordAuthenticationToken(username, password))
        } catch (e: DisabledException) {
            throw Exception("USER_DISABLED", e)
        } catch (e: BadCredentialsException) {
            throw Exception("INVALID_CREDENTIALS", e)
        }
    }
}