package pl.poleq.pixdogfight.entity.plane;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlaneEquipment {
    private final int MAX_AMMO;
    private final int MAX_MISSILES;
    private final int MAX_COUNTERMEASURES;

    private int ammo;
    private int missiles;
    private int countermeasures;

    /**
     * Set maximum and current values
     * @param ammo ammunition
     * @param missiles missiles
     * @param countermeasures countermeasures (flares
     */
    public PlaneEquipment(int ammo, int missiles, int countermeasures) {
        this.MAX_AMMO = ammo;
        this.MAX_MISSILES = missiles;
        this.MAX_COUNTERMEASURES = countermeasures;

        this.ammo = ammo;
        this.missiles = missiles;
        this.countermeasures = countermeasures;
    }

    public void decrementAmmo() {
        ammo--;
    }

    public void decrementMissiles() {
        missiles--;
    }

    public void decrementCountermeasures() {
        countermeasures--;
    }
}
