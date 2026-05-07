package AutoBattler.entitiesTest;

import AutoBattler.entities.*;
import AutoBattler.teams.*;
import org.junit.*;

public class FighterTest {
    private Fighter p;
    private Fighter w;
    private Fighter t;
    private Fighter b;
    private Fighter a;
    private Fighter m;
    private Team team;
    private Team team2;


    @Before
    public void setup(){
        p = new Paladin();
        w = new Warrior();
        t = new Thief();
        b = new Berserker();
        a = new Archer();
        m = new Mage();
        team = new Team();
        team2 = new Team();
    }

    @After
    public void teardown() {

    }

    @Test
    public void FighterGetIdTest(){
        Assert.assertTrue(p.getId() > 0);
    }

    @Test
    public void FighterGetHpTest(){
        Assert.assertEquals(200,p.getHp());
        Assert.assertEquals(200,p.getBaseHp());
    }

    @Test
    public void FighterGetAttackTest(){
        Assert.assertEquals(45,p.getAttack());
        Assert.assertEquals(45,p.getBaseAttack());
    }

    @Test
    public void FighterGetDefenseTest(){
        Assert.assertEquals(25,p.getDefense());
        Assert.assertEquals(25,p.getBaseDefense());
    }

    @Test
    public void FighterGetSpeedTest(){
        Assert.assertEquals(10,p.getSpeed());
        Assert.assertEquals(10,p.getBaseSpeed());
    }

    @Test
    public void FighterGetTypeTest(){
        Assert.assertEquals("Paladin",p.getType());
    }

    @Test
    public void FighterGetNameTest(){
        Assert.assertEquals("Paladin",p.getName());
    }

    @Test
    public void FighterGetTeamTest(){
        p.joinTeam(team);
        Assert.assertEquals(team, p.getTeam());
    }

    @Test
    public void FighterUpdateHpMoreThanBaseHpTest(){
        p.updateHp(1000);
        Assert.assertEquals(200, p.getHp());
    }

    @Test
    public void FighterUpdateHpLessThanBaseHpTest(){
        p.updateHp(50);
        Assert.assertEquals(50, p.getHp());
    }

    @Test
    public void FighterUpdateBaseHpMoreThanHpTest(){
        p.updateBaseHp(1000);
        Assert.assertEquals(1000,p.getBaseHp());
        Assert.assertEquals(200,p.getHp());
    }

    @Test
    public void FighterUpdateBaseHpLessThanHpTest(){
        p.updateBaseHp(50);
        Assert.assertEquals(50,p.getBaseHp());
        Assert.assertEquals(50,p.getHp());
    }

    @Test
    public void FighterUpdateAttackMoreThanBaseAttackTest(){
        p.updateAttack(1000);
        Assert.assertEquals(45, p.getAttack());
    }

    @Test
    public void FighterUpdateAttackLessThanBaseAttackTest(){
        p.updateAttack(10);
        Assert.assertEquals(10, p.getAttack());
    }

    @Test
    public void FighterUpdateBaseAttackMoreThanAttackTest(){
        p.updateBaseAttack(1000);
        Assert.assertEquals(1000,p.getBaseAttack());
        Assert.assertEquals(45,p.getAttack());
    }

    @Test
    public void FighterUpdateBaseAttackLessThanAttackTest(){
        p.updateBaseAttack(10);
        Assert.assertEquals(10,p.getBaseAttack());
        Assert.assertEquals(10,p.getAttack());
    }

    @Test
    public void FighterUpdateDefenseMoreThanBaseDefenseTest(){
        p.updateDefense(1000);
        Assert.assertEquals(25, p.getDefense());
    }

    @Test
    public void FighterUpdateDefenseLessThanBaseDefenseTest(){
        p.updateDefense(10);
        Assert.assertEquals(10, p.getDefense());
    }

    @Test
    public void FighterUpdateBaseDefenseMoreThanDefenseTest(){
        p.updateBaseDefense(1000);
        Assert.assertEquals(1000,p.getBaseDefense());
        Assert.assertEquals(25,p.getDefense());
    }

    @Test
    public void FighterUpdateBaseDefenseLessThanDefenseTest(){
        p.updateBaseDefense(10);
        Assert.assertEquals(10,p.getBaseDefense());
        Assert.assertEquals(10,p.getDefense());
    }

    @Test
    public void FighterUpdateSpeedMoreThanBaseSpeedTest(){
        p.updateSpeed(1000);
        Assert.assertEquals(10, p.getSpeed());
    }

    @Test
    public void FighterUpdateSpeedLessThanBaseSpeedTest(){
        p.updateSpeed(5);
        Assert.assertEquals(5, p.getSpeed());
    }

    @Test
    public void FighterUpdateBaseSpeedMoreThanSpeedTest(){
        p.updateBaseSpeed(1000);
        Assert.assertEquals(1000,p.getBaseSpeed());
        Assert.assertEquals(10,p.getSpeed());
    }

