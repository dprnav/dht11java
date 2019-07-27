# dht11java
Steps To Run Code
1) Change Gpio Pin in "DHT11SensorReader.java". (Default is 1).\
2) javac DHT11SensorReader.java
3) javah -jni DHT11SensorReader
4) gcc -shared -Wall -Werror -I/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/include/ -I/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/include/linux -o libdht11sensor.so -fPIC dht11sensor.c -l wiringPi
5) java DHT11SensorReader
