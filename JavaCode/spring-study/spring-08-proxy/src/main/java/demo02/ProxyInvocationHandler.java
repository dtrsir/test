package demo02;

import demo01.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//使用这个类来自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //得到生成代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

    }

    //处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        return invoke;
    }
}
