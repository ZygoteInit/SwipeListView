package com.hanzala.swipelistview;

import java.util.List;

import com.hanzala.swipelistview.DAL.Book;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemAdaptor extends ArrayAdapter {
	 
   


	List<Book> data;
    Context context;
    int layoutResID;


public ItemAdaptor(Context context, int layoutResourceId,List<Book> data) {
	 super(context, layoutResourceId, data);

	    this.data=data;
	    this.context=context;
	    this.layoutResID=layoutResourceId;
}
public ItemAdaptor(MainActivity context2, int listviewrow, List<Book> itemData) {
	// TODO Auto-generated constructor stub
	 super(context2, listviewrow, itemData);

	    this.data=data;
	    this.context=context2;
	    this.layoutResID=listviewrow;
}
@Override
public View getView(int position, View convertView, ViewGroup parent) {

    NewsHolder holder = null;
       View row = convertView;
        holder = null;

      if(row == null)
      {
          LayoutInflater inflater = LayoutInflater.from(context);
          row = inflater.inflate(layoutResID, parent, false);

          holder = new NewsHolder();

          holder.itemName = (TextView)row.findViewById(R.id.example_itemname);
          holder.icon=(ImageView)row.findViewById(R.id.example_image);
          holder.button1=(Button)row.findViewById(R.id.swipe_button1);
          holder.button2=(Button)row.findViewById(R.id.swipe_button2);
          holder.button3=(Button)row.findViewById(R.id.swipe_button3);
          row.setTag(holder);
      }
      else
      {
          holder = (NewsHolder)row.getTag();
      }

      Book itemdata = data.get(position);
      holder.itemName.setText(itemdata.getTitle());
      

      holder.button1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                      // TODO Auto-generated method stub
                      Toast.makeText(context, "Button 1 Clicked",Toast.LENGTH_SHORT).show();
                }
          });

           holder.button2.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                  // TODO Auto-generated method stub
                                  Toast.makeText(context, "Button 2 Clicked",Toast.LENGTH_SHORT).show();
                            }
                      });

           holder.button3.setOnClickListener(new View.OnClickListener() {

                      @Override
                      public void onClick(View v) {
                            // TODO Auto-generated method stub
                         
                    	  try {
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    	  Toast.makeText(context, "Button 3 Clicked",Toast.LENGTH_SHORT);
                      }
                });

      return row;

}

static class NewsHolder{

    TextView itemName;
    ImageView icon;
    Button button1;
    Button button2;
    Button button3;
    }

}
