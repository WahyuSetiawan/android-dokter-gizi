package com.daniel.doktergizi.util;

import java.util.Calendar;
import java.util.Date;

import android.R.integer;
import android.content.Context;

import com.daniel.doktergizi.config.JadwalRule;
import com.daniel.doktergizi.config.RuleAnak;
import com.daniel.doktergizi.database.DBProfileAnak;
import com.daniel.doktergizi.model.entitas.Jadwal;
import com.daniel.doktergizi.model.entitas.Vaksin;

public class UtilityReminder implements RuleAnak {
	DBProfileAnak databaseAnak;
	Context mContext;

	public UtilityReminder(Context context) {
		this.mContext = context;
		databaseAnak = new DBProfileAnak(context);
	}

	public void resetReminder(Calendar tanggalLahir) {
		databaseAnak.deleteAllReminder();

		int countVaksin = databaseAnak.getCountVaksin();

		if (countVaksin == 0) {
			this.databaseVaksinUP();
		}

		for (JadwalRule jadwalRule : ruleJadwalStrings) {
			Jadwal jadwal = new Jadwal();

			jadwal.setId(jadwalRule.getId());
			jadwal.setNoImun(jadwalRule.getNoImun());
			jadwal.setStatus(jadwalRule.getStatus());
			jadwal.setKeterangan(jadwalRule.getKeterangan());
			jadwal.setVaksin(jadwalRule.getVaksin());
			
			jadwal.setTanggalMulai(tambahBulan(tanggalLahir, jadwalRule.getTanggalMulai()));
			jadwal.setTanggalBerakhir(tambahBulan(tanggalLahir, jadwalRule.getTanggalBerakhir()));
			
			databaseAnak.saveJadwa(jadwal);
		}
	}

	public void databaseVaksinUP() {
		for (Vaksin jadwalRule : vaksins) {
			databaseAnak.simpanVaksin(jadwalRule);
		}
	}

	public void databaseVaksinDown() {
		databaseAnak.hapusSemuaVaksin();
	}
	
	@SuppressWarnings("deprecation")
	private Date tambahBulan(Calendar awal, Date tambahan) {
		Date tanggal= new Date();
		int month, year = 0;
		
		tanggal.setDate(tambahan.getDate());
		
		month = awal.getTime().getMonth() + tambahan.getMonth();
		if (month > 12){
			year++;
			tanggal.setMonth(month - 12);
		} else {
			tanggal.setMonth(month);
		}
		
		tanggal.setYear(year + awal.getTime().getYear() + tambahan.getYear());
		
		return tanggal;
	}
}
