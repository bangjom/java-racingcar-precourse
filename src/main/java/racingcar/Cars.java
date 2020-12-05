package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = convertStringToCar(carNames);
    }

    public void moveByRandomNumber() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            car.moveIfRandomNumberIsBiggerThanLimit(randomNumber);
        }

    }

    public void showCarsCurrentPosition() {
        for (Car car : cars) {
            System.out.println(car + " : " + car.convertPositionToBar());
        }
        System.out.println();
    }

    public List<Car> findMaxPositionCars() {
        Car winningCar = cars.stream()
            .max(Car::compareTo)
            .get();

        return cars.stream()
            .filter(car -> winningCar.isSamePosition(car))
            .collect(Collectors.toList());
    }

    private List<Car> convertStringToCar(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }


}
