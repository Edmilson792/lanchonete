package util;

import java.security.MessageDigest;

/**
 *  Método para criptografia de senha.
 * @author Edmilson
 */
public class Seguranca {
    
    public static String hash(String senha) throws Exception {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("SHA-256");
            byte MesageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : MesageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            
            return hexString.toString();
        } catch (Exception e) {
            throw e;
        }
    }
}
