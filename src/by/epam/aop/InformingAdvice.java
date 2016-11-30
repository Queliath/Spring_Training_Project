package by.epam.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by Uladzislau_Kastsevic on 11/30/2016.
 */
public class InformingAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Method method = methodInvocation.getMethod();
        System.out.println("Before method: " + method.getName());
        Object returnValue = methodInvocation.proceed();
        System.out.println("After method: " + method.getName());
        return returnValue;
    }
}
