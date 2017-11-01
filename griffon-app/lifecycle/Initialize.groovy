import griffon.core.GriffonApplication
import io.github.aretche.griffonWebSocket.GriffonWebsocketService
import org.codehaus.griffon.runtime.core.AbstractLifecycleHandler

import javax.annotation.Nonnull
import javax.inject.Inject

class Initialize extends AbstractLifecycleHandler {

    @Inject
    private GriffonWebsocketService griffonWebsocketService

    @Inject
    Initialize(@Nonnull GriffonApplication application) {
        super(application)
    }

    @Override
    void execute() {
        // Invoco el servicio para escuchar los mensajes del websocket
        griffonWebsocketService.iniciarListener()
    }
}