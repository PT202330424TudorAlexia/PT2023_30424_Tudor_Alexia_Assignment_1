package business_logic;

import data_logic.Polynomial;
import jdk.dynalink.Operation;

public class Operations {

    private Polynomial p1;
    private String operation;

    public Operations() {

    }

    public Polynomial getP1() {
        return p1;
    }

    public void setP1(Polynomial p1) {
        this.p1 = p1;
    }

    public Polynomial compute(Polynomial p2, String operation) {
        Polynomial r = new Polynomial();

        switch (operation) {
            case "add":
                r = add(this.p1, p2);
                break;
            case "sub":
                r = substraction(this.p1, p2);
                break;
            case "mul":
                r = multiplication(this.p1, p2);
                break;
            case "divide":
                r = division(this.p1, p2);
                break;
            case "integration":
                r = integration(this.p1);
                break;
            case "derivation":
                r = derivative(this.p1);
                break;
        }
        return r;

    }

    private Polynomial add(Polynomial a, Polynomial b) {
        Polynomial r = new Polynomial();
        r.polynomials.putAll(a.polynomials);

        for (Integer i : b.getPolynomials().keySet()) {
            double c = 0;
            if (b.getPolynomials().containsKey(i))
                c = b.getPolynomials().get(i);

            if (r.getPolynomials().containsKey(i))
                r.polynomials.put(i, c + r.getPolynomials().get(i));
            else r.polynomials.put(i, c);
        }

        return r;
    }


    private Polynomial substraction(Polynomial a, Polynomial b) {
        Polynomial r = new Polynomial();
        r.polynomials.putAll(a.polynomials);

        for (Integer i : b.getPolynomials().keySet()) {
            double c = 0;
            if (b.getPolynomials().containsKey(i))
                c = b.getPolynomials().get(i);

            if (r.getPolynomials().containsKey(i))
                r.polynomials.put(i, r.getPolynomials().get(i) - c);
            else r.polynomials.put(i, -c);
        }

        return r;
    }

    private Polynomial division(Polynomial a, Polynomial b) {
        Polynomial r = new Polynomial();

        //while(grad(d)>=grad(i))
        //coefd=getCoefMax(d)
        //coefi=getCoefMax(i)
        //gradd=getGradMax(d)
        //gradi=getGradMax(i)
        //coefc=coefd/coefi
        //gradc=gradd-gradi
        //c.put(coefc,gradc)

        /*

        Polynom aux=new Polynom(coefc,gradc)
        c=c.add(aux)
        Polynom aux2=i.multiply(aux)
        d=d.substract(aux2)

         */

        return r;
    }

    private Polynomial integration(Polynomial a) {
        Polynomial r = new Polynomial();

        for (Integer i : a.getPolynomials().keySet()) {
            double c = 0;
            if (a.getPolynomials().containsKey(i)) {
                c = a.getPolynomials().get(i);
                if (i == 0) {
                    r.polynomials.put(i, c);
                } else {
                    r.polynomials.put(i + 1, c / (i + 1));
                }
            }
        }
        return r;
    }

    private Polynomial multiplication(Polynomial a, Polynomial b) {
        Polynomial r = new Polynomial();

        for (Integer j : a.getPolynomials().keySet()) {
            for (Integer i : b.getPolynomials().keySet()) {
                double c = 1;
                if (b.getPolynomials().containsKey(i)) {
                    c = b.getPolynomials().get(i);

                    if (r.getPolynomials().containsKey(i+j))
                        r.polynomials.put(j + i, c * a.getPolynomials().get(j)+ r.getPolynomials().get(i+j));
                    else r.polynomials.put(j + i, c * a.getPolynomials().get(j));

                }
            }
        }



        return r;

    }

    private Polynomial derivative(Polynomial a) {
        Polynomial r = new Polynomial();

        for (Integer i : a.getPolynomials().keySet()) {
            double c = 0;
            if (a.getPolynomials().containsKey(i)) {
                c = a.getPolynomials().get(i);
                if (i == 0) {
                    r.polynomials.put(i, c);
                } else r.polynomials.put(i - 1, c * i);
            }
        }
        return r;
    }

}
