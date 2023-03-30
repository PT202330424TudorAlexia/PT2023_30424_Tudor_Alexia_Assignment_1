package business_logic;

import data_logic.Polynomial;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class OperationsTest extends TestCase {

    private Polynomial p1,p2,r;
    private Operations o;
    private String result;

    @Before
    public void setUp() {
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();

        Operations o= new Operations();
    }

    public void testGetP1() {
    }

    @Test
    public void testComputeAdditionEqual() {
        //given
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();

        Operations o= new Operations();
        p1.polynomials.put(2,3.0);
        p1.polynomials.put(1,-8.0);
        p1.polynomials.put(0,1.0);

        p2.polynomials.put(2,5.0);
        p2.polynomials.put(1,1.0);
        p2.polynomials.put(0,-2.0);

        o.setP1(p1);

        //when
        r= o.compute(p2,"add");
        result=r.finalPolynomial(r);

        //then
        assertEquals("Result should be 8.0x^2 - 7.0x - 1.0",result,"8.0x^2 - 7.0x - 1.0");

    }

    @Test
    public void testComputewhenArgumentsAreEqualAndOperationIsMinusThenResultIsZero(){
        //given
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();

        Operations o= new Operations();
        p1.polynomials.put(2,5.0);
        p1.polynomials.put(1,1.0);
        p1.polynomials.put(0,2.0);

        p2.polynomials.put(2,5.0);
        p2.polynomials.put(1,1.0);
        p2.polynomials.put(0,2.0);

        o.setP1(p1);

        //when
        r= o.compute(p2,"sub");
        result=r.finalPolynomial(r);

        //then
        assertEquals("Result should be 0",result,"0");
    }

    @Test
    public void testComputeMultiplicationOperation() {
        //given
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();
        String result="";
        Operations o= new Operations();
        p1.polynomials.put(2,3.0);
        p1.polynomials.put(1,-8.0);
        p1.polynomials.put(0,1.0);

        p2.polynomials.put(2,5.0);
        p2.polynomials.put(1,1.0);
        p2.polynomials.put(0,-2.0);

        o.setP1(p1);

        //when
        r= o.compute(p2,"mul");
        result=r.finalPolynomial(r);

        //then
        assertEquals("Result should be 15.0x^4 - 37.0x^3 - 9.0x^2 + 17.0x - 2.0",result,"15.0x^4 - 37.0x^3 - 9.0x^2 + 17.0x - 2.0");

    }

    @Test
    public void testComputeDivideOperation() {
        //given
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();
        String result="";
        Operations o= new Operations();
        p1.polynomials.put(3,1.0);
        p1.polynomials.put(2,-2.0);
        p1.polynomials.put(1,+6.0);
        p1.polynomials.put(0,-5.0);


        p2.polynomials.put(2,2.0);
        p2.polynomials.put(0,-1.0);

        o.setP1(p1);

        //when
        r= o.compute(p2,"divide");
        result=r.finalPolynomial(r);

        //then
        assertEquals("Result should be 0.5x - 1.0",result,"0.5x - 1.0");

    }

    @Test
    public void testComputeIntegrationOperation() {
        //given
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();
        String result="";
        Operations o= new Operations();
        p1.polynomials.put(2,3.0);
        p1.polynomials.put(1,-8.0);
        p1.polynomials.put(0,1.0);

        o.setP1(p1);

        //when
        r= o.compute(p1,"integration");
        result=r.finalPolynomial(r);

        //then
        assertEquals("Result should be x^3 - 4.0x^2 + 1.0",result,"x^3 - 4.0x^2 + 1.0");

    }

    @Test
    public void testComputeDerivationOperation() {
        //given
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();
        String result="";
        Operations o= new Operations();
        p1.polynomials.put(2,3.0);
        p1.polynomials.put(1,-8.0);
        p1.polynomials.put(0,1.0);

        o.setP1(p1);

        //when
        r= o.compute(p1,"derivation");
        result=r.finalPolynomial(r);

        //then
        assertEquals("Result should be 6.0x - 8.0",result,"6.0x - 8.0");

    }
}