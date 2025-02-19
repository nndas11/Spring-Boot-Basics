package com.example.demo.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomAnnotation {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Pet pet = new Pet();
        pet.name = "Cat";

        if(pet.getClass().isAnnotationPresent(VeryImportant.class)){
            System.out.println("Very Important!!");
        }


        for(Method method : pet.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for(int i =0;i<annotation.times();i++){
                    method.invoke(pet);
                }
            }
        }

        for(Field field :pet.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(FieldImportant.class)){
                Object objectValue = field.get(pet);
                if(objectValue instanceof String stringValue){
                    System.out.println(stringValue);
                }
            }
        }
    }
}
