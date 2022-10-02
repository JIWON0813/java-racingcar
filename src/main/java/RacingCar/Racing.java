package RacingCar;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {
    private int round;
    private List<Car> carList;

    public Racing(String carInput, int round) {
        initCarList(carInput);
        this.round = round;
    }

    private void initCarList(String carInput) {
        carList = new ArrayList<>();

        String[] carArray = carInput.split(",");

        init(carArray);
    }

    private void init(String[] carArray) {
        for (String carName : carArray) {
            Validate.carNameCheck(carName);

            carList.add(new Car(carName));
        }
    }

    public void round(List<Integer> randomList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            int randomNumber = randomList.get(i);

            car.move(randomNumber);
        }
    }

    public List<Car> winner() {
        int max = carList.stream().max(Comparator.comparing(Car::getPosition)).get().getPosition();

        return carList.stream().filter(x -> x.getPosition() == max).collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getRound() {
        return round;
    }
}
