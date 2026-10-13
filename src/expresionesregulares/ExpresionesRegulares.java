package ExpresionesRegulares;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ExpresionesRegulares {
    
    private static final String PLACA = "[A-Z]{3}\\d{3}";
    private static final String POSTAL = "0500\\d{2}";
    private static final String FIJOS = "[2-5]\\d{6}";
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
}
  