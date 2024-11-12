package com.pluralsight.deliciousdeli.controller;

import com.pluralsight.deliciousdeli.enums.Bread;
import com.pluralsight.deliciousdeli.enums.SandWichSize;

public class DELIcousMain {
    public static void main(String[] args) {
       for(SandWichSize b: SandWichSize.values()){
           System.out.println(b.getBasePrice());
       }
    }
}
