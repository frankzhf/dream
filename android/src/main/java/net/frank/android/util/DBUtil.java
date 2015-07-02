package net.frank.android.util;

import java.util.ArrayList;
import java.util.List;

import net.frank.android.entity.Account;
import net.frank.android.entity.SystemEnv;
import net.frank.android.holder.ContextHolder;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class DBUtil {
	static SQLiteDatabase sld;
	public static void createOrOpenDatabase(boolean init) {
		try {
			sld = SQLiteDatabase.openDatabase(
					ContextHolder.getContext().getFilesDir().getPath() + ContextHolder.getDbConfig(), 
					null, // CursorFactory
					SQLiteDatabase.OPEN_READWRITE
							| SQLiteDatabase.CREATE_IF_NECESSARY 
			);
			
			String sql01 = "create table if not exists SYSTEM_ENV" + "("
					+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "ENV_NAME Varchar(32)," + "ENV_VALUE Varchar(512)" + ")";


			String sql02 = "create table if not exists ACCOUNT" + "("
					+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "LOGIN_ID Varchar(32)," + "PASSWORD Varchar(32),"
					+ "USER_NAME Varchar(32)," + "AGE Integer,"
					+ "MOBILE Varchar(32)" + ")";
			
			//customPrepare

			if (init) {
				sld.execSQL("delete from SYSTEM_ENV");
				sld.execSQL("delete from ACCOUNT");
				sld.execSQL(sql01);
				sld.execSQL(sql02);
				//customInit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public abstract void customPrepare();
	public abstract void customInit();

	public static Account getAccount(Integer id) {
		Account rt = null;
		try {
			String sql = "SELECT ID,LOGIN_ID,PASSWORD,USER_NAME,AGE,MOBILE FROM ACCOUNT WHERE ID ="
					+ id;
			Cursor cur = sld.rawQuery(sql, new String[] {});
			while (cur.moveToNext()) {
				rt = new Account();
				rt.setId(cur.getInt(0));
				rt.setLoginId(cur.getString(1));
				rt.setPassword(cur.getString(2));
				rt.setUserName(cur.getString(3));
				rt.setAge(cur.getInt(4));
				rt.setMobile(cur.getString(5));
				return rt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rt;
	}

	public static Account queryAccountByLoginId(String loginId) {
		Account rt = null;
		try {
			String sql = "SELECT ID,LOGIN_ID,PASSWORD,USER_NAME,AGE,MOBILE FROM ACCOUNT WHERE LOGIN_ID ='"
					+ loginId + "'";
			Cursor cur = sld.rawQuery(sql, new String[] {});
			while (cur.moveToNext()) {
				rt = new Account();
				rt.setId(cur.getInt(0));
				rt.setLoginId(cur.getString(1));
				rt.setPassword(cur.getString(2));
				rt.setUserName(cur.getString(3));
				rt.setAge(cur.getInt(4));
				rt.setMobile(cur.getString(5));
				return rt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rt;
	}

	public static void updateAccount(Account account) {
		try {
			sld.execSQL("UPDATE ACCOUNT SET LOGIN_ID='"
					+ account.getLoginId()
					+ "',"
					+ "PASSWORD='"
					+ account.getPassword()
					+ "',"
					+ "USER_NAME='"
					+ (account.getUserName() == null ? "" : account
							.getUserName())
					+ "'"
					+ (account.getAge() == null ? "" : ",AGE="
							+ account.getAge() + ",")
					+ "MOBILE='"
					+ (account.getMobile() == null ? "" : account.getMobile()
							+ "' WHERE ID=" + account.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteAccount(Account account) {
		try {
			sld.execSQL("DELETE FROM ACCOUNT WHERE ID=" + account.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Account createAccount(Account account) {
		try {
			sld.execSQL("INSERT INTO ACCOUNT (LOGIN_ID,PASSWORD,USER_NAME,AGE,MOBILE) VALUES('"
					+ account.getLoginId()
					+ "','"
					+ account.getPassword()
					+ "','"
					+ account.getUserName()
					+ "',"
					+ account.getAge()
					+ ",'" + account.getMobile() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryAccountByLoginId(account.getLoginId());
	}

	public static List<SystemEnv> listSystemEnv() {
		List<SystemEnv> rt = new ArrayList<SystemEnv>();
		try {
			String sql = "SELECT ID,ENV_NAME,ENV_VALUE FROM SYSTEM_ENV";
			Cursor cur = sld.rawQuery(sql, new String[] {});
			SystemEnv se = null;
			while (cur.moveToNext()) {
				se = new SystemEnv();
				se.setId(cur.getInt(0));
				se.setEnvName(cur.getString(1));
				se.setEnvValue(cur.getString(2));
				rt.add(se);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rt;
	}
	
	public static void closeDatabase() {
		try {
			sld.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}