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


    @Before
    public void setup(){
        p = new Paladin();
        w = new Warrior();
        t = new Thief();
        b = new Berserker();
        a = new Archer();
        m = new Mage();
        team = new Team();
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
}
