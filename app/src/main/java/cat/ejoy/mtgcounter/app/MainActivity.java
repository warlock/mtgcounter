package cat.ejoy.mtgcounter.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    TextView player1, player2;
    Button lifeP1, lifeP2, poisonP1, poisonP2, btnlP1a1, btnlP1a5, btnpP1a1,btnpP1a5, btnlP2a1, btnlP2a5, btnpP2a1, btnpP2a5;
    int p1life = 20;
    int p2life = 20;
    int p1poison = 0;
    int p2poison = 0;
    String life = " life";
    String poison = " poison";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Strings Externes */
        life = " " + getString(R.string.life);
        poison = " " + getString(R.string.poison);

        /* Jugadors */
        player1 = (TextView) findViewById(R.id.player1);
        player2 = (TextView) findViewById(R.id.player2);

        /* Text vida jugador 1 */
        lifeP1 = (Button) findViewById(R.id.lifeP1);
        lifeP1.setText(String.valueOf(p1life) + life);
        lifeP1.setOnClickListener(this);

        /* Text vida jugador 2 */
        lifeP2 = (Button) findViewById(R.id.lifeP2);
        lifeP2.setText(String.valueOf(p2life) + life);
        lifeP2.setOnClickListener(this);

        /* Text veri jugador 1 */
        poisonP1 = (Button) findViewById(R.id.poisonP1);
        poisonP1.setText(String.valueOf(p1poison) + poison);
        poisonP1.setOnClickListener(this);

        /* Text veri jugador 2 */
        poisonP2 = (Button) findViewById(R.id.poisonP2);
        poisonP2.setText(String.valueOf(p2poison) + poison);
        poisonP2.setOnClickListener(this);

        /* Carrega Botons jugador 1 */
        btnlP1a1 = (Button) findViewById(R.id.btnlP1a1);
        btnlP1a5 = (Button) findViewById(R.id.btnlP1a5);
        btnpP1a1 = (Button) findViewById(R.id.btnpP1a1);
        btnpP1a5 = (Button) findViewById(R.id.btnpP1a5);

        /* Carrega Listeners jugador 1*/
        btnlP1a1.setOnClickListener(this);
        btnlP1a5.setOnClickListener(this);
        btnpP1a1.setOnClickListener(this);
        btnpP1a5.setOnClickListener(this);

        /* Carrega Botons jugador 2 */
        btnlP2a1 = (Button) findViewById(R.id.btnlP2a1);
        btnlP2a5 = (Button) findViewById(R.id.btnlP2a5);
        btnpP2a1 = (Button) findViewById(R.id.btnpP2a1);
        btnpP2a5 = (Button) findViewById(R.id.btnpP2a5);

        /* Carrega Listeners jugador 1*/
        btnlP2a1.setOnClickListener(this);
        btnlP2a5.setOnClickListener(this);
        btnpP2a1.setOnClickListener(this);
        btnpP2a5.setOnClickListener(this);

    }


