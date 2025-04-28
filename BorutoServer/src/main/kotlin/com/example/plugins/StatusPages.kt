package com.example.plugins

import com.example.models.ApiResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import javax.naming.AuthenticationException

fun Application.configureStatusPages() {
    install(StatusPages) {
        // Quando ocorrer uma AuthenticationException
        exception<AuthenticationException> { call, _ ->
            call.respond(
                status = HttpStatusCode.Unauthorized,
                message = ApiResponse(
                    success = false,
                    message = "Authentication failed."
                )
            )
        }

        // Quando uma rota não existir (404 NotFound)
        status(HttpStatusCode.NotFound) { call, _ ->
            call.respond(
                status = HttpStatusCode.NotFound,
                message = ApiResponse(
                    success = false,
                    message = "Page not Found."
                )
            )
        }
    }
}
