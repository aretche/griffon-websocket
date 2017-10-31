package io.github.aretche.griffonWebSocket

import griffon.core.artifact.GriffonModel
import griffon.transform.FXObservable
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonModel)
class GriffonWebsocketModel {
    @FXObservable String clickCount = "0"
}