public class DHT11SensorReader {

    private static final int DTHPIN = 1;
    
    public static native float[] readData(int pin);
    
    
    
    static {
        System.loadLibrary("dht11sensor");
    }

    public static void main(String[] args) {
        DHT11SensorReader sensor = new DHT11SensorReader();
        float[] readData = sensor.readData1();
        String msg = String.format("temp: %.1f, hum %.1f",readData[0], readData[1]);        
        System.out.println(msg);
    }
    
    public float[] readData1() {
        float[] data = DHT11SensorReader.readData(DTHPIN);
        int stopCounter = 0;
        while (!isValid(data)) {
            stopCounter++;
            if (stopCounter > 10) {
                throw new RuntimeException("Sensor return invalid data 10 times:" + data[0] + ", " + data[1]);
            }
            data = DHT11SensorReader.readData(DTHPIN);
        }
        return data;
    }
    
    private boolean isValid(float[] data) {
        return data[0] > 0 && data[0] < 100 && data[1] > 0 && data[1] < 100;
    }
}
