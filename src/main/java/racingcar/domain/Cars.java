package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public Cars(List<String> carNameList) {
        carNameList.forEach(carName -> carList.add(new Car(carName)));
    }

    public void processOneTurn() {
        carList.forEach(car -> car.oneTurn(RandomNumberGenerator.turnNumber()));
    }

    public List<Car> getList() {
        return this.carList;
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition(this.carList);
        List<String> winnerList = new ArrayList<>();
        carList.stream()
            .filter(carElement -> (carElement.isSamePosition(maxPosition)))
            .map(Car::getName)
            .forEach(winnerList::add);
        return winnerList;
    }

    private int findMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}