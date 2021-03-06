package hu.itware.kite.service;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.crashlytics.android.Crashlytics;

import hu.itware.kite.service.orm.KiteORM;
import hu.itware.kite.service.orm.sync.SyncAdapter;
import hu.itware.kite.service.settings.Settings;
import io.fabric.sdk.android.Fabric;

public class KiteApplication extends Application {

	private static final String TAG = "KITE.APP";

	private static final String ACCOUNT_NAME = "KITE Szervíz";
	private static KiteApplication instance;
	private Account syncAccount;
	private KiteORM kiteORM;

	public static Context getContext() {
		return instance.getApplicationContext();
	}
	public static KiteORM getKiteORM() {
		return instance.kiteORM;
	}

	@Override
	public void onCreate() {
		instance = this;
		super.onCreate();
		this.kiteORM = new KiteORM(this);
		if (!BuildConfig.DEBUG) {
			Fabric.with(this, new Crashlytics());
		}
		Log.i(TAG, "KITE application created.");
		SyncAdapter.checkSyncDataDefaultsTable(this);

		// create Kite Dummy account tipusKod and default account
		syncAccount = new Account(ACCOUNT_NAME, "hu.itware.kite.service");
		AccountManager accountManager = (AccountManager) this.getSystemService(ACCOUNT_SERVICE);
		accountManager.addAccountExplicitly(syncAccount, null, null);

		Log.i(TAG, "Account added to AccoutnManager:" + ACCOUNT_NAME);

	}

	public Account getAccount() {
		return syncAccount;
	}

}
