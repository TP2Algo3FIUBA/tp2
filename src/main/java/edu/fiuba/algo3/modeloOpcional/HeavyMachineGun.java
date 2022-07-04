
package edu.fiuba.algo3.modeloOpcional;

public class HeavyMachineGun implements AttackStrategy {

	private int power;
	private String name = "marco_heavy_machinegun";

	public HeavyMachineGun() {
		power = 100;
	}

	@Override
	public void attack(Attackable target) {
		target.takeDamage(power);
	}

	@Override
	public String getName() {
		return name;
	}
}