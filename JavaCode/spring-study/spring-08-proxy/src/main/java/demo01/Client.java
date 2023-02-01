package demo01;

public class Client {
    public static void main(String[] args) {
        //被代理角色
        Host host = new Host();

        //代理角色
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        //调用程序处理对象来处理要调用的接口对象
        proxyInvocationHandler.setRent(host);

        Rent proxy = (Rent) proxyInvocationHandler.getProxy();

        proxy.rent();
    }
}
