package com.strubium.ssjprofiler;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Profiler testProfiler = new Profiler("test profiler");

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        testProfiler.start();

        long sum = 0;
        for (int j = 0; j < 25; j++) {
            Profiler p = new Profiler("Run " + j);

            p.start();
            for (int i = 0; i < 50_000_000; i++) {
                sum += i;
            }
            p.end();

            p.print();
        }


        testProfiler.end();

        testProfiler.print();

        ProfilerGlobal.exportToFile("/home/smeagle/Documents/GitHub/SSJavaProfiler/profiler_results.txt");
    }
}