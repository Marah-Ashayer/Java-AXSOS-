import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
class PuzzleJava{
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> randomRolls = new ArrayList<Integer>();
        Random rd = new Random();
        for (int i = 0; i <= 11 ; i++) {
            randomRolls.add(rd.nextInt(21));
    }
    return (randomRolls);
}
    public char getRandomLetter(){
        int max= 25 ;
        int min= 0 ;
        char[] arrAlphabet={'a','b','c','d','e','f','g','h','i','g','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int ra = (int) (Math.random()*(max-min+1)+min);
        char ranLet= arrAlphabet[ra];
        return (ranLet);
    }
    public String generatePassword(){
        String ranStr="";
        for(int i=0 ; i<8; i++){
            ranStr += this.getRandomLetter();
        }
        return (ranStr);
    }
    
    public ArrayList<String> getNewPasswordSet(int n){
        ArrayList<String> randomArrOfString = new ArrayList<String>();
        for( int j=0; j<n ; j++){
            randomArrOfString.add(this.generatePassword());
        }
        return (randomArrOfString);


    }
}
