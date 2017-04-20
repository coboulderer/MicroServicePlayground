package rk.playground.customer.service;

/**
 * Sends a message to the messaging queue
 */
public interface Sender {

    void send(String message);
}
