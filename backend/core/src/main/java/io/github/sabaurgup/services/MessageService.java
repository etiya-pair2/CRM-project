package io.github.sabaurgup.services;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String messageKey) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(messageKey, null, currentLocale);
    }
}
