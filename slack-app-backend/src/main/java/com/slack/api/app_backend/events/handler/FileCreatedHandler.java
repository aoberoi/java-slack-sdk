package com.slack.api.app_backend.events.handler;

import com.slack.api.model.event.FileCreatedEvent;
import com.slack.api.app_backend.events.EventHandler;
import com.slack.api.app_backend.events.payload.FileCreatedPayload;

public abstract class FileCreatedHandler extends EventHandler<FileCreatedPayload> {

    @Override
    public String getEventType() {
        return FileCreatedEvent.TYPE_NAME;
    }
}