    @Test
    public void FighterUpdateBaseSpeedLessThanSpeedTest(){
        p.updateBaseSpeed(5);
        Assert.assertEquals(5,p.getBaseSpeed());
        Assert.assertEquals(5,p.getSpeed());
    }

    @Test
    public void FighterUpdateTypeTest(){
        p.updateType("Warrior");
        Assert.assertEquals("Warrior", p.getType());
    }

    @Test
    public void FighterUpdateNameTest(){
        p.updateName("John");
        Assert.assertEquals("John",p.getName());
    }

    @Test
    public void FighterUpdateIdTest(){
        p.updateId(10);
        Assert.assertEquals(10,p.getId());
    }

    @Test
    public void FighterToStringTest(){
        Assert.assertEquals("Paladin[200/200 HP]",p.toString());
    }

    @Test
    public void FighterFllHealTest(){
        p.updateHp(10);
        p.fullHeal();
        Assert.assertEquals(200,p.getHp());
    }

    @Test
    public void FighterResetAttackTest(){
        p.updateAttack(5);
        p.resetAttack();
        Assert.assertEquals(45,p.getAttack());
    }

    @Test
    public void FighterResetDefenseTest(){
        p.updateDefense(5);
        p.resetDefense();
        Assert.assertEquals(25,p.getDefense());
    }

    @Test
    public void FighterResetSpeedTest(){
        p.updateSpeed(5);
        p.resetSpeed();
        Assert.assertEquals(10,p.getSpeed());
    }

    @Test
    public void FighterRevertStatChangesTest(){
        p.updateAttack(5);
        p.updateDefense(5);
        p.updateSpeed(5);
        p.revertStatChanges();
        Assert.assertEquals(45,p.getAttack());
        Assert.assertEquals(25,p.getDefense());
        Assert.assertEquals(10,p.getSpeed());
    }

    @Test
    public void FighterResetStatsTest(){
        p.updateHp(5);
        p.updateAttack(5);
        p.updateDefense(5);
        p.updateSpeed(5);
        p.resetStats();
        Assert.assertEquals(200,p.getHp());
        Assert.assertEquals(45,p.getAttack());
        Assert.assertEquals(25,p.getDefense());
        Assert.assertEquals(10,p.getSpeed());
    }

    @Test
    public void FighterOtherConstructorTest(){
        Paladin p2 = new Paladin(1,1,1,1,"1","1");
        Fighter p3 = new Paladin(p2);
        Assert.assertEquals(p2.getHp(),p3.getHp());
        Assert.assertEquals(p2.getAttack(),p3.getAttack());
        Assert.assertEquals(p2.getDefense(),p3.getDefense());
        Assert.assertEquals(p2.getSpeed(),p3.getSpeed());
        Assert.assertEquals(p2.getType(),p3.getType());
        Assert.assertEquals(p2.getName(),p3.getName());
        Assert.assertEquals(p2.getId(),p3.getId());
    }

    @Test
    public void FighterRegenerateHpMoreThanZero(){
        p.updateHp(10);
        p.regenerateHp(5);
        Assert.assertEquals(15,p.getHp());
    }

    @Test
    public void FighterRegenerateHpLessThanZero(){
        p.updateHp(-5);
        p.regenerateHp(5);
        Assert.assertEquals(-5,p.getHp());
    }

    @Test
    public void FighterTakeDamageLessThanHp(){
        p.joinTeam(team);
        w.joinTeam(team2);
        p.takeDamage(20,w);
        Assert.assertEquals(184,p.getHp());
    }

    @Test
    public void FighterTakeDamageMoreThanHp(){
        p.joinTeam(team);
        w.joinTeam(team2);
        p.takeDamage(10000000,w);
        Assert.assertEquals(0,p.getHp());
    }

    @Test
    public void FighterTakeDamageMoreThanZero(){
        p.joinTeam(team);
        w.joinTeam(team2);
        p.takeDamage(-1,w);
        Assert.assertEquals(200,p.getHp());
    }

    @Test
    public void FighterTakeMagicalDamageLessThanHp(){
        p.joinTeam(team);
        m.joinTeam(team2);
        p.takeMagicalDamage(20,m);
        Assert.assertEquals(180,p.getHp());
    }

    @Test
    public void FighterTakeMagicalDamageMoreThanHp(){
        p.joinTeam(team);
        m.joinTeam(team2);
        p.takeMagicalDamage(10000000,m);
        Assert.assertEquals(0,p.getHp());
    }

    @Test
    public void FighterTakeMagicalDamageMoreThanZero(){
        p.joinTeam(team);
        m.joinTeam(team2);
        p.takeMagicalDamage(-1,m);
        Assert.assertEquals(200,p.getHp());
    }

    @Test
    public void FighterAttackTest(){
        team.add(p);
        team2.add(w);
        p.attack(team2);
        Assert.assertEquals(184,w.getHp());
    }
}
