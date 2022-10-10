package com.example.demo.utils;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author YuChenXi
 * @date 2022/6/7 11:08 下午
 */
/*
@Component
public class TtInterfaceImpl implements TtInterface{
    @Override
    public void t1() {
        System.out.println("嘿嘿");
    }

    public  static Transaction t11(){
        Transaction build = Transaction.builder().year(11).build();
        return new Trader();
    }

}
class Trader extends Transaction{
    private String name;
    private  String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }
    public Trader() {
    }


    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}
@Builder
@Data
class Transaction {
    private Trader trader;
    private int year;
    private int value;

    @Override
    public String toString() {
        return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}*/
