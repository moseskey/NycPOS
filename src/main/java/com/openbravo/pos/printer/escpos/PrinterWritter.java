package com.openbravo.pos.printer.escpos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class PrinterWritter {

    private boolean initialized = false;

    private ExecutorService exec;

    public PrinterWritter() {
        exec = Executors.newSingleThreadExecutor();
    }

    protected abstract void internalWrite(byte[] data);

    protected abstract void internalFlush();

    protected abstract void internalClose();

    public void init(final byte[] data) {
        if (!initialized) {
            write(data);
            initialized = true;
        }
    }

    public void write(String sValue) {
        write(sValue.getBytes());
    }

    public void write(final byte[] data) {
        exec.execute(new Runnable() {
            @Override
            public void run() {
                internalWrite(data);
            }
        });
    }

    public void flush() {
        exec.execute(new Runnable() {
            @Override
            public void run() {
                internalFlush();
            }
        });
    }

    public void close() {
        exec.execute(new Runnable() {
            @Override
            public void run() {
                internalClose();
            }
        });
        exec.shutdown();
    }
}
