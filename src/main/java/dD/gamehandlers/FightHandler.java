package dD.gamehandlers;

import dD.model.Monster;
import dD.model.PlayerCharacter;
import dD.popboxes.FightBox;

import static dD.controllers.MainController.monsterToFight;

public class FightHandler {

    private FightBox fightBox = new FightBox();

    public void pickFight(String monsterName, PlayerCharacter p){
        Monster monster;
        Monster monster2;

        switch(monsterName){
            case "MANTICORE" :
                monster = new Monster("Manticore", 11,11);
                fight(p,monster);
                break;
            case "GIANTFLY" :
                monster = new Monster("Giant Fly",8,7);
                fight(p,monster);
                break;
            case "MINOTAUR" :
                monster = new Monster("Minotaur",9,9);
                fight(p,monster);
                break;
            case "HOBGOBLIN" :
                monster = new Monster("Hobgoblin",5,6);
                fight(p,monster);
                break;
            case "ORCDUO" :
                monster = new Monster("Orc 1",5,5);
                monster2 = new Monster("Orc 2",5,6);
                doubleFight(p,monster,monster2);
                break;
            case "GOBLINDUO" :
                monster = new Monster("Goblin 1",4,5);
                monster2 = new Monster("Goblin 2",5,5);
                doubleFight(p,monster,monster2);
                break;
            case "HOBGOBLINDUO" :
                monster = new Monster("Hobgoblin 1",5,7);
                monster2 = new Monster("Hobgoblin 2",5,6);
                doubleFight(p,monster,monster2);
                break;
            case "IVY" :
                monster = new Monster("Ivy The Troll",9,9);
                fight(p,monster);
                break;
            case "SCORPION" :
                monster = new Monster("Giant Scorpion",10,10);
                fight(p,monster);
                break;
            case "DWARF" :
                monster = new Monster("Dwarf",6,8);
                fight(p,monster);
                break;
            case "DOGDUO" :
                monster = new Monster("Dog 1",7,7);
                monster2 = new Monster("Dog 2",8,7);
                doubleFight(p,monster,monster2);
                break;
            case "GUARDIANDUO" :
                monster = new Monster("Guardian 1",8,7);
                monster2 = new Monster("Guardian 2",8,8);
                doubleFight(p,monster,monster2);
                break;
            case "BLOODBEAST" :
                monster = new Monster("Bloodbeast",10,12);
                fight(p,monster);
                break;
            case "PITFIEND" :
                monster = new Monster("Pit Fiend",15,12);
                fight(p,monster);
                break;
            case "IMITATOR" :
                monster = new Monster("Imitator",8,9);
                fight(p,monster);
                break;
            case "ROCKGRUB" :
                monster = new Monster("Rock Grub",11,7);
                fight(p,monster);
                break;
            case "THROM" :
                monster = new Monster("Throm",12,10);
                fight(p,monster);
                break;
            case "NINJA" :
                monster = new Monster("Ninja",9,11);
                fight(p,monster);
                break;
            case "MIRRORDEMON" :
                monster = new Monster("Mirror Demon",10,10);
                fight(p,monster);
                break;
            case "SKELETON" :
                monster = new Monster("Skeleton Warrior",6,8);
                fight(p,monster);
                break;
            case "CAVETROLL" :
                monster = new Monster("Cave Troll",11,10);
                fight(p,monster);
                break;
            case "CAVEMAN" :
                monster = new Monster("Caveman",7,7);
                fight(p,monster);
                break;
        }
    }

    private void fight(PlayerCharacter p, Monster m){
        monsterToFight = m;
        fightBox.displayFightBox(p,m);
    }

    private void doubleFight(PlayerCharacter p, Monster m1, Monster m2){
        monsterToFight = m1;
        fightBox.displayFightBox(p,m1);
        monsterToFight = m2;
        fightBox.displayFightBox(p,m1);
    }
}
