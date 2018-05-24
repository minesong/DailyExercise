package com.song.myagent;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 */
public class App {
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("=========premain方法执行========");
        System.out.println(agentOps);
        // 添加Transformer
        inst.addTransformer(new FirstAgent());
    }

    public static void main(String[] args) {
        hello();
    }

    public static void hello() {
        System.out.println("this is agent-demo output");
    }
}