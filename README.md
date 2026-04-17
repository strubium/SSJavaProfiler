# SSJavaProfiler
SSJavaProfiler (Stupid Simple Java Profiler) is a very easy to use profiler for java apps. 
It allows you to individually profile parts of java code

## Installing

Add [Jitpack](https://www.jitpack.io/#strubium/JavaWindowManager) to your build.gradle file
```
    maven { url 'https://jitpack.io' }
```

Add SSJavaProfiler to your dependencies block

```
implementation 'com.github.strubium:SSJavaProfiler:1.0.0'
```

### Usage

```java
        Profiler testProfiler = new Profiler("test profiler");


        testProfiler.start();

        long sum = 0;
        for (int j = 0; j < 25; j++) {

            for (int i = 0; i < 50_000_000; i++) {
                sum += i;
            }

        }


        testProfiler.end();
        testProfiler.print();
```

#### Output
`Time for test profiler to run was 285ms`



