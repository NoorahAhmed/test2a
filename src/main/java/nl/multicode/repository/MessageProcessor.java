package nl.multicode.repository;

public interface MessageProcessor<T, R> {

    R process(T message);

}
