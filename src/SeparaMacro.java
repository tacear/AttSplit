import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Properties;


public class SeparaMacro {
	//Variables de instancia
		private static String IMG_PATH = "";
		//    private static String OutLog = "";
		static String Ruta = "";
		static String sDirectorio = "";
		static String sDirectorioPDF = "";
		static String sDirectorioQR = "";
		static String sDirectorioJrxml = "";
		static String sDirectoriologo = "";
		//	static String sDirectorioXSD = "";

		static String otro = "";
		static String rfcrec = "";
		
		static String uuid = "";
		static String Total;
		static String Titulo = "";
		static String NameBMP = "";
		static String NameImage = "";
		static String sourceFile = "";
		static String destinationFile = "";
		static String Conc_Importe = "";

		//Comprobante
		static String Serie = "";
		static String Folio = "";
		static String FechaComp = "";
		static String CondicionesDePago = "";
		static String Moneda = "";
		static String Simbolo = "";
		static String TipoCambio = "";
		static String TipoDeComprobante = "";
		static String FormaPago = "";
		static String MetodoPago = "";
		static String NoCertificado = "";
		static String LugarExpedicion = "";
		static String Cantidadpais = "";
		



		//Variables Emisor
		static String NombreEmi = "";
		static String RfcEmi = "";
		static String RegimenFiscal = "";

		//Variables Receptor
		static String rfcFacturaReceptor = "";
		static String NombreReceptor = "";
		static String UsoCFDI = "";

		static String call = "";
		static String fax = "";

		static String ResidenciaFiscal = "";

		//Concepto
		static String NoIdentificacion = "";
		static String ClaveProdServ = "";
		static String ConcDescuento = "";


		//Aduana
		static String NumeroPedimento = "";

		//Impuestos
		static String TotalImpuestosRetenidos = "";
		static String TotalImpuestosTrasladados = "";
		
		
		static String Base = "";
		static String Impuesto = "";
		static String TipoFactor = "";
		static String TasaOCuota = "";
		static String ImpImporte = "";
		//cfdi:Traslado

		//Addenda
		static String incoTerms = "";
		static String clientCode = "";
		static String providerCode = "";
		static String name = "";
		static String address = "";
		
		static String via_embarque = "";
		static String numero_talon = "";
		static String fecha_embarque = "";
		static String orden_compra = "";
		
		static String informacion = "";

		static String partNumbermahle = "";
		static String partNumberclient = "";

		static String packageNumber = "";
		static String container = "";

		static String Cantidad = "";
		static String Unidad = "";
		static String Descripcion = "";
		static String ValorUnitario = "";
		static String Importe = "";
		
		static String valorUnitario_Pais="";

		static String pomahle = "";
		static String poclient = "";
		static String pais = "";
		static String paisesAddenda = "";
		static String identifi = "";
			
		static String itemMahle= "";
		static String itemDelivery= "";

		static String freeLine1 = "";
		static String freeLine2 = "";
		static String freeLine3 = "";

		static String manufCountry = "";
		static String net = "";
		static String gross = "";
		static String number = "";
		static String asn = "";

		static String writtenAmount = "";
		static String footerPageComment2 = "";
		static String documentType = "";
		
		static String informacionLey = "";
		
		static String piezas = "";
		static String p_pais = "";
		
		static String Observaciones = "";


		//pallets



		//Timbre
		static String UUID = "";
		static String SelloSAT = "";
		static String SelloCFD = "";
		static String NoCertificadoSAT = "";
		static String FechaTimbrado = "";
		static String Version = "";
		static String Cadena33 = "";
		static String cbb = "";
		static String logo = "";




		//OPERACIONES
		static String Subtotal ;
		static String Descuento = "0.00" ;
		static String TotImpTrasl = "0.00";
		static String TotImpRet = "0.00" ;
		static String ConcImp = "" ;
		static String ConcImpdom = "" ;

//		int i=0;
		
		static BufferedWriter bw;
		static Writer out;
		
		static int x = 0;

	public static void main(String[] args) throws IOException {
		
		int z=0;

		Macro lista = new Macro();

		try {  
			//Iniciamos a leer y obtener properties
			//Iniciamos las variables Properties
			Properties properties = new Properties();   

			//Cargo el archivo properties   
			//de la carpeta Properties de nuestro proyecto  
			properties.load(Macro.class.getResource("/Properties/Variables.properties").openStream());  

			//Obtengo en valor de las propiedades  
			sDirectorio = properties.getProperty("InXML");
			sDirectorioPDF = properties.getProperty("OutPDF");
			
			

		} catch (IOException ex) { 
			ex.printStackTrace();  
		}  


		//Lee el directorio donde se leeran los XML
		File fileDirec = new File(sDirectorio);

		//Utilizaremos el método .exists() para comprobar que el directorio existe.
		if (fileDirec.exists()){ 
			//			System.out.println("si existen Archivos en el Directorio");

		}
		else { 
			//			System.out.println("No existen Archivos en el Directorio");

		}

		//Una vez pasada esta validación utilizamos el método .listFiles. 
		//Este método devuelve todos los ficheros asociados al directorio en un array de Files. 
		//Es por ello que solo nos quedará recorrer el array e ir mostrando el nombre de lo ficheros y 
		//directorios que componen nuestro directorio.

		File[] ficherosDir = fileDirec.listFiles();
		
		try {
        	
        	
			  destinationFile =  sDirectorioPDF+NameBMP+"("+x+").XML";
//				 OutputStream os = (OutputStream)new FileOutputStream(destinationFile);
////			      String encoding = "UTF8";
////			      Charset ENCODING = StandardCharsets.UTF_8;
//				 Charset ENCODING = StandardCharsets.UTF_8;
//			      OutputStreamWriter osw = new OutputStreamWriter(os, ENCODING);
////			      BufferedWriter bw = new BufferedWriter(osw);
//				bw = new BufferedWriter(new BufferedWriter(osw));
				out = new BufferedWriter(new OutputStreamWriter(
					    new FileOutputStream(destinationFile), "UTF-8"));
//					try {
//					    out.write(aString);
//					} finally {
//					    out.close();
//					}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		//Recorremos la lista
		for (int w=0;w<ficherosDir.length;w++){

			//Validamos que solo leamos archivos XML
			if(ficherosDir[w].getName().toUpperCase().indexOf(".XML") !=-1){

				//Imprime el nombre del archivo(Ruta Completa)
				//			  System.out.println("Nombre del Archivo = " + ficherosDir[w]);

				//Se le asigna la direccion del archivo origen de donde se movera
				sourceFile = ficherosDir[w].toString();
				
				System.out.println("sourceFile : "+ sourceFile);

				//Se le asigna a la variable la ruta del XML
				String rutas = ficherosDir[w].toString();
				Ruta = rutas;

				System.out.println("Ruta : "+ Ruta);
				
				//Obtenemos nombre de Archivo
				File fichero=new File(Ruta);

				//Valida si existe la ruta
				if(fichero.exists()){

					//Imprime el nombre del archivo XML que esta leyedo
					//				        System.out.println("Nombre del archivo "+fichero.getName());

					//Sele asigna el valor a la variable de la ruta de destino a la cual se movera el archivo XML
					//despues de ser procesado
					destinationFile = IMG_PATH+fichero.getName();
					
					System.out.println("destinationFile : "+ destinationFile);

					//Se le asigna el nombre del archivo XML a procesar
					Titulo = fichero.getName();
					
					System.out.println("Titulo : "+ Titulo);

				}
				
				String [] tit = Titulo.toUpperCase().split(".XML");
				 
				 //Se recorre la lista del Split
	     		if(z<tit.length){
	     			
	     			//Imprime el valor del split
//	     			System.out.println("Titulo   " + tit[z]);
	     			
	     			//Se le asigna el valor de la posicion 0 a NAmeBMP
	     			NameBMP = tit[0];
	     			System.out.println("sDirectorioPDF : "+ sDirectorioPDF);
	     			System.out.println("NameBMP : "+ NameBMP);
	     		}
				
				 // Abrimos el archivo
	            FileInputStream fstream = new FileInputStream(Ruta);
	            		            
	            // Creamos el objeto de entrada
	            DataInputStream entrada = new DataInputStream(fstream);
	            
	            // Creamos el Buffer de Lectura
	            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada, "utf-8"));
	            String strLinea;
	            String MacroIni ="";
	            String MacroFin ="";
	            
	            
//	            lista.leerXMLPDF(sDirectorio+NameBMP+".XML");
	            
//	            NameBMP = RfcEmi+"_"+NameBMP;
	            
	            
				
				  while ((strLinea = buffer.readLine()) != null)   {
					  
					  
					  
					  // Imprimimos la línea por pantalla
		               
		                
//		                MacroIni = strLinea.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><MacroXML>", "<cfdi:Comprobante xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\" xmlns:pago10=\"http://www.sat.gob.mx/Pagos\" xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" Certificado=\"\" Fecha=\"2018-10-10T08:34:51\" Folio=\"0\" LugarExpedicion=\"54030\" Moneda=\"XXX\" NoCertificado=\"00000000000000000000\" Sello=\"\" Serie=\"CPLN\" SubTotal=\"0\" TipoDeComprobante=\"P\" Total=\"0\" Version=\"3.3\"><cfdi:Emisor Nombre=\"Prueba\" RegimenFiscal=\"601\" Rfc=\"AAA010101AAA \"/><cfdi:Receptor Nombre=\"prueba\" Rfc=\"AAA010101AAA\" UsoCFDI=\"P01\"/><cfdi:Conceptos><cfdi:Concepto Cantidad=\"1\" ClaveProdServ=\"84111506\" ClaveUnidad=\"ACT\" Descripcion=\"Pago\" Importe=\"0\" ValorUnitario=\"0\"/></cfdi:Conceptos><cfdi:Complemento><pago10:Pagos Version=\"1.0\"><pago10:Pago FechaPago=\"2018-09-20T12:00:00\" FormaDePagoP=\"03\" MonedaP=\"MXN\" Monto=\"1274986.74\"><pago10:DoctoRelacionado IdDocumento=\"EEECDCD0-FEC4-4E5E-B418-C022421C7DEE\" ImpPagado=\"1274986.74\" ImpSaldoAnt=\"1274986.74\" ImpSaldoInsoluto=\"0.00\" MetodoDePagoDR=\"PPD\" MonedaDR=\"MXN\" NumParcialidad=\"1\"/></pago10:Pago></pago10:Pagos></cfdi:Complemento></cfdi:Comprobante>").replace("</MacroXML>", "");
		                MacroIni = strLinea.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><MacroXML>", "").replace("<?xml version =\"1.0\" encoding =\"UTF-8\"?>", "").replace("<MacroXML>", "").replace("</MacroXML>", "");
		             
		                MacroFin = MacroIni;
		                
//		                System.out.println ("Linea: "+  MacroFin);
		                
		                
		                
		                
		                String[] arrayColores = MacroFin.split("\\<cfdi:Comprobante");
//		                String[] arrayColores = MacroFin.split("\\*");
		                
		             // En este momento tenemos un array en el que cada elemento es un color.
		             for (int i = 0; i < arrayColores.length; i++) {
		             	
		            	
		             	if(!arrayColores[i].equals("")){
		             		
		             		if(x == 0){
		             		System.out.println("2- Bloque --> "+ x +":"+ arrayColores[i]);
//		             		out.write("<cfdi:Comprobante " +"\r"+ "\n" );
		             		out.write("<cfdi:Comprobante " +arrayColores[i] +"\r"+ "\n" );
		             		}
		             		

		             	

		             		
		                	if(arrayColores[i].indexOf("</cfdi:Comprobante") != -1){
		                		x++; 
		                		System.out.println(x+" Termina ");
		                		out.close();
		                		
		                		destinationFile =  sDirectorioPDF+RfcEmi+"_"+NameBMP+"_("+x+").XML";
//		                		NameBMP="";
//			            		if(!strLinea.equals(""))
//			            		 bw = new BufferedWriter(new FileWriter(destinationFile));
			            		 out = new BufferedWriter(new OutputStreamWriter(
										    new FileOutputStream(destinationFile), "UTF-8"));
			            		 out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r"+ "\n");
		                	}else{
		                		x++; 
		                		System.out.println(x+" Termina ");
		                		out.close();
		                		
		                		destinationFile =  sDirectorioPDF+RfcEmi+"_"+NameBMP+"_("+x+").XML";
//		                		NameBMP="";
//			            		if(!strLinea.equals(""))
//			            		 bw = new BufferedWriter(new FileWriter(destinationFile));
			            		 out = new BufferedWriter(new OutputStreamWriter(
										    new FileOutputStream(destinationFile), "UTF-8"));
			            		 out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r"+ "\n");
		                	}
		                	
		                	System.out.println("1- Bloque --> "+ x +":"+ arrayColores[i]);
//		                	out.write("<cfdi:Comprobante " +"\r"+ "\n" );
		             		out.write("<cfdi:Comprobante " +arrayColores[i] +"\r"+ "\n" );

		                	
				  }

				}
			}
		}
		}

	}

}
