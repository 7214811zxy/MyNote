// 种族abstract
abstract class Race{

    String raceName;
    // 种族的名字
    Race(String raceName){
        this.raceName = raceName;
    }
    // 种族技能
    abstract void useRaceSkill();
}

// 种族 —— 亡灵
class RaceUndead extends Race{

    static String skill;
    static String raceName;

    static {
        skill = "Undead Determination";
        raceName = "Undead";
    }

    RaceUndead(){
        super(raceName);
    }

    @Override
    void useRaceSkill() {
        System.out.println( raceName + "use race skill " + skill );
    }
}
// 种族 —— 人类
class RaceHuman extends Race{

    static String skill;
    static String raceName;

    static {
        skill = "Human Self-Interested";
        raceName = "Human";
    }

    RaceHuman(){
        super(raceName);
    }

    @Override
    void useRaceSkill() {
        System.out.println( raceName + " use race skill " + skill );
    }
}

// 角色
class Player{

    Race race;
    Profession profession;
    String name;
    Player( String name, int raceCode, int professionCode ){
        this.name = name;
        this.race = this.creatRace( raceCode );
    }

    private Race creatRace( int raceCode ){
        if(raceCode == 0){
            return new RaceHuman();
        } else{
            return new RaceUndead();
        }

    }

}

// 种族
class Undead{
    String name;
    int typeNum;
    Profession profession;
    static String skill;

    static {
        skill = "determination";
        System.out.println("Undead has init");
    }

    Undead( String name, int typeNum ){
        this.name = name;
        this.typeNum = typeNum;
        this.profession = new Magic(this.name, this.typeNum);
    }

    public void death(){
        System.out.println("Undead dead!");
    }

}

// 职业abstract
abstract class Profession{
    String proName;
    Profession(String proName){
        this.proName = proName;
    }
    public abstract void getHorse();
    public abstract void useSkill();
}

//
class Magic extends Profession{

    Object specialization;
    String iniSkill;
    static String horseName;

    static {
        horseName = "ufo";
    }

    Magic(String name, int typeNum){

        super( name );
        this.specialization = this.iniSpecialization( typeNum );
    }

    // abstract getHorse实现
    public void getHorse(){
        System.out.println(super.proName + " ride horse " + horseName );
    }

    // abstract useSkill实现
    public void useSkill(){
        System.out.println(super.proName + " use skill " + iniSkill);
    }

    // 初始化专精
    private Object iniSpecialization( int typeNum ){

        if( typeNum == 0 ){
            this.iniSkill = "Ice Arrow!";
            return "Ice";
        }
        else if( typeNum == 1){
            this.iniSkill = "Fire Ball!";
            return "Fire";
        }
        else if( typeNum == 2){
            this.iniSkill = "Arcane Missile!";
            return "Arcane";
        }else{
            return 666;
        }

    }

}

public class Modifier {
    public static void main(String[] args) {
        Undead peter = new Undead("peter", 0);
        peter.profession.getHorse();
        peter.profession.useSkill();

        Undead mike = new Undead("mike", 1);
        mike.profession.getHorse();
        mike.profession.useSkill();
    }
}
