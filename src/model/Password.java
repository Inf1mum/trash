package model;
//2r4
//a1
//afd
import java.security.SecureRandom;

public class Password {


    private int hash;
    private int salt;


    public Password(){
        hash=0;
        salt=0;

    }
    public Password(int Hash,int Salt){
        this.hash=Hash;
        this.salt=Salt;
    }
    public Password(String Password){
        SecureRandom R=new SecureRandom();
        int salt=R.nextInt();

        String Salt=Integer.toString(salt);
        String pass=Password+Salt;
        this.hash=pass.hashCode();
        this.salt=salt;
    }
    public int getHash(){
        return this.hash;
    }
    public int getSalt() {
        return this.salt;
    }
    public void setPassword(int Hash,int Salt){
        this.hash=Hash;
        this.salt=Salt;
    }

    public boolean checkPassword(String Password){
        Password=Password+Integer.toString(this.salt);
        int passHash=Password.hashCode();
        if(passHash==this.hash)
            return true;
        else
            return false;

    }
}
