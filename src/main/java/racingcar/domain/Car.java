package racingcar.domain;

public class Car {

    private final String name;
    private Position position;

    private static final int GO_CRITERIA = 4;

    public Car(String name) {
        this.name = name;
        position = new Position();
    }

    public void oneTurn(int randomTurnNumber) {
        if (randomTurnNumber >= GO_CRITERIA) {
            progressPosition();
        }
    }

    private void progressPosition() {
        this.position.progressOneTime();
    }

    public boolean isSamePosition(int targetPosition) {
        return this.position.isSameValue(targetPosition);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position.getValue();
    }
}