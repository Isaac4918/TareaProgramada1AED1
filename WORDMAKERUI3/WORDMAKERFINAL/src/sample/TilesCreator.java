package sample;

public class TilesCreator {
    private String [] letters={"A","B","C","D","E"};
    private int tilevalue;
    public String generatetiles() {
        int pos=random();
        String tileletter=letters[pos];

        return tileletter;
    }

    public int settilevalue(String tileletter){
        if(tileletter.equals("A") || tileletter.equals("B")|| tileletter.equals("C") ){
            tilevalue=1;
        }
        else {
            tilevalue=0;
        }

        return tilevalue;


    }


    private int random(){
        return (int) (Math.random()*letters.length);
        }
}
