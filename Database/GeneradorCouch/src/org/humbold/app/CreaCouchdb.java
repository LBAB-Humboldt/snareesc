/**
 * 
 */
package org.humbold.app;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

/**
 * @author 
    **********************************************************************************
    **********************************************************************************
    PROYECTO SNIARES HUMBOLDT - CONTRATO 16-16-0081-148PS
    **********************************************************************************
    **********************************************************************************
    INSTITUTO DE INVESTIGACION DE RECURSOS BIOLOGICOS 
    ALEXANDER VON HUMBOLDT
    PROYECTO DE IMPLEMENTACION DEL SISTEMA NACIONAL DE INFORMACION 
    DE ANALISIS DE RIESGO DE EXTINCION DE ESPECIES 
    DE FLORA Y FAUNA DE COLOMBIA
    BOGOTA, D.C., FEBRERO DE 2017
    **********************************************************************************
    **********************************************************************************
 *
 */
public class CreaCouchdb {

	/**
	 * 
	 */
	public CreaCouchdb() 
	{
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated constructor stub
		String archivoFuente = "";
		String rutaDestino = "";
		String admin = "";
		String clave = "";
		String servidor = "";
		String basecouch = "";
		String valor = "";
		
		valor = String.valueOf(System.currentTimeMillis());
		
		ArrayList<RegistroDarwin> registros = null;
		//***********************************************
		//***********************************************
		//curl -X POST -d @cargue2.json -H "Content-Type: application/json" http://admin:ncc123x@192.168.50.200:5984/especies_colombianas/_bulk_docs
		admin = JOptionPane.showInputDialog(null,"Ingrese el usuario: ");
		clave = JOptionPane.showInputDialog(null,"Ingrese la clave: ");
		servidor = JOptionPane.showInputDialog(null,"Ingrese el servidor: ");
		basecouch = JOptionPane.showInputDialog(null,"Ingrese el nombre de la base: ");
		//***********************************************
		//***********************************************
		archivoFuente = JOptionPane.showInputDialog(null,"Ingrese la ruta del archivo fuente: ");
		rutaDestino = JOptionPane.showInputDialog(null,"Ingrese la ruta del destino: ");
		//***********************************************
		//***********************************************
		//***********************************************
		//***********************************************
		CreaCouchdb objetoGenerador = new CreaCouchdb();
		registros = objetoGenerador.leerArchivoFuente(archivoFuente);
		objetoGenerador.generarArchivoCouchDB(valor,registros,rutaDestino,admin,clave,servidor,basecouch);
		//***********************************************
		//***********************************************
		//Actualización del índice
		//curl -XPOST 192.168.50.200:9200/especies_humboldt/_bulk --data-binary @indice.json
		objetoGenerador.generarArchivoIndiceElastic(valor,registros,rutaDestino,admin,clave,servidor,basecouch);
		//***********************************************
		//***********************************************
	}
	//*************************************************************
	//*************************************************************
	//*************************************************************
	public ArrayList<RegistroDarwin> leerArchivoFuente (String ruta)
	{
		  ArrayList<RegistroDarwin> registros = null;
		  File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      String linea = "";
	      RegistroDarwin registroActual = null;
	      //****************************************************
	      //****************************************************
	      String id;
	      String nombreCientifico;
	      String kingdom;
	      String phylum;
	      String clase;
	      String orden;
	      String family;
	      String genus;
	      String specificEpithet;
	      String rango;
	      String autor;
	      String nombreComun;
	      //****************************************************
	      //****************************************************
	      try 
	      {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	    	 System.out.println ("Archivo para leer: " + ruta);
	         archivo = new File (ruta);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         StringTokenizer st = null;
	         int lineNumber = 0;
		     //****************************************************
		     //****************************************************
	         registros = new ArrayList<RegistroDarwin>();
		     //****************************************************
		     //****************************************************
	         // Lectura del fichero
	         int secuencial = 2844601;
	         int fechaCreacion = 1479335273;
	         int fechaModificacion = 1479329397;
		     //****************************************************
		     //****************************************************
	         while((linea=br.readLine())!=null)
	         {
	        	 st = new StringTokenizer(linea,";");
                 registroActual = new RegistroDarwin();
            	 System.out.println ("******************************");
            	 System.out.println ("Leyendo registros de la fuente");
                 while(st.hasMoreTokens())
                 {
                	 //**********************************
                	 //**********************************
                	 id = st.nextToken();
                	 nombreCientifico = st.nextToken();
                	 kingdom = st.nextToken();
                	 phylum = st.nextToken();
                	 clase = st.nextToken();
                	 orden = st.nextToken();
                	 family = st.nextToken();
                	 genus = st.nextToken();
                	 specificEpithet = st.nextToken();
                	 rango = st.nextToken();
                	 autor = st.nextToken();
                	 nombreComun = st.nextToken();
                	 //**********************************
                	 //**********************************
                	 System.out.println ("******************************");
                	 System.out.println ("******************************");
      	             System.out.println(linea);
                	 System.out.println ("Registro actual de ID = " +  id);
                	 System.out.println ("id: " + id);
                	 System.out.println ("nombreCientifico: " + nombreCientifico);
                	 System.out.println ("kingdom: " + kingdom);
                	 System.out.println ("phylum: " + phylum);
                	 System.out.println ("clase: " + clase);
                	 System.out.println ("orden: " + orden);
                	 System.out.println ("family: " + family);
                	 System.out.println ("genus: " + genus);
                	 System.out.println ("specificEpithet: " + specificEpithet);
                	 System.out.println ("rango: " + rango);
                	 System.out.println ("autor: " + autor);
                	 System.out.println ("nombreComun: " + nombreComun);
                	 System.out.println ("******************************");
                	 System.out.println ("******************************");
                	 //**********************************
                	 //**********************************
                	 registroActual.setId(id);
                	 registroActual.set_rev("1-49cdcc98dff1785f64a3d9fd0"+ String.valueOf(secuencial));
                	 registroActual.setTaxonID(id);
                	 registroActual.setScientificName(nombreCientifico + " - " + autor);
                	 registroActual.setScientificNameWithoutAuthorship(nombreCientifico);
                	 registroActual.setScientificNameAuthorship(autor);
                	 registroActual.setFamily(family);
                	 registroActual.setTaxonRank(rango);
                	 registroActual.setTaxonomicStatus("accepted");
                	 registroActual.setAcceptedNameUsage(nombreCientifico + " - " + autor);
                	 registroActual.setIdentifier(id);
                	 registroActual.setType("taxon");
                	 registroActual.setCreated(String.valueOf(fechaCreacion));
                	 registroActual.setModified(String.valueOf(fechaModificacion));
                	 registroActual.setCreator("Jaime Alberto Gutierrez");
                	 registroActual.setContributor("Jaime Alberto Gutierrez");
                	 registroActual.setContact("jaimealbertogutierrez@gmail.com");
                	 registroActual.setSource("User");
                	 //**********************************
                	 //**********************************
                	 secuencial++;
                	 fechaCreacion++;
                	 fechaModificacion++;
                	 //**********************************
                	 //**********************************
                	 registros.add(registroActual);
                	 //**********************************
                	 //**********************************
                	 lineNumber++;
                 }
	         }
        	 System.out.println ("Terminando lectura de los registros");
        	 System.out.println ("******************************");
        	 System.out.println ("Total de Registros del Plano de Cargue: " + lineNumber);
        	 System.out.println ("******************************");
        	 System.out.println ("******************************");
	      }
	      
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      
	      finally
	      {
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }		
		return (registros);
	}
	//*************************************************************
	//*************************************************************
	//*************************************************************
	public void generarArchivoCouchDB (String nArchivo, ArrayList<RegistroDarwin> registrosEntrada, String rutaSalida, 
	String admin,String clave,String servidor,String basecouch)
	{
		FileWriter fichero = null;
        PrintWriter pw = null;
        String nombreArchivo = "";
        String salida = "";
        int i = 0;
        RegistroDarwin registro = null;
        String lineaEntradaNueva = "";
        String comandoCargue = "";
        
        try
        {
        	nombreArchivo = "RegistrosCouchDb" + nArchivo + ".json";
        	salida = rutaSalida + "/" + nombreArchivo;
        	//************************************************************
        	//************************************************************
        	System.out.println ("Ruta de salida del archivo de COUCHDB: " + salida);
        	//************************************************************
        	//************************************************************
            fichero = new FileWriter(salida);
            pw = new PrintWriter(fichero);
        	//************************************************************
        	//************************************************************
            pw.println("{");
            pw.println(" \"docs\": ");
            pw.println(" [ ");
            for (i = 0;  i < registrosEntrada.size();  i++)
            {
            	registro = (RegistroDarwin)registrosEntrada.get(i);
            	lineaEntradaNueva = "{\"_id\":\"" + registro.getId() +  "\",\"_rev\": \"" + registro.get_rev() + "\",\"taxonID\":\"" +  registro.getId() + "\",\"scientificName\": \"" + registro.getScientificName() + "\",\"scientificNameWithoutAuthorship\": \"" + registro.getScientificNameWithoutAuthorship() +  "\",\"scientificNameAuthorship\": \"" + registro.getScientificNameAuthorship() + "\",\"family\": \"" + registro.getFamily() + "\",\"taxonRank\": \"" + registro.getTaxonRank() + "\",\"taxonomicStatus\": \"" + registro.getTaxonomicStatus() + "\",\"acceptedNameUsage\": \"" + registro.getAcceptedNameUsage() + "\",\"metadata\":{\"identifier\": \"" + registro.getId() + "\",\"type\": \"" + registro.getType() + "\",\"created\":" + registro.getCreated() + ",\"modified\":" + registro.getModified() + ",\"creator\": \"" + registro.getCreator() + "\",\"contributor\": \"" + registro.getContributor() + "\",\"contact\": \"" + registro.getContact() + "\",\"source\": \"" + registro.getSource() + "\"}}";
            	
            	if (i != registrosEntrada.size()-1)
            	{
            		lineaEntradaNueva += ",";
            	}
            	System.out.println (lineaEntradaNueva);
            	pw.println(lineaEntradaNueva);
            }
            pw.println(" ] ");
            pw.println("} ");
        	//************************************************************
        	//************************************************************
            comandoCargue = 
            "curl -X POST -d @" + nombreArchivo + " -H \"Content-Type: application/json\" http://" + admin + ":" + clave + "@" + servidor +":5984/" + basecouch + "/_bulk_docs ";
            System.out.println(comandoCargue);
        	//************************************************************
        	//************************************************************
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        
        finally 
        {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }		
	}
	//*************************************************************
	//*************************************************************
	//*************************************************************
	public void generarArchivoIndiceElastic (String nArchivo, ArrayList<RegistroDarwin> registrosEntrada, String rutaSalida, 
	String admin,String clave,String servidor,String basecouch)
	{
		FileWriter fichero = null;
        PrintWriter pw = null;
        String nombreArchivo = "";
        String salida = "";
        int i = 0;
        RegistroDarwin registro = null;
        String lineaEntradaNueva = "";
        String comandoCargue = "";
        
        try
        {
        	nombreArchivo = "RegistrosElasticSearch" + nArchivo + ".json";
        	salida = rutaSalida + "/" + nombreArchivo;
        	//************************************************************
        	//************************************************************
        	System.out.println ("Ruta de salida del archivo de ELASTICSEARCH: " + salida);
        	//************************************************************
        	//************************************************************
            fichero = new FileWriter(salida);
            pw = new PrintWriter(fichero);
        	//************************************************************
        	//************************************************************
            for (i = 0;  i < registrosEntrada.size();  i++)
            {
            	registro = (RegistroDarwin)registrosEntrada.get(i);
            	//******************************************************
            	//******************************************************
            	lineaEntradaNueva = "{\"index\":{\"_index\":\"" + basecouch + "\",\"_type\":\"taxon\",\"_id\":\"" + registro.getId() + "\"}}";
            	pw.println(lineaEntradaNueva);
            	//******************************************************
            	lineaEntradaNueva = "{\"_score\" :1.0,\"taxonID\":\"" + registro.getId() + "\",\"scientificName\":\"" + registro.getScientificName() + "\",\"scientificNameWithoutAuthorship\":\"" + registro.getScientificNameWithoutAuthorship() + "\",\"scientificNameAuthorship\":\"" + registro.getScientificNameAuthorship() + "\",\"family\":\"" + registro.getFamily() + "\",\"taxonRank\":\"" + registro.getTaxonRank() + "\",\"taxonomicStatus\":\"" + registro.getTaxonomicStatus() + "\",\"acceptedNameUsage\":\"" + registro.getAcceptedNameUsage() + "\",\"metadata\":{\"identifier\":\"" + registro.getId() + "\",\"type\":\"" + registro.getType() + "\",\"created\":" + registro.getCreated() + ",\"modified\":" + registro.getModified() + ",\"creator\":\"" + registro.getCreator() + "\",\"contributor\":\"" + registro.getContributor() + "\",\"contact\":\"" + registro.getContact() + "\",\"source\":\"" + registro.getSource() + "\"},\"rev\":null}";
            	pw.println(lineaEntradaNueva);
            	//******************************************************
            	//******************************************************
            }
        	//************************************************************
        	//************************************************************
            comandoCargue =
         	"curl -XPOST " + servidor + ":9200/" + basecouch + "/_bulk --data-binary @" + nombreArchivo;
            System.out.println(comandoCargue);
        	//************************************************************
        	//************************************************************
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        
        finally 
        {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }		
	}
	//*************************************************************
	//*************************************************************
	//*************************************************************
	//*************************************************************
	//*************************************************************
	//*************************************************************
	//*************************************************************
	//*************************************************************
	//*************************************************************
	//*************************************************************
	//*************************************************************
	//*************************************************************
}
