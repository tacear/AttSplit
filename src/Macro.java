import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import net.sf.jasperreports.engine.JRExporterParameter;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.export.JRPdfExporter;
//import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
//import net.sf.jasperreports.engine.util.JRLoader;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;


public class Macro {
	

	//	static String sDirectorio = "c:\\tmp\\";



	//C:\tmp\qrcode.png

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

//	int i=0;
	
	static BufferedWriter bw;
	static Writer out;
	
	static int x = 0;
	static int Numerico = 0;


	/**
	 * @param args
	 * @throws Exception 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, Exception {
		
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
		
		
		
		
		//Recorremos la lista
		for (int w=0;w<ficherosDir.length;w++){

			//Validamos que solo leamos archivos XML
			if(ficherosDir[w].getName().toUpperCase().indexOf(".XML") !=-1){

				//Imprime el nombre del archivo(Ruta Completa)
				//			  System.out.println("Nombre del Archivo = " + ficherosDir[w]);

				//Se le asigna la direccion del archivo origen de donde se movera
				sourceFile = ficherosDir[w].toString();
				
//				System.out.println("sourceFile : "+ sourceFile);

				//Se le asigna a la variable la ruta del XML
				String rutas = ficherosDir[w].toString();
				Ruta = rutas;

//				System.out.println("Ruta : "+ Ruta);
				
				//Obtenemos nombre de Archivo
				File fichero=new File(Ruta);

				//Valida si existe la ruta
				if(fichero.exists()){

					//Imprime el nombre del archivo XML que esta leyedo
					//				        System.out.println("Nombre del archivo "+fichero.getName());

					//Sele asigna el valor a la variable de la ruta de destino a la cual se movera el archivo XML
					//despues de ser procesado
					destinationFile = IMG_PATH+fichero.getName();
					
//					System.out.println("destinationFile : "+ destinationFile);

					//Se le asigna el nombre del archivo XML a procesar
					Titulo = fichero.getName();
					
//					System.out.println("Titulo : "+ Titulo);

				}
				
				String [] tit = Titulo.toUpperCase().split(".XML");
				 
				 //Se recorre la lista del Split
	     		if(z<tit.length){
	     			
	     			//Imprime el valor del split
//	     			System.out.println("Titulo   " + tit[z]);
	     			
	     			//Se le asigna el valor de la posicion 0 a NAmeBMP
	     			NameBMP = tit[0];
//	     			System.out.println("sDirectorioPDF : "+ sDirectorioPDF);
//	     			System.out.println("NameBMP : "+ NameBMP);
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
		                MacroIni = strLinea.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?><MacroXML>", "").replace("<?xml version=\"1.0\" encoding=\"utf-8\"?><MacroXML>", "").replace("</MacroXML>", "").replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><MacroXML>", "").replace("<?xml version =\"1.0\" encoding =\"UTF-8\"?>", "").replace("<MacroXML>", "").replace("</MacroXML>", "");
		                MacroFin = MacroIni;
		                
//		                System.out.println ("Linea: "+  MacroFin);
		                
		                
		                
		                
		                String[] arrayColores = MacroFin.split("\\<cfdi:Comprobante");
//		                String[] arrayColores = MacroFin.split("\\*");
		               
		             // En este momento tenemos un array en el que cada elemento es un color.
		             for (int i = 0; i < arrayColores.length; i++) {
		             	
		            	
		             	if(!arrayColores[i].trim().equals("")){
		             		
		             		
		             		
		             		
		             		String[] arraySerie = arrayColores[i].split("Serie=\"");
		             		 for (int b = 0; b < arraySerie.length; b++) {
//		 		             	System.out.println("Bloque --> "+ x +":"+ arrayColores[b);
		 		            	
		 		             	if(!arraySerie[b].equals("")){
		 		             		try {
		 		             			arraySerie[b].substring(0, 12);
		 		             			
		 		             			Serie = arraySerie[b].substring(0,4 ).replace("\"", "");
		 		             			System.out.println("Serie --> "+ arraySerie[b].substring(0,4 ).replace("\"", ""));
									} catch (Exception e) {
										// TODO: handle exception
										continue;
									}
		 		             		
		 		             		
		 		             		
		 		             	}
		             		 }
		             		 
		             		String[] arrayFolio = arrayColores[i].split("Folio=\"");
		             		 for (int u = 0; u < arrayFolio.length; u++) {
//		 		             	System.out.println("Bloque --> "+ x +":"+ arrayColores[u]);
		 		            	
		 		             	if(!arrayFolio[u].equals("")){
		 		             		try {
		 		             			arrayFolio[u].substring(0, 19);
		 		             			
		 		             			Folio =arrayFolio[u].substring(0, 19).replace("\"", "");
		 		             			System.out.println("Folio --> "+ arrayFolio[u].substring(0, 19));
									} catch (Exception e) {
										// TODO: handle exception
										continue;
									}
		 		             	}
		             		 }
		 		             	
		             		
		             		String[] arrayRFC = arrayColores[i].split("RegimenFiscal=\"601\" Rfc=\"");
		             		 for (int u = 0; u < arrayRFC.length; u++) {
		 		             	System.out.println("Bloque --> "+ x +":"+ arrayColores[u]);
		 		            	
		 		             	if(!arrayRFC[u].equals("")){
		 		             		try {
		 		             			arrayRFC[u].substring(0, 12);
		 		             			
		 		             			RfcEmi = arrayRFC[u].substring(0, 12).replace("\"", "");
		 		             			System.out.println("RFC --> "+ arrayRFC[u].substring(0, 12));
									} catch (Exception e) {
										// TODO: handle exception
										continue;
									}
		 		             		
		 		             		
		 		             		
		 		             	}
		             	}
		             		
		             		if(x == 0){
		             			
		             			try {
		             	        	
		             	        	
		             				  destinationFile =  sDirectorioPDF+RfcEmi+"_"+Serie+"_"+Folio+".XML";
//		             					 OutputStream os = (OutputStream)new FileOutputStream(destinationFile);
////		             				      String encoding = "UTF8";
////		             				      Charset ENCODING = StandardCharsets.UTF_8;
//		             					 Charset ENCODING = StandardCharsets.UTF_8;
//		             				      OutputStreamWriter osw = new OutputStreamWriter(os, ENCODING);
////		             				      BufferedWriter bw = new BufferedWriter(osw);
//		             					bw = new BufferedWriter(new BufferedWriter(osw));
		             					out = new BufferedWriter(new OutputStreamWriter(
		             						    new FileOutputStream(destinationFile), "UTF-8"));
//		             						try {
//		             						    out.write(aString);
//		             						} finally {
//		             						    out.close();
//		             						}
		             					
		             					System.out.println("Bloque --> "+ Numerico +":"+ arrayColores[i]);
		    		             		out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r"+ "\n");
		    		             		out.write("<cfdi:Comprobante ");
		    		             		out.write(arrayColores[i]);
		    		             		
		    		             		 Numerico++;

		             				} catch (IOException e1) {
		             					// TODO Auto-generated catch block
		             					e1.printStackTrace();
		             				}
		             		
		             		}
		             		
//		             		out.write(arrayColores[i]+"\r"+ "\n" );
		             		
		             		
		             	
//		             	String[] arrayRFC = MacroFin.split("Rfc=\"");
////		                String[] arrayColores = MacroFin.split("\\*");
//		                
//		             // En este momento tenemos un array en el que cada elemento es un color.
//		             for (int u = 0; u < arrayRFC.length; u++) {
//		             	System.out.println("Bloque --> "+ x +":"+ arrayColores[u]);
//		            	
//		             	if(!arrayColores[u].equals("")){
//		             		out.write(arrayColores[u].replace("xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\"", "<cfdi:Comprobante xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\"") +"\r"+ "\n" );
////		             		out.write(arrayColores[i]+"\r"+ "\n" );
//		             	}
		             	
//		             	if(arrayColores[i].equals("<cfdi:Comprobante")){
//		                	
//		             			
//		             		 bw.write(arrayColores[i]+"\r"+ "\n" );  
//		                	
//		                }else{
		             		
		             		if(x == 0){
		             			out.close();
		             		}else{
		             			 Numerico++;
		             			x++;
		             			if(arrayColores[i].indexOf("</cfdi:Comprobante") != -1){
			                		x++; 
//			                		System.out.println(x+" Termina ");
			                		out.close();
			                		
			                		destinationFile =   sDirectorioPDF+RfcEmi+"_"+Serie+"_"+Folio+".XML";
			                		//destinationFile =  sDirectorioPDF+NameBMP+"_("+x+").XML";
			                		
//			                		NameBMP="";
//				            		if(!strLinea.equals(""))
//				            		 bw = new BufferedWriter(new FileWriter(destinationFile));
				            		 out = new BufferedWriter(new OutputStreamWriter(
											    new FileOutputStream(destinationFile), "UTF-8"));
				            		 out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r"+ "\n");
			                	}
			                	else{
//			                		x++; 
////			                		System.out.println(x+" Termina ");
//			                		out.close();
//			                		
//			                		destinationFile =  sDirectorioPDF+RfcEmi+"_"+NameBMP+"_("+x+").XML";
////			                		NameBMP="";
////				            		if(!strLinea.equals(""))
////				            		 bw = new BufferedWriter(new FileWriter(destinationFile));
//				            		 out = new BufferedWriter(new OutputStreamWriter(
//											    new FileOutputStream(destinationFile), "UTF-8"));
//				            		 out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r"+ "\n");
			                	}
		             			
		             			out.write("<cfdi:Comprobante ");
			             		out.write(arrayColores[i]);
		             		}
		             		
		                	
		                	
//		                	System.out.println("Bloque --> "+ x +":"+ arrayColores[i]);
//		             		out.write(arrayColores[i].replace("xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\"", "<cfdi:Comprobante xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd http://www.sat.gob.mx/Pagos http://www.sat.gob.mx/sitio_internet/cfd/Pagos/Pagos10.xsd\" xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\"") +"\r"+ "\n" );
		                	
		                	
//		                }
//		             }
		                	
				  }


//				try {
//					lista.leerXMLPDF(Ruta);
//				} catch (NullPointerException e1){
//					System.out.println(e1.toString());
				}
			}
		}
		}

	}



	public void leerXMLPDF(String fileName ) throws NullPointerException,IllegalArgumentException,Exception{

		DecimalFormat formateador = new DecimalFormat("###,###,###.00");

//				pw.println("--------------- Inicio de Errores de operación --------------------------- "+"\r"+ "\n" );
//		List<DetalleAfter> listaDetalle = new ArrayList<DetalleAfter>();


		NodeList nList = null;
		//		DateFormat formatter = new SimpleDateFormat (Constantes.DATE_FORMAT);
		File fXmlFile = new File(fileName);
		String nombre =  fXmlFile.getName();
		nombre = nombre.substring(0, nombre.length() - 4);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		//		nList = doc.getElementsByTagName("cfdi:Comprobante");
		////		fechaFactura =  recuperaValor(nList,"fecha");
		////		fechaFacturacion = new  Timestamp(formatter.parse(fechaFactura).getTime());
		//		Subtotal = recuperaValor(nList,"SubTotal");
		//		Descuento = recuperaValor(nList,"Descuento");

//		nList = doc.getElementsByTagName("cfdi:Comprobante");
//		Serie      = recuperaValor(nList,"Serie");
//		Folio      = recuperaValor(nList,"Folio");
//		FechaComp      = recuperaValor(nList,"Fecha");
//		CondicionesDePago      = recuperaValor(nList,"CondicionesDePago");
//		Moneda      = recuperaValor(nList,"Moneda");
//		TipoCambio      = recuperaValor(nList,"TipoCambio");
//		TipoDeComprobante      = recuperaValor(nList,"TipoDeComprobante");
//		FormaPago      = recuperaValor(nList,"FormaPago");
//		MetodoPago      = recuperaValor(nList,"MetodoPago");
//		NoCertificado      = recuperaValor(nList,"NoCertificado");
////		FormaPago = FormaPago(FormaPago);
////		MetodoPago = MetodoDePago(MetodoPago);
////		TipoDeComprobante = TipoComprobante(TipoDeComprobante);
////		Simbolo = TipoMoneda(Moneda);
//		
//		Total      = recuperaValor(nList,"Total");
//		
//		double conv = Double.parseDouble(Total);
//		Total = formateador.format(conv);
//		
//		
//		Subtotal              = recuperaValor(nList,"SubTotal");
//		
//		double D_Subtotal = Double.parseDouble(Subtotal);
//		Subtotal = formateador.format(D_Subtotal);
//		
//		Descuento = recuperaValor(nList,"Descuento");
//				
//		if(!Descuento.equals("")){
//		double D_Descuento = Double.parseDouble(Descuento);
//		Descuento = formateador.format(D_Descuento);
//		}else{
//			Descuento = "0.00";
//		}
//		
//		LugarExpedicion = recuperaValor(nList,"LugarExpedicion");
//		
//		nList = doc.getElementsByTagName("cfdi:Impuestos");
//		TotalImpuestosRetenidos   = recuperaValor(nList,"TotalImpuestosRetenidos");
//		
//		if(!TotalImpuestosRetenidos.equals("")){
//		double D_TotalImpuestosRetenidos = Double.parseDouble(TotalImpuestosRetenidos);
//		TotalImpuestosRetenidos = formateador.format(D_TotalImpuestosRetenidos);
//		}else{
//			TotalImpuestosRetenidos =".00";
//		}
//		
//		
//		TotalImpuestosTrasladados   = recuperaValor(nList,"TotalImpuestosTrasladados");
//
//		if(!TotalImpuestosTrasladados.equals("")){
//		double D_TotalImpuestosTrasladados = Double.parseDouble(TotalImpuestosTrasladados);
//		TotalImpuestosTrasladados = formateador.format(D_TotalImpuestosTrasladados);
//		
//		}
//		
//		if(TotalImpuestosTrasladados.equals(".00")){
//			TotalImpuestosTrasladados = "0.00";
//		}
		
		
		
//		nList = doc.getElementsByTagName("cfdi:InformacionAduanera");
//		NumeroPedimento =	recuperaValorPedimento(nList,"NumeroPedimento") ;
		
		//      Emisor
		nList = doc.getElementsByTagName("cfdi:Emisor");
		RfcEmi = recuperaValor(nList,"Rfc");
//		NombreEmi = recuperaValor(nList,"Nombre");
//		RegimenFiscal = recuperaValor(nList,"RegimenFiscal");
//		RegimenFiscal = RegimenFiscal(RegimenFiscal);

		//		Receptor
//		nList = doc.getElementsByTagName("cfdi:Receptor");
//		rfcFacturaReceptor   = recuperaValor(nList,"Rfc");
//		NombreReceptor   = recuperaValor(nList,"Nombre");
//		UsoCFDI   = recuperaValor(nList,"UsoCFDI");
//		ResidenciaFiscal   = recuperaValor(nList,"ResidenciaFiscal");
//		
//		
//		nList = doc.getElementsByTagName("phone");
//		call   = recuperaValor(nList,"call");
//		fax   = recuperaValor(nList,"fax");
		
//		nList = doc.getElementsByTagName("cce11:ComercioExterior");
//		Observaciones   = recuperaValor(nList,"Observaciones");
		
		

		
//		//Concepto
//		nList = doc.getElementsByTagName("cfdi:Concepto");
//		ClaveProdServ   = recuperaValor(nList,"ClaveProdServ");
//		ConcDescuento   = recuperaValor(nList,"Descuento");
//
//
//		//Impuestos
//		nList = doc.getElementsByTagName("cfdi:Traslado");
//		Base   = recuperaValor(nList,"Base");
//		Impuesto   = recuperaValor(nList,"Impuesto");
//		TipoFactor   = recuperaValor(nList,"TipoFactor");
//		TasaOCuota   = recuperaValor(nList,"TasaOCuota");
//		ImpImporte   = recuperaValor(nList,"Importe");
		
		
		
		


		//Aduana
//		nList = doc.getElementsByTagName("cfdi:InformacionAduanera");
//		NumeroPedimento   = recuperaValor(nList,"NumeroPedimento");

//		nList = doc.getElementsByTagName("DatosGenerales");
//		
//		clientCode    = recuperaValor(nList,"numero_cliente");
//		incoTerms    = recuperaValor(nList,"numero_pedido");
//		via_embarque    = recuperaValor(nList,"via_embarque");
//		numero_talon    = recuperaValor(nList,"numero_talon");
//		fecha_embarque    = recuperaValor(nList,"fecha_embarque");
//		orden_compra    = recuperaValor(nList,"orden_compra");
//		
//		nList = doc.getElementsByTagName("texto");
//		
//		informacion    = recuperaValor(nList,"informacion");
//		
////		System.out.println("informacion : "+ informacion);
//		
//		nList = doc.getElementsByTagName("Leyenda");
//		
//		informacionLey    = recuperaValor(nList,"informacion");
//		
//		System.out.println("informacion : "+ informacionLey);
//		
////		nList = doc.getElementsByTagName("Parte");
////		pais   = recuperaValorAdd(nList,"pais");
//		
//		
//		nList = doc.getElementsByTagName("PiezasPais");
//		piezas   = recuperaValorAdd(nList,"piezas");
//		p_pais   = recuperaValorAdd(nList,"pais");
		
		

		//		Addenda
//		incoTerms   = doc.getElementsByTagName("incoTerms").item(0).getTextContent();
//		clientCode   = doc.getElementsByTagName("clientCode").item(0).getTextContent();
//		providerCode   = doc.getElementsByTagName("providerCode").item(0).getTextContent();
//		name   = doc.getElementsByTagName("name").item(0).getTextContent();
//		address   = doc.getElementsByTagName("address").item(0).getTextContent();
//
//		freeLine1   = doc.getElementsByTagName("freeLine1").item(0).getTextContent();
//		freeLine2   = doc.getElementsByTagName("freeLine2").item(0).getTextContent();
//		freeLine3   = doc.getElementsByTagName("freeLine3").item(0).getTextContent();
//
//		manufCountry   = doc.getElementsByTagName("manufCountry").item(0).getTextContent();
//
//		writtenAmount   = doc.getElementsByTagName("writtenAmount").item(0).getTextContent();
//		writtenAmount   =  "IMPUESTO RETENIDO DE CONFORMIDAD CON LA LEY DEL IMPUESTO AL VALOR AGREGADO";
//		footerPageComment2   = doc.getElementsByTagName("footerPageComment2").item(0).getTextContent();
//
//		documentType   = doc.getElementsByTagName("documentType").item(0).getTextContent();




//		nList = doc.getElementsByTagName("partNumber");
//		partNumbermahle   = recuperaValor(nList,"mahle");
//		partNumberclient   = recuperaValor(nList,"client");
//
//		nList = doc.getElementsByTagName("totalWeight");
//		net   = recuperaValor(nList,"net");
//		gross   = recuperaValor(nList,"gross");
//
//		nList = doc.getElementsByTagName("pallets");
//		number   = recuperaValor(nList,"number");
//		asn   = recuperaValor(nList,"asn");
//
//
//
//		nList = doc.getElementsByTagName("package");
//		packageNumber   = recuperaValor(nList,"packageNumber");
//		container   = recuperaValor(nList,"container");

		
		//Se leen los conceptos de la factutra
		
		
//		listaDetalle = recuperaValorDetalles(doc);
		
//		paisesAddenda += p_pais +" -- ";
		
//		nList = doc.getElementsByTagName("Concepto");
//		Cantidad   = recuperaValorAdd(nList,"Cantidad");
//		Unidad   = recuperaValorAdd(nList,"Unidad");
//		Descripcion   = recuperaValorAdd(nList,"Descripcion");
//		ValorUnitario   = recuperaValorAdd(nList,"ValorUnitario");
//		Importe   = recuperaValorAdd(nList,"Importe");

//		nList = doc.getElementsByTagName("po");
//		pomahle   = recuperaValorAdd(nList,"mahle");
//		poclient   = recuperaValor(nList,"client");
//
//		nList = doc.getElementsByTagName("Moneda");
//		footerPageComment2   = recuperaValorAdd(nList,"leyenda_pesos");
//		
//		nList = doc.getElementsByTagName("delivery");
//		itemMahle   = recuperaValorAdd(nList,"itemMahle");
//		itemDelivery   = recuperaValor(nList,"itemDelivery");
//		
//
//		//		Timbre Fiscal
//		nList = doc.getElementsByTagName("tfd:TimbreFiscalDigital");
//		UUID   = recuperaValor(nList,"UUID");
//		SelloSAT   = recuperaValor(nList,"SelloSAT");
//		SelloCFD   = recuperaValor(nList,"SelloCFD");
//		NoCertificadoSAT   = recuperaValor(nList,"NoCertificadoSAT");
//		FechaTimbrado   = recuperaValor(nList,"FechaTimbrado");
//		Version   = recuperaValor(nList,"Version");
//
//		Cadena33 ="||"+Version+"|"+UUID+"|"+FechaTimbrado+"|"+SelloCFD+"||"+NoCertificadoSAT+"||" ;
//		cbb =  sDirectorioQR + nombre + ".png";
//		logo= sDirectoriologo;
//
//
//
//
//
//		nList = doc.getElementsByTagName("cfdi:Concepto");
//		ConcImpdom += recuperaValor(nList,"Importe");
		//		while(uu<nList.getLength()){
		//			ConcImpdom += recuperaValor(nList,"Importe");
		//			
		//			System.out.println("ConcImpdom: "+ConcImpdom);
		//			
		//			uu++;
		//		}


//		nList = doc.getElementsByTagName("cfdi:Impuestos");
//		TotImpRet = recuperaValor(nList,"TotalImpuestosRetenidos");
//		TotImpTrasl = recuperaValor(nList,"TotalImpuestosTrasladados");
//
//		nList = doc.getElementsByTagName("tfd:TimbreFiscalDigital");
//		uuid = recuperaValor(nList,"UUID");




		//		    
		//		    for (int i = 1; i <= 10; i++)
		//		    {
//		Detalle d = new Detalle(i,Descripcion, Cantidad, ValorUnitario, Unidad, Importe, pomahle, Base, Impuesto,TipoFactor, TasaOCuota, 
//				ImpImporte,partNumbermahle,partNumberclient,packageNumber,container,ClaveProdServ,NumeroPedimento,ConcDescuento);
//		listaDetalle.add(d);
		//		    }

		//				i++;

//		try {
//			//Crear el mapa de parametros
//			Map<String,Object> parameters = new HashMap<String,Object>();
//
//			parameters.put("Serie", Serie);
//			parameters.put("Folio", Folio);
//			parameters.put("FechaComp", FechaComp);
//			parameters.put("CondicionesDePago", CondicionesDePago);
//			parameters.put("Moneda", Moneda);
//			parameters.put("Simbolo", Simbolo);
//			parameters.put("TipoCambio", TipoCambio);
//			parameters.put("TipoDeComprobante", TipoDeComprobante);
//			parameters.put("FormaPago", FormaPago);
//			parameters.put("MetodoPago", MetodoPago);
//			parameters.put("NoCertificado", NoCertificado);
//
//
//			parameters.put("call", call);
//			parameters.put("fax", fax);
//
//
//			parameters.put("RfcEmi", RfcEmi);
//			parameters.put("NombreEmi", NombreEmi);
//			parameters.put("RegimenFiscal", RegimenFiscal);
//
//			parameters.put("RfcRecep", rfcFacturaReceptor);
//			parameters.put("NomRecep", NombreReceptor);
//			parameters.put("UsoCFDI", UsoCFDI);
//			parameters.put("ResidenciaFiscal", ResidenciaFiscal);
//			
//
//			parameters.put("ClaveProdServ", ClaveProdServ);
////			parameters.put("NumeroPedimento", NumeroPedimento);
//			//			parameters.put("ConcDescuento", ConcDescuento);
//
//			parameters.put("Base", Base);
//			parameters.put("Impuesto", Impuesto);
//			parameters.put("TipoFactor", TipoFactor);
//			parameters.put("TasaOCuota", TasaOCuota);
//			parameters.put("ImpImporte", ImpImporte);
//			
//			parameters.put("TotalImpuestosRetenidos", TotalImpuestosRetenidos);
//			parameters.put("TotalImpuestosTrasladados", TotalImpuestosTrasladados);
//			
//			//cfdi:Impuestos
//			
//			
//
//			parameters.put("incoTerms", incoTerms);
//			parameters.put("clientCode", clientCode);
//			parameters.put("providerCode", providerCode);
//			parameters.put("name", name);
//			parameters.put("address", address);
//			parameters.put("partNumbermahle", partNumbermahle);
//			parameters.put("partNumberclient", partNumberclient);
//			parameters.put("packageNumber", packageNumber);
//			parameters.put("container", container);
//			parameters.put("informacion", informacion);
//			parameters.put("informacionLey", informacionLey);
//			
//			parameters.put("via_embarque", via_embarque);
//			parameters.put("numero_talon", numero_talon);
//			parameters.put("fecha_embarque", fecha_embarque);
//			parameters.put("orden_compra", orden_compra);
//			
//			 
//
//			parameters.put("freeLine1", freeLine1);
//			parameters.put("freeLine2", freeLine2);
//			parameters.put("freeLine3", freeLine3);
//
//			parameters.put("manufCountry", manufCountry);
//			parameters.put("net", net);
//			parameters.put("gross", gross);
//			parameters.put("number", number);
//			parameters.put("asn", asn);
//
//			parameters.put("writtenAmount", writtenAmount);
//			parameters.put("footerPageComment2", footerPageComment2);
//			parameters.put("documentType", documentType);
//
//
//			parameters.put("poclient", poclient);
//
//			parameters.put("UUID", UUID);
//			parameters.put("SelloSAT", SelloSAT);
//			parameters.put("SelloCFD", SelloCFD);
//			parameters.put("NoCertificadoSAT", NoCertificadoSAT);
//			parameters.put("FechaTimbrado", FechaTimbrado);
//			parameters.put("Cadena33", Cadena33);
//			parameters.put("imagen", cbb);
//			parameters.put("logo", logo);
//
//			parameters.put("Total", Total);
//			parameters.put("Subtotal", Subtotal);
//			parameters.put("Descuento", Descuento);
//			parameters.put("LugarExpedicion", LugarExpedicion);
//			parameters.put("piezas", piezas);
//			parameters.put("p_pais", p_pais);
//			
//			System.out.println("paisesAddenda: "+ pais);
//			
//			parameters.put("paisesAddenda", pais);
////			System.out.println("Observaciones: "+ Observaciones);
////			
////			parameters.put("Observaciones", Observaciones);
//
//			
//
//
//
//			//SelloSAT
//
//
//
//			//Version
//
//
//			InputStream reportStream = new FileInputStream(sDirectorioJrxml + "PDFXMLAfter.jrxml");
//
//			//Iniciar reporte
//			JasperReport report = JasperCompileManager.compileReport(reportStream);
//			JasperPrint jasperPrint = new JasperPrint();
//
//			//Llenar el reporte donde se le pasa en el tercer argumento el mapa ya creado
//			JasperFillManager.fillReportToFile(report, sDirectorioJrxml +"PDFXMLAfter.jrprint", (Map<String,Object>)parameters,new JRBeanCollectionDataSource(listaDetalle));
//			reportStream.close();
//
//			//Generar PDF
//			List listJasper = new ArrayList();
//			listJasper.add(JRLoader.loadObject(sDirectorioJrxml + "PDFXMLAfter.jrprint"));
//			JRPdfExporter exp = new JRPdfExporter();
//			exp.setParameter(JRExporterParameter.JASPER_PRINT_LIST, listJasper);
//			exp.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, Boolean.TRUE);
//			
//			exp.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, sDirectorioPDF + nombre+".pdf");
//			exp.exportReport();
//			
//			
//			fXmlFile.delete();
//			pais="";
//		} catch (Exception e) {
//			e.printStackTrace();
//			pais="";
//		}

	}

//	public String FormaPago(String pago){
//
//		if(FormaPago.trim().equals("01")){
//			pago="01 - Efectivo";
//		}
//		if(FormaPago.trim().equals("02")){
//			pago="02 - Cheque nominativo";
//		}
//		if(FormaPago.trim().equals("03")){
//			pago="03 - Transferencia electrónica de fondos";
//		}
//		if(FormaPago.trim().equals("04")){
//			pago="04 - Tarjeta de crédito";
//		}
//		if(FormaPago.trim().equals("05")){
//			pago="05 - Monedero electrónico";
//		}
//		if(FormaPago.trim().equals("06")){
//			pago="06 - Dinero electrónico";
//		}
//		if(FormaPago.trim().equals("08")){
//			pago="08 - Vales de despensa";
//		}
//		if(FormaPago.trim().equals("12")){
//			pago="12 - Dación en pago";
//		}
//		if(FormaPago.trim().equals("13")){
//			pago="13 - Pago por subrogación";
//		}
//		if(FormaPago.trim().equals("14")){
//			pago="14 - Pago por consignación";
//		}
//		if(FormaPago.trim().equals("15")){
//			pago="15 - Condonación";
//		}
//		if(FormaPago.trim().equals("17")){
//			pago="17 - Compensación";
//		}
//		if(FormaPago.trim().equals("23")){
//			pago="23 - Novación";
//		}
//		if(FormaPago.trim().equals("24")){
//			pago="24 - Confusión";
//		}
//		if(FormaPago.trim().equals("25")){
//			pago="25 - Remisión de deuda";
//		}
//		if(FormaPago.trim().equals("26")){
//			pago="26 - Prescripción o caducidad";
//		}
//		if(FormaPago.trim().equals("27")){
//			pago="27 - A satisfacción del acreedor";
//		}
//		if(FormaPago.trim().equals("28")){
//			pago="28 - Tarjeta de débito";
//		}
//		if(FormaPago.trim().equals("29")){
//			pago="29 - Tarjeta de servicios";
//		}
//		if(FormaPago.trim().equals("99")){
//			pago="99 - Por definir";
//		}
//
//		return pago;
//
//	}

//	public String MetodoDePago(String Metodopago){
//
//		if(MetodoPago.trim().equals("PUE")){
//			Metodopago="PUE - Pago en una sola exhibición";
//		}
//		if(MetodoPago.trim().equals("PIP")){
//			Metodopago="PIP - Pago inicial y parcialidades";
//		}
//		if(MetodoPago.trim().equals("PPD")){
//			Metodopago="PPD - Pago en parcialidades o diferido";
//		}
//
//		return Metodopago;
//
//	}

//	public String RegimenFiscal(String regimenfiscal){
//
//		if(RegimenFiscal.trim().equals("601")){
//			regimenfiscal="601 - General de Ley Personas Morales";
//		}
//		if(RegimenFiscal.trim().equals("603")){
//			regimenfiscal="603 - Personas Morales con Fines no Lucrativos";
//		}
//		if(RegimenFiscal.trim().equals("605")){
//			regimenfiscal="605 - Sueldos y Salarios e Ingresos Asimilados a Salarios";
//		}
//		if(RegimenFiscal.trim().equals("606")){
//			regimenfiscal="606 - Arrendamiento";
//		}
//		if(RegimenFiscal.trim().equals("608")){
//			regimenfiscal="608 - Demás ingresos";
//		}
//		if(RegimenFiscal.trim().equals("609")){
//			regimenfiscal="609 - Consolidación";
//		}
//		if(RegimenFiscal.trim().equals("610")){
//			regimenfiscal="610 - Residentes en el Extranjero sin Establecimiento Permanente en México";
//		}
//		if(RegimenFiscal.trim().equals("611")){
//			regimenfiscal="611 - Ingresos por Dividendos (socios y accionistas)";
//		}
//		if(RegimenFiscal.trim().equals("612")){
//			regimenfiscal="612 - Personas Físicas con Actividades Empresariales y Profesionales";
//		}
//		if(RegimenFiscal.trim().equals("614")){
//			regimenfiscal="614 - Ingresos por intereses";
//		}
//		if(RegimenFiscal.trim().equals("616")){
//			regimenfiscal="616 - Sin obligaciones fiscales";
//		}
//		if(RegimenFiscal.trim().equals("620")){
//			regimenfiscal="620 - Sociedades Cooperativas de Producción que optan por diferir sus ingresos";
//		}
//		if(RegimenFiscal.trim().equals("621")){
//			regimenfiscal="621 - Incorporación Fiscal";
//		}
//		if(RegimenFiscal.trim().equals("622")){
//			regimenfiscal="622 - Actividades Agrícolas, Ganaderas, Silvícolas y Pesqueras";
//		}
//		if(RegimenFiscal.trim().equals("623")){
//			regimenfiscal="623 - Opcional para Grupos de Sociedades";
//		}
//		if(RegimenFiscal.trim().equals("624")){
//			regimenfiscal="624 - Coordinados";
//		}
//		if(RegimenFiscal.trim().equals("628")){
//			regimenfiscal="628 - Hidrocarburos";
//		}
//		if(RegimenFiscal.trim().equals("607")){
//			regimenfiscal="607 - Régimen de Enajenación o Adquisición de Bienes";
//		}
//		if(RegimenFiscal.trim().equals("629")){
//			regimenfiscal="629 - De los Regímenes Fiscales Preferentes y de las Empresas Multinacionales";
//		}
//		if(RegimenFiscal.trim().equals("630")){
//			regimenfiscal="630 - Enajenación de acciones en bolsa de valores";
//		}
//		if(RegimenFiscal.trim().equals("615")){
//			regimenfiscal="615 - Régimen de los ingresos por obtención de premios";
//		}
//
//		return regimenfiscal;
//
//	}

//	public String TipoComprobante(String tipoCompro){
//
//		if(TipoDeComprobante.trim().equals("I")){
//			tipoCompro="I - Ingreso";
//		}
//		if(TipoDeComprobante.trim().equals("E")){
//			tipoCompro="E - Egreso";
//		}
//		if(TipoDeComprobante.trim().equals("T")){
//			tipoCompro="T - Traslado";
//		}
//		if(TipoDeComprobante.trim().equals("N")){
//			tipoCompro="N - Nómina";
//		}
//		if(TipoDeComprobante.trim().equals("P")){
//			tipoCompro="P - Pago";
//		}
//
//		return tipoCompro;
//
//	}

//	public String TipoMoneda(String tipomoneda){
//
//		if(Moneda.trim().equals("EUR")){
//			tipomoneda="€";
//		}
//		if(Moneda.trim().equals("MXN")){
//			tipomoneda="$";
//		}
//		if(Moneda.trim().equals("CAD")){
//			tipomoneda="C$";
//		}
//		if(Moneda.trim().equals("USD")){
//			tipomoneda="$";
//		}
//		if(Moneda.trim().equals("GBP")){
//			tipomoneda="£";
//		}
//		if(Moneda.trim().equals("JPY")){
//			tipomoneda="¥";
//		}
//
//
//		return tipomoneda;
//
//	}





	/**
	 * Metodo que se encarga de regresar el valor del atributo, el cual se encuentra en el archivo xml
	 * @param nList   Lista de  tags y atributos  
	 * @param campo   valor del atributo del cual se desea saber el valor
	 * @return   el valor del atributo
	 */
	public String  recuperaValor(NodeList nList,String campo){
		String valorRegreso="";
		if(nList != null){
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if(nNode != null){
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						valorRegreso += eElement.getAttribute(campo);

						//						System.out.println("valorRegreso: " + valorRegreso);
					}
				}
			}
		}
		return valorRegreso;
	}

	/**
	 * Metodo que se encarga de regresar el valor del atributo, el cual se encuentra en el archivo xml
	 * @param nList   Lista de  tags y atributos  
	 * @param string   valor del atributo del cual se desea saber el valor
	 * @return   el valor del atributo
	 */
	public String  recuperaValorAdd(NodeList nList,String campo){
		String valorRegreso="";
		if(nList != null){
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if(nNode != null){
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						valorRegreso += eElement.getAttribute(campo);

						//						System.out.println("valorRegreso: " + valorRegreso);
					}
				}
			}
		}
		return valorRegreso;
	}
	
	/**
	 * Metodo que se encarga de regresar el valor del atributo, el cual se encuentra en el archivo xml
	 * @param nList   Lista de  tags y atributos  
	 * @param string   valor del atributo del cual se desea saber el valor
	 * @return   el valor del atributo
	 */