/* Metode onClick */
    @Override
    public void onClick(View view) {
        /* Strings Externes */
        life = " " + getString(R.string.life);
        poison = " " + getString(R.string.poison);
        String firstp = getString(R.string.firstp);
        String secondp = getString(R.string.secondp);
        String win = " " + getString(R.string.win);
        String lose = " " + getString(R.string.lose);

        switch (view.getId()) {
                //botons jugador 1
                case R.id.btnlP1a1:
                    p1life = p1life+1;
                    lifeP1.setText(String.valueOf(p1life) + life);
                    break;
                case R.id.btnlP1a5:
                    p1life = p1life+5;
                    lifeP1.setText(String.valueOf(p1life) + life);
                    break;
                case R.id.btnpP1a1:
                    if (p1poison > 0){
                        p1poison = p1poison - 1;
                        poisonP1.setText(String.valueOf(p1poison) + poison);
                    }
                    break;
                case R.id.btnpP1a5:
                    if (p1poison > 4) {
                        p1poison = p1poison - 5;
                        poisonP1.setText(String.valueOf(p1poison) + poison);
                    }
                    break;

                //botons jugador 2
                case R.id.btnlP2a1:
                    p2life = p2life+1;
                    lifeP2.setText(String.valueOf(p2life) + life);
                    break;
                case R.id.btnlP2a5:
                    p2life = p2life+5;
                    lifeP2.setText(String.valueOf(p2life) + life);
                    break;

                case R.id.btnpP2a1:
                    if (p2poison > 0){
                        p2poison = p2poison - 1;
                        poisonP2.setText(String.valueOf(p2poison) + poison);
                    }
                    break;
                case R.id.btnpP2a5:
                    if (p2poison > 4) {
                        p2poison = p2poison - 5;
                        poisonP2.setText(String.valueOf(p2poison) + poison);
                    }
                    break;

                //Vida jugadors
                case R.id.lifeP1:
                    if (p1life <= 1 ) {
                        p1life = 0;
                        lifeP1.setText("0" + life);
                        player1.setText(firstp + lose);
                        player2.setText(secondp + win);
                    } else {
                        p1life--;
                        lifeP1.setText(String.valueOf(p1life) + life);
                    }
                    break;


                case R.id.lifeP2:
                    if (p2life <= 1 ) {
                        p2life = 0;
                        lifeP2.setText("0" + life);
                        player1.setText(firstp + win);
                        player2.setText(secondp + lose);
                    } else {
                        p2life--;
                        lifeP2.setText(String.valueOf(p2life) + life);
                    }
                    break;

                case R.id.poisonP1:
                    if (p1poison >= 9) {
                        p1poison = 10;
                        poisonP1.setText("10" + poison);
                        player1.setText(firstp + lose);
                        player2.setText(secondp + win);
                    } else {
                        p1poison++;
                        poisonP1.setText(String.valueOf(p1poison) + poison);
                    }
                    break;

                case R.id.poisonP2:
                    if (p2poison >= 9) {
                        p2poison = 10;
                        poisonP2.setText("10" + poison);
                        player1.setText(firstp + win);
                        player2.setText(secondp + lose);
                    } else {
                        p2poison++;
                        poisonP2.setText(String.valueOf(p2poison) + poison);
                    }
                    break;

        }

    }

/* Menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_reset:
                if (p1life != 20 || p2life != 20 || p1poison != 0 || p2poison != 0) {
                    p1life = 20;
                    p2life = 20;
                    p1poison = 0;
                    p2poison = 0;
                    lifeP1.setText(String.valueOf(p1life) + life);
                    lifeP2.setText(String.valueOf(p2life) + life);
                    poisonP1.setText(String.valueOf(p1poison) + poison);
                    poisonP2.setText(String.valueOf(p2poison) + poison);
                    String firstp = getString(R.string.firstp);
                    String secondp = getString(R.string.secondp);
                    player1.setText(firstp);
                    player2.setText(secondp);
                }
                break;
            case R.id.menu_about:
                Toast.makeText(getApplicationContext(), getString(R.string.credits),
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_dice:
                Random r = new Random();
                String dice;
                Integer i = r.nextInt(6 - 1 + 1) + 1;
                dice = i.toString();
                Toast.makeText(getApplicationContext(), dice,
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_coin:
                String coin;
                Random randcoin = new Random();
                if (randcoin.nextBoolean()) {
                    coin = getString(R.string.heads);
                } else {
                    coin = getString(R.string.tails);
                }
                Toast.makeText(getApplicationContext(), coin,
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_exit:
                finish();
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /* Recordar instancia */
    @Override
    protected void onSaveInstanceState(Bundle estat) {
        super.onSaveInstanceState(estat);
        estat.putInt("p1life", p1life);
        estat.putInt("p2life", p2life);
        estat.putInt("p1poison", p1poison);
        estat.putInt("p2poison", p2poison);
    }

    /* Recarregar instancia */
    @Override
    protected void onRestoreInstanceState(Bundle estat) {
        super.onRestoreInstanceState(estat);
        p1life = estat.getInt("p1life");
        lifeP1.setText(String.valueOf(p1life) + life);
        p2life = estat.getInt("p2life");
        lifeP2.setText(String.valueOf(p2life) + life);
        p1poison = estat.getInt("p1poison");
        poisonP1.setText(String.valueOf(p1poison) + poison);
        p2poison = estat.getInt("p2poison");
        poisonP2.setText(String.valueOf(p2poison) + poison);
    }
}