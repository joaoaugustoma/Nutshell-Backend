package com.ueg.nutshellbackend.common.util;

import com.ueg.nutshellbackend.application.model.reflection.GenericTabela;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Util {

    static Method method;

    public static String getUCFirst(String name) {
        return getFirstChar(name).toUpperCase() + name.substring(1);
    }

    public static Object invokeMethod(GenericTabela genericTabela, String methodName, Object object) {
        Class<?> cls = genericTabela.getClass();

        method = null;
        try {
            if (object == null) {
                method = cls.getMethod(methodName);
                return method.invoke(genericTabela);
            } else {
                method = cls.getMethod(methodName, object.getClass());
                return method.invoke(genericTabela, object);
            }

        } catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("A classe: " + cls.getName() + " n�o possui o metodo: " + methodName + " com visibilidade p�blica, ou n�o existe!");
        } catch (IllegalAccessException |
                 IllegalArgumentException |
                 InvocationTargetException e) {
            throw new RuntimeException("Houve um erro desconhecido na execu��o do m�todo:" + cls.getName() + "." + methodName, e);
        }
    }

    public static Object invokeGetMethod(GenericTabela genericTabela, String fieldName) {
        String methodName = getGetterMethodName(fieldName);
        return invokeMethod(genericTabela, methodName, null);
    }

    public static void invokeSetMethod(GenericTabela genericTabela, String fieldName, Object object) {
        String methodName = getSettterMethodName(fieldName);
        invokeMethod(genericTabela, methodName, object);
    }

    public static String getGetterMethodName(String fieldName) {
        return "get" + Util.getUCFirst(fieldName);
    }

    public static String getSettterMethodName(String fieldName) {
        return "set" + Util.getUCFirst(fieldName);
    }

    public static String getLastChar(String str) {
        return str.substring(str.length() - 1);
    }

    public static String getFirstChar(String str) {
        return str.substring(0, 1);
    }
}
