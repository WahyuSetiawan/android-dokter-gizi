package com.daniel.doktergizi.database;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;

import com.daniel.doktergizi.model.entitas.Jadwal;
import com.daniel.doktergizi.model.entitas.Profile;
import com.daniel.doktergizi.model.entitas.Vaksin;
import com.daniel.doktergizi.util.Utility;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBProfileAnak extends SQLiteOpenHelper {
	private Context mContext;
	private Utility utility;

	static final int DATABASE_VERSION = 2;
	static final String DATABASE_NAME = "DokterGizi";

	static final String TABLE_PROFILE = "profileanak";
	static final String KEY_PROFILE_NAMA = "nama";
	static final String KEY_PROFILE_TANGGAL = "tanggal";
	static final String KEY_PROFILE_JENIS_KELAMIN = "jenis_kelamin";
	static final String KEY_PROFILE_FOTO_PATH = "foto";

	static final String TABLE_JADWAL = "reminder";
	static final String KEY_JADWAL_ID = "no";
	static final String KEY_JADWAL_VAKSIN = "vaksin";
	static final String KEY_JADWAL_TANGGAL_MULAI = "tanggalMulai";
	static final String KEY_JADWAL_TANGGAL_BERAKIR = "tanggalBerakhir";
	static final String KEY_JADWAL_NOIMUN = "no_imun";
	static final String KEY_JADWAL_STATUS = "status";
	static final String KEY_JADWAL_KETARANGAN = "keterangan";

	static final String TABLE_VAKSIN = "vaksin";
	static final String KEY_VAKSIN_ID = "no";
	static final String KEY_VAKSIN_NAME = "name";
	static final String KEY_VAKSIN_KETERANGAN = "keterangan";

	static final String[] ALL_PROFILE = { KEY_PROFILE_NAMA,
			KEY_PROFILE_TANGGAL, KEY_PROFILE_JENIS_KELAMIN,
			KEY_PROFILE_FOTO_PATH };

	static final String[] ALL_JADWAL = { KEY_JADWAL_ID, KEY_JADWAL_VAKSIN,
			KEY_JADWAL_TANGGAL_MULAI, KEY_JADWAL_TANGGAL_BERAKIR,
			KEY_JADWAL_NOIMUN, KEY_JADWAL_STATUS, KEY_JADWAL_KETARANGAN };

	static final String[] ALL_VAKSIN = { KEY_JADWAL_ID, KEY_VAKSIN_NAME,
			KEY_VAKSIN_KETERANGAN };

	public DBProfileAnak(Context context) {
		// TODO Auto-generated constructor stub
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		mContext = context;
		utility = new Utility();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table " + TABLE_PROFILE + " ( " + KEY_PROFILE_NAMA
				+ " varchar (2), " + KEY_PROFILE_TANGGAL + " date, "
				+ KEY_PROFILE_JENIS_KELAMIN + " varchar (2), "
				+ KEY_PROFILE_FOTO_PATH + " varchar (100))");

		db.execSQL("create table " + TABLE_VAKSIN + "( " + KEY_VAKSIN_ID
				+ " integer unique, " + KEY_VAKSIN_NAME + " varchar(11) , "
				+ KEY_VAKSIN_KETERANGAN + " char(200))");

		db.execSQL("create table " + TABLE_JADWAL + "( " + KEY_JADWAL_ID
				+ " integer unique, " + KEY_JADWAL_VAKSIN + " int(11) , "
				+ KEY_JADWAL_TANGGAL_MULAI + " date, "
				+ KEY_JADWAL_TANGGAL_BERAKIR + " date, " + KEY_JADWAL_NOIMUN
				+ " integer, " + KEY_JADWAL_STATUS + " integer, "
				+ KEY_JADWAL_KETARANGAN + " varchar (100))");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists " + TABLE_PROFILE);
		db.execSQL("drop table if exists " + TABLE_JADWAL);
		onCreate(db);
	}

	public void saveProfile(Profile profile) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_PROFILE, ALL_PROFILE, null, null, null,
				null, null);

		try {
			if (cursor.moveToFirst()) {
				db.execSQL("update " + TABLE_PROFILE + " set "
						+ KEY_PROFILE_NAMA + " = '" + profile.getName()
						+ "' , " + KEY_PROFILE_TANGGAL + " = ' "
						+ utility.getDateTime(profile.getTanggal()) + "', "
						+ KEY_PROFILE_JENIS_KELAMIN + " = '"
						+ profile.getJenisKelamin() + "' where "
						+ KEY_PROFILE_NAMA + "= '" + cursor.getString(0) + "'");
			} else {
				db.execSQL("insert into " + TABLE_PROFILE + " values ('"
						+ profile.getName() + "','"
						+ utility.getDateTime(profile.getTanggal()) + "','"
						+ profile.getJenisKelamin() + "','')");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	public void saveImage(String path) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_PROFILE, ALL_PROFILE, null, null, null,
				null, null);

		try {
			if (cursor.moveToFirst()) {
				db.execSQL("update " + TABLE_PROFILE + " set "
						+ KEY_PROFILE_FOTO_PATH + " = '" + path + "' where "
						+ KEY_PROFILE_NAMA + "= '" + cursor.getString(0) + "'");
			} else {
				db.execSQL("insert into " + TABLE_PROFILE
						+ " values ('android','','','" + path + "')");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	public String getImage() {
		SQLiteDatabase database = this.getReadableDatabase();

		Cursor cursor = database.query(TABLE_PROFILE,
				new String[] { KEY_PROFILE_FOTO_PATH }, null, null, null, null,
				null);

		if (cursor.moveToFirst()) {
			System.out.println(cursor.getString(0).toString());
			return cursor.getString(0).toString();
		} else {
			return "";
		}
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public void saveJadwa(Jadwal jadwal) {
		// TODO Auto-generated method stub
		SQLiteDatabase database = this.getReadableDatabase();
		try {
			database.execSQL("insert into " + TABLE_JADWAL + " values ("
					+ jadwal.getId() + ",'" + jadwal.getVaksin().getID()
					+ "','" + utility.getDateTime(jadwal.getTanggalMulai())
					+ "','" + utility.getDateTime(jadwal.getTanggalBerakhir())
					+ "'," + jadwal.getNoImun() + "," + jadwal.getStatus()
					+ ",'" + jadwal.getKeterangan() + "')");
		} catch (SQLiteConstraintException e) {
			// TODO: handle exception
			Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
		}

	}

	public void deleteAllReminder() {
		// TODO Auto-generated method stub
		SQLiteDatabase database = this.getReadableDatabase();

		database.execSQL("delete from " + TABLE_JADWAL);
	}

	public boolean getActivityCalendar(String string) {
		// TODO Auto-generated method stub
		SQLiteDatabase database = this.getReadableDatabase();

		Cursor cursor = database.rawQuery("select * from " + TABLE_JADWAL
				+ " where '" + string + "' >= " + KEY_JADWAL_TANGGAL_MULAI
				+ " and '" + string + "' <= " + KEY_JADWAL_TANGGAL_BERAKIR,
				null);

		if (cursor.moveToFirst()) {
			System.out.println(cursor.getString(0).toString());
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Jadwal> selectAllJadwal() {
		// TODO Auto-generated method stub
		ArrayList<Jadwal> jadwals = new ArrayList<Jadwal>();
		SQLiteDatabase database = this.getReadableDatabase();

		Cursor cursor = database.query(TABLE_JADWAL, ALL_JADWAL, null, null,
				null, null, null);

		if (cursor.moveToFirst()) {
			do {
				Vaksin vaksin = this.getVaksin(cursor.getString(1));

				Jadwal jadwal = new Jadwal(cursor.getInt(0), vaksin,
						utility.getDate(cursor.getString(2)),
						utility.getDate(cursor.getString(3)), cursor.getInt(4),
						cursor.getInt(5), cursor.getString(6));
				jadwals.add(jadwal);
			} while (cursor.moveToNext());

			return jadwals;
		} else {
			return null;
		}
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 */

	public void simpanVaksin(Vaksin vaksin) {
		SQLiteDatabase database = this.getReadableDatabase();

		try {
			database.execSQL("insert into " + TABLE_VAKSIN + " values('"
					+ vaksin.getID() + "','" + vaksin.getVaksin() + "','"
					+ vaksin.getKeterangan() + "')");
		} catch (SQLiteConstraintException e) {
			// TODO: handle exception
			Toast.makeText(mContext, e.getMessage().toString(),
					Toast.LENGTH_LONG).show();
		}

	}

	public void hapusSemuaVaksin() {
		SQLiteDatabase database = this.getReadableDatabase();

		database.execSQL("delete from " + TABLE_VAKSIN);
	}

	public int getCountVaksin() {
		// TODO Auto-generated method stub
		SQLiteDatabase database = this.getReadableDatabase();

		Cursor cursor = database.query(TABLE_VAKSIN, new String[] { " count("
				+ KEY_VAKSIN_ID + ") " }, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			return Integer.valueOf(cursor.getString(0));
		} else {
			return 0;
		}

	}

	public ArrayList<Jadwal> getImunisasi(String string) {
		// TODO Auto-generated method stub
		ArrayList<Jadwal> jadwals = new ArrayList<Jadwal>();
		SQLiteDatabase database = this.getReadableDatabase();

		Cursor cursor = database.query(TABLE_JADWAL, ALL_JADWAL,
				KEY_JADWAL_TANGGAL_MULAI + " <= '" + string + "' and "
						+ KEY_JADWAL_TANGGAL_BERAKIR + " >= '" + string + "'",
				null, null, null, null);

		if (cursor.moveToFirst()) {
			do {
				Vaksin vaksin = this.getVaksin(cursor.getString(1));

				Jadwal jadwal = new Jadwal(cursor.getInt(0), vaksin,
						utility.getDate(cursor.getString(2)),
						utility.getDate(cursor.getString(3)), cursor.getInt(4),
						cursor.getInt(4), cursor.getString(5));
				jadwals.add(jadwal);
			} while (cursor.moveToNext());

			return jadwals;
		} else {
			return null;
		}
	}

	private Vaksin getVaksin(String string) {
		// TODO Auto-generated method stub
		SQLiteDatabase database = this.getReadableDatabase();

		Cursor cursor = database.query(TABLE_VAKSIN, ALL_VAKSIN, KEY_VAKSIN_ID
				+ " = " + string, null, null, null, null);

		if (cursor.moveToFirst()) {
			Vaksin vaksin = new Vaksin(cursor.getInt(0), cursor.getString(1),
					cursor.getString(2));
			return vaksin;
		} else {
			return null;
		}
	}

	public void updateReminderSetTrue(int id) {
		// TODO Auto-generated method stub
		SQLiteDatabase database = this.getReadableDatabase();

		try {
			database.execSQL("update " + TABLE_JADWAL + " set "+ KEY_JADWAL_STATUS+" = 1 where " + KEY_JADWAL_ID + " = " + id);
		} catch (SQLiteConstraintException e) {
			// TODO: handle exception
			Toast.makeText(mContext, e.getMessage().toString(),
					Toast.LENGTH_LONG).show();
		}
	}
	
	public void updateReminderSetFalse(int id) {
		// TODO Auto-generated method stub
		SQLiteDatabase database = this.getReadableDatabase();

		try {
			database.execSQL("update " + TABLE_JADWAL + " set "+ KEY_JADWAL_STATUS+" = 0 where " + KEY_JADWAL_ID + " = " + id);
		} catch (SQLiteConstraintException e) {
			// TODO: handle exception
			Toast.makeText(mContext, e.getMessage().toString(),
					Toast.LENGTH_LONG).show();
		}
	}
}
