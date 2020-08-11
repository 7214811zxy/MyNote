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

// 职业abstract
abstract class Profession{
    String proName;
    Profession(String proName){
        this.proName = proName;
    }
    public abstract void getHorse();
    public abstract void useSkill();
}
// 职业 —— 法师
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
        else{
            this.iniSkill = "Arcane Missile!";
            return "Arcane";
        }

    }

}
// 职业 —— 战士
class Warrior extends Profession{

    private Object specialization;
    private String iniSkill;
    private static String horseName;

    static {
        horseName = "horse";
    }

    Warrior(String name, int typeNum){

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
            this.iniSkill = "Mortal Strike!";
            return "Arms";
        }
        else if( typeNum == 1){
            this.iniSkill = "Bloodthirsty!";
            return "Rage";
        }
        else{
            this.iniSkill = "Shield Rush!";
            return "Defense";
        }

    }

}

// 角色
class Player{

    Race race;
    Profession profession;
    private String name;
    private int raceCode, professionCode;
    Player( String name, int raceCode, int professionCode ){
        this.name = name;
        this.professionCode =  professionCode;
        this.raceCode = raceCode;
        this.race = this.creatRace();
        this.profession = this.creatProfession();
    }

    private Race creatRace(){
        if(this.raceCode == 0){
            return new RaceHuman();
        } else{
            return new RaceUndead();
        }
    }

    private Profession creatProfession(){
        if(this.raceCode == 0){
            return new Magic(this.name, this.professionCode);
        } else{
            return new Warrior(this.name, this.professionCode);
        }
    }

}


public class Modifier {
    public static void main(String[] args) {
        Player peter = new Player("peter", 0, 0);
        Player mike = new Player("mike", 1, 2);

        peter.profession.useSkill();
        peter.profession.getHorse();
        peter.race.useRaceSkill();

        mike.profession.useSkill();
        mike.profession.getHorse();
        mike.race.useRaceSkill();
    }
}
