import java.util.Scanner;


public class miniproject {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.print("Enter Player Name: ");
        System.out.println(" ");

        String playerName = kbd.nextLine();

        Player P = new Player();
        P.setName(playerName);

        System.out.print("Weapon You can choose : ");
        System.out.println(" ");
        System.out.println("1. Knife");
        System.out.println("2. Sword");
        System.out.println("3. Axe");
        System.out.print("Choose Your Weapon : ");
        System.out.println(" ");



        String playerWeapon = kbd.nextLine();
        P.setWeapon2(playerWeapon);

        System.out.print("Armor You can Armor : ");
        System.out.println(" ");
        System.out.println("1. Low");
        System.out.println("2. Mid");
        System.out.println("3. High");
        System.out.print("Choose Your Armor : ");
        System.out.println(" ");
        String playerArmor = kbd.nextLine();
        P.setArmor2(playerArmor);
        System.out.println("=====================================");

        kbd.close();
        P.ShowDetails();
    Monster1 M1 = new Monster1();
    M1.ShowDetails();



    }
}
abstract class Character{

    protected String NAME;
    protected int HP ;
    protected int DEF;
    protected int ATK;
    protected int SPD;
    
    public String getNAME (){
        return this.NAME;
    }
    public int getHP(){
        return this.HP;
    }
    public int getDEF(){
        return this.DEF;
    }
    public int getATK(){
        return this.ATK;
    }
    public int getSPD(){
        return this.SPD;
    }


    public void setName(String name){
        this.NAME = name;
    }
    public void setHP(int HP){
        this.HP = HP;
    }
    public void setDEF(int DEF){
        this.DEF = DEF;
    }
    public void setATK(int Atk){
        this.ATK = Atk;
    }
    public void setSPD(int Spd){
        this.SPD = Spd;
    }
}

class Player extends Character{

    protected String Weapon;
    protected String Armor;
    

    public Player() {
        super.setName("John");
        this.HP = 100;
        this.DEF = 50;
        this.ATK = 30;
        this.SPD = 20;
                

        
    }
    
    public String getWeapon(){
        return this.Weapon;
    }

    public void setWeapon(String Weapon){
        this.Weapon = Weapon;
    }
    
    public String getArmor(){
        return this.Armor;
    }

    public void setArmor(String Armor){
        this.Armor = Armor;
    }

    
    public void setWeapon2(String Choose_Weapon){
        
        this.Weapon = Choose_Weapon; 

        if (Weapon.equalsIgnoreCase("Sword")) {
            this.Weapon = Weapon;
            this.ATK += 100;
        } 
        else if (Weapon.equalsIgnoreCase("Axe")) {
            this.Weapon = Weapon;

            this.ATK += 150;
        }
        else if (Weapon.equalsIgnoreCase("Knife")) {
            this.Weapon = Weapon;

            this.ATK += 50;
            
        }
        else{
            System.out.println("=====================================");
            System.out.println("We don't have that weapon ");
            System.out.println("Please try again");
            System.out.println("=====================================");
            System.exit(1);
        }
        
    }

    public void  setArmor2 (String Choose_Armor){
        
        this.Armor = Choose_Armor;
        
        if (Armor.equalsIgnoreCase("Mid")) {
            this.Armor = Armor;

            this.DEF += 100;
        } 
        else if (Armor.equalsIgnoreCase("High")) {
            this.Armor = Armor;

            this.DEF += 150;
        }
        else if (Armor.equalsIgnoreCase("Low")) {
            this.Armor = Armor;

            this.DEF += 50;
        }
        else{
            System.out.println("=====================================");
            System.out.println("We don't have that Armor ");
            System.out.println("Please try again");
            System.out.println("=====================================");
            System.exit(1);
            
        }
    }

    public void ShowDetails(){
        System.out.println("=====================================");
        System.out.println("Name : " + this.NAME);
        System.out.println("HP : " + this.HP);
        System.out.println("DEF : " + this.DEF);
        System.out.println("ATK : " + this.ATK);
        System.out.println("Weapon : " + this.Weapon);
        System.out.println("Armor : " +this.Armor);
        System.out.println("=====================================");


    }
}
class Monster1 extends Character{

    private boolean ExtraSkill;

    
    public Monster1() {
        super.setName("Slime");
        this.HP = 100;
        this.DEF = 50;
        this.ATK = 30;
        this.SPD = 20;

    }

    public void ShowDetails(){
        System.out.println("=====================================");
        System.out.println("Name : " + this.NAME);
        System.out.println("HP : " + this.HP);
        System.out.println("DEF : " + this.DEF);
        System.out.println("ATK : " + this.ATK);
        System.out.println("=====================================");


    }
    
}

