package com.slack.api.app_backend.events.handler;

import com.slack.api.model.event.SubteamSelfAddedEvent;
import com.slack.api.app_backend.events.EventHandler;
import com.slack.api.app_backend.events.payload.SubteamSelfAddedPayload;

public abstract class SubteamSelfAddedHandler extends EventHandler<SubteamSelfAddedPayload> {

    @Override
    public String getEventType() {
        return SubteamSelfAddedEvent.TYPE_NAME;
    }
}
