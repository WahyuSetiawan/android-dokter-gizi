package com.daniel.doktergizi.config;

import java.util.Date;

import com.daniel.doktergizi.model.entitas.Vaksin;

public interface RuleAnak {
	int index = 0;

	final Vaksin[] vaksins = {
			new Vaksin(1, "Hepaetitis B",
					"diberikan dalam waktu 12 jam setelah lahir"),
			new Vaksin(
					2,
					"Polio",
					"diberikan pada kunjungan pertama. bayi yang lahir di RB/RS diberikan vaksin OPV saat "
							+ "dipulangkan untuk menghindari "
							+ "transmisi virus vaksin kepada bayi. Selanjutnya, untuk polio - 1, polio - 2, polio - 3 "
							+ "dapat diberikan vaksin OPV atau IPV"),
			new Vaksin(
					3,
					"BCG",
					"optimal diberikan pada umur 2 atau 3 bulan. Bila vaksin BCG akan diberikan sesudah umur "
							+ "3 bulan, perlu dilakukan uji tuberkulin. Bila uji tuberkulin pra-BCG tidak dimungkinkan, "
							+ "BCG dapat diberikan, namun harus diobservasi dalam 7 hari. Bila ada reaksi lokal cepat "
							+ "di tempat suntikan (accelerated local reaction), perlu divaluasi lebih lanjut"),
			new Vaksin(4, "DTP", ""), 
			new Vaksin(5, "PCV", ""),
			new Vaksin(6, "Rotavirus", ""),
			new Vaksin(7, "Influenza", ""),
			new Vaksin(8, "Campak", ""),
			new Vaksin(9, "MMR", ""),
			new Vaksin(10, "Tifoid", ""),
			new Vaksin(11, "Hepatitis A", ""),
			new Vaksin(12, "Varisela", ""),
			new Vaksin(13, "HPV", "") 
	};


	@SuppressWarnings("deprecation")
	final JadwalRule[] ruleJadwalStrings = {
			new JadwalRule(0, vaksins[0], new Date(0, 0, 1),
					new Date(0, 0, 30), 0, 1, ""),
			new JadwalRule(1, vaksins[0], new Date(0, 1, 1),
					new Date(0, 1, 30), 0, 2, ""),
			new JadwalRule(2, vaksins[0], new Date(0, 6, 1),
					new Date(0, 6, 30), 0, 3, ""),
			// polio
			new JadwalRule(3, vaksins[1], new Date(0, 0, 1),
					new Date(0, 0, 30), 0, 1, ""),
			new JadwalRule(4, vaksins[1], new Date(0, 2, 1),
					new Date(0, 2, 30), 0, 2, ""),
			new JadwalRule(5, vaksins[1], new Date(0, 4, 1),
					new Date(0, 4, 30), 0, 3, ""),
			new JadwalRule(6, vaksins[1], new Date(1, 6, 1),
					new Date(1, 12, 30), 0, 4, ""),
			new JadwalRule(7, vaksins[1], new Date(5, 0, 1),
					new Date(5, 12, 30), 0, 5, ""),
	// BCG
	/*
	 * new JadwalRule(indexjadwal, vaksins[1], new Date(0, 1, 0), new Date(0, 1,
	 * 30), 0, 1, ""), // DTP new JadwalRule(indexjadwal, vaksins[1], new
	 * Date(0, 1, 0), new Date(0, 1, 30), 0, 1, ""), new JadwalRule(indexjadwal,
	 * vaksins[1], new Date(0, 1, 0), new Date(0, 1, 30), 0, 1, ""), new
	 * JadwalRule(indexjadwal, vaksins[1], new Date(0, 1, 0), new Date(0, 1,
	 * 30), 0, 1, ""), new JadwalRule(indexjadwal, vaksins[1], new Date(0, 1,
	 * 0), new Date(0, 1, 30), 0, 1, ""), new JadwalRule(indexjadwal,
	 * vaksins[1], new Date(0, 1, 0), new Date(0, 1, 30), 0, 1, ""), new
	 * JadwalRule(indexjadwal, vaksins[1], new Date(0, 1, 0), new Date(0, 1,
	 * 30), 0, 1, ""), new JadwalRule(indexjadwal, vaksins[1], new Date(0, 1,
	 * 0), new Date(0, 1, 30), 0, 1, ""), // Hib new JadwalRule(indexjadwal,
	 * vaksins[1], new Date(0, 1, 0), new Date(0, 1, 30), 0, 1, ""),
	 */

	};
}
