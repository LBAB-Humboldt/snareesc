#************************************************
#************************************************
#************************************************
#************************************************
import jinja2
import json
import requests
import urllib
import ConfigParser
import random
import netifaces as ni
#************************************************
#************************************************
#************************************************
#************************************************
from flask.views import MethodView
from flask import Flask, render_template, request, flash
from base import BaseHandler
#from pif import get_public_ip
#************************************************
#************************************************
#************************************************
#************************************************
class HomeHandler(MethodView, BaseHandler):
    #*******************************************************************
    #*******************************************************************
    #*******************************************************************
    def get(self):
    	#************************************************************
    	#************************************************************
    	#************************************************************
    	#************************************************************
    	#************************************************************
        #config = ConfigParser.RawConfigParser();
        #config.read('ConfigFile.properties');
        #nombrebase = config.get('DatabaseSection', 'database.dbname');
        #nombrebase = int(random.random() * 100000);
        #print nombrebase;
    	#************************************************************
    	#************************************************************
    	#************************************************************
        #direccionServidor = socket.gethostbyname(socket.gethostname())
        ni.ifaddresses('eth1')
        direccionServidor = ni.ifaddresses('eth1')[2][0]['addr']   
        uriServicio = 'http://' + direccionServidor + ':75/html/ServiciosHumboldt/ServicioIndicadores.php'
        resp = requests.get(uriServicio)
        if resp.status_code != 200:
           raise ApiError('GET /tasks/ {}'.format(resp.status_code))
		
        datos = json.loads(resp.text)
        especies = datos['especies'] 
        clasificadas = datos['clasificadas'] 
        amenazadas = datos['amenazadas'] 
        accion = datos['accion']
    	#************************************************************
    	#************************************************************
    	#************************************************************
        return  render_template('home.html',base_url=self.base_url,static_url= self.static_url,
        especies=especies,
        clasificadas=clasificadas,
        amenazadas=amenazadas,
        accion=accion,
        direccionServidor=direccionServidor)
    #*******************************************************************
    #*******************************************************************
    #*******************************************************************
#************************************************
#************************************************
#************************************************
#************************************************
