package com.demo.mysql_resources.aspect;

import com.demo.mysql_resources.annonation.DS;
import com.demo.mysql_resources.resource.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 宋艾衡
 * @date 2019/6/24 15:19
 * @desc
 */

@Aspect
@Component
public class DynamicDataSourceAspect {


    @Before("@annotation(DS)")

    public void beforeSwitchDS(JoinPoint point) {
        Class<?> className = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        Class<?>[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            Method method = className.getMethod(methodName, argClass);

            if (method.isAnnotationPresent(DS.class)) {
                DS annotation = method.getAnnotation(DS.class);
                dataSource = annotation.value();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        DataSourceContextHolder.setDS(dataSource);
    }

    @After("@annotation(DS)")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHolder.clearDS();
    }
}
