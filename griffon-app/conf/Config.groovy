application {
    title = 'griffon-websocket'
    startupGroups = ['griffonWebsocket']
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "griffonWebsocket"
    'griffonWebsocket' {
        model      = 'io.github.aretche.griffonWebSocket.GriffonWebsocketModel'
        view       = 'io.github.aretche.griffonWebSocket.GriffonWebsocketView'
        controller = 'io.github.aretche.griffonWebSocket.GriffonWebsocketController'
    }
}