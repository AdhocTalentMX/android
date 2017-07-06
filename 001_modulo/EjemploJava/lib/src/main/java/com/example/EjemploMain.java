package com.example;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class EjemploMain {

    public static void main(String[] args) {
        System.out.println("Programa Java");
        ClaseBase obj =
                new ClaseDerivada();
        obj.verificaNum();
        obj.cambiarX(8);
        obj.verificaNum();

    }

}
