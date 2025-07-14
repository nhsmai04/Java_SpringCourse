package Proxies65;

import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Greeter realGreeter = new GreeterImpl();

        Greeter greeterProxy = (Greeter) Proxy.newProxyInstance(
                Greeter.class.getClassLoader(),
                new Class[] { Greeter.class },
                new LoggingHandler(realGreeter)
        );

        System.out.println(greeterProxy.sayHello("Alice"));
    }
}

