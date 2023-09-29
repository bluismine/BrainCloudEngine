package net.bcloud.bengine.api.listener;

public interface Loadable {

    void setup();

    void shutdown();

    default void reload() {
        this.shutdown();
        this.setup();
    }
}