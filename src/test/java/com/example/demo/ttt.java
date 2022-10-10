package com.example.demo;

import com.example.demo.utils.TestStrategyImp;
import com.example.demo.utils.TtInterface;
import com.example.demo.utils.ValidStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author YuChenXi
 * @date 2022/5/22 4:39 下午
 */
public class ttt {

    @Test
    public void tt (){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions =
                Arrays.asList(new Transaction(brian, 2011, 300),
                        new Transaction(raoul, 2012, 1000),
                        new Transaction(raoul, 2011, 400),
                        new Transaction(mario, 2012, 710),
                        new Transaction(mario, 2012, 700),
                        new Transaction(alan, 2012, 950));
        TestStrategyImp testStrategyImp = new TestStrategyImp();
        Optional<String> s1 = testStrategyImp.executeV11("22222");
        Transaction transaction = new Transaction();
        Optional<Transaction> transaction1 = Optional.of(transaction);
        String s = transaction1
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .orElseGet(() -> String.valueOf(11));

        HashMap<String, String> map = new HashMap<>();
        //map.put("sss","sss1");\
        Optional<Object> empty = Optional.empty();
        boolean present = empty.isPresent();
        System.out.println(present);
        BigInteger bigInteger = BigInteger.probablePrime(100, new Random());

        //   Optional<String> sss = Optional.ofNullable(map.get("sss"));
        /* List<Transaction> collect = transactions.stream()
                .filter(i -> i.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(collect);*/

        /*List<String> collect = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);*/

      /*  List<Trader> cambridge = transactions.stream().
                map(Transaction::getTrader)
                .filter(i -> i.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(cambridge);*/
      /*  String reduce = transactions.stream().
                map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining());
        System.out.println(reduce);
*/
      /*  boolean milan = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(i -> i.getCity().equals("Milan"));
        System.out.println(milan);*/
/*
        Integer cambridge = transactions.stream()
                .filter(i -> i.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println(cambridge);*/

       /* Integer integer = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .get();
        System.out.println(integer);*/

       /* Transaction transaction = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue,Comparator.reverseOrder()))
                .findFirst().get();
        System.out.println(transaction);*/

     /*   long l = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(1, 100000000)
                .reduce(0, Long::sum);
        System.out.println(reduce);
        System.out.println("-------"+(System.currentTimeMillis()-l));*/

        // lambda的策略模式
       /* Predicate <String> p = s->s.equals("111");

        ValidStrategy v = new ValidStrategy(p);
        ValidStrategy v1 = new ValidStrategy(s->s.equals("2"));
        String validate = v.validate("111");
        String validate2 = v1.validate("1");
        System.out.println(validate);
        System.out.println(validate2);*/
    }

    public  static Transaction t11(){
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

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

class Transaction {
    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Transaction() {
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}