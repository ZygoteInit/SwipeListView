package com.hanzala.swipelistview;

import java.util.ArrayList;
import java.util.List;

import com.hanzala.swipelistview.DAL.Book;
import com.hanzala.swipelistview.DAL.DBHelper;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	SwipeListView swipelistview;
	ItemAdaptor adapter;
	List<Book> itemData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DBHelper db = new DBHelper(this);
		 
        /**
         * CRUD Operations
         * */
        // add Books
        db.addBook(new Book("A song of Ice and Fire", "g.g.martin"));   
        db.addBook(new Book("Storm of Swords", "g.g.martin"));       
        db.addBook(new Book("Clash of Kings", "g.g.martin"));
 
        // get all books
       itemData = db.getAllBooks();
        
       
       //Assigning Listview Adapter
        swipelistview=(SwipeListView)findViewById(R.id.swipe_listview);
        adapter=new ItemAdaptor(getApplicationContext(),R.layout.listviewrow,itemData);
        
        
        //SetOnClickListener for SwipeListView
     

        swipelistview.setSwipeListViewListener(new SwipeListViewListener() {

			@Override
			public void onOpened(int position, boolean toRight) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onClosed(int position, boolean fromRight) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onListChanged() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onMove(int position, float x) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStartOpen(int position, int action, boolean right) {
				// TODO Auto-generated method stub
				
				Log.d("swipe", String.format("onStartOpen %d", position));
			}

			@Override
			public void onStartClose(int position, boolean right) {
				// TODO Auto-generated method stub
				Log.d("swipe", String.format("onStartClose %d", position));
			}

			@Override
			public void onClickFrontView(int position) {
				// TODO Auto-generated method stub
				Log.d("swipe", String.format("onClickFrontView %d", position));
				
				swipelistview.openAnimate(position); //when you touch front view it 
			}

			@Override
			public void onClickBackView(int position) {
				// TODO Auto-generated method stub
				Log.d("swipe", String.format("onClickBackView %d", position));
				swipelistview.closeAnimate(position);//when you touch back view it will close
			}

			@Override
			public void onDismiss(int[] reverseSortedPositions) {
				// TODO Auto-generated method stub
					
			}

			@Override
			public int onChangeSwipeMode(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void onChoiceChanged(int position, boolean selected) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChoiceStarted() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChoiceEnded() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFirstListItem() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onLastListItem() {
				// TODO Auto-generated method stub
				
			}
            
           
    
        });
        
        swipelistview.setSwipeMode(SwipeListView.SWIPE_MODE_LEFT); // there are five swiping modes
      	 swipelistview.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL); //there are four swipe actions
      	 swipelistview.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
//      	 swipelistview.setOffsetLeft(convertDpToPixel(500f)); // left side offset
//      	 swipelistview.setOffsetRight(convertDpToPixel(0f)); // right side offset
      	 swipelistview.setAnimationTime(50); // animarion time
      	 swipelistview.setSwipeOpenOnLongPress(true); // enable or disable SwipeOpenOnLongPress

      	swipelistview.setAdapter(adapter);
      	
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public int convertDpToPixel(float dp) {
	       DisplayMetrics metrics = getResources().getDisplayMetrics();
	       float px = dp * (metrics.densityDpi / 160f);
	       return (int) px;
	   }

}
