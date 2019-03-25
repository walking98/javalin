/*
 * Javalin - https://javalin.io
 * Copyright 2017 David Åse
 * Licensed under Apache 2.0: https://github.com/tipsy/javalin/blob/master/LICENSE
 */

package io.javalin.core

import io.javalin.core.util.JettyServerUtil
import io.javalin.websocket.JavalinWsServlet
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.session.SessionHandler

class JavalinServer {

    var server: Server? = null
    var sessionHandler: SessionHandler? = null

    var port = 7000
    var contextPath = "/"

    fun start(javalinServlet: JavalinServlet, javalinWsServlet: JavalinWsServlet) {
        server = server ?: JettyServerUtil.defaultServer()
        sessionHandler = sessionHandler ?: JettyServerUtil.defaultSessionHandler()
        port = JettyServerUtil.initialize(
                server!!,
                sessionHandler!!,
                port,
                contextPath,
                javalinServlet,
                javalinWsServlet
        )
    }
}

