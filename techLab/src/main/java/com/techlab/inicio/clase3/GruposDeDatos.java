package com.techlab.inicio.clase3;

public class GruposDeDatos {
    public static void main(String[] args) {
        String textoEjemplo = "mensaje en formato String 123";


        // 1. length() -> devuelve la cantidad de datos que hay en el array String
        System.out.println("length(): " + textoEjemplo.length());

        // 2. charAt(int index)  -> devuelve el caracter que se encuentre en ese indice
        System.out.println("charAt(0): " + textoEjemplo.charAt(0));

        // 3. substring(int beginIndex, int endIndex) -> devuelve los caracteres que se encuentren en el rango del 1 valor y el segundo valor
        System.out.println("substring(8, 10): " + textoEjemplo.substring(8, 10));

        // 4. toUpperCase() -> devuelve todo en maysucula
        System.out.println("toUpperCase(): " + textoEjemplo.toUpperCase());

        // 5. toLowerCase()  -> devuelve todo en minuscula
        System.out.println("toLowerCase(): " + textoEjemplo.toLowerCase());

        // 6. contains(CharSequence s) ->  devuelve verdadero o falso si se encuentra una paridad en caracteres
        System.out.println("contains(\"formato\"): " + textoEjemplo.contains("formato"));

        // 7. startsWith(String prefix) -> devuelve verdadero o falso si arranca con esa palabra
        System.out.println("startsWith(\"mensaje\"): " + textoEjemplo.startsWith("mensaje"));

        // 8. endsWith(String suffix) -> devuelve verdadero o falso si terimna con:
        System.out.println("endsWith(\"123\"): " + textoEjemplo.endsWith("123"));

        // 9. indexOf(String str) -> devuelve el indice de la primera letra.
        System.out.println("indexOf(\"formato\"): " + textoEjemplo.indexOf("formato"));

        // 10. lastIndexOf(String str) ->  muestra el último índice dnd se encuentra ese caracter
        System.out.println("lastIndexOf(\" \"): " + textoEjemplo.lastIndexOf(" "));

        // 11. replace(CharSequence target, CharSequence replacement) -> Reemplaza
        System.out.println("replace(\"mensaje\", \"texto\"): " + textoEjemplo.replace("mensaje", "texto"));

        // 12. equals(Object anObject) ->  Compara contenido
        System.out.println("equals(\"mensaje en formato String 123\"): " + textoEjemplo.equals("mensaje en formato String 123"));

        // 13. equalsIgnoreCase(String anotherString) -> 	Compara sin importar mayúsculas/minúsculas
        System.out.println("equalsIgnoreCase(\"MENSAJE EN FORMATO STRING 123\"): " + textoEjemplo.equalsIgnoreCase("MENSAJE EN FORMATO STRING 123"));

        // 14. trim() -> 	Elimina espacios extremos
        String conEspacios = "   Hola mundo!   ";
        System.out.println("trim(): '" + conEspacios.trim() + "'");

        // 15. split(String regex)  -> 	Divide el String en partes
        String[] palabras = textoEjemplo.split(" ");
        System.out.println("split(\" \"):");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }

        // 16. isEmpty()  -> Está vacío
        System.out.println("isEmpty(): " + textoEjemplo.isEmpty());

        // 17. matches(String regex)  -> Coincide con una expresión regular
        System.out.println("matches(\".*\\d+\"): " + textoEjemplo.matches(".*\\d+"));

        // 18. compareTo(String anotherString)   -> Compara lexicográficamente
        System.out.println("compareTo(\"mensaje en formato String 123\"): " + textoEjemplo.compareTo("mensaje en formato String 123"));

        // 19. intern()  -> 	Usa String del pool (optimiza memoria)
        String texto2 = new String("mensaje en formato String 123");
        System.out.println("intern(): " + (textoEjemplo == texto2.intern()));

        // 20. repeat(int count) (desde Java 11)  ->  Repite el String (Java 11+)
        System.out.println("repeat(2): " + textoEjemplo.repeat(2));


    }
}