//	public String  recuperaValorPedimento(NodeList nList,String campo){
//		String valorRegreso="";
//		NumeroPedimento = "";
//		if(nList != null){
//			for (int temp = 0; temp < nList.getLength(); temp++) {
//				Node nNode = nList.item(temp);
//				if(nNode != null){
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						Element eElement = (Element) nNode;
//						valorRegreso += eElement.getAttribute(campo)+ " , ";
//
//						//						System.out.println("valorRegreso: " + valorRegreso);
//					}
//				}
//			}
//		}
//		return valorRegreso;
//	}
	
	
//	public List<DetalleAfter>  recuperaValorDetalles(Document doc){
//		Map<String, DetalleAfter> mapa = new HashMap<String, DetalleAfter>();
//		List<DetalleAfter> response = new ArrayList<DetalleAfter>();
//		
//		NodeList nList = doc.getElementsByTagName("cfdi:Concepto");
//		if(nList != null){
//			for (int temp = 0; temp < nList.getLength(); temp++) {
//				Node nNode = nList.item(temp);
//				if(nNode != null){
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						NumeroPedimento = "";
//						Element eElement = (Element) nNode;
//						Cantidad   = eElement.getAttribute("Cantidad");
//						Unidad   = eElement.getAttribute("ClaveUnidad");//Se Cambio a Clave Unidad por Peticion del cliente 
//						Descripcion   = eElement.getAttribute("Descripcion");
//						ValorUnitario   = eElement.getAttribute("ValorUnitario");
//						Importe   = eElement.getAttribute("Importe");
//						ConcDescuento =  eElement.getAttribute("Descuento");
//						ClaveProdServ =  eElement.getAttribute("ClaveProdServ");
//						NoIdentificacion = eElement.getAttribute("NoIdentificacion");
//						
////						System.out.println("NoIdentificacion: " + NoIdentificacion);
//						
//						identifi = NoIdentificacion;
//						
//						NodeList nListImpuestos  = nNode.getChildNodes();
//						Node nNodeImpuestos = null;
//						Node nNodeInfAduanera = null;
//						
////						System.out.println("--------------- "+nListImpuestos.getLength());
//						for(int y = 0; y < nListImpuestos.getLength(); y++ ) {
//							Node nNode1 = nListImpuestos.item(y);
////							System.out.println("name: " + nNode1.getNodeName());
//							if (nNode1.getNodeName().equals("cfdi:Impuestos")) {
//								nNodeImpuestos = nListImpuestos.item(y);
//							}
//							else if (nNode1.getNodeName().equals("cfdi:InformacionAduanera")) {
//								nNodeInfAduanera = nListImpuestos.item(y);
//								
//								if ( nNodeInfAduanera != null) {
//									
//									Element eElementInfAduanera = (Element) nNodeInfAduanera;
////									System.out.println("Valor de Numero de pedimento: " +eElementInfAduanera.getAttribute("NumeroPedimento"));
//									NumeroPedimento += eElementInfAduanera.getAttribute("NumeroPedimento") + " - ";
//								}
//							}
//								
//						}
//						
////						if(nNodeImpuestos.getChildNodes() != null){
////							System.out.println("Es null");
////						}else{
////							System.out.println("No es Es null");
////						}
////							System.out.println(nNodeImpuestos.getChildNodes());
//						if(nListImpuestos.getLength() !=0){
//						NodeList nListTransladados  = nNodeImpuestos.getChildNodes();
//						Node nNodeTransladados = null;
//						for(int y = 0; y < nListTransladados.getLength(); y++ ) {
//							Node nNode1 = nListTransladados.item(y);
////							System.out.println("name: " + nNode1.getNodeName());
//							if (nNode1.getNodeName().equals("cfdi:Traslados")) {
//								nNodeTransladados = nListTransladados.item(y);
//							}
//								
//						}
//						
//						
//						
////						Node nNodeTransladados = nListTransladados.item(1);
//						NodeList nListTransladado  = nNodeTransladados.getChildNodes();
//						Node nNodeTransladado = null;
//						
//						for(int y = 0; y < nListTransladado.getLength(); y++ ) {
//							Node nNode1 = nListTransladado.item(y);
////							System.out.println("name: " + nNode1.getNodeName());
//							if (nNode1.getNodeName().equals("cfdi:Traslado")) {
//								nNodeTransladado = nListTransladado.item(y);
//							}
//								
//						}
//						
//						Element eElementImpuestos = (Element) nNodeTransladado;
//						Base = eElementImpuestos.getAttribute("Base");
//						Impuesto = eElementImpuestos.getAttribute("Impuesto");
//						TipoFactor = eElementImpuestos.getAttribute("TipoFactor");
//						TasaOCuota = eElementImpuestos.getAttribute("TasaOCuota");
//						ImpImporte = eElementImpuestos.getAttribute("Importe");
//						}
//						DetalleAfter d = new DetalleAfter(i,Descripcion, Cantidad, ValorUnitario, Unidad, Importe, pomahle, poclient, Base, Impuesto,TipoFactor, TasaOCuota, 
//								ImpImporte,partNumbermahle,partNumberclient,packageNumber,container,ClaveProdServ,NumeroPedimento,ConcDescuento, NoIdentificacion, itemMahle, itemDelivery,pais,identifi);
////						response.add(d);
//						
//						mapa.put(temp+"", d);
//					}
//				}
//			}
//		}
//		
//		nList=null;
//		nList = doc.getElementsByTagName("Partes");
//
//		String key = "";
//		DetalleAfter detalle = null;
//		if(nList != null){
//			for (int temp = 0; temp < nList.getLength(); temp++) {
//				Node nNode = nList.item(temp);
//				if(nNode != null){
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						NodeList nListItem  = nNode.getChildNodes();
//						Node nNodeConcepto = null;
//						Node nNodePartNumber = null;
//						Node nNodePo = null;
//						Node nNodePackage = null;
//						Node nNodedelivery = null;
//						for(int y = 0; y < nListItem.getLength(); y++ ) {
//							Node nNode1 = nListItem.item(y);
////							System.out.println("name"+y+": " + nNode1.getNodeName());
//							if ("Parte".equals(nNode1.getNodeName())) {
//								nNodeConcepto = nListItem.item(y);
//								
//								Element eElementConcepto = (Element) nNodeConcepto;
//								key = eElementConcepto.getAttribute("pais");
////								System.out.println(key);
//								
//							
////								detalle = mapa.get(temp);
////								detalle.setNoidentificacion(key);
////								detalle.setPais(eElementConcepto.getAttribute("pais"));
////								pais = eElementConcepto.getAttribute("pais");
////								
////								pais += pais +" -- ";
////								System.out.println("pais: " +pais);
////								
////								detalle.setNoidentificacion(eElementConcepto.getAttribute("noIdentificacion"));
//								identifi = eElementConcepto.getAttribute("noIdentificacion");
//								Cantidadpais   = eElementConcepto.getAttribute("Cantidad");
//								valorUnitario_Pais   = eElementConcepto.getAttribute("valorUnitario");
////								System.out.println("identifi: " +identifi);
//								
//								pais +=identifi+" - "+ valorUnitario_Pais+" - "+ key +" , ";
//							} 
//							
//							
//						}
//						
//						
//						
//						
//						
////						Element eElementPartNumber = (Element) nNodePartNumber;
////						detalle.setMahle(eElementPartNumber.getAttribute("mahle"));
////						detalle.setClient(eElementPartNumber.getAttribute("client"));
////						
////						
////						
////						Element eElementPo = (Element) nNodePo;
////						detalle.setPomahle(eElementPo.getAttribute("mahle"));
////						detalle.setPoclient(eElementPo.getAttribute("client"));
////						
////						Element eElementdelivery = (Element) nNodedelivery;
////						detalle.setItemMahle(eElementdelivery.getAttribute("itemMahle"));
////						detalle.setItemDelivery(eElementdelivery.getAttribute("itemDelivery"));
////						
////											
////						Element eElementPackage = (Element) nNodePackage;
////						detalle.setPackagenumber(eElementPackage.getAttribute("packageNumber"));
//						
//						
////						for(int y = 0; y<nListItem.getLength(); y++ ) {
////							Node nNode1 = nListItem.item(y);
////							System.out.println("name: " + nNode1.getNodeName());
////						}
//						
//					}
//				}
//			}
//		}
//		
//		response.addAll(mapa.values());
//		return response;
//	}


//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
