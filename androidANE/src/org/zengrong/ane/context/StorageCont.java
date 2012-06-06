package org.zengrong.ane.context;

import java.util.HashMap;
import java.util.Map;

import org.zengrong.ane.funs.storage.DelFile;
import org.zengrong.ane.funs.storage.GetExternal;
import org.zengrong.ane.funs.storage.GetExternalFilesDir;
import org.zengrong.ane.funs.storage.GetExternalPublicDir;
import org.zengrong.ane.funs.storage.GetExternalState;
import org.zengrong.ane.funs.storage.GetInternal;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class StorageCont extends FREContext
{

	public static final String TAG = "org.zengrong.ane.context.StorageCont";
	
	/**
	 * 记录所有支持的FREFunction
	 * @author zrong
	 */
	public static enum FUNS
	{
		GET_EXTERNAL_STATE, GET_INTERNAL, GET_EXTERNAL, 
		GET_EXTERNAL_FILES_DIR, GET_EXTERNAL_PUBLIC_DIR, 
		DEL_FILE 
	};
	
	@Override
	public void dispose()
	{
		String __info = "StorageCont dispose";
		Log.d(TAG, __info);
		dispatchStatusEventAsync(__info, TAG);
	}

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put(FUNS.GET_INTERNAL.toString(), new GetInternal());
		functions.put(FUNS.GET_EXTERNAL.toString(), new GetExternal());
		functions.put(FUNS.GET_EXTERNAL_STATE.toString(), new GetExternalState());
		functions.put(FUNS.GET_EXTERNAL_FILES_DIR.toString(), new GetExternalFilesDir());
		functions.put(FUNS.GET_EXTERNAL_PUBLIC_DIR.toString(), new GetExternalPublicDir());
		functions.put(FUNS.DEL_FILE.toString(), new DelFile());
		return functions;
	}

}
