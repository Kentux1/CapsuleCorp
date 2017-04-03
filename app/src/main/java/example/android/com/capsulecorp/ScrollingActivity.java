package example.android.com.capsulecorp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import static example.android.com.capsulecorp.R.drawable.capsulecorp;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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
    public void emailButtonClick (View view) {
        Intent emailButton = new Intent(Intent.ACTION_SENDTO);
        emailButton.setData(Uri.parse("mailto:"));
        emailButton.putExtra(Intent.EXTRA_EMAIL, new String [] {"capsulecorp@capscorp.com"});
        if (emailButton.resolveActivity(getPackageManager()) != null) {
            startActivity(emailButton);
        }
    }
    public void phoneButtonClick (View view) {
        Intent phoneButton = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", getString(R.string.call_number), null));
        if (phoneButton.resolveActivity(getPackageManager()) != null) {
            startActivity(phoneButton);
        }
    }
    public void openBrowser (View view) {
        Intent websiteButton = new Intent(Intent.ACTION_VIEW);
        websiteButton.setData(Uri.parse("http://dragonball.wikia.com/wiki/Capsule_Corporation"));
        if (websiteButton.resolveActivity(getPackageManager()) != null) {
            startActivity(websiteButton);
        }
    }
}
