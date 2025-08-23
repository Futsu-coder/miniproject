public class miniproject {
    public static void main(String[] args) {

    Player P = new Player();
    P.ShowDetails();
    Monster1 M1 = new Monster1();
    M1.ShowDetails();



    }
}
abstract class Character{

    protected String NAME;
    protected int HP ;
    protected int ARMOR;
    protected int ATK;
    protected int SPD;
    
    public String getNAME (){
        return this.NAME;
    }
    public int getHP(){
        return this.HP;
    }
    public int getARMOR(){
        return this.ARMOR;
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
    public void setArmor(int Amr){
        this.ARMOR = Amr;
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
        this.ARMOR = 50;
        this.ATK = 30;
        this.SPD = 20;

    }

   // public void EquipWeapon(String name , int atk , int speed){
   //     Weapon w1 = new Weapon(name , atk , speed);
     //   this.Weapon = w1;
     //   int ina = this.weapon.getATK();
     //   String n = this.weapon.getName();
    //    super.setATK(super.getATK() + ina);
     //   System.out.println("Equip : " + n);
   // }

    public void ShowDetails(){
        System.out.println("=====================================");
        System.out.println("Name : " + this.NAME);
        System.out.println("HP : " + this.HP);
        System.out.println("ARMOR : " + this.ARMOR);
        System.out.println("ATK : " + this.ATK);
        System.out.println("Weapon : " + this.Weapon);
        System.out.println("Armor : " + this.Armor);
        System.out.println("=====================================");


    }


    
}
class Monster1 extends Character{

    private boolean ExtraSkill;

    
    public Monster1() {
        super.setName("Slime");
        this.HP = 100;
        this.ARMOR = 50;
        this.ATK = 30;
        this.SPD = 20;

    }

    public void ShowDetails(){
        System.out.println("=====================================");
        System.out.println("Name : " + this.NAME);
        System.out.println("HP : " + this.HP);
        System.out.println("ARMOR : " + this.ARMOR);
        System.out.println("ATK : " + this.ATK);
        System.out.println("=====================================");


    }
    
}

