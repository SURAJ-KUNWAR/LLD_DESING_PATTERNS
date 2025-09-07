package Structural;
//Target Interfaceexpected by client
interface RowingBoat{
    void row();
}


// existing incompatible class
class FishingBoat{
    public void sail(){
        System.out.println("The boat is sailing");
    }
}

// adapter class that makes FishingBoat compatible with Rowing Boat
class FishingBoatAdapter implements RowingBoat{
     private  FishingBoat boat;

     public FishingBoatAdapter(FishingBoat fishingBoat){
         this.boat = fishingBoat;
     }
    @Override
    public void row() {
          boat.sail(); // adpating  sail() to row()
    }
}

//Client that expects a rowing boat
class Captain{
    private RowingBoat rowingBoat;

    Captain(RowingBoat rowingBoat){
        this.rowingBoat = rowingBoat;
    }
    public void row(){
        rowingBoat.row();
    }
}


public class AdapterPattern {
    public static void main(String[] args) {
        Captain captain = new Captain(new FishingBoatAdapter(new FishingBoat()));
        captain.row();
    }
}
