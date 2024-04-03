package utilidade;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	public static void validaDoublePositivo(Double valor, String mensagem) throws NullPointerException {
		if (valor < 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}


	public static void validaDouble(Double valor, String mensagem) throws NullPointerException {
		if (valor == null) {
			throw new NullPointerException(mensagem);
		}
	}
	
	public static void validaPrioridade(Integer valor, String mensagem) {
		if (valor < 1 || valor > 3) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
    public static void validaData(String data, String mensagem) {
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YY");

        try {
            sdf.parse(data);
        } catch (Exception e) {
        	throw new IllegalArgumentException(mensagem);
        }
    }
    
    public static void validaVencimento(String data, String mensagem) {
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YY");

        try {
            Date date = sdf.parse(data);
            Date today = new Date();
            
            if (!date.after(today)) {
            	throw new IllegalArgumentException(mensagem);
            }
            
        } catch (Exception e) {
        	throw new IllegalArgumentException(mensagem);
        }
    }
	
}
