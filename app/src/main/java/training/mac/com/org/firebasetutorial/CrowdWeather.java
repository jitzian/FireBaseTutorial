package training.mac.com.org.firebasetutorial;

import com.firebase.client.Firebase;

/**
 * Created by User on 8/19/2016.
 */
public class CrowdWeather extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
