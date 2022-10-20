package com.ueg.nutshellbackend.application.model.reflection;

import com.ueg.nutshellbackend.common.util.Util;

import javax.persistence.Id;
import java.lang.reflect.Field;

public class ReflexaoTabela {

    private static Class<?> clazz;
    private static Field[] attributes;

    private static Field getIdField(GenericTabela genericTabela) {
        validarParametroTab(genericTabela);

        Field idField = null;
        clazz = genericTabela.getClass();
        attributes = clazz.getDeclaredFields();

        for (Field attribute : attributes) {
            if (attribute.isAnnotationPresent(Id.class)) {
                idField = attribute;
            }
        }
        if (idField == null) {
            throw new RuntimeException(
                    "Classe: " + clazz.getName() + " não tem nenhum atributo anotado com @Id");
        }
        return idField;
    }

    public static Object getIdValue(GenericTabela genericTabela
    ) {
        Field idField = getIdField(genericTabela);
        String idMethodName = Util.getGetterMethodName(idField.getName());

        return Util.invokeGetMethod(genericTabela, idMethodName);
    }

    public static void validarParametroTab(GenericTabela genericTabela) {
        if (genericTabela == null) {
            throw new RuntimeException("Erro Metodo ReflexaoTabela " + genericTabela + ", deve receber um objeto não nulo");
        }
    }
}
