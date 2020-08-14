/**
 * 修饰符、抽象类综合练习
 * 类功能：
 * 对游戏的逻辑进行了一些简单模拟，实现了如下功能
 *
 *      创建一个名字为peter的人类冰系法师并使用种族技能冰箭，召唤职业坐骑
 *      Player peter = new Player("peter", 0, 0);
 *      peter.profession.getHorse();
 *
 *      创建一个名字为mike的亡灵火系法师并使用职业技能火球，使用种族技能
 *      Player mike = new Player("mike", 0, 1);
 *      mike.profession.useSkill();
 *      mike.race.useRaceSkill()
 *
 * */

// Race abstract
abstract class Race{

    String raceName;
    // 种族的名字
    Race(String raceName){
        this.raceName = raceName;
    }
    // 种族技能
    abstract void useRaceSkill();
}
// Race —— undead
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
// Race —— human
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

// Pro abstract
abstract class Profession{
    String proName;
    Profession(String proName){
        this.proName = proName;
    }
    public abstract void getHorse();
    public abstract void useSkill();
}
// pro —— magic
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
// pro —— warrior
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

// play
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

        // 创建一个名字为peter的人类冰霜系法师
        Player peter = new Player("peter", 0, 0);

        // 创建一个名字为mike的亡灵防御系战士
        Player mike = new Player("mike", 1, 2);

        // peter法师使用了一堆冰法的技能
        peter.profession.useSkill();
        peter.profession.getHorse();
        peter.race.useRaceSkill();

        // mike使用了一堆防战的技能
        mike.profession.useSkill();
        mike.profession.getHorse();
        mike.race.useRaceSkill();
    }
}
