package com.animalquiz.moondragon.animalquiz;

/**
 * Created by Elad on 24/04/2017.
 */

public class WildAnimal extends Animal {

    public WildAnimal (String imagePath, String soundPath) {
        super(imagePath, soundPath);
        _type = "Wild_Animal";
    }
}
