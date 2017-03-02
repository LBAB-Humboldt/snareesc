#***********************************************************************************
#***********************************************************************************
#***********************************************************************************
from flask.views import MethodView
from flask import Flask, render_template, request, flash
from base import BaseHandler
from collections import OrderedDict
#***********************************************************************************
#***********************************************************************************
import requests
import jinja2
import json
#***********************************************************************************
#***********************************************************************************
#***********************************************************************************
#***********************************************************************************
class RedlistHandler(MethodView, BaseHandler):
    #************************************************************
    #************************************************************
    #************************************************************
    def get(self, language, family):
    #************************************************************
    #************************************************************
        newlist = []
        #uriServicio = 'http://'+ self.services  +'/assessments/family/'+family
        uriServicio = '192.168.50.200/services'
        print "Uri de servicio 1 = " + uriServicio
        if family:
            #json_family = requests.get('http://'+ self.services  +'/assessments/family/'+family)
            json_family = requests.get('http://'+ uriServicio  +'/assessments/family/'+family)
            family_description = json.loads(json_family.text)
            newlist = sorted(family_description, key=lambda k: k['taxon']['scientificName'])
        else:
            family = {}
        uriServicio2 = '192.168.50.200/services'
        print "Uri de servicio 2 = " + uriServicio2
        json_data = requests.get('http://'+ uriServicio2 +'/assessments/families')
        #json_data = requests.get('http://'+ self.services +'/assessments/families')
        families = json.loads(json_data.text)
        return render_template(
                'redlist.html',
                language=language,
                base_url=self.base_url,
                static_url=self.static_url,
                families=sorted(families),
                family_description=newlist,
                family=family
                )
    #************************************************************
    #************************************************************
#***********************************************************************************
#***********************************************************************************
#***********************************************************************************
#***********************************************************************************
