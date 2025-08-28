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
        healpotion Heal = new healpotion(100);

        System.out.print("Weapon You can choose : ");
        System.out.println(" ");
        System.out.println("1. Sword");
        System.out.println("2. Axe");
        System.out.println("3. Knife");
        System.out.print("Choose Your Weapon : ");
        System.out.println(" ");

        String playerWeapon = kbd.nextLine();
        P.equipWeapon(playerWeapon);

        System.out.print("Armor You can Armor : ");
        System.out.println(" ");
        System.out.println("1. Low");
        System.out.println("2. Mid");
        System.out.println("3. High");
        System.out.print("Choose Your Armor : ");
        System.out.println(" ");
        String playerArmor = kbd.nextLine();
        P.equipArmor(playerArmor);
        System.out.println("=====================================");
        P.ShowDetails();

        Monster M = new Monster();
        M.ShowDetails();
        System.out.println("=========== BATTLE START ============");
        System.out.println("Player Speed: " + P.getSPD() + " | Monster Speed: " + M.getSPD());

        Flight(P, M, kbd , Heal);
        kbd.close();



    }
    public static void Flight (Player P,Monster M,Scanner input , healpotion Heal){
        
        while (P.getHP() > 0 && M.getHP() > 0){

            System.out.println("========== Your turn ================");
            System.out.println("What will you do ?");
            System.out.println("1. Attack");
            System.out.println("2. Block");
            System.out.println("3. Potion (You Potion Current is : " + P.gethealpotioncount() + " ) ");
            System.out.println("=====================================");
            System.out.println("Enter your choice (Choose the number): ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=====================================");
                    System.out.println(P.getNAME() + " is Attacking!");
                    P.Attack(P, M);
                    break;
                case 2:
                    P.block(P,M);
                    break;
                case 3:
                if (P.gethealpotioncount() > 0) {
                    Heal.use(P);
                    P.sethealpotioncount((P.gethealpotioncount() - 1));
                } else {
                    System.out.println("You don't have any potions left!");
                }
                break;
                default:
                    System.out.println("Invalid choice. You lose your turn.");
                    return;
            }
            if (M.getHP() <= 0) {
                break;
            }
            M.Attack(P, M);
            
            if (P.getHP() <= 0) {
                break;
            }

            System.out.println("Current HP: " + P.getNAME() + " (" + P.getHP() + " HP) vs " + M.getNAME() + " (" + M.getHP() + " HP)");
        }
        System.out.println("=========== BATTLE END ==============");
        
        if (P.getHP() <= 0) {
            System.out.println(P.getNAME() + " has been defeated! " + M.getNAME() + " wins!");
        } 
        else{
            System.out.println(P.getNAME() + " is victorious!");
            System.out.println("=====================================");

        }
    }





}
abstract class Character{

    private String  NAME;
    private int HP = 100;
    private int DEF = 50;
    private int ATK = 160;
    private int SPD = 20;
    
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

    public void ShowDetails(){
        System.out.println("Name : " + this.NAME);
        System.out.println("HP : " + this.HP);
        System.out.println("DEF : " + this.DEF);
        System.out.println("ATK : " + this.ATK);
        System.out.println("SPD : " + this.SPD);    
    }

}

class Player extends Character implements characterFunction{

    private Weapon Weapon;
    private Armor Armor;
    private boolean isBlocking = false;
    private int healpotioncount = 3 ;
    private int originalDef;

    public Player(Weapon Weapon, Armor Armor ,int originalDef) {
        super();
        this.Weapon = Weapon;
        this.Armor = Armor;
        this.originalDef = originalDef;

    }

    public Player() {
    }
    


    public int getHP() { return super.getHP();}
    public int getDEF() { return super.getDEF();}
    public int getATK() { return super.getATK();}
    public int getSPD() { return super.getSPD();}
    public String getName() {return super.getNAME();}

    public String getWeapon(){
        return this.Weapon.getName(); 
    }
    public String getArmor(){
        return this.Armor.getName(); 
    }
    public boolean getIsBlocking() {
        return this.isBlocking;
    }
    public int gethealpotioncount(){
        return this.healpotioncount;
    }
    public int getoriginalDef(){
        return this.originalDef;
    }
    
    private void setArmor(String name , int DEF){
        Armor na = new Armor(name , DEF);
        this.Armor = na;
        super.setDEF(getDEF() + na.getDEF());
    } 

