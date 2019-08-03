import serial
port=serial.Serial("/dev/ttyUSB0", baudrate=9600,timeout=1.0)
data=port.readline()
print(data)
