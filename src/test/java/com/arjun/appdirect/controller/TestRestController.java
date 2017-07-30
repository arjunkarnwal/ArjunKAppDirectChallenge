package com.arjun.appdirect.controller;

import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.signature.AuthorizationHeaderSigningStrategy;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.arjun.appdirect.Application;
import com.arjun.appdirect.util.HttpClientOAuthConsumer;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment=WebEnvironment.RANDOM_PORT)
@DirtiesContext
public abstract class TestRestController {

    @Autowired
    protected ApplicationContext appContext;

    @Value("${local.server.port}")
    private int port;

    @Value("${APPDIRECT_CONSUMER_KEY}")
    private String consumerKey;

    @Value("${APPDIRECT_SECRET}")
    private String secret;

    protected <T> ResponseEntity<T> getForEntity(String path, Class<T> responseType) throws IOException, OAuthCommunicationException, OAuthExpectationFailedException, OAuthMessageSignerException {
        HttpClientOAuthConsumer consumer = new HttpClientOAuthConsumer(consumerKey, secret);
        consumer.setSigningStrategy(new AuthorizationHeaderSigningStrategy());

        String uri = constructUrl(path);
        HttpGet getRequest = new HttpGet(uri);

        consumer.sign(getRequest);

        HttpHeaders headers = new HttpHeaders();
        for (Header header : getRequest.getAllHeaders()) {
            headers.add(header.getName(), header.getValue());
        }

        ResponseEntity<T> entity = new TestRestTemplate().getForEntity(uri, responseType, headers);

        return entity;
    }

    protected <T> ResponseEntity<T> postForEntity(String path, Object request, Class<T> responseType) {
        return new TestRestTemplate().postForEntity(constructUrl(path), request, responseType);
    }

    protected String constructUrl(String path) {
        return new StringBuilder("http://localhost:").append(this.port).append("/").append(path).toString();
    }


}
