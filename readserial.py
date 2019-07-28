import serial
port = serial.Serial("/dev/tyUSB0", baudrate=9600,timeout=3.0)
while True:
	data = port.readline()