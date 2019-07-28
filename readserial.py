import serial
port = serial.Serial("/dev/ttyUSB0", baudrate=9600,timeout=3.0)
while True:
	data = port.readline()
	print (data)