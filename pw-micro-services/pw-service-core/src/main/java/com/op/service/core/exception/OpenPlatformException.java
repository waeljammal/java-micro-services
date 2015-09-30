package com.op.service.core.exception;

import org.springframework.web.client.RestClientException;

/**
 * Class exception to the application resources to send to the client the
 * message in json format.
 *
 */
public class OpenPlatformException extends RestClientException {

    public OpenPlatformException(String msg) {
        super(msg);
    }

    public OpenPlatformException(String msg, Throwable ex) {
        super(msg, ex);
    }

    public OpenPlatformException(Throwable ex) {
        super(ex.getMessage(), ex);
    }
}
