package com.mtsmda.souvenir.spring.validation.structural;

/**
 * Created by dminzat on 6/15/2016.
 */
public class StructuralValidationResultObject {

    private String message;
    private Object value;
    private String propertyPathName;

    public StructuralValidationResultObject() {

    }

    public StructuralValidationResultObject(String message, Object value, String propertyPathName) {
        this.message = message;
        this.value = value;
        this.propertyPathName = propertyPathName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getPropertyPathName() {
        return propertyPathName;
    }

    public void setPropertyPathName(String propertyPathName) {
        this.propertyPathName = propertyPathName;
    }

    @Override
    public String toString() {
        return "StructuralValidationResultObject{" +
                "message='" + message + '\'' +
                ", value=" + value +
                ", propertyPathName='" + propertyPathName + '\'' +
                '}';
    }
}