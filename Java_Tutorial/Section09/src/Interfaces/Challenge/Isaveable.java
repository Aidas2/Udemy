package Interfaces.Challenge;

import java.util.ArrayList;
import java.util.List;

public interface Isaveable {
    List<String> write(); //this is method to "SAVE" player/monster state
    void read(List<String> savedValues); //this method to "LOAD" player/monster state;
}
