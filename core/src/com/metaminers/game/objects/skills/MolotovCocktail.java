package com.metaminers.game.objects.skills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class MolotovCocktail extends AbstractDamagingSkill {
        public MolotovCocktail(){
        this.name = "Molotov Cocktail";
        this.areaOfEffect = 3;
        this.damage = 50;
        this.cooldown = 6000;
        this.energyCost = 12;
    }
}
