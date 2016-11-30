package by.epam.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Uladzislau_Kastsevic on 11/30/2016.
 */
public class Main {
    public static void main(String[] args){
        FunctionalClass target = new FunctionalClass();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new InformingAdvice());
        proxyFactory.setTarget(target);

        FunctionalClass proxy = (FunctionalClass) proxyFactory.getProxy();

        target.doSomeOperation();
        proxy.doSomeOperation();
    }
}
