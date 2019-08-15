#! /usr/bin/python
 
from gps import *
import time
    
gpsd = gps(mode=WATCH_ENABLE|WATCH_NEWSTYLE) 
#print 'latitude,longitude,time utc,altitude,epv,ept,speed,climb' # '\t' = TAB to try and output the data in columns.
   
try:
 
 
#    while True:
        report = gpsd.next() #
        if report['class'] == 'TPV':
             
            print  getattr(report,'lat',0.0),",",
            print  getattr(report,'lon',0.0),",",
            print  getattr(report,'time',''),",",
            print  getattr(report,'alt','nan'),",",
            print  getattr(report,'epv','nan'),",",
            print  getattr(report,'ept','nan'),",",
            print  getattr(report,'speed','nan'),",",
            print  getattr(report,'climb','nan'),","
 
#        time.sleep(1) 
 
except (KeyboardInterrupt, SystemExit): #when you press ctrl+c
    print "Done.\nExiting."