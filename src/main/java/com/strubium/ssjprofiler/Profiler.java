package com.strubium.ssjprofiler;

public class Profiler {


    private long startNS = 0;
    private long endNS = 0;
    private long differenceMS = 0;
    private String name = null;

    public Profiler(String name){
        this.name = name;
        ProfilerGlobal.INSTANCES.add(this);
    }

    public void start(){
        startNS = System.nanoTime();
    }
    public void end(){
        endNS = System.nanoTime();

        differenceMS = (endNS - startNS)/ 1_000_000;
    }

    public String printReady(){
        return "Time for " + name + " to run was " + differenceMS;
    }

    public void print(){
        System.out.println(printReady());
    }

    public long getDifferenceMS() {
        return differenceMS;
    }
    public long getStartNS() {
        return startNS;
    }
    public long getEndNS() {
        return endNS;
    }
}
