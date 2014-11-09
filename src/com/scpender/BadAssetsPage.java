package com.scpender;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.scpender.R;

public class BadAssetsPage extends ActionBarActivity 
{
	private ListView badassetsLV;
	private BadAssetListAdapter listAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bad_assets_page);
		TabUtils.activateTab(this, R.id.badassetstab);
		
		//Hacked in Items
		List<String> myTransactions = new ArrayList<String>();
		myTransactions.add("first");
		myTransactions.add("first");
		myTransactions.add("first");
		
		badassetsLV = (ListView) findViewById(R.id.BadAssetsListView);
		listAdapter = new BadAssetListAdapter(getApplicationContext(), myTransactions);
		badassetsLV.setAdapter(listAdapter);
	}
	
	private class BadAssetListAdapter extends ArrayAdapter<String>
	{
		private List<String> transactions;
		private Context mContext = null;
		private LayoutInflater inflater = null;
		
		private class ViewHolder 
		{
            TextView date;
            TextView store;
            TextView price;
        }
		
		public BadAssetListAdapter(Context context, List<String> items) 
		{
			super(context, R.layout.transaction_list_item, items);
			this.transactions = items;
			this.mContext = context;
			this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() 
		{
			return transactions.size();
		}

		@Override
		public String getItem(int item) 
		{
			return transactions.get(item);
		}

		@Override
		public long getItemId(int id) 
		{
			return id;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) 
		{
			ViewHolder viewholder = new ViewHolder();
			view = inflater.inflate(R.layout.transaction_list_item, parent, false);
			
			viewholder.date = (TextView) view.findViewById(R.id.dateTextview);
			viewholder.price = (TextView) view.findViewById(R.id.priceTextview);
			viewholder.store = (TextView) view.findViewById(R.id.storeTextview);
			
			viewholder.date.setText("Nov 6, 2014");
			viewholder.price.setText("$69.99");
			viewholder.store.setText("Umami Burger");
			
			view.setTag(viewholder);
			return view;
		}
		
	}
}
