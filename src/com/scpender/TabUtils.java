package com.scpender;

import com.example.scpender.R;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TabWidget;

public class TabUtils 
{
	static int sActiveTabIndex = -1;
	public static void activateTab(Activity a, int highlight) 
	{
		final TabWidget ll = (TabWidget) a.findViewById(R.id.buttonbar);
		if (highlight == 0) 
		{
            ll.setVisibility(View.GONE);
        }
		else
        {
            ll.setVisibility(View.VISIBLE);
        }
        for (int i = ll.getChildCount() - 1; i >= 0; i--) {
            
            View v = ll.getChildAt(i);
            boolean isActive = (v.getId() == highlight);
            if (isActive) {
                ll.setCurrentTab(i);
                sActiveTabIndex = i;
            }
            v.setTag(i);
            v.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        for (int i = 0; i < ll.getTabCount(); i++) {
                            if (ll.getChildTabViewAt(i) == v) {
                                ll.setCurrentTab(i);
                                processTabClick((Activity)ll.getContext(), v, ll.getChildAt(sActiveTabIndex).getId());
                                break;
                            }
                        }
                    }
                }});
            
            v.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    processTabClick((Activity)ll.getContext(), v, ll.getChildAt(sActiveTabIndex).getId());
                }});
        }
	}
	
	static void processTabClick(Activity a, View v, int current) {
        int id = v.getId();
        if (id == current) 
        {
            return;
        }
        switch(id)
        {
	        case R.id.totalstab:
	        {
	        	Intent intent = new Intent(a, MainActivity.class);
	        	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        	a.startActivity(intent);
	        	break;
	        }
	        case R.id.badassetstab:
	        {
	        	Intent intent = new Intent(a, BadAssetsPage.class);
	        	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        	a.startActivity(intent);
	        	break;
	        }
	        case R.id.archivestab:
	        {
	        	Intent intent = new Intent(a, ArchivesPage.class);
	        	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        	a.startActivity(intent);
	        	break;
	        }
        }
        a.overridePendingTransition(0, 0);
        activateTab(a, id);
    }
}
