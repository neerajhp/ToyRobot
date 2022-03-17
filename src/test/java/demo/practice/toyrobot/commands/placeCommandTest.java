package demo.practice.toyrobot.commands;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import demo.practice.toyrobot.robot.DefaultRobot;
import demo.practice.toyrobot.model.Position;
import demo.practice.toyrobot.model.CardinalDirection;

class placeCommandTest {

    DefaultRobot robot;
    Command commandUnderTest;
    Position placedPosition = new Position(1, 3);
    CardinalDirection placedDirection = CardinalDirection.WEST;

    @BeforeAll
    void setup() {
        this.robot = new DefaultRobot();
        this.commandUnderTest = new PlaceCommand(Position position, CardinalDirection cardinalDirection);
    }

    @Test 
    void executePlaceCommand() {
        //act
        commandUnderTest.execute(robot);
        //assert
        assertAll(() -> assertEquals(placedPosition, robot.getPosition()), () -> assertEquals(placedDirection, robot.getCardinalDirection()));

    } 
    
}
