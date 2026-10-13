package ExpresionesRegulares;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ExpresionesRegulares {

    public static void main(String[] args) {
    
        int cont = 0;
        Pattern p;
        Matcher m;
        
        String PLACA = "[A-Z]{3}\\d{3}";
        String POSTAL = "0500\\d{2}";
        String FIJOS = "[2-5]\\d{6}";
        String CELULARES = "3\\d{9}";
        String CORREO = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
        String FECHA = "(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}";
        String HMILITAR = "([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
        String HNORMAL = "(0[1-9]|1[0-2]):[0-5]\\d:[0-5]\\d\\s(AM|PM)";
        String VARIABLES  = "(int|long|short|byte|double|float|char|boolean|String)\\s+[a-zA-Z_$][a-zA-Z0-9_$]*(\\s*=\\s*[^;]+)?;";
        String URL = "https?://([\\w-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/[^\\s]*)?";
        String ISBN = "\\d{9}[\\dX]"; //es ISBN-10 
        String BARRAS = "770\\d{10}";
        String NOMBRES = "[A-ZÁÉÍÓÚÑÜ][a-záéíóúñü]+(\\\\s[A-ZÁÉÍÓÚÑÜ][a-záéíóúñü]+)*";
        String CONTRASEÑA = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%&+=!*._-])\\S{8,}";
        String CICLO = "for\\s*\\(\\s*(int\\s+)?[a-zA-Z_]\\w*\\s*=\\s*\\w+\\s*;\\s*[a-zA-Z_]\\w*\\s*(<=|>=|<|>|!=|==)\\s*\\w+\\s*;\\s*[a-zA-Z_]\\w*\\s*(\\+\\+|--|\\+=\\s*\\w+|-=\\s*\\w+)\\s*\\)";
        String NDOUBLE = "[+-]?\\d+\\.\\d+";
        String LEYES = "(?i)(?:(?:ley|decreto|resolución)\\s\\d{1,4}\\sde\\s\\d{4}|art(?:ículo|\\.)\\s?\\d{1,4})";
        String RIEEE = "\\[\\d+\\]\\s(?:[A-Z]\\.\\s)+[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?:,\\s(?:[A-Z]\\.\\s)+[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*,\\s[^,]+,\\s(?:\\d+(?:st|nd|rd|th)\\sed\\.\\s)?[^:]+:\\s[^,]+,\\s\\d{4}\\.";
        String RAPA = "(?:[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+,\\s(?:[A-Z]\\.\\s?)+(?:,\\s&\\s|,\\s)?)+\\(\\d{4}\\)\\.\\s[^.]+\\.\\s(?:\\(\\d+\\.?ª?\\sed\\.\\)\\.\\s)?[^.]+\\.";
        String PRECIOS = "\\$\\s?\\d{1,3}(\\.\\d{3})*(,\\d{2})?|\\$\\s?\\d+(,\\d{2})?";
        String DIPTONGOS = "(?i)[aeoáéó][iuü]|[iuü][aeoáéó]|iu|ui";
        String HIATOS = "(?i)[aeoáéó][aeoáéó]|[aeo][íú]|[íú][aeo]";
        
       String cadena = "ola hola Carola que rica que esta la ola \n"
                + "ola invita a Magola para que traiga las polas \nola y"
                +" salgamons al sol a escuchar la radiola\"";
        
        p=Pattern.compile(PLACA,Pattern.CASE_INSENSITIVE|Pattern.MULTILINE); //CASE_INSENSITIVE es para no diferencie entre minusculas y mayusculas, MULTILINE: 
        m=p.matcher(cadena);
        StringBuilder sb= new StringBuilder();
      
//      CONCIDENCIA
        while(m.find()){
            cont++;
            sb.append("desde ").append(m.start()).append(" hasta ").append(m.end()).append(" en ").append(m.group()).append("\n");
        }
        if(cont == 0){
            JOptionPane.showMessageDialog(null, "el patron no se encontro");
        }else{
            String mensaje = String.format("El patron se encontro %d veces en la cadena \n Esta en las siguientes posiciones: \n%s", cont,sb.toString());
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    
}
  //CONCIDENCIA TOTAL
//        if(m.matches()){
//            JOptionPane.showMessageDialog(null, "es valido");
//        }else{
//            JOptionPane.showMessageDialog(null, "NO es valido");
//        }
//      CONCIDENCIA INICIAL
//           if(m.lookingAt()){
//            JOptionPane.showMessageDialog(null, "es valido");
//        }else{
//            JOptionPane.showMessageDialog(null, "NO es valido");
//        }