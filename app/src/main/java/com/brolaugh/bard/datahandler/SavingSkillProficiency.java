package com.brolaugh.bard.datahandler;

public class SavingSkillProficiency extends CharacterDependent{

    private String modifierType;
    private Skill parentType;
    private Byte modifierAmount;

    public SavingSkillProficiency(int id, int characterID, String modifierType, Byte modifierAmount){
        this(modifierType, modifierAmount);
        setId(id);
        setCharacterID(characterID);
    }

    public SavingSkillProficiency(String modifierType, Byte modifierAmount){
        this.modifierAmount = modifierAmount;
        switch (modifierType.toLowerCase()){
            case "strength":
            case "str":
                this.modifierType = "str";
                this.parentType = Skill.STRENGTH;
                break;
            case "dexterity":
            case "dext":
                this.modifierType = "dext";
                this.parentType = Skill.DEXTERITY;
                break;
            case "constitution":
            case "cons":
                this.modifierType = "cons";
                this.parentType = Skill.CONSTITUTION;
                break;
            case "intelligence":
            case "inte":
                this.modifierType = "inte";
                this.parentType = Skill.INTELLIGENCE;
                break;
            case "wisdom":
            case "wisd":
                this.modifierType = "wisd";
                this.parentType = Skill.WISDOM;
                break;
            case "charisma":
            case "char":
                this.modifierType = "char";
                this.parentType = Skill.CHARISMA;
                break;
            case "acrobatics":
            case "acro":
                this.modifierType = "acro";
                this.parentType = Skill.DEXTERITY;
                break;
            case "animal Handling":
            case "anim":
                this.modifierType = "anim";
                this.parentType = Skill.WISDOM;
                break;
            case "arcana":
            case "arca":
                this.modifierType = "arca";
                this.parentType = Skill.INTELLIGENCE;
                break;
            case "athletics":
            case "athl":
                this.modifierType = "athl";
                this.parentType = Skill.STRENGTH;
                break;
            case "deception":
            case "dece":
                this.modifierType = "dece";
                this.parentType = Skill.CHARISMA;
                break;
            case "history":
            case "hist":
                this.modifierType = "hist";
                this.parentType = Skill.INTELLIGENCE;
                break;
            case "insight":
            case "insi":
                this.modifierType = "insi";
                this.parentType = Skill.INTELLIGENCE;
                break;
            case "intimidation":
            case "inti":
                this.modifierType = "inti";
                this.parentType = Skill.CHARISMA;
                break;
            case "investigation":
            case "inve":
                this.modifierType = "inve";
                this.parentType = Skill.INTELLIGENCE;
                break;
            case "medicine":
            case "medi":
                this.modifierType = "medi";
                this.parentType = Skill.WISDOM;
                break;
            case "nature":
            case "natu":
                this.modifierType = "natu";
                this.parentType = Skill.INTELLIGENCE;
                break;
            case "perception":
            case "perc":
                this.modifierType = "perc";
                this.parentType = Skill.WISDOM;
                break;
            case "performance":
            case "perf":
                this.modifierType = "perf";
                this.parentType = Skill.CHARISMA;
                break;
            case "persuasion":
            case "pers":
                this.modifierType = "pers";
                this.parentType = Skill.CHARISMA;
                break;
            case "religion":
            case "reli":
                this.modifierType = "reli";
                this.parentType = Skill.INTELLIGENCE;
                break;
            case "sleight of Hand":
            case "slei":
                this.modifierType = "slei";
                this.parentType = Skill.DEXTERITY;
                break;
            case "stealth":
            case "stea":
                this.modifierType = "stea";
                this.parentType = Skill.DEXTERITY;
                break;
            case "survival":
            case "surv":
                this.modifierType = "surv";
                this.parentType = Skill.WISDOM;
                break;
            default:
                this.modifierType = "broken";
                this.parentType = Skill.CONSTITUTION;
        }
    }
    public Skill getSkill(){
        return parentType;
    }
    public byte getModifierAmount(){
        return modifierAmount;
    }
    public String getModifierType(){
        return modifierType;
    }
}
