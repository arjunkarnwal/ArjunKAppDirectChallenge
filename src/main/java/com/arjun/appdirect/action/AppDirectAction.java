package com.arjun.appdirect.action;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arjun.appdirect.handler.AppDirectHandler;

@Data
public abstract class AppDirectAction implements IAppDirectAction {

    private static Logger log = LoggerFactory.getLogger(AppDirectAction.class);

    private String token;
	private String url;
	protected AppDirectHandler handler;

    public AppDirectAction(final AppDirectHandler handler, final String url, final String token) {
        this.handler = handler;
        this.url = url;
        this.token = token;
    }

    @Override
    public <T> ActionResult<T> executeAction(Class<T> eventType) {
        ActionResult<T> result = new ActionResult();

        try {
            T event = getEvent(url, eventType);
            result.setEntity(event);
            result.setSuccess(true);

        } catch (JAXBException | IOException | OAuthExpectationFailedException | OAuthCommunicationException | OAuthMessageSignerException e) {
            log.error(e.getMessage(), e);
            result.setSuccess(false);
            result.setErrorMessage(e.getMessage());
        }

        return result;
    }

    protected <T> T getEvent(final String url, final Class<T> clazz) throws JAXBException, OAuthExpectationFailedException, OAuthCommunicationException, OAuthMessageSignerException, IOException {
        return handler.handle(url, clazz);
    }

}