    private void setWeapon(String name , int Atk ,int spd){
        Weapon nw = new Weapon(name , Atk , spd);
        this.Weapon = nw;
        super.setATK(getATK() + nw.getATK());
        super.setSPD(getSPD() + nw.getSpeed());
    } 
        
    
    public void equipWeapon(String Choose_Weapon){
         
        if (Choose_Weapon.equalsIgnoreCase("Sword") || Choose_Weapon.equalsIgnoreCase("1")) {
            setWeapon("Sword", 100, 50);
        } 
        else if (Choose_Weapon.equalsIgnoreCase("Axe") || Choose_Weapon.equalsIgnoreCase("2")) {
            setWeapon("Axe", 150, 25);
        }
        else if (Choose_Weapon.equalsIgnoreCase("Dagger") || Choose_Weapon.equalsIgnoreCase("3")) {
            setWeapon("Dagger", 50, 75);
        }
        else{
            System.out.println("=====================================");
            System.out.println("We don't have that weapon ");
            System.out.println("Please try again");
            System.out.println("=====================================");
            System.exit(1);
        }
        
    }

    public void equipArmor (String Choose_Armor){
        if (Choose_Armor.equalsIgnoreCase("Low") || Choose_Armor.equalsIgnoreCase("1")) {
            this.setArmor("Low", 50);
        }

        else if (Choose_Armor.equalsIgnoreCase("Mid") || Choose_Armor.equalsIgnoreCase("2")) {
            this.setArmor("Mid", 100);
        }

        else if (Choose_Armor.equalsIgnoreCase("High") || Choose_Armor.equalsIgnoreCase("3")) {
            this.setArmor("High", 150);
        }
        else{
            System.out.println("=====================================");
            System.out.println("We don't have that Armor ");
            System.out.println("Please try again");
            System.out.println("=====================================");
            System.exit(1);
            
        }
    }
    
    public void setIsBlocking(boolean isBlocking) {
        this.isBlocking = isBlocking;
    }
    public void sethealpotioncount(int healpotion){
        this.healpotioncount = healpotion;
    }


    @Override
    public void ShowDetails(){
        System.out.println("========== PLAYER INFORMATION =======");
        super.ShowDetails();
        System.out.println("Weapon : " + getWeapon());
        System.out.println("Armor : " +getArmor());
        System.out.println("=====================================");


    }
    @Override
    public void Attack(Player P , Monster M){
        
        int playerDamage = P.getATK() - M.getDEF();
        if(playerDamage < 0) playerDamage = 0;

        M.setHP(M.getHP() - playerDamage);
        System.out.println(P.getNAME() + " attacks " + M.getNAME() + " " + playerDamage + " Damage" + P.getDEF());
        super.ShowDetails();


        
    }
    public void block(Player P , Monster M){

        P.setIsBlocking(true);

        System.out.println("=====================================");                
        System.out.println(P.getNAME() + " is blocking!");
        
        this.originalDef = P.getDEF(); 

        double playerincreasedef = P.getDEF() * 0.5;
        P.setDEF((int)(P.getDEF() + playerincreasedef));
        System.out.println(P.getNAME() + " block " + M.getNAME() + " DEF UP " + playerincreasedef + " (DEF NOW " + P.getDEF() + ")");
        super.ShowDetails();
        P.setDEF(P.originalDef);

        
    }
}

class Weapon{

    private String name;
    private int ATK;
    private int speed;

    Weapon(String name , int atk , int speed){
        this.name = name;
        this.ATK = atk;
        this.speed = speed;
    }
    public int getATK(){return this.ATK;}
    public int getSpeed(){return this.speed;}
    public String getName(){return this.name;}
}

class Armor{

    private String name; 
    private int DEF;

    Armor(String name , int def){
        this.name = name ;
        this.DEF = def;
    }
    public int getDEF(){return this.DEF;}
    public String getName(){return this.name;}
}


abstract class Potion {

    private String name;

    public Potion(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void use(Player player);

}

class healpotion extends Potion{

    private int heal;

    public healpotion(int heal) {
        super("Heal Potion");
        this.heal = heal;
    }

    public int setheal(){
        return this.heal;
    }

    @Override
    public void use(Player player){
        player.setHP(player.getHP()+this.heal);

    }
}



class Monster extends Character implements characterFunction{
    
    public Monster() {
        super.setName("Slime");
        super.setHP(1000);
    }

    public int getHP() { return super.getHP();}
    public int getDEF() { return super.getDEF();}
    public int getATK() { return super.getATK();}
    public int getSPD() { return super.getSPD();}
    public String getName() {return super.getNAME();}

    @Override
    public void ShowDetails(){

        System.out.println("========= MONSTER INFORMATION =======");
          super.ShowDetails();
        System.out.println("=====================================");

    }
    @Override
    public void Attack(Player P , Monster M){
            
            int monsterDamage = M.getATK() - P.getDEF();
            
            if (P.getIsBlocking()) { 
            monsterDamage -= P.getDEF() * 0.5; 
            P.setIsBlocking(false);
            }
            
            if(monsterDamage < 0) monsterDamage = 0;
            

            P.setHP(P.getHP() - monsterDamage);
            System.out.println(M.getNAME() + " attacks " + P.getNAME() + " " + monsterDamage + " Damage");
            System.out.println("=====================================");

        }
        
    }


interface characterFunction {
    void Attack(Player player , Monster M);
    void ShowDetails();

}