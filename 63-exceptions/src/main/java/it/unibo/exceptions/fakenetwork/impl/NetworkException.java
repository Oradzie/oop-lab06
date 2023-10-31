package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException {
    public NetworkException() {
        new Exception("Network error: no response");
    }

    public NetworkException(String message) {
        new Exception(message);
    }
}
