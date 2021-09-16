package org.acme;

import io.quarkus.qute.i18n.Localized;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AppMessagesProvider {

    private final AlertMessages enAppMessages;
    private final AlertMessages elAppMessages;

    public AppMessagesProvider(@Localized("en") AlertMessages enAppMessages,
                               @Localized("el") AlertMessages elAppMessages) {
        this.enAppMessages = enAppMessages;
        this.elAppMessages = elAppMessages;
    }

    public AlertMessages appMessages(String lang) {
        switch (lang) {
            case "el": return elAppMessages;
            case "en":
            default:
                return enAppMessages;
        }
    }
}
