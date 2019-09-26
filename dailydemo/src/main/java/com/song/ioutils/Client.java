package com.song.ioutils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.*;

public class Client {

    public static void main(String[] args) {

        // 我们要代理的真实对象
        Subject realSubject = new RealSubject();//这里指定被代理类

        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader()，我们这里使用代理类的类加载器，也就是被代理的那个真实对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler，我们这里将这个代理对象关联到了上方的InvocationHandler 这个对象上
         */
        Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);

        //这里可以通过运行结果证明subject是Proxy的一个实例，这个实例实现了Subject接口
        System.out.println(subject instanceof Proxy);

        //这里可以看出subject的Class类是$Proxy0,这个$Proxy0类继承了Proxy，实现了Subject接口
        System.out.println("subject的Class类是：" + subject.getClass().toString());

        System.out.print("subject中的属性有：");

        Field[] field = subject.getClass().getDeclaredFields();
        for (Field f : field) {
            System.out.print(f.getName() + ", ");
        }

        System.out.print("\n" + "subject中的方法有：");

        Method[] method = subject.getClass().getDeclaredMethods();

        for (Method m : method) {
            System.out.print(m.getName() + ", ");
        }

        System.out.println("\n" + "subject的父类是：" + subject.getClass().getSuperclass());

        System.out.print("\n" + "subject实现的接口是：");

        Class<?>[] interfaces = subject.getClass().getInterfaces();

        for (Class<?> i : interfaces) {
            System.out.print(i.getName() + ", ");
        }

        System.out.println(subject.getClass().getName());
        System.out.println("\n\n" + "运行结果为：");
        subject.rent();
        subject.hello("world");
    }
}
