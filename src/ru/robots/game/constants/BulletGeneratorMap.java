package ru.robots.game.constants;

import ru.robots.game.gameObjects.Bullet;

import static ru.robots.game.constants.Gun.*;
import java.util.*;
import static java.util.Map.entry;

public class BulletGeneratorMap {

    private final Map<Gun, ArrayList<Bullet>> bulletMap = Map.ofEntries(
            entry(PISTOL, generatePistolBullets()),
            entry(SHOTGUN, generateShotgunBullets()),
            entry(SNIPER_RIFLE, generateRifleBullets())
    );

    public Map<Gun, ArrayList<Bullet>> getBulletMap() {
        return bulletMap;
    }

    private ArrayList<Bullet> generatePistolBullets() {
        return new ArrayList<>(Collections.singletonList(new Bullet(0, 0, 0, 6, 3, PISTOL.getBulletVelocity(), PISTOL.getDtl(),
                PISTOL.getDamage(), PISTOL.getShotDelay())));
    }

    private ArrayList<Bullet> generateShotgunBullets(){
        return new ArrayList<>(Arrays.asList(new Bullet(0, 0, 0, 6, 3, SHOTGUN.getBulletVelocity(), SHOTGUN.getDtl(), SHOTGUN.getDamage(), SHOTGUN.getShotDelay()),
                new Bullet(0, 0, SHOTGUN.getBulletAngle(), 6, 3, SHOTGUN.getBulletVelocity(), SHOTGUN.getDtl(), SHOTGUN.getDamage(), SHOTGUN.getShotDelay()),
                new Bullet(0, 0, -SHOTGUN.getBulletAngle(), 6, 3, SHOTGUN.getBulletVelocity(), SHOTGUN.getDtl(), SHOTGUN.getDamage(), SHOTGUN.getShotDelay())));
    }

    private ArrayList<Bullet> generateRifleBullets() {
        return new ArrayList<>(Collections.singletonList(new Bullet(0, 0, 0, 6, 3, SNIPER_RIFLE.getBulletVelocity(), SNIPER_RIFLE.getDtl(),
                SNIPER_RIFLE.getDamage(), SNIPER_RIFLE.getShotDelay())));
    }
}
