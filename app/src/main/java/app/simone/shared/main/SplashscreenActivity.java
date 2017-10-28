package app.simone.shared.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;

import app.simone.R;
import app.simone.multiplayer.controller.NearbyGameController;
import app.simone.multiplayer.view.nearby.NearbyGameActivity;
import app.simone.multiplayer.view.newmatch.FriendsListFragment;
import app.simone.scores.view.ScoreboardActivity;
import app.simone.settings.view.SettingsActivity;
import app.simone.shared.firebase.FCMTokenService;
import app.simone.shared.utils.AudioManager;
import app.simone.shared.utils.Constants;
import app.simone.singleplayer.view.VSCpuActivity;
import io.fabric.sdk.android.Fabric;

/**
 * MainActivity of the app.
 *
 * @author Michele Sapignoli
 */
public class SplashscreenActivity extends FullscreenBaseGameActivity {
    private static final int SPLASH_TIME=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntentLauncher launcher = new IntentLauncher();
        launcher.start();
    }


    protected void setSubclassContentView() {
        setContentView(R.layout.activity_splashscreen);
        mContentView = findViewById(R.id.splash_fullscreen_content);
        mVisible = true;
    }

    @Override
    protected void backTransition() {
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    private class IntentLauncher extends Thread {

        /**
         * Sleep for some time and than start new activity.
         */
        @Override
        public void run() {
            try {
                // Sleeping
                Thread.sleep(SPLASH_TIME*1000);
            } catch (Exception e) {
                Log.e("SPLASH", e.getMessage());
            }

            // Start main activity
            /*Intent intent = new Intent(SplashscreenActivity.this, MainActivity.class);
            SplashscreenActivity.this.startActivity(intent);
            SplashscreenActivity.this.finish();*/
            openActivity(MainActivity.class, R.anim.fade_in, R.anim.fade_in);
            SplashscreenActivity.this.finish();
        }

    }
}

