package SOLID;

import java.util.Arrays;
import java.util.List;

public class client {
    public static void main(String[] args) {

        //v0 bird
        Birdv0 bird = new Birdv0();
        bird.type = "eagle";
        bird.fly();

        //v1 Bird
        Birdv1 bird1 = new Parrot();
        bird1.fly();

        //v2 bird
        List<Birdv2> birds = Arrays.asList(new Eaglev2(),new Parrotv2(),new Penguinv2());
        for(Birdv2 bird2:birds){
            bird2.walk();
        }

        List<Flyable> flyingBirds = Arrays.asList(new Eaglev2(),new Parrotv2());
        for(Flyable bird2: flyingBirds){
            bird2.fly();
        }

        List<Swimmable> swimmingBirds = Arrays.asList(new Penguinv2());
        for(Swimmable bird2: swimmingBirds){
            bird2.swim();
        }

        //v3 bird
        List<Flyablev3> flyingBirdsv3 = Arrays.asList(new Eaglev3(new GlidingFlyingBehaviour("Eagle")));
        for(Flyablev3 bird3: flyingBirdsv3){
            bird3.fly();
        }
    }
}
