package com.alfabita.wephi.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * LocaleUtils simplifies access to i18n messages throughout the application.
 * It automatically resolves the current user's locale from the context.
 *
 * Examples:
 *  - localeUtils.getMessage("user.register.success")
 *  - localeUtils.getMessage("welcome.user", "John")
 *  - localeUtils.getMessage("email.subject", Locale.FRENCH)
 */
@Component
public class LocaleUtils {

    private final MessageSource messageSource;

    public LocaleUtils(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Get message using the current locale stored in LocaleContextHolder.
     */
    public String getMessage(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, null, key, locale);
    }

    /**
     * Retrieves a localized message from the configured message source based on the
     * current user's locale (resolved from {@link org.springframework.context.i18n.LocaleContextHolder}).
     * <p>
     * This method supports parameterized messages using placeholders <code>{0}</code>, <code>{1}</code>, etc.,
     * defined inside your <code>messages.properties</code> files.
     * The arguments supplied in <code>args</code> will replace these placeholders in order.
     * <p>
     * <strong>Example usage:</strong>
     * <pre>{@code
     * // Example 1: Simple one-argument message
     * String msg = localeUtils.getMessage("welcome.user", "Ijhar");
     * // messages.properties → welcome.user=Welcome, {0}!
     * // Output → "Welcome, Ijhar!"
     *
     * // Example 2: Multi-argument message
     * String msg = localeUtils.getMessage("order.confirmation",
     *     "John", "A12345", "Tomorrow");
     * // messages.properties → order.confirmation=Dear {0}, your order #{1} will be delivered by {2}.
     * // Output → "Dear John, your order #A12345 will be delivered by Tomorrow."
     * }</pre>
     * <p>
     * If the message key is not found in any resource bundle, the method
     * gracefully returns the key itself instead of throwing an exception.
     *
     * @param key  the message key to resolve (must match a key in messages.properties)
     * @param args optional list of dynamic arguments to replace placeholders ({0}, {1}, etc.)
     * @return the resolved and localized message string for the current locale,
     *         or the key itself if no message is found
     * @see org.springframework.context.MessageSource#getMessage(String, Object[], String, java.util.Locale)
     * @see org.springframework.context.i18n.LocaleContextHolder#getLocale()
     */
    public String getMessage(String key, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, args, key, locale);
    }



    /**
     * Convenience method to get the current active locale.
     */
    public Locale getCurrentLocale() {
        return LocaleContextHolder.getLocale();
    }
}