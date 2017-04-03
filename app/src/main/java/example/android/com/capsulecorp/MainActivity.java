package example.android.com.capsulecorp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tiago Gomes on 29/03/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle outState) {
        super.onCreate(outState);
        setContentView(R.layout.content_scrolling);
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
        Intent websiteButton = new Intent (Intent.ACTION_VIEW);
        websiteButton.setData(Uri.parse("http://dragonball.wikia.com/wiki/Capsule_Corporation"));
        startActivity(websiteButton);
    }
}
