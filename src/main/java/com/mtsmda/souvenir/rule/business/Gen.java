package com.mtsmda.souvenir.rule.business;

/**
 * Created by MTSMDA on 29.05.2016.
 */
public class Gen<T extends Abst> {


    public static void main(String[] args) {
        new Gen<Abst>();
        new Gen<Super>();
    }

}



abstract class Abst {

}

class Super extends Abst {

}