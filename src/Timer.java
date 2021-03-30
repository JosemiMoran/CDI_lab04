class Timer {
    private final long[] startTime;
    private final long[] stopTime;

    Timer(int n) {
        startTime = new long[n];
        stopTime = new long[n];
    }

    public void Start(int i) {
        startTime[i] = System.nanoTime();
    }

    public void Stop(int i) {
        stopTime[i] = System.nanoTime();
    }

    public double Elapsed() {
        long minTime = startTime[0];
        for (int i = 1; i < startTime.length; ++i)
            if (startTime[i] < minTime) minTime = startTime[i];
        long maxTime = stopTime[0];
        for (int i = 1; i < stopTime.length; ++i)
            if (stopTime[i] > maxTime) maxTime = stopTime[i];
        return (maxTime - minTime) / 1000000.0;
    }
}