package edu.fiuba.algo3.modeloOpcional;

public class SimpleGun implements AttackStrategy {

	private int power;
	private String name = "marco_pistola";

	public SimpleGun() {
		power = 10;
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
