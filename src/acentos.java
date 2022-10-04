import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class acentos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		    String original = new String("Transferencia virtual efectuada de conformidad con el Art. 112 de la Ley Aduanera,  bajo el amparo de la regla 4.3.21, 5.2.7 y 5.2.6 Fracci√≥n I de las RGCE vigentes y el Art. 29  fracci√≥n I de la Ley del IVA. Operaci√≥n realizada entre Mahle Sistemas de Filtraci√≥n SA de CV con IMMEX 3180-2006 y Mahle de M√©xico S de RL de CV con IMMEX 3133-2006");  //(AmÈrica)
//		    String nuevo = original.replace("√≥", "Û").replace("√©", "È");   //reemplazo
//
//		    System.out.println(nuevo);
		// PatrÛn para validar el email
				Pattern pattern = Pattern
						.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
								+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9.-_]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				// El email a validar
				String email = "dsoriano@xxx-medio.com.mx";

				Matcher mather = pat.matcher(email);

				if (mather.find() == true) {
					System.out.println("El email ingresado es v·lido.");
				} else {
					System.out.println("El email ingresado es inv·lido.");
				}
		

	}

}
