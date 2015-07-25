package com.metaminers.game.objects.skills.damagingSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class Headshot extends AbstractDamagingSkill {
    public Headshot(){
        this.name = "Headshot";     //headshot zosta³ zaprojektowany jako ten basic attack do klikania
        this.areaOfEffect = 1;      //byæ mo¿e lepszym pomys³em bêdzie zostawienie headshota jako basic attacku
        this.damage = 200;          //i wy³¹czenie go z listy skilli?
        this.cooldown = 800;        //wtedy zawsze bêdzie trzeba klikaæ, z przerwami na granata czy coœ
        this.energyCost = 0;        //temat pozostawiam otwarty do dyskusji
    }
}
