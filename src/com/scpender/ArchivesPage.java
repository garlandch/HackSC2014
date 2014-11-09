package com.scpender;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.example.scpender.R;

public class ArchivesPage extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_archives_page);
		TabUtils.activateTab(this, R.id.archivestab);
	}

}
