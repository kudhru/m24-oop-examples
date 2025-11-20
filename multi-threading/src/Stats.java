class Stats {
    private final Object hitsLock = new Object(), errsLock = new Object();
    private int hits, errs;
    void hit() { synchronized (hitsLock) { hits++; } }
    void err() { synchronized (errsLock) { errs++; } }
}
