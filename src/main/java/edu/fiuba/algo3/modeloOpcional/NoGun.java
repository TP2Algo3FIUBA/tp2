package edu.fiuba.algo3.modeloOpcional;

public class NoGun implements AttackStrategy {

	private String name = "marco_unarmed";

	@Override
	public void attack(Attackable target) {
	}

	@Override
	public String getName() {
		return name;
	}

}
