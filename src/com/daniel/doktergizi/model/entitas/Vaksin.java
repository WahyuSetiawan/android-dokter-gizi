package com.daniel.doktergizi.model.entitas;

public class Vaksin {
	private int ID;

	public Vaksin(int iD, String vaksin, String keterangan) {
		super();
		ID = iD;
		this.vaksin = vaksin;
		Keterangan = keterangan;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getVaksin() {
		return vaksin;
	}

	public void setVaksin(String vaksin) {
		this.vaksin = vaksin;
	}

	public String getKeterangan() {
		return Keterangan;
	}

	public void setKeterangan(String keterangan) {
		Keterangan = keterangan;
	}

	private String vaksin;
	private String Keterangan;
}
