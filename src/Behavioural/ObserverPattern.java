package Behavioural;

import java.util.ArrayList;
import java.util.List;

interface WeatherObserver{
    void update(int temperature);
}

//Publisher
class WeatherStation{
    List<WeatherObserver> observerList = new ArrayList<>();
    int temperature;
    public void subscribe(WeatherObserver observer){
        observerList.add(observer);
    }
    public void unsubscribe(WeatherObserver observer){
        observerList.remove(observer);
    }
    public void setTemperature(int temperature){
        this.temperature = temperature;
        notifyObservers();
    }
    public void notifyObservers(){
        for(WeatherObserver observer : observerList){
            observer.update(temperature);
        }
    }

}


//Subscribers
class CurrentTemperature implements WeatherObserver{

    @Override
    public void update(int temperature) {
        System.out.println("Current temperature: " + temperature);
    }
}

class WeatherStatics implements WeatherObserver{
    @Override
    public void update(int temperature) {
        System.out.println("Statistics changed due to change in " + temperature);
    }
}
class WeatherForecast implements WeatherObserver{
    @Override
    public void update(int temperature) {
        System.out.println("Weather forecast changed due to change in  " + temperature);
    }
}
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        // curr temp subscribed to weather station
        CurrentTemperature currentTemperature = new CurrentTemperature();
        weatherStation.subscribe(currentTemperature);

        //  weather forecast subscribed to weather station
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherStation.subscribe(weatherForecast);

        // weather statistics subscribed to weather station
        WeatherStatics weatherStatics = new WeatherStatics();
        weatherStation.subscribe(weatherStatics);

        weatherStation.setTemperature(25);
        weatherStation.setTemperature(35);
        weatherStation.setTemperature(45);
    }
}
