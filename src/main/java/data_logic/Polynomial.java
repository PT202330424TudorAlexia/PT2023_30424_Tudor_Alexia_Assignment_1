package data_logic;

import java.util.Collections;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    public HashMap<Integer, Double> polynomials = new HashMap();

    public Polynomial() {
    }

    public Polynomial(String input) {
        this.polynomials = polynomialStringToHash(input);
    }

    public HashMap polynomialStringToHash(String input) {
        HashMap<Integer, Double> degreeAndCoeffs = new HashMap();

        input = input.replace("-", "+-");

        String[] parts = input.split("\\+");
        for (String term : parts) {
            Double coeff = null;
            Integer degree = null;
            if (term.contains("x")) {
                Pattern pattern = Pattern.compile("([-]?\\d*)[^+]x?\\^?(\\d*)");
                Matcher matcher = pattern.matcher(term);
                String x;
                if (matcher.find()) {
                    x = matcher.group(1);

                    coeff = (matcher.group(1) == null || matcher.group(1).isEmpty() || matcher.group(1).equals("-")) ? 1.0 : Double.parseDouble(matcher.group(1));
                    degree = (matcher.group(2) == null || matcher.group(2).isEmpty()) ? 0 : Integer.parseInt(matcher.group(2));

                    if (degree == 0)
                        degreeAndCoeffs.put(1, coeff);
                    else degreeAndCoeffs.put(degree, coeff);
                }
            } else if (term != "") {
                coeff = Double.parseDouble(term);
                degreeAndCoeffs.put(0, coeff);
            }
        }
        return degreeAndCoeffs;
    }


    public HashMap<Integer, Double> getPolynomials() {
        return polynomials;
    }

    public void setPolynomials(HashMap<Integer, Double> polynomials) {
        this.polynomials = polynomials;
    }

    public TreeMap orderHashMap(HashMap<Integer, Double> polynomials) {
        TreeMap<Integer, Double> sortHash = new TreeMap<>(Collections.reverseOrder());
        sortHash.putAll(polynomials);

        return sortHash;
    }

    public String finalPolynomial(Polynomial a) {
        String result;
        return result = listTree(a.orderHashMap(a.polynomials));

    }

    public String listTree(TreeMap<Integer, Double> poltree) {
        StringBuilder sb = new StringBuilder();
        boolean isFirstTerm = true;
        for (Map.Entry<Integer, Double> entry : poltree.entrySet()) {
            int degree = entry.getKey();
            double coefficient = entry.getValue();
            if (coefficient == 0) {
                continue;
            }
            if (coefficient > 0 && !isFirstTerm) {
                sb.append(" + ");
            }
            if (coefficient < 0) {
                sb.append(" - ");
                coefficient = -coefficient;
            }
            if (coefficient != 1 || degree == 0) {
                sb.append(coefficient);
            }
            if (degree > 1) {
                sb.append("x^").append(degree);
            } else if (degree == 1) {
                sb.append("x");
            }
            isFirstTerm = false;
        }
        if (sb.length() == 0) {
            sb.append("0");
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


    public Double getCoeff(TreeMap<Integer, Double> poltree) {
        return poltree.firstEntry().getValue();
    }

    public Integer getHighestGrade(TreeMap<Integer, Double> poltree) {
        return poltree.firstKey();
    }

    public Integer getNextHighestGrade(TreeMap<Integer, Double> poltree) {
        while (getCoeff(poltree) == 0)
            poltree.remove(getHighestGrade(poltree));
        return poltree.firstKey();
    }

}
