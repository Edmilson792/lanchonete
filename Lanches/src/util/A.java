
package util;

/**
 *
 * @author aluno
 */
public abstract class A {
    public static String formataValor(Double valor) {
        return String.format("%.2f", valor).replaceAll(",", ".");
    }
}
