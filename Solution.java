import java.util.ArrayList;
import java.util.*;

class Solution {

    public static String intToRoman(int num) {
        List<String> numeroRomano = new ArrayList<String>();
        String numero = String.valueOf((float)num / 1000);
        char[] numeroDividido = numero.toCharArray();
        int miles;
        int centenas;
        int decenas;
        int unidades;
        if (numeroDividido.length == 1) {
            miles = Character.getNumericValue(numeroDividido[0]);
            centenas = 0;
            decenas = 0;
            unidades = 0;
        } else if (numeroDividido.length == 3) {
            miles = Character.getNumericValue(numeroDividido[0]);
            centenas = Character.getNumericValue(numeroDividido[2]);
            decenas = 0;
            unidades = 0;
        } else if (numeroDividido.length == 4) {
            miles = Character.getNumericValue(numeroDividido[0]);
            centenas = Character.getNumericValue(numeroDividido[2]);
            decenas = Character.getNumericValue(numeroDividido[3]);
            unidades = 0;
        } else {
            miles = Character.getNumericValue(numeroDividido[0]);
            centenas = Character.getNumericValue(numeroDividido[2]);
            decenas = Character.getNumericValue(numeroDividido[3]);
            unidades = Character.getNumericValue(numeroDividido[4]);
        }
        while (miles != 0) {
            numeroRomano.add("M");
            miles -= 1;
        }
        
        switch (centenas) {
            case 4:
                numeroRomano.add("CD");
                break;
            case 5:
                numeroRomano.add("D");
                break;
            case 9:
                numeroRomano.add("CM");
                break;
            default:
                if (centenas > 5) {
                    numeroRomano.add("D");
                    while (centenas != 5) {
                        numeroRomano.add("C");
                        centenas -= 1;
                    }
                } else {
                    while (centenas != 0) {
                        numeroRomano.add("C");
                        centenas -= 1;
                    }
                }
        }

        switch (decenas) {
            case 4:
                numeroRomano.add("XL");
                break;
            case 5:
                numeroRomano.add("L");
                break;
            case 9:
                numeroRomano.add("XC");
                break;
            default:
                if (decenas > 5) {
                    numeroRomano.add("L");
                    while (decenas != 5) {
                        numeroRomano.add("X");
                        decenas -= 1;
                    }
                } else {
                    while (decenas != 0) {
                        numeroRomano.add("X");
                        decenas -= 1;
                    }
                }
        }

        switch (unidades) {
            case 4:
                numeroRomano.add("IV");
                break;
            case 5:
                numeroRomano.add("V");
                break;
            case 9:
                numeroRomano.add("IX");
                break;
            default:
                if (unidades > 5) {
                    numeroRomano.add("V");
                    while (unidades != 5) {
                        numeroRomano.add("I");
                        unidades -= 1;
                    }
                } else {
                    while (unidades != 0) {
                        numeroRomano.add("I");
                        unidades -= 1;
                    }
                }
        }

        String romano = new String();
        for (int i = 0; i < numeroRomano.size(); i++) {
            romano = romano + numeroRomano.get(i);
        }
        return romano;
    }
}