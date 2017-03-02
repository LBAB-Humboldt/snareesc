#**********************************************************************************
#**********************************************************************************
#  PROYECTO SNIARES HUMBOLDT - CONTRATO 16-16-0081-148PS
#**********************************************************************************
#**********************************************************************************
#  INSTITUTO DE INVESTIGACION DE RECURSOS BIOLOGICOS 
#  ALEXANDER VON HUMBOLDT
#  PROYECTO DE IMPLEMENTACION DEL SISTEMA NACIONAL DE INFORMACION 
#  DE ANALISIS DE RIESGO DE EXTINCION DE ESPECIES 
#  DE FLORA Y FAUNA DE COLOMBIA
#  BOGOTA, D.C., FEBRERO DE 2017
#**********************************************************************************
#**********************************************************************************
#  CARPETA DATABASE:
#
#  OBJETIVO:  Permitir el acceso a las herramientas de migración de orígenes de datos
#  empleados por CNCFLORA COLOMBIA para el cargue de todas las especies objeto de
#  estudio de investigación científica para el proceso de Análisis de Riesgo
#  de extinción, las plantillas de precarga y el modelo de migración entre Sistemas
#
#

#  a)  GeneradorCouch:  Proyecto de Integración ECLIPSE IDE de aplicación Java Standalone JSE
#      que permite el proceso de cargue de archivos en formato CSV de listados de especies
#      y la correspondiente generación en formato JSON de cargue para base de datos noSQL
#      COUCHDB, así como de generación del índice de configuración y despliegue para CNCNFLORA
#      de los registros de especies migradas a CouchDB.
#b)  Migración:  Carpeta de ejemplo con el correspondiente contenido de migración de las
#    especies:
#    		anfibios
#	 		briofitos
#			bromelias
#			fanerogamas
#			frailejones
#			maderables
#			magnolias
#			mirisiticaceae
#			orquideas
#			palmas
#			reptiles
#			zamias
#	Tanto en formato original CSV, como en su correspondiente archivo COUCHDB y ELASTICSEARCH,
#	bases de datos e indización usados por CNCFLORA
#
#   c)  PlantillaRegistrosFlora.xlsx:  Archivo de Hoja de Cálculo Excel que sirve como template
#       preparatorio para la generación de archivos CSV de alimentación del aplicativo GeneradorCouch
#   d)  PreparacionCargue.xlsx:  Ejemplo funcional de migración real (por pestañas) de las especies
#       referenciadas en el punto b) de este archivo de documentación
#**********************************************************************************
#**********************************************************************************