package com.daniel.doktergizi.model.entitas;

import java.util.Date;

public class Profile {
	private String name;
	private Date tanggal;
	private String jenisKelamin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public Profile(String name, Date tanggal, String jenisKelamin) {
		super();
		this.name = name;
		this.tanggal = tanggal;
		this.jenisKelamin = jenisKelamin;
	}
}
