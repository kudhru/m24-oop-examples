class Logger {
    private final Object lock = new Object();
    private final java.io.Writer out;
    Logger(java.io.Writer out) { this.out = out; }

    void log(String level, String msg) throws java.io.IOException {
        String line = java.time.OffsetDateTime.now() + " [" + level + "] " + msg + "\n"; // outside lock
        synchronized (lock) {
            out.write(line);    // only the I/O is synchronized
            out.flush();
        }
    }
}
