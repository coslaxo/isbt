package com.elliottgarner.cataddict;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                update();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    int happiness = 0;
    int money = 0;
    int petClickWorth = 1;
    int hps = 0;
    int mps = 0;

    public void update() {
        happiness = happiness + hps;
        displayHappiness(happiness);
        displayMoney(money);
        displayHps(hps);
        displayMps(mps);
    }
    //updates values
    public void displayHappiness(int happiness) {
        TextView happinessView = (TextView) findViewById(R.id.happiness_value);
        happinessView.setText(String.valueOf(happiness));
    }
    public void displayHps(int hps) {
        TextView happinessView = (TextView) findViewById(R.id.hps_value);
        happinessView.setText(String.valueOf(hps));
    }
    public void displayMps(int mps) {
        TextView happinessView = (TextView) findViewById(R.id.mps_value);
        happinessView.setText(String.valueOf(mps));
    }
    public void displayMoney(int money){
        TextView moneyView = (TextView) findViewById(R.id.money_value);
        moneyView.setText(String.valueOf(money));
    }
    //buttons
    public void work(View view){
        money = money + happiness;
        happiness = 0;
        update();
    }
    public void pet(View view){
        happiness = happiness + petClickWorth;
        update();
    }

    int kittenCost = 50;
    public void buyKitten(View view) {
        if (money >= kittenCost){
            money = money - kittenCost;
            hps = hps + 1;
        }
    }
    int catCost = 500;
    public void buyCat(View view) {
        if (money >= catCost){
            money = money - catCost;
            hps = hps + 5;
        }
    }
    int shortHairCost = 5000;
    public void buyShortHair(View view){
        if (money >= shortHairCost){
            money = money - shortHairCost;
            hps = hps + 50;
        }
    }


    public void showCatsTable(View view){
        LinearLayout cats = (LinearLayout) findViewById(R.id.cats_buys);
        LinearLayout work = (LinearLayout) findViewById(R.id.work_buys);
        LinearLayout humanToys = (LinearLayout) findViewById(R.id.human_buys);
        LinearLayout toys = (LinearLayout) findViewById(R.id.toys_buys);
        toys.setVisibility(View.GONE);
        humanToys.setVisibility(View.GONE);
        work.setVisibility(View.GONE);
        cats.setVisibility(View.VISIBLE);
    }
    public void showWorkTable(View view){
        LinearLayout cats = (LinearLayout) findViewById(R.id.cats_buys);
        LinearLayout work = (LinearLayout) findViewById(R.id.work_buys);
        LinearLayout humanToys = (LinearLayout) findViewById(R.id.human_buys);
        LinearLayout toys = (LinearLayout) findViewById(R.id.toys_buys);
        toys.setVisibility(View.GONE);
        humanToys.setVisibility(View.GONE);
        work.setVisibility(View.VISIBLE);
        cats.setVisibility(View.GONE);
    }
    public void showCatToysTable(View view){
        LinearLayout cats = (LinearLayout) findViewById(R.id.cats_buys);
        LinearLayout work = (LinearLayout) findViewById(R.id.work_buys);
        LinearLayout humanToys = (LinearLayout) findViewById(R.id.human_buys);
        LinearLayout toys = (LinearLayout) findViewById(R.id.toys_buys);
        toys.setVisibility(View.VISIBLE);
        humanToys.setVisibility(View.GONE);
        work.setVisibility(View.GONE);
        cats.setVisibility(View.GONE);
    }
    public void showHumanToys(View view){
        LinearLayout cats = (LinearLayout) findViewById(R.id.cats_buys);
        LinearLayout work = (LinearLayout) findViewById(R.id.work_buys);
        LinearLayout humanToys = (LinearLayout) findViewById(R.id.human_buys);
        LinearLayout toys = (LinearLayout) findViewById(R.id.toys_buys);
        toys.setVisibility(View.GONE);
        humanToys.setVisibility(View.VISIBLE);
        work.setVisibility(View.GONE);
        cats.setVisibility(View.GONE);
    }
}
