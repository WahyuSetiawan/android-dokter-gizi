package com.daniel.doktergizi.model.entitas;

import java.util.Date;

public class Jadwal {
	private int id;
	private Vaksin vaksin;
	private Date tanggalMulai;
	private Date tanggalBerakhir;
	private int status;
	private int noImun;
	private String keterangan;

	public Jadwal(int id, Vaksin vaksin, Date tanggalMulai,
			Date tanggalBerakhir, int noImun, int status, String keterangan) {
		super();
		this.id = id;
		this.vaksin = vaksin;
		this.tanggalMulai = tanggalMulai;
		this.tanggalBerakhir = tanggalBerakhir;
		this.status = status;
		this.noImun = noImun;
		this.keterangan = keterangan;
	}

	public Jadwal() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vaksin getVaksin() {
		return vaksin;
	}

	public void setVaksin(Vaksin vaksin) {
		this.vaksin = vaksin;
	}

	public Date getTanggalMulai() {
		return tanggalMulai;
	}

	public void setTanggalMulai(Date tanggalMulai) {
		this.tanggalMulai = tanggalMulai;
	}

	public Date getTanggalBerakhir() {
		return tanggalBerakhir;
	}

	public void setTanggalBerakhir(Date tanggalBerakhir) {
		this.tanggalBerakhir = tanggalBerakhir;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getNoImun() {
		return noImun;
	}

	public void setNoImun(int noImun) {
		this.noImun = noImun;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

}
