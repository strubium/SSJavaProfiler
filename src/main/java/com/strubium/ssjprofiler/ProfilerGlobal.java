package com.strubium.ssjprofiler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfilerGlobal {

    static final List<Profiler> INSTANCES = new ArrayList<>();

    public static void exportToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Profiler p : INSTANCES) {
                writer.write(p.printReady() + System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        INSTANCES.clear();
    }
}
