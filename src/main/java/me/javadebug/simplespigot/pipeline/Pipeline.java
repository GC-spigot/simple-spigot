package me.javadebug.simplespigot.pipeline;

public class Pipeline<T, R> {
    private final Handler<T, R> currentHandler;

    public Pipeline(Handler<T, R> currentHandler) {
        this.currentHandler = currentHandler;
    }

    public <U> Pipeline<T, U> addHandler(Handler<R, U> handler) {
        return new Pipeline<>(input -> handler.process(this.currentHandler.process(input)));
    }

    public R execute(T type) {
        return this.currentHandler.process(type);
    }
}
