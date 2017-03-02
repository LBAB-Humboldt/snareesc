#!/usr/bin/python    
import ConfigParser
config = ConfigParser.RawConfigParser()
config.read('ConfigFile.properties')

nombrebase = config.get('DatabaseSection', 'database.dbname');
print nombrebase;
print config.get('DatabaseSection', 'database.user');
print config.get('DatabaseSection', 'database.password');
