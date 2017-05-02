package br.com.a3maismais.a321go.model;

/**
 * Created by fred on 27/04/17.
 */

public enum Status {

    STOPPED("Stopped - Back"),
    EXERCISE("In Action - Green"),
    PREPARE("Preparing - Yellow"),
    REST("Rest - Red");

    private final String color;

    private Status(String cor) {

        this.color = cor;

    }

    public String getCor() {
        return color;
    }


}
