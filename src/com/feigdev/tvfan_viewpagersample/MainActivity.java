package com.feigdev.tvfan_viewpagersample;

import com.feigdev.tvfan_viewpagersample.TvPagerAdapter.Layouts;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends Activity implements OnTabChangeListener {
	private static final String TAG = "MainActivity";
	View tabView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tabView = findViewById(R.id.tabView);

		((Button)findViewById(R.id.toggleButton)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleTabs();
			}
		});
			
		getActionBar().setTitle("TV Fan");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void toggleTabs(){
		initTabs();
		
		if (View.VISIBLE == tabView.getVisibility())
			tabView.setVisibility(View.GONE);
		else 
			tabView.setVisibility(View.VISIBLE);
	}
	
	private void initTabs(){
	    if (null != findViewById(R.id.tabSubTree)){
	    	return;
	    }
	    ((ViewStub) findViewById(R.id.tabstub)).inflate();
	    
    	
	    TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
	    tabHost.setup();

	    tabHost.addTab(tabHost.newTabSpec("80s").setIndicator("80s")
                .setContent(R.id.tab1));
	    
	    tabHost.addTab(tabHost.newTabSpec("90s").setIndicator("90s")
                .setContent(R.id.tab2));
	    
	    tabHost.addTab(tabHost.newTabSpec("00s").setIndicator("00s")
                .setContent(R.id.tab3));

	    // this will be visible when nothing is selected, so let's inflate it now
	    ((ViewStub) findViewById(R.id.tab1stub)).inflate();
	    initPager("80s");
	    
	    tabHost.setOnTabChangedListener(this);
	}

	private void initPager(String spec){
		Layouts l;
		int view;
		
		if ("80s".equals(spec)){
			l = Layouts.L80S;
			view = R.id.viewpager1;
		} else if ("90s".equals(spec)){
			l = Layouts.L90S;
			view = R.id.viewpager2;
		} else if ("00s".equals(spec)){
			l = Layouts.L00S;
			view = R.id.viewpager3;
		} else {
			l = Layouts.L80S;
			view = R.id.viewpager1;
		}

		TvPagerAdapter tvAdapter = new TvPagerAdapter(this, l);
		ViewPager awesomePager = (ViewPager) findViewById(view);
        awesomePager.setAdapter(tvAdapter);
	}
	
	@Override
	public void onTabChanged(String arg0) {
		if ("80s" == arg0 && null != findViewById(R.id.tab1stub)){
		    ((ViewStub) findViewById(R.id.tab1stub)).inflate();
		    initPager("80s");
		} else if ("90s" == arg0 && null != findViewById(R.id.tab2stub)){
		    ((ViewStub) findViewById(R.id.tab2stub)).inflate();
		    initPager("90s");
		} else if ("00s" == arg0 && null != findViewById(R.id.tab3stub)){
		    ((ViewStub) findViewById(R.id.tab3stub)).inflate();
		    initPager("00s");
		}
	}
	
}
