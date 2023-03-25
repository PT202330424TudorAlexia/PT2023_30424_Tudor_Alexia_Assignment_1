package data_logic;

import graphic_user_interface.Graphic;

import java.util.Collections;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    public HashMap<Integer, Double> polynomials = new HashMap();

    public Polynomial() {
    }

    public Polynomial(String input) {
        this.polynomials=polynomialStringToInt(input);
    }

    public HashMap polynomialStringToInt( String input) {
        HashMap<Integer, Double> degreeToCoeff = new HashMap();

        input = input.replace("-", "+-");

        String[] parts = input.split("\\+");
        String x;
        for (String term : parts) {
            Double coeff;
            Integer degree;
            if(term.contains("x")) {
                Pattern pattern = Pattern.compile("([-]?\\d*)[^+]x?\\^?(\\d*)");
                Matcher matcher = pattern.matcher(term);

                if (matcher.find()) {
                    x = matcher.group(1);

                    coeff = (matcher.group(1) == null || matcher.group(1).isEmpty() || matcher.group(1).equals("-")) ? 1.0 : Double.parseDouble(matcher.group(1));
                    degree = (matcher.group(2) == null || matcher.group(2).isEmpty()) ? 0 : Integer.parseInt(matcher.group(2));

                    if(degree==0)
                        degreeToCoeff.put(1, coeff);
                    else degreeToCoeff.put(degree, coeff);
                }
            }else if(term != ""){
                coeff = Double.parseDouble(term);
                degreeToCoeff.put(0, coeff);
            }
        }
    return degreeToCoeff;
    }


    public HashMap<Integer, Double> getPolynomials() {
        return polynomials;
    }

    public void setPolynomials(HashMap<Integer, Double> polynomials) {
        this.polynomials = polynomials;
    }

    public TreeMap orderHashMap(HashMap<Integer, Double> polynomials) {
        TreeMap<Integer, Double> sortHash = new TreeMap<>(Collections.reverseOrder());
        Polynomial result = new Polynomial();
        sortHash.putAll(polynomials);

        return sortHash;
    }

    public String finalPolynomial(Polynomial a){
        String result;
        return result=listTree(a.orderHashMap(a.polynomials));

    }

    public String listTree(TreeMap<Integer, Double> poltree) {
        StringBuilder sb = new StringBuilder();
        boolean isFirstTerm = true;
        for (Map.Entry<Integer, Double> entry : poltree.entrySet()) {
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            if (coefficient == 0) {
                continue; // skip terms with a coefficient of zero
            }
            if (coefficient > 0 && !isFirstTerm) {
                sb.append(" + "); // add a plus sign for positive terms (except the first term)
            }
            if (coefficient < 0) {
                sb.append(" - "); // add a minus sign for negative terms
                coefficient = -coefficient; // make the coefficient positive for formatting purposes
            }
            if (coefficient != 1 || degree == 0) {
                sb.append(coefficient); // print the coefficient (except for x^0)
            }
            if (degree > 1) {
                sb.append("x^").append(degree); // print x^n
            } else if (degree == 1) {
                sb.append("x"); // print x
            }
            isFirstTerm = false;
        }
        if (sb.length() == 0) {
            sb.append("0"); // handle the case where the polynomial is zero
        }
        return sb.toString();
    }


    public String listPolynomial() {
        String result = " ";
        for (Integer i : this.getPolynomials().keySet()) {
            double c = 0, k = 0;

            if (this.getPolynomials().containsKey(i)) {
                c = this.getPolynomials().get(i);

                if (c == 0 || c == 1) {
                    if (i == 1)
                        result = result + "+ " + "x ";
                    else if (i == 0) result = result + "+ " + c + " ";
                    else result = result + "+ " + "x^" + i + " ";
                } else if (c > 0) {
                    if (i == 1)
                        result = result + "+ " + "x ";
                    else if (i == 0) result = result + "+ " + c + " ";
                    else result = result + "+ " + c + "x^" + i + " ";
                } else if (c < 0 || k == 0) {
                    if (i == 1)
                        result = result + c + "x ";
                    else if (i == 0) result = result + c + " ";
                    else result = result + c + "x^" + i + " ";
                }
                if (k == 0) {
                    String newresult = result.substring(1);
                    result = newresult;
                    k = 1;
                }
            }
        }
        return result;
    }


    public double getCoeff(Polynomial pol, Integer key) {
        return pol.polynomials.get(key);
    }

    void getHighestGrade(HashMap polynomials) {

    }

    public static void main(String[] args) {
        Polynomial first = new Polynomial();
        Polynomial finalpol = new Polynomial();
        // split dupa + in List<String>
        //si replace la - cu +-
        String poly = "-3x^2-x+5";

        poly = poly.replace("-", "+-");

        Map<Integer, Double> degreeToCoeff = new HashMap<>();

        System.out.println(poly);
        String[] parts = poly.split("\\+");
        String x;
        for (String term : parts) {
            Double coeff;
            Integer degree;
            if(term.contains("x")) {
                Pattern pattern = Pattern.compile("([-]?\\d*)[^+]x?\\^?(\\d*)");
                Matcher matcher = pattern.matcher(term);

                if (matcher.find()) {
                    x = matcher.group(1);
                    System.out.println(x);

                    coeff = (matcher.group(1) == null || matcher.group(1).isEmpty() || matcher.group(1).equals("-")) ? 1.0 : Double.parseDouble(matcher.group(1));
                    degree = (matcher.group(2) == null || matcher.group(2).isEmpty()) ? 0 : Integer.parseInt(matcher.group(2));

                    if(degree==0)
                    degreeToCoeff.put(1, coeff);
                    else degreeToCoeff.put(degree, coeff);
                }
            }else if(term != ""){
                coeff = Double.parseDouble(term);
                degreeToCoeff.put(0, coeff);
            }
        }
        System.out.println(degreeToCoeff);
    }
}
