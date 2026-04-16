package com.strubium.ssjprofiler;


/**
 * A simple utility class for measuring execution time of code blocks.
 * Usage:
 * <pre>
 *     Profiler profiler = new Profiler("My Task");
 *     profiler.start();
 *     // code to measure
 *     profiler.end();
 *     profiler.print();
 * </pre>
 *
 * Time is measured in nanoseconds internally and reported by {@code #print()} in milliseconds.
 */
public class Profiler {


    private long startNS = 0;
    private long endNS = 0;
    private long differenceNS = 0;
    private long differenceMS = 0;
    private String name = null;


    /**
     * Constructs a new Profiler instance with a given name.
     * The instance is automatically registered in {@code ProfilerGlobal.INSTANCES}.
     *
     * @param name the name of the task being profiled
     */
    public Profiler(String name){
        this.name = name;
        ProfilerGlobal.INSTANCES.add(this);
    }


    /**
     * Starts the profiler
     */
    public void start(){
        startNS = System.nanoTime();
    }

    /**
     * End the profiler
     */
    public void end(){
        endNS = System.nanoTime();

        differenceNS = endNS - startNS;
        differenceMS = differenceNS / 1_000_000;
    }

    /**
     * Make a formatted string containing the profiling result.
     *
     * @return a string describing the execution time in milliseconds
     */
    public String printReady(){
        return "Time for " + name + " to run was " + differenceMS + "ms";
    }

    public void print(){
        System.out.println(printReady());
    }

    /**
     * Gets the elapsed time in milliseconds.
     *
     * @return the time difference between {@link #start()} and {@link #end()} in milliseconds
     */
    public long getDifferenceMS() {
        return differenceMS;
    }

    /**
     * Gets the elapsed time in nanoseconds (raw).
     *
     * @return the time difference between {@link #start()} and {@link #end()} in nanoseconds
     */
    public long getDifferenceNS() {
        return differenceNS;
    }

    /**
     * Gets the recorded start time in nanoseconds.
     *
     * @return the start time
     */
    public long getStartNS() {
        return startNS;
    }

    /**
     * Gets the recorded end time in nanoseconds.
     *
     * @return the end time
     */
    public long getEndNS() {
        return endNS;
    }
}
