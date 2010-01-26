package org.abrantix.rockon.rockonnggl;

import java.util.ArrayList;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;

class PlaylistSelectedClickListener implements android.content.DialogInterface.OnClickListener{
	private final String TAG = "PlaylistSelectedClickListener";
	ArrayList<Playlist>	mPlaylistArray;
	Handler				mPlaylistItemSelectedHandler;
	
	public PlaylistSelectedClickListener(
			Handler playlistClickHandler, 
			ArrayList<Playlist> playlistArray) {
		mPlaylistItemSelectedHandler = playlistClickHandler;
		mPlaylistArray = playlistArray;
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		Log.i(TAG, "Item "+which+" clicked!");
		mPlaylistItemSelectedHandler.sendEmptyMessageDelayed(
				Integer.parseInt(mPlaylistArray.get(which).get(Constants.PLAYLIST_ID_KEY)), 
				Constants.CLICK_ACTION_DELAY);
		dialog.dismiss();
	}
}
