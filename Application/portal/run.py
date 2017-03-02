# -*- coding: utf-8 -*-

from flask import Flask, render_template, request, flash
import jinja2
import json
import logging
import requests
import urllib2
from flask_marrowmailer import Mailer
from handlers.home import HomeHandler
from handlers.redlist import RedlistHandler
from handlers.document import DocumentHandler
from handlers.profile import ProfileHandler
from handlers.project import ProjectHandler
from handlers.equipe import EquipeHandler
from handlers.book import BookHandler

import sys;
reload(sys);
sys.setdefaultencoding("utf8")

application = app = Flask(__name__)
file_handler = logging.FileHandler('app.log')
app.logger.addHandler(file_handler)
app.logger.setLevel(logging.DEBUG)
app.secret_key = 'some_secret'
app.config['MARROWMAILER_CONFIG'] = {
    'manager.use': 'futures',
    'transport.use': 'smtp',
    'transport.host': 'mtp.gmail.com',
    'transport.port': 465,
    'transport.tls': 'ssl',
    'transport.username': 'sistema@cncflora.net',
    'transport.password': 'sistema@cncflora',
}
app.url_map.strict_slashes = False
mailer = Mailer(app)

app.add_url_rule('/', view_func=HomeHandler.as_view('home'))
app.add_url_rule('/<language>/listavermelha',defaults={'family': None},
  view_func=RedlistHandler.as_view('redlist'))
app.add_url_rule('/<language>/listavermelha/<family>',
  view_func=RedlistHandler.as_view('redlistfamily'))
app.add_url_rule('/<language>/publicacoes',
  view_func=DocumentHandler.as_view('documents'))
app.add_url_rule('/<language>/profile/<name>',
  view_func=ProfileHandler.as_view('profile'))
app.add_url_rule('/<language>/projetos', defaults={'project': None},
  view_func=ProjectHandler.as_view('projects'))
app.add_url_rule('/<language>/projetos/<project>',
  view_func=ProjectHandler.as_view('project'))
app.add_url_rule('/<language>/equipe',
  view_func=EquipeHandler.as_view('equipe'))
app.add_url_rule('/<language>/livros',
  view_func=BookHandler.as_view('livros'))

if __name__ == "__main__":
    app.run(port=85, host='192.168.50.200', debug=True)
