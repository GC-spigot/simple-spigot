package me.javadebug.simplespigot.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;

public class Locks {

    public static ReentrantLock newReentrantLock() {
        return new ReentrantLock();
    }

    public static ReentrantLock newReentrantLock(boolean fair) {
        return new ReentrantLock(fair);
    }

    public static ReentrantReadWriteLock newReadWriteLock() {
        return new ReentrantReadWriteLock();
    }

    public static StampedLock newStampedLock() {
        return new StampedLock();
    }

    public static <T> T supplySafety(Lock lock, Supplier<T> supplier) {
        lock.lock();
        try {
            return supplier.get();
        } finally {
            lock.unlock();
        }
    }

    public static void safety(Lock lock, Runnable runnable) {
        lock.lock();
        try {
            runnable.run();
        } finally {
            lock.unlock();
        }
    }
}
