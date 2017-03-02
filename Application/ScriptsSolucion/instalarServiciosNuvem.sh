#!/bin/bash
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#  INSTITUTO DE INVESTIGACION DE RECURSOS BIOLOGICOS ALEXANDER VON HUMBOLDT
#  PROYECTO DE IMPLEMENTACION DEL SISTEMA NACIONAL DE INFORMACION DE ANALISIS DE RIESGO DE EXTINCION DE ESPECIES DE FLORA Y FAUNA DE COLOMBIA
#  SCRIPT DE INSTALACION DE CONTENEDORES DOCKER DE LA SOLUCION NUVEM CNCFLORA PORTAL
#  SUPERVISOR:  INGENIERO RAFAEL RICARDO REYES
#  CONTRATISTA:  INGENIERO JAIME ALBERTO GUTIERREZ MEJIA.  9733675
#  CONTRATO NO. 16-16-0081-148PS
#  BOGOT, D.C., FEBRERO DE 2017
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#  SCRIPT DE INSTALACION DE CONTENEDORES DOCKER DE LA SOLUCION NUVEM CNCFLORA PORTAL
#***********************************************************************************************************************************************
#  OBJETIVO:  Permitir la instalacion del cluster dockerizado de aplicaciones de Nuvem CNCFLORA, que 
#  involucra los siguientes modulos:
#
#  a)  Flora do brasil:  Fuente taxonomica autoritativa. Expone un IPT (Kit integrado de herramientas de publicacion) con sus datos.
#  b)  Floradata:  Consume el IPT de Flora do Brasil en una base de datos SQLite mas adecuada, y expone los nombres a traves 
#      de una API de webservices REST en la taxonomia.
#  c)  DWC-Services:  Biblioteca y API para manejar las operaciones principales en estandar Darwincore: Conversion entre formatos de archivo 
#      (xlsx, csv, dwc-a, json, geojson), validacion, solucion de problemas comunes y ejecucion de algunos analisis.
#  d)  Connect:  Componente de autenticacion unico (Single Sign On) para todas las aplicaciones.
#  e)  CouchDB:  Base de datos basada en REST y libre de esquema para manipulacion de documentos.  optima en procesos de persistencia, 
#      replicacion y reduccion del mapa de riesgos para el tratamiento de los datos.  Se utiliza como almacenamiento principal.
#  f)  ElasticSearch:  Servidor de indexacion y busqueda.
#  g)  Checklist:  Modulo que permitie el agrupamiento de las especies en una lista de control, la creacion de la base de datos 
#      en couchdb y el indice en elasticsearch.
#  h)  Occurrences:  Manipula los datos de ocurrencias. Permite cargar, insertar, georeferenciar, buscar por 
#      especies con sinonimos (de lista de verificacion), validacion y analisis.
#  i)  Profiles:  Perfil de la especie con datos ecologicos, con flujo de trabajo para la creacion, validacion y revision.
#  j)  Assessments:  Flujo de trabajo para la evaluacion de riesgos.
#  k)  Entrypoint:  Modulo unico de especificacion con enlaces para las diferentes aplicaciones en diferentes listas de verificacion.
#  l)  Services:  API de publicacion de Web Services RESTFull.
#  m)  Reports:  Generar archivos CSV (y un archivo SQLite) con los datos para su posterior publicacion en CKAN.
#  n)  CKAN:  Herramienta de publicacion de datos amigable para el usuario.
#  o)  Portal:  Portal Web Unificado con la capacidad de consulta basada en Web Services de la Lista Roja de Especies Amenazadas.
#  p)  Dockers:  Base contenedores de base, especialmente: Apache, Ruby, Java8, ElasticSearch, CouchDB, Kibana y Selenio.
#  q)  Docker Proxy:  Proxy NGINX dinamico para los contenedores del acoplador.
#  r)  Nuvem:  Proyecto utilizando docker-compose para ejecutar todas las aplicaciones.
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#  NOTA:  En la cofinguracion actual de distribucion fuera del dockerizador, este script ha de ejecutarse en la ruta /vagrant/portal o en
#  aquella ubicada en la configuracion hecha por el Administrador del Sistema, de la solucion independiente, configurable y editable del
#  Portal editado para la actualizacion de servicios y contenido del interesado.
DIA=`date +"%d/%m/%Y"`
HORA=`date +"%H:%M"`
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo " INSTITUTO DE INVESTIGACION DE RECURSOS BIOLOGICOS ALEXANDER VON HUMBOLDT "
echo " PROYECTO DE IMPLEMENTACION DEL SISTEMA NACIONAL DE INFORMACION DE ANALISIS DE RIESGO DE EXTINCION DE ESPECIES DE FLORA Y FAUNA DE COLOMBIA "
echo " SCRIPT DE INSTALACION DE CONTENDORES DOCKER DE LA SOLUCION NUVEM CNCFLORA PORTAL "
echo " SUPERVISOR:  INGENIERO RAFAEL RICARDO REYES "
echo " CONTRATISTA:  INGENIERO JAIME ALBERTO GUTIERREZ MEJIA.  9733675 "
echo " CONTRATO NO. 16-16-0081-148PS "
echo " BOGOTA, D.C., FEBRERO DE 2017 "
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo "  SCRIPT DE INSTALACION DE CONTENDORES DOCKER DE LA SOLUCION NUVEM CNCFLORA PORTAL "
echo "  OBJETIVO:  Permitir la instalacion del cluster dockerizado de aplicaciones de Nuvem CNCFLORA, que "
echo "  involucra los siguientes modulos: "
echo "  a)  Flora do brasil:  Fuente taxonomica autoritativa. Expone un IPT (Kit integrado de herramientas de publicacion) con sus datos."
echo "  b)  Floradata:  Consume el IPT de Flora do Brasil en una base de datos SQLite mas adecuada, y expone los nombres a traves "
echo "      de una API de webservices REST en la taxonomia."
echo "  c)  DWC-Services:  Biblioteca y API para manejar las operaciones principales en estandar Darwincore: Conversion entre formatos de archivo "
echo "      (xlsx, csv, dwc-a, json, geojson), validacion, solucion de problemas comunes y ejecucion de algunos analisis."
echo "  d)  Connect:  Componente de autenticacion unico (Single Sign On) para todas las aplicaciones."
echo "  e)  CouchDB:  Base de datos basada en REST y libre de esquema para manipulacion de documentos.  optima en procesos de persistencia, "
echo "      replicacion y reduccion del mapa de riesgos para el tratamiento de los datos.  Se utiliza como almacenamiento principal."
echo "  f)  ElasticSearch:  Servidor de indexacion y busqueda."
echo "  g)  Checklist:  Modulo que permitie el agrupamiento de las especies en una lista de control, la creacion de la base de datos "
echo "      en couchdb y el indice en elasticsearch."
echo "  h)  Occurrences:  Manipula los datos de ocurrencias. Permite cargar, insertar, georeferenciar, buscar por "
echo "      especies con sinonimos (de lista de verificacion), validacion y analisis."
echo "  i)  Profiles:  Perfil de la especie con datos ecologicos, con flujo de trabajo para la creacion, validacion y revision."
echo "  j)  Assessments:  Flujo de trabajo para la evaluacion de riesgos."
echo "  k)  Entrypoint:  Modulo unico de especificacion con enlaces para las diferentes aplicaciones en diferentes listas de verificacion."
echo "  l)  Services:  API de publicacion de Web Services RESTFull."
echo "  m)  Reports:  Generar archivos CSV (y un archivo SQLite) con los datos para su posterior publicacion en CKAN."
echo "  n)  CKAN:  Herramienta de publicacion de datos amigable para el usuario."
echo "  o)  Portal:  Portal Web Unificado con la capacidad de consulta basada en Web Services de la Lista Roja de Especies Amenazadas."
echo "  p)  Dockers:  Base contenedores de base, especialmente: Apache, Ruby, Java8, ElasticSearch, CouchDB, Kibana y Selenio."
echo "  q)  Docker Proxy:  Proxy NGINX dinamico para los contenedores del acoplador."
echo "  r)  Nuvem:  Proyecto utilizando docker-compose para ejecutar todas las aplicaciones."
echo "Hoy es el $DIA y la hora actual son las $HORA"
export HOST=192.168.50.200
export COMPOSE_HTTP_TIMEOUT=5000
sudo docker-compose up -d
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
echo "***********************************************************************************************************************************"
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************
#***********************************************************************************************************************************************

