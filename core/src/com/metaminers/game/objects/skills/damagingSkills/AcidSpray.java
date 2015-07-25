package com.metaminers.game.objects.skills.damagingSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class AcidSpray extends AbstractDamagingSkill {
    public AcidSpray(){         //basic attack dla maga
        this.cooldown = 800;
        this.damage = 20;
        this.areaOfEffect = 1;
        this.energyCost = 0;
        this.name = "Acid Spray";
    }
}
