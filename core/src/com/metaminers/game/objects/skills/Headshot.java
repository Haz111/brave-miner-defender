package com.metaminers.game.objects.skills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class Headshot extends AbstractDamagingSkill {
    public Headshot(){
        this.name = "Headshot";     //headshot zosta� zaprojektowany jako ten basic attack do klikania
        this.areaOfEffect = 1;      //by� mo�e lepszym pomys�em b�dzie zostawienie headshota jako basic attacku
        this.damage = 200;          //i wy��czenie go z listy skilli?
        this.cooldown = 800;        //wtedy zawsze b�dzie trzeba klika�, z przerwami na granata czy co�
        this.energyCost = 0;        //temat pozostawiam otwarty do dyskusji
    }
}
