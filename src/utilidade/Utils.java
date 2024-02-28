package utilidade;

public class Utils {

	public static void validaString(String valor, String mensagem) throws NullPointerException {
		if (valor == null) {
			throw new NullPointerException(mensagem);
		}

		if (valor.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void validaInteiro(Integer valor, String mensagem) throws NullPointerException {
		if (valor == null) {
			throw new NullPointerException(mensagem);
		}
	}
	
}
