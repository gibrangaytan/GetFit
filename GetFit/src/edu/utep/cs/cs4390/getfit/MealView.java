package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Displays the details of a meal.  Shows a picture of a meal, the ingredients, and the directions 
 * to prepare it.
 */ 
public class MealView extends Activity {
	
	LinearLayout view;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mealview);
        
        view = (LinearLayout) findViewById(R.id.imageView);
        ImageView imageMeal = new ImageView(MealView.this);
        imageMeal.setBackgroundResource(R.drawable.chickem);
        view.addView(imageMeal);
        
        TextView textview = (TextView)findViewById(R.id.instructions);
        textview.setText("Ingredients: 1/4 cup all-purpose flour for coating, 1/2 teaspoon salt, 1/4 teaspoon ground black pepper"
        		+ "1/2 teaspoon dried oregano, 4 skinless, boneless chicken breast halves - pounded 1/4 inch thick, "
        		+ "4 tablespoons butter, 4 tablespoons olive oil, 1 cup sliced mushrooms, 1/2 cup Marsala wine, 1/4 cup cooking sherry");
        TextView textview2 = (TextView) findViewById(R.id.directions);
        textview2.setText("Directions: 1.In a shallow dish or bowl, mix together the flour, "
        		+ "salt, pepper and oregano. Coat chicken pieces in flour mixture."
        		+ "2. In a large skillet, melt butter in oil over medium heat. Place chicken in the pan, and lightly brown. Turn over"
        		+ " chicken pieces, and add mushrooms. Pour in wine and sherry. Cover skillet; simmer chicken 10 minutes, turning once,"
        		+ " until no longer pink and juices run clear.");

 }
 
 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}




