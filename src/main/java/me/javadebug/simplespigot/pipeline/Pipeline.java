package me.javadebug.simplespigot.pipeline;

public class Pipeline<T, R> {
    private final Step<T, R> current;

    public Pipeline(Step<T, R> current) {
        this.current = current;
    }

    public <U> Pipeline<T, U> pipe(Step<R, U> handler) {
        return new Pipeline<>(input -> handler.process(this.current.process(input)));
    }

    public R execute(T type) {
        return this.current.process(type);
    }
}
