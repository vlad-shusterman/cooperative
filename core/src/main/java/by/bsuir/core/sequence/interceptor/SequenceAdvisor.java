package by.bsuir.core.sequence.interceptor;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class SequenceAdvisor implements PointcutAdvisor {

    @Autowired
    @Qualifier("sequenceInterceptor")
    private MethodInterceptor methodInterceptor;

    @Override
    public Pointcut getPointcut() {
        return new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                return method.getName().startsWith("save")
                        && method.getDeclaringClass().isAssignableFrom(CrudRepository.class) ;
            }
        };
    }

    @Override
    public Advice getAdvice() {
        return methodInterceptor;
    }

    @Override
    public boolean isPerInstance() {
        return true;
    }
}
