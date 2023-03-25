package org.example;

import business_logic.Operations;
import data_logic.Polynomial;

import java.util.Collections;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String result;
        Polynomial a =new Polynomial();
        a.polynomials.put(2,3.0);
        a.polynomials.put(1,-8.0);
        a.polynomials.put(0,1.0);

        Polynomial b =new Polynomial();
        b.polynomials.put(2,5.0);
        b.polynomials.put(1,1.0);
        b.polynomials.put(0,2.0);

        Polynomial r=new Polynomial();
        Operations o=new Operations();
        o.setP1(a);
        r= o.compute(b,"mul");

      //  result=r.listPolynomial();
     //   System.out.println(result);

     //   r= o.compute(b,"integration");

        result=r.listPolynomial();
      //  System.out.println(result);

     //   r= o.compute(b,"sub");

      //  result=r.listPolynomial();
      //  System.out.println(result);

      //  r= o.compute(b,"mul");

       // result=r.listPolynomial();
        //System.out.println(result);

        TreeMap<Integer, Double> tree=r.orderHashMap(r.polynomials);

       // result=r.listTree(tree);
        System.out.println(result);

    }
}
