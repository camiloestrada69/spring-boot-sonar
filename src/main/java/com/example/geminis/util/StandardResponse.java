package com.example.geminis.util;

public class StandardResponse<T> {

    private int status;
    private String message;
    private String devMesssage;
    private AlertType alertType;
    private T body;

    public StandardResponse() {
    }

    public StandardResponse(StatusStandardResponse status, T body) {
        this.status = status.getStatus();
        this.body = body;
    }

    public StandardResponse(StatusStandardResponse status, String message, T body){
        this.status = status.getStatus();
        this.message = message;
        this.body = body;
    }

    public StandardResponse(StatusStandardResponse status) {
        this.status = status.getStatus();
    }

    public StandardResponse(String message, StatusStandardResponse status) {
        this.status = status.getStatus();
        this.message = message;
    }

    public StandardResponse(StatusStandardResponse status, String message, AlertType alertType) {
        this.status = status.getStatus();
        this.message = message;
        this.alertType = alertType;
    }

    public StandardResponse(int status, String message, String devMesssage, AlertType alertType, T body) {
        this.status = status;
        this.message = message;
        this.devMesssage = devMesssage;
        this.alertType = alertType;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDevMesssage() {
        return devMesssage;
    }

    public void setDevMesssage(String devMesssage) {
        this.devMesssage = devMesssage;
    }

    public AlertType getAlertType() {
        return alertType;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public enum StatusStandardResponse {
        //Utilizar cuando no se requiere imprimir mensage
        OK(200),

        //Utilizar en creación y actualización de datos y se requiera imprimir mensaje de exito
        CREATED(201),

        UPDATED(201),

        //Utilizar cuando se ejecute una accion que no devuelva contenido y se requiera imprimir mensaje de exito

        ACCION_OK(204),
        ERROR(1);

        private int status;

        StatusStandardResponse(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
    }
}
