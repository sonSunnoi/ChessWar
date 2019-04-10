package arena;

import chessman.Chessman;

import java.util.ArrayList;
import java.util.Arrays;

public class Field {

    private ArrayList<Chessman> chessmen;

    public Field(){
        chessmen = new ArrayList<Chessman>();
    }

    public Field(Chessman chessman){
        this();
        chessmen.add(chessman);
    }

    public Field(Chessman... manychessman){
        this();
        chessmen.addAll(Arrays.asList(manychessman));
    }

    public Field(Field field){
        this();
        field.getChessmen().stream().forEach((c) -> chessmen.add(c.copy()));
        //TODO: Mo check deep copy and is this lambda correct?
    }

    //not deep get
    public ArrayList<Chessman> getChessmen() {
        return chessmen;
    }

    public void setChessmen(ArrayList<Chessman> chessmen) {
        this.chessmen = chessmen;
    }
}
