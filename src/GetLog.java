import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;


public class GetLog {
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
	private static int increm = 0;

//	public static void main(String[] args) {
////		 try {
////			    File file = new File("C:\\Users\\khurt\\Desktop\\xml.txt");
////			    InputStream myScan = new FileInputStream(file);
////			    byte[] b = new byte[(int)file.length()];
////			    myScan.read(b);
////			    String cowo = myScan.toString();
////			    String decoded = DatatypeConverter.printBase64Binary(b);
////			    String cat = b.toString();
////			    System.out.println(decoded);
////			    byte[] bArray = cat.getBytes();
////			        OutputStream out = new FileOutputStream("C:\\Users\\gdfurt\\Desktop\\cow.xml");
////			        out.write(b);
////			        out.close();
////			    } catch (FileNotFoundException e) {
////			        // TODO Auto-generated catch block
////			        e.printStackTrace();
////			    } catch (IOException e) {
////			        // TODO Auto-generated catch block
////			        e.printStackTrace();
////			    }
//		
//		String originalInput = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiID8+CjxjZmRpOkNvbXByb2JhbnRlIHhtbG5zOmNmZGk9Imh0dHA6Ly93d3cuc2F0LmdvYi5teC9jZmQvMyIgeG1sbnM6cGFnbzEwPSJodHRwOi8vd3d3LnNhdC5nb2IubXgvUGFnb3MiIHhtbG5zOnRmZD0iaHR0cDovL3d3dy5zYXQuZ29iLm14L1RpbWJyZUZpc2NhbERpZ2l0YWwiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTpzY2hlbWFMb2NhdGlvbj0iaHR0cDovL3d3dy5zYXQuZ29iLm14L2NmZC8zIGh0dHA6Ly93d3cuc2F0LmdvYi5teC9zaXRpb19pbnRlcm5ldC9jZmQvMy9jZmR2MzMueHNkIGh0dHA6Ly93d3cuc2F0LmdvYi5teC9QYWdvcyBodHRwOi8vd3d3LnNhdC5nb2IubXgvc2l0aW9faW50ZXJuZXQvY2ZkL1BhZ29zL1BhZ29zMTAueHNkIiBDZXJ0aWZpY2Fkbz0iTUlJR1dEQ0NCRUNnQXdJQkFnSVVNREF3TURFd01EQXdNREEwTURZMU16TXhNalF3RFFZSktvWklodmNOQVFFTEJRQXdnZ0d5TVRnd05nWURWUVFEREM5QkxrTXVJR1JsYkNCVFpYSjJhV05wYnlCa1pTQkJaRzFwYm1semRISmhZMm5EczI0Z1ZISnBZblYwWVhKcFlURXZNQzBHQTFVRUNnd21VMlZ5ZG1samFXOGdaR1VnUVdSdGFXNXBjM1J5WVdOcHc3TnVJRlJ5YVdKMWRHRnlhV0V4T0RBMkJnTlZCQXNNTDBGa2JXbHVhWE4wY21GamFjT3piaUJrWlNCVFpXZDFjbWxrWVdRZ1pHVWdiR0VnU1c1bWIzSnRZV05wdzdOdU1SOHdIUVlKS29aSWh2Y05BUWtCRmhCaFkyOWtjMEJ6WVhRdVoyOWlMbTE0TVNZd0pBWURWUVFKREIxQmRpNGdTR2xrWVd4bmJ5QTNOeXdnUTI5c0xpQkhkV1Z5Y21WeWJ6RU9NQXdHQTFVRUVRd0ZNRFl6TURBeEN6QUpCZ05WQkFZVEFrMVlNUmt3RndZRFZRUUlEQkJFYVhOMGNtbDBieUJHWldSbGNtRnNNUlF3RWdZRFZRUUhEQXREZFdGMWFIVERxVzF2WXpFVk1CTUdBMVVFTFJNTVUwRlVPVGN3TnpBeFRrNHpNVjB3V3dZSktvWklodmNOQVFrQ0RFNVNaWE53YjI1ellXSnNaVG9nUVdSdGFXNXBjM1J5WVdOcHc3TnVJRU5sYm5SeVlXd2daR1VnVTJWeWRtbGphVzl6SUZSeWFXSjFkR0Z5YVc5eklHRnNJRU52Ym5SeWFXSjFlV1Z1ZEdVd0hoY05NVGN3TmpFME1UWXpNVFV3V2hjTk1qRXdOakUwTVRZek1UVXdXakNCK0RFeU1EQUdBMVVFQXhRcFFWUW1WQ0JEVDAxRlVrTkpRVXhKV2tGRFNVOU9JRTFQVmtsTUlGTWdSRVVnVWt3Z1JFVWdRMVl4TWpBd0JnTlZCQ2tVS1VGVUpsUWdRMDlOUlZKRFNVRk1TVnBCUTBsUFRpQk5UMVpKVENCVElFUkZJRkpNSUVSRklFTldNVEl3TUFZRFZRUUtGQ2xCVkNaVUlFTlBUVVZTUTBsQlRFbGFRVU5KVDA0Z1RVOVdTVXdnVXlCRVJTQlNUQ0JFUlNCRFZqRWxNQ01HQTFVRUxSTWNTVlZUT0Rrd05qRTJVa2cySUM4Z1JrOUhUVGN4TURVd05FVXhOREVlTUJ3R0ExVUVCUk1WSUM4Z1JrOUhUVGN4TURVd05FaEVSa3hTVWpBNU1STXdFUVlEVlFRTEV3cEZjMk55YVhSdmNtbHZNSUlCSWpBTkJna3Foa2lHOXcwQkFRRUZBQU9DQVE4QU1JSUJDZ0tDQVFFQTBBSmZvTWVHalpBNTg4WkhKdHRqZHhSVTk1RVRXNFE0RTc5OFNST0pFT1AxY1lIQ2pxaHVDcVdZUUF3emxiaXVPVlEzNTZJM1V1TE41K2txckhXeDY5RGw2MXVtSFJhMWNVaDNQdXdWTUt2VjBOMFE1Nkd0NFc5bkllOFdVYmUwS3lCLzF0TzF1Wm94ak1VTkROcDkvRURqWlg4cDd2T2NXa1ppdm5GZ2hwaTBOTkI5czVRamhha1lIMVlHSWk0U0VzcXJGZS9VcXpJWXZCNXBBRW9CeXpCT3JVVFlheXJCakx4dVdxUGVkbzNLeHpsQ2FDc1dKczFpZXpGTXdvZzBCcitDZHp3RlFDSDhOWDZOT2VtaWdVU1hrZ01ka1Flamx1YXh5YTJYQ3VpUit4ZmZKMFJXWDNEUVRyeVdGTExhS1pUM1ZTR0JWdFlyUC9hMjY5YTQvd0lEQVFBQm94MHdHekFNQmdOVkhSTUJBZjhFQWpBQU1Bc0dBMVVkRHdRRUF3SUd3REFOQmdrcWhraUc5dzBCQVFzRkFBT0NBZ0VBSnFzYm9QSGxPdmVlMTgrTGVxV0tKWk1yUTJqQS9uWDFoMlBwRWtWNFlXbjdleGlBbWxKdGNnRnBvV2EzS1Fpd1UyZ28xSFRKb3JWYWNETVdQZ01OakxMV3ZvNlF4RWVjRmpDejdIMjQzZnpoYXFlMWJOZnZteWZERFowNlV6d3pxaFFQY1BxM09WbUJtUk11azVxQXlSL2NXRklTZDZPZURNUU0zaTJ3aHJ6ODJac1IvUWZSV0VaakJnbmNiMkFpSDk3alJoZlF6M0dIdDI5OS9iRjBBRjU3cjFTUTd1TUo1UkJFbW80QVRBbUk2dENyRUtDeXRUMTZiY2RyeGFwb2VLK3dQOVhKblAzbERReURNYlk2ZitEa042TXNzK3MyZXVkRkR2L0EyWGF4djc1Wk84L1ZLb2Zvd1B1RnErdmo3WFc2MTl3MnZUNDl1MmNhRGJ3czU2c0lGTHRiNGZYNW0zSlhybU1wTVBlM2RhTzBRSjBXZ1V5TUlkaFNQT2JkVnFPYUVjSWxGTzFOams5NitvK1lwdkhyOUdqclAzZG1HekpjRW5NZWNzTW9xMzFtNGRXMy9xTGhqQUxtWEVCemNOTmk2T3BYcmdsem85a0tvbkc1bWpBQlZYVWFaai9NNlNQMmlOdlN2UHAzZXV5ajFoRW40MGIxRDFEZnRpK3lYaHI4bTVRd2VaNWF3Q3BRVXhDNE1zcTNNSFpYbmV4N3hHRDgyVzhUY2dyQThoWTBPME5MSStWc1FXNFFkdCtHbGpycEJvSXZvaCtTbS95a01Mei9OVm5MTGN4cGR5c1k3UnVLTmVSMFVpK3FHM2ZjUVNwMDVaWWQxVldHY3REZlZQT3hBVzVSbGY4OHV2eVltS0JIblhHalZ1UzMyTzJpcGRtK3ZMYVNnc3c9IiBGZWNoYT0iMjAxOC0xMC0wNFQxMTowMDo0MCIgRm9saW89IjQ3OTU1MSIgTHVnYXJFeHBlZGljaW9uPSI1NDAzMCIgTW9uZWRhPSJYWFgiIE5vQ2VydGlmaWNhZG89IjAwMDAxMDAwMDAwNDA2NTMzMTI0IiBTZWxsbz0idzF0YmFua1NQek5oMW5DeVJ1MEsxSi9ONU9HWU0zb1lWeTkzaEVXcU5qa0p5TXdrUkQ3dTRNWWhpU3VQZ2ZyYVBBSXhWcXdCRjd6S0pyNjVJL0QveldsVEZDa1ljOGdnWUR4RE8xVzRJNURMVkhxV2hTbmhwMFMweVNOdjRDYzhiek02cFNXKzU3L1I5ZnJZM1ZEckRFVEZHVFJwWE9hMmpkWExLN1dEZml3eXp2Wk9TZjZLcjBqTlUvUGJ0MjFsaWpCdzhWZGV1eXc3Z1l3MklYb2VkRVArcmN4MFA0ZkYyWEdUbmlpaWUvbUdRYnY5akdmUXRpR1FSekpHdXdVQ3NQa2RRS3ZGMU1YMHlrOWl5NW9OUFEvMDB2Z0V5T2gvNjJhR0laa3hHTWJPRWw2M1UxcTV3anBObFRZVUt4eVdRNU9mcnZSa3o3VW9iaVp1RStlUyt3PT0iIFNlcmllPSJDUExSIiBTdWJUb3RhbD0iMCIgVGlwb0RlQ29tcHJvYmFudGU9IlAiIFRvdGFsPSIwIiBWZXJzaW9uPSIzLjMiPjxjZmRpOkVtaXNvciBOb21icmU9IkFUJmFtcDtUIENvbWVyY2lhbGl6YWNpw7NuIE3Ds3ZpbCwgUy4gZGUgUkwgZGUgQ1YgIiBSZWdpbWVuRmlzY2FsPSI2MDEiIFJmYz0iSVVTODkwNjE2Ukg2Ii8+PGNmZGk6UmVjZXB0b3IgTm9tYnJlPSIgUk9DSU8gSVZFVFRFIENBUlJJTExPIENPUlRFUyIgUmZjPSJDQUNSODYwNTA3SUc1IiBVc29DRkRJPSJQMDEiLz48Y2ZkaTpDb25jZXB0b3M+PGNmZGk6Q29uY2VwdG8gQ2FudGlkYWQ9IjEiIENsYXZlUHJvZFNlcnY9Ijg0MTExNTA2IiBDbGF2ZVVuaWRhZD0iQUNUIiBEZXNjcmlwY2lvbj0iUGFnbyIgSW1wb3J0ZT0iMCIgVmFsb3JVbml0YXJpbz0iMCIvPjwvY2ZkaTpDb25jZXB0b3M+PGNmZGk6Q29tcGxlbWVudG8+CiAgICAgICAgPHBhZ28xMDpQYWdvcyBWZXJzaW9uPSIxLjAiPjxwYWdvMTA6UGFnbyBGZWNoYVBhZ289IjIwMTgtMDktMjVUMDU6NDk6NDkiIEZvcm1hRGVQYWdvUD0iMDEiIE1vbmVkYVA9Ik1YTiIgTW9udG89IjgwMS40NCI+PHBhZ28xMDpEb2N0b1JlbGFjaW9uYWRvIElkRG9jdW1lbnRvPSIzMjg5RDc2QS1GMzIzLTREQjEtQThDQS0yNzFCQTcwNTg0OUQiIEltcFBhZ2Fkbz0iODAxLjQ0IiBJbXBTYWxkb0FudD0iODAxLjQ0IiBJbXBTYWxkb0luc29sdXRvPSIwLjAwIiBNZXRvZG9EZVBhZ29EUj0iUFBEIiBNb25lZGFEUj0iTVhOIiBOdW1QYXJjaWFsaWRhZD0iMSIvPjwvcGFnbzEwOlBhZ28+PC9wYWdvMTA6UGFnb3M+PHRmZDpUaW1icmVGaXNjYWxEaWdpdGFsIHhtbG5zOnRmZD0iaHR0cDovL3d3dy5zYXQuZ29iLm14L1RpbWJyZUZpc2NhbERpZ2l0YWwiIHhzaTpzY2hlbWFMb2NhdGlvbj0iaHR0cDovL3d3dy5zYXQuZ29iLm14L1RpbWJyZUZpc2NhbERpZ2l0YWwgaHR0cDovL3d3dy5zYXQuZ29iLm14L3NpdGlvX2ludGVybmV0L2NmZC9UaW1icmVGaXNjYWxEaWdpdGFsL1RpbWJyZUZpc2NhbERpZ2l0YWx2MTEueHNkIiBWZXJzaW9uPSIxLjEiIFVVSUQ9IjM4ZTlmNjI5LWQ2MmMtNDA0Yi1hNTEzLTMzYmZlYTA1MmQ5MyIgUmZjUHJvdkNlcnRpZj0iRElBMDMxMDAyTFoyIiBGZWNoYVRpbWJyYWRvPSIyMDE4LTEwLTA1VDEyOjM1OjU2IiBTZWxsb0NGRD0idzF0YmFua1NQek5oMW5DeVJ1MEsxSi9ONU9HWU0zb1lWeTkzaEVXcU5qa0p5TXdrUkQ3dTRNWWhpU3VQZ2ZyYVBBSXhWcXdCRjd6S0pyNjVJL0QveldsVEZDa1ljOGdnWUR4RE8xVzRJNURMVkhxV2hTbmhwMFMweVNOdjRDYzhiek02cFNXKzU3L1I5ZnJZM1ZEckRFVEZHVFJwWE9hMmpkWExLN1dEZml3eXp2Wk9TZjZLcjBqTlUvUGJ0MjFsaWpCdzhWZGV1eXc3Z1l3MklYb2VkRVArcmN4MFA0ZkYyWEdUbmlpaWUvbUdRYnY5akdmUXRpR1FSekpHdXdVQ3NQa2RRS3ZGMU1YMHlrOWl5NW9OUFEvMDB2Z0V5T2gvNjJhR0laa3hHTWJPRWw2M1UxcTV3anBObFRZVUt4eVdRNU9mcnZSa3o3VW9iaVp1RStlUyt3PT0iIE5vQ2VydGlmaWNhZG9TQVQ9IjAwMDAxMDAwMDAwNDA0NjE0OTIwIiBTZWxsb1NBVD0iS0o2QnB6SmZycTRqRWpQcHk4aWxrQ29YT1RGZ2hOOU9ZNzlUN3FBVHlUem1RYVkrREh5dFZUTTF0d08zUU5HWHNpbk4zT1VvZzh6UkZaTDBNR2FScC8xdkVVQUR1TjU4MjlNQ3M1bXFmVnNhblpuZzBxd3Q2eFVUT3lMalJYYlVGKzZHYzlaUkJJNjhTbWRRS1c2amcxWWhxcDVQeWNFa3FKa1psQ0NkaEo4RGRtbjZqb0xVMUxramVXZEtKNFdFT08zVlJQSEMxMFc2Rlh0WlNPNmhHZjlDcTVadDhUQzBkMFpkV283QUZOb29Tc3V1VTlHNFBjMU5CSWh2VUFJVHcrWFB4blZ2em1XcGVVQVJYQkp5cHBTQUxoemZ6VktnbzhhYVpVVkdMVmE5bjk4ZzZURnhTd3p3Ymw4OEp5Zkttek1kempFSnFFZEVJajR4NTRQbmZnPT0iLz4KICAgIDwvY2ZkaTpDb21wbGVtZW50bz48L2NmZGk6Q29tcHJvYmFudGU+";
//		String encodedString = new String(Base64.encodeBase64(originalInput.getBytes()));
//		System.out.println("1.- "+encodedString);
//		String decodedString = new String(Base64.decodeBase64(originalInput.getBytes()));
//		System.out.println("2.- "+decodedString);
//
//	}
	
