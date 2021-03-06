package com.slack.api.app_backend.events.handler;

import com.slack.api.model.event.GoodbyeEvent;
import com.slack.api.app_backend.events.EventHandler;
import com.slack.api.app_backend.events.payload.GoodbyePayload;

public abstract class GoodbyeHandler extends EventHandler<GoodbyePayload> {

    @Override
    public String getEventType() {
        return GoodbyeEvent.TYPE_NAME;
    }
}
