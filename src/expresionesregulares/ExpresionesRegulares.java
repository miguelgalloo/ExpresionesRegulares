package expresionesregulares;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ExpresionesRegulares {
    
    private static final String PLACA = "[A-Z]{3}\\d{3}";
    private static final String POSTAL = "0500\\d{2}";
    private static final String FIJOS = "(?:604)?[2-5]\\d{6}";
    private static final String CELULARES = "3\\d{9}";
    private static final String CORREO = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
    private static final String FECHA = "(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}";
    private static final String HMILITAR = "([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
    private static final String HNORMAL = "(0[1-9]|1[0-2]):[0-5]\\d:[0-5]\\d\\s(AM|PM)";
    private static final String VARIABLES = "(int|long|short|byte|double|float|char|boolean|String)\\s+[a-zA-Z_$][a-zA-Z0-9_$]*(\\s*=\\s*[^;]+)?;";
    private static final String URL = "https?://([\\w-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/[^\\s]*)?";
    private static final String ISBN = "\\d{9}[\\dX]"; //es ISBN-10 
    private static final String BARRAS = "770\\d{10}";
    private static final String NOMBRES = "[A-ZÁÉÍÓÚÑÜ][a-záéíóúñü]+(\\\\s[A-ZÁÉÍÓÚÑÜ][a-záéíóúñü]+)*";
    private static final String CONTRASEÑA = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%&+=!*._-])\\S{8,}";
    private static final String CICLO = "for\\s*\\(\\s*(int\\s+)?[a-zA-Z_]\\w*\\s*=\\s*\\w+\\s*;\\s*[a-zA-Z_]\\w*\\s*(<=|>=|<|>|!=|==)\\s*\\w+\\s*;\\s*[a-zA-Z_]\\w*\\s*(\\+\\+|--|\\+=\\s*\\w+|-=\\s*\\w+)\\s*\\)";
    private static final String NDOUBLE = "[+-]?\\d+\\.\\d+";
    private static final String LEYES = "(?i)(?:(?:ley|decreto|resolución)\\s\\d{1,4}\\sde\\s\\d{4}|art(?:ículo|\\.)\\s?\\d{1,4})";
    private static final String RIEEE = "\\[\\d+\\]\\s(?:[A-Z]\\.\\s)+[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?:,\\s(?:[A-Z]\\.\\s)+[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*,\\s[^,]+,\\s(?:\\d+(?:st|nd|rd|th)\\sed\\.\\s)?[^:]+:\\s[^,]+,\\s\\d{4}\\.";
    private static final String RAPA = "(?:[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+,\\s(?:[A-Z]\\.\\s?)+(?:,\\s&\\s|,\\s)?)+\\(\\d{4}\\)\\.\\s[^.]+\\.\\s(?:\\(\\d+\\.?ª?\\sed\\.\\)\\.\\s)?[^.]+\\.";
    private static final String PRECIOS = "\\$\\s?\\d{1,3}(\\.\\d{3})*(,\\d{2})?|\\$\\s?\\d+(,\\d{2})?";
    private static final String DIPTONGOS = "(?i)[aeoáéó][iuü]|[iuü][aeoáéó]|iu|ui";
    private static final String HIATOS = "(?i)[aeoáéó][aeoáéó]|[aeo][íú]|[íú][aeo]";


    public static void main(String[] args) {
        placas();
        postal();
        fijos();
        celulares();
        correo();
        fecha();
        hmilitar();
        hnormal();
        variables();
        url();
        isbn();
 
     
    }
     static String validar(boolean x) {
   
 
        if (x) {
            return "Es válido";
        } else {
            return "No es válido";
        }
    }
    
    static void placas() {
        String titulo = "PLACAS DE CARRO";
        Pattern p = Pattern.compile(PLACA);
        Matcher m;
        String resultado;
 
        // ---- matches() ----
        String cadena = "ABC123";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "AB1234";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        // ---- find() ----
        String texto = "Los carros ABC123 y XYZ987 están registrados";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrada: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        // ---- replaceAll() y replaceFirst() ----
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(PLACA, "[PLACA]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(PLACA, "[PLACA]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        // ---- split() ----
        String lista = "ABC123, XYZ987;DEF456";
        String[] partes = lista.split("\\s*[,;]\\s*");
        resultado = "Lista: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
           int k=i+1;
            resultado += "Parte " + k + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
     static void postal() {
        String titulo = "CÓDIGOS POSTALES MEDELLÍN";
        Pattern p = Pattern.compile(POSTAL);
        Matcher m;
        String resultado;
 
        // ---- matches() ----
        String cadena = "050021";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "110111";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        // ---- find() ----
        String texto = "Envíos a 050001, 050021 y 110111 (Bogotá)";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrada: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        // ---- replaceAll() y replaceFirst() ----
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(PLACA, "[PLACA]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(PLACA, "[PLACA]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        // ---- split() ----
        String lista = "050001-050021-050030";
        String[] partes = lista.split("-");
        resultado = "Lista: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
           int k=i+1;
            resultado += "Parte " + k + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
     static void fijos() {
        String titulo = "TELÉFONOS FIJOS MEDELLÍN";
        Pattern p = Pattern.compile(FIJOS);
        Matcher m;
        String resultado;
 
        String cadena = "(604) 2345678";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "1234567";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        String texto = "Llame al 2345678 o al +57 604 3216549 o al 4441122";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrado: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(FIJOS, "[TEL]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(FIJOS, "[TEL]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        String lista = "2345678 / 3216549 / 4441122";
        String[] partes = lista.split("\\s*/\\s*");
        resultado = "Lista: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
            int k = i + 1;
            resultado += "Parte " + k + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
 
   
    static void celulares() {
        String titulo = "CELULARES COLOMBIA";
        Pattern p = Pattern.compile(CELULARES);
        Matcher m;
        String resultado;
 
        String cadena = "3101234567";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "2101234567";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        String texto = "Llámame al 3101234567 o al +57 3209876543";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrado: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(CELULARES, "[CEL]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(CELULARES, "[CEL]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        String lista = "3101234567 / 3209876543 / 3001112233";
        String[] partes = lista.split("\\s*/\\s*");
        resultado = "Lista: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
            int k = i + 1;
            resultado += "Parte " + k + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
 
    static void correo() {
        String titulo = "CORREOS ELECTRÓNICOS";
        Pattern p = Pattern.compile(CORREO);
        Matcher m;
        String resultado;
 
        String cadena = "juan.perez@gmail.com";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "juan.perez@gmail";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        String texto = "Escríbanos a ventas@empresa.com o a soporte@mail.co.uk";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrado: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(CORREO, "[CORREO]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(CORREO, "[CORREO]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        String lista = "ana@mail.com; luis@mail.com, eva@mail.com";
        String[] partes = lista.split("\\s*[,;]\\s*");
        resultado = "Lista: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
            int k = i + 1;
            resultado += "Parte " + k + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
 

    static void fecha() {
        String titulo = "FECHAS dd/mm/aaaa";
        Pattern p = Pattern.compile(FECHA);
        Matcher m;
        String resultado;
 
        String cadena = "01/01/2023";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "32/13/2023";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        String texto = "Nació el 15/03/1998 y se graduó el 20/11/2020";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrada: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(FECHA, "[FECHA]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(FECHA, "[FECHA]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        String lista = "15/03/1998";
        String[] partes = lista.split("/");
        String[] nombres = {"Día", "Mes", "Año"};
        resultado = "Fecha: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
            resultado += nombres[i] + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
 
 
    static void hmilitar() {
        String titulo = "HORA 24 HORAS";
        Pattern p = Pattern.compile(HMILITAR);
        Matcher m;
        String resultado;
 
        String cadena = "14:30:00";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "25:61:00";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        String texto = "Entrada 08:15:00 y salida 17:45:30";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrada: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(HMILITAR, "[HORA]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(HMILITAR, "[HORA]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        String lista = "08:15:30";
        String[] partes = lista.split(":");
        String[] nombres = {"Hora", "Minuto", "Segundo"};
        resultado = "Hora: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
            resultado += nombres[i] + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
 

    static void hnormal() {
        String titulo = "HORA 12 HORAS";
        Pattern p = Pattern.compile(HNORMAL);
        Matcher m;
        String resultado;
 
        String cadena = "02:30:00 AM";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "13:30:00 PM";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        String texto = "Abre a las 08:00:00 AM y cierra a las 06:30:00 PM";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrada: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(HNORMAL, "[HORA]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(HNORMAL, "[HORA]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        String lista = "08:00:00 AM - 06:30:00 PM";
        String[] partes = lista.split("\\s*-\\s*");
        resultado = "Lista: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
            int k = i + 1;
            resultado += "Parte " + k + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
 

    static void variables() {
        String titulo = "DECLARACIÓN DE VARIABLES";
        Pattern p = Pattern.compile(VARIABLES);
        Matcher m;
        String resultado;
 
        String cadena = "int contador = 0;";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "int 2x = 5;";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        String texto = "int a = 5; double precio = 9.5; String nombre;";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrada: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(VARIABLES, "[VARIABLE]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(VARIABLES, "[VARIABLE]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        String lista = "int a = 5; double b = 2.5; boolean ok = true";
        String[] partes = lista.split("\\s*;\\s*");
        resultado = "Lista: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
            int k = i + 1;
            resultado += "Parte " + k + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
 
  
    static void url() {
        String titulo = "URL";
        Pattern p = Pattern.compile(URL);
        Matcher m;
        String resultado;
 
        String cadena = "https://www.google.com";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "www.google.com";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        String texto = "Visite https://www.udea.edu.co o http://ejemplo.com/inicio para más info";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrada: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(URL, "[URL]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(URL, "[URL]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        String lista = "https://google.com | http://udea.edu.co | https://youtube.com";
        String[] partes = lista.split("\\s*\\|\\s*");
        resultado = "Lista: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
            int k = i + 1;
            resultado += "Parte " + k + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
 
    static void isbn() {
        String titulo = "ISBN-10";
        Pattern p = Pattern.compile(ISBN);
        Matcher m;
        String resultado;
 
        String cadena = "0306406152";
        m = p.matcher(cadena);
        resultado = cadena + " -> " + validar(m.matches()) + "\n";
 
        cadena = "03064061";
        m = p.matcher(cadena);
        resultado += cadena + " -> " + validar(m.matches());
        JOptionPane.showMessageDialog(null, resultado, titulo + " - matches()", JOptionPane.INFORMATION_MESSAGE);
 
        String texto = "Libros 0306406152 y 080442957X";
        m = p.matcher(texto);
        resultado = "Texto: " + texto + "\n\n";
        while (m.find()) {
            resultado += "Encontrado: " + m.group() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - find()", JOptionPane.INFORMATION_MESSAGE);
 
        resultado = "Original: " + texto + "\n\n"
                + "replaceAll: " + texto.replaceAll(ISBN, "[ISBN-10]") + "\n"
                + "replaceFirst: " + texto.replaceFirst(ISBN, "[ISBN-10]");
        JOptionPane.showMessageDialog(null, resultado, titulo + " - replaceAll() / replaceFirst()", JOptionPane.INFORMATION_MESSAGE);
 
        String lista = "0306406152, 080442957X";
        String[] partes = lista.split("\\s*,\\s*");
        resultado = "Lista: " + lista + "\n\n";
        for (int i = 0; i < partes.length; i++) {
            int k = i + 1;
            resultado += "Parte " + k + ": " + partes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado, titulo + " - split()", JOptionPane.INFORMATION_MESSAGE);
    }
 
}
  