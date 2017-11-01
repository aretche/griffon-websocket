package io.github.aretche.griffonWebSocket

import griffon.core.artifact.GriffonView
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor

import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonView)
class GriffonWebsocketView {
    @MVCMember @Nonnull
    FactoryBuilderSupport builder
    @MVCMember @Nonnull
    GriffonWebsocketModel model

    void initUI() {
        builder.application(title: application.configuration['application.title'],
            sizeToScene: true, centerOnScreen: true, name: 'mainWindow') {
            scene(fill: WHITE, width: 200, height: 60) {
                gridPane {
                    button(row: 1, column: 0, prefWidth: 200,
                           id: 'clickActionTarget', clickAction,
                            text: 'Enviar Hello')
                }
            }
        }
    }
}