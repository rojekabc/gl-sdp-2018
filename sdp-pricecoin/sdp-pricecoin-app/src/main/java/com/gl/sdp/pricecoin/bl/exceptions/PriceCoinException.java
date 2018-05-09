package com.gl.sdp.pricecoin.bl.exceptions;

public class PriceCoinException extends RuntimeException {
    public PriceCoinException() {
    }

    public PriceCoinException(String message) {
        super(message);
    }

    public PriceCoinException(String message, Throwable cause) {
        super(message, cause);
    }

    public PriceCoinException(Throwable cause) {
        super(cause);
    }
}
