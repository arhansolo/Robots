package ru.robots.game.constants;

public enum Gun {
    PISTOL("pistol", 10, 500, 20, 200, 0),
    SHOTGUN("shotgun", 10, 150, 25, 1000, Math.PI/18),
    SNIPER_RIFLE("rifle", 10, 1000, 75, 2000, 0);

    Gun(String typeOfGun, int bulletVelocity, int dtl, int damage, int shotDelay, double bulletAngle) {
        this.typeOfGun = typeOfGun;
        this.bulletVelocity = bulletVelocity;
        this.dtl = dtl;
        this.damage = damage;
        this.shotDelay = shotDelay;
        this.bulletAngle = bulletAngle;
    }

    private final String typeOfGun;
    private final int bulletVelocity;
    private final int dtl;
    private final int damage;
    private final int shotDelay;
    private final double bulletAngle;

    public String getTypeOfGun() {
        return typeOfGun;
    }

    public int getBulletVelocity() {
        return bulletVelocity;
    }

    public int getDtl() {
        return dtl;
    }

    public int getDamage() {
        return damage;
    }

    public int getShotDelay() {
        return shotDelay;
    }

    public double getBulletAngle() {
        return bulletAngle;
    }
}