	public static void main(String[] args) throws IllegalArgumentException, Exception {
		
		int z=0;

		GetLog lista = new GetLog();

		try {  
			//Iniciamos a leer y obtener properties
			//Iniciamos las variables Properties
			Properties properties = new Properties();   

			//Cargo el archivo properties   
			//de la carpeta Properties de nuestro proyecto  
			properties.load(GetLog.class.getResource("/Properties/Variables.properties").openStream());  

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
			if(ficherosDir[w].getName().toUpperCase().indexOf(".txt") ==-1){

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
				
				String [] tit = Titulo.toUpperCase().split(".txt");
				 
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
	            int x = 0;
	            
//	            lista.leerXMLPDF(sDirectorio+NameBMP+".XML");
	            
//	            NameBMP = RfcEmi+"_"+NameBMP;
	            
	            try {
	            	
//	            	int increm = 0;
					  destinationFile =  sDirectorioPDF+NameBMP+"_("+increm+").XML";
//						 OutputStream os = (OutputStream)new FileOutputStream(destinationFile);
////					      String encoding = "UTF8";
////					      Charset ENCODING = StandardCharsets.UTF_8;
//						 Charset ENCODING = StandardCharsets.UTF_8;
//					      OutputStreamWriter osw = new OutputStreamWriter(os, ENCODING);
////					      BufferedWriter bw = new BufferedWriter(osw);
//						bw = new BufferedWriter(new BufferedWriter(osw));
						out = new BufferedWriter(new OutputStreamWriter(
							    new FileOutputStream(destinationFile), "UTF-8"));
						
						out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r"+ "\n");
//							try {
//							    out.write(aString);
//							} finally {
//							    out.close();
//							}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
	            
				  while ((strLinea = buffer.readLine()) != null)   {
					  
					  
					  
					  // Imprimimos la línea por pantalla
		               
		                
//		                MacroIni = strLinea;
//		                MacroFin = MacroIni;
		                
//					  System.out.println ("Linea1 : "+  strLinea);
		                
//		               if(strLinea.startsWith("\\<cfdi:Comprobante")){
		                
//		            	   System.out.println ("Linea: "+  strLinea);
		                String[] arrayColores = strLinea.split("content\":\"");
//		                String[] arrayColores = MacroFin.split("\\*");
		                
		             // En este momento tenemos un array en el que cada elemento es un color.
		             for (int i = 0; i < arrayColores.length; i++) {
//		             	System.out.println("Bloque --> "+ x +":"+ arrayColores[i]);
		            	
		             	if(arrayColores[i].indexOf("cfdi:Comprobante") != -1){
//		             		out.write(arrayColores[i] +"\r"+ "\n" );
//		             		out.write(arrayColores[i]+"\r"+ "\n" );
		             		if(arrayColores[i].startsWith("<cfdi:Comprobante")){
//		             		
//		             		System.out.println("Bloque --> "+ x +":"+ arrayColores[i]);
		             		out.write(arrayColores[i] +"\r"+ "\n" );
		             		increm ++;
		             		
		             		out.close();
		             		
		             		destinationFile =  sDirectorioPDF+NameBMP+"_("+increm+").XML";
		            		 out = new BufferedWriter(new OutputStreamWriter(
									    new FileOutputStream(destinationFile), "UTF-8"));
		            		 out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r"+ "\n");
		             	}
//		             		
		             		
		             		
//		             		String[] arrayRFC = arrayColores[i].split("RegimenFiscal=\"601\" Rfc=\"");
//		             		 for (int u = 0; u < arrayRFC.length; u++) {
////		 		             	System.out.println("Bloque --> "+ x +":"+ arrayColores[u]);
//		 		            	
//		 		             	if(!arrayRFC[u].equals("")){
//		 		             		try {
//		 		             			arrayRFC[u].substring(0, 12);
//		 		             			RfcEmi = arrayRFC[u].substring(0, 12).replace("\"", "");
//		 		             			System.out.println("RFC --> "+ arrayRFC[u].substring(0, 12));
//									} catch (Exception e) {
//										// TODO: handle exception
//										continue;
//									}
//		 		             		
//		 		             		
//		 		             		
//		 		             	}
//		             	}
		             	
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
		                	
		                	
		                	if(arrayColores[i].indexOf(":}") != -1){
		                		x++; 
		                		System.out.println(x+" Termina ");
		                		out.close();
		                		
		                		destinationFile =  sDirectorioPDF+RfcEmi+"_"+NameBMP+"_("+x+").XML";
			            		 out = new BufferedWriter(new OutputStreamWriter(
										    new FileOutputStream(destinationFile), "UTF-8"));
			            		 out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\r"+ "\n");
		                	}
//		                }
//		             }
		            
				  }


//				try {
//					lista.leerXMLPDF(Ruta);
//				} catch (NullPointerException e1){
//					System.out.println(e1.toString());
				}
//		               }
			}
		}
		}

	}

}
