package com.feigdev.tvfan_viewpagersample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

// http://code.google.com/p/viewpagerexample/source/browse/trunk/AwesomePager/src/com/geekyouup/paug/awesomepager/AwesomePagerActivity.java
public class TvPagerAdapter extends PagerAdapter {
	private static final String TAG = "TvPagerAdapter";
	enum Layouts {
		L80S(new int[] { R.layout.alf, R.layout.cosby, R.layout.boss,
				R.layout.full_house, R.layout.night_court }), L90S(new int[] {
				R.layout.friends, R.layout.bmw, R.layout.simpsons,
				R.layout.saved, R.layout.fresh, R.layout.seinfeld }), L00S(
				new int[] { R.layout.arrested, R.layout.rock, R.layout.bad,
						R.layout.scrubs });

		final int[] layouts;

		Layouts(int[] layouts) {
			this.layouts = layouts;
			Log.d(TAG,"init: " + this);
		}
	}

	private Context cxt;
	private final Layouts layouts;

	public TvPagerAdapter(Context context, Layouts layouts) {
		cxt = context;
		this.layouts = layouts;
		Log.d(TAG,"use: " + this.layouts);
	}

	@Override
	public int getCount() {
		return layouts.layouts.length;
	}

	@Override
	public Object instantiateItem(ViewGroup collection, int position) {
		View view = View.inflate(cxt, layouts.layouts[position], null);

		collection.addView(view, 0);

		return view;
	}

	@Override
	public void destroyItem(ViewGroup collection, int position, Object view) {
		collection.removeView((View) view);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return (view == object);
	}

}
