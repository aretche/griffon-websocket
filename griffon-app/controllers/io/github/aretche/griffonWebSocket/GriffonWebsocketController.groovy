package io.github.aretche.griffonWebSocket

import griffon.core.artifact.GriffonController
import griffon.core.controller.ControllerAction
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Threading

import javax.annotation.Nonnull
import javax.inject.Inject

@ArtifactProviderFor(GriffonController)
class GriffonWebsocketController {
    @MVCMember @Nonnull
    GriffonWebsocketModel model

    @Inject
    private GriffonWebsocketService griffonWebsocketService

    @ControllerAction
    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    void click() {

        griffonWebsocketService.enviarMensaje("Hello from Griffon!!!")

    }
}