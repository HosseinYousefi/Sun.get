package space.harbour.sunget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView textView = findViewById(R.id.json);
		Sun sun = new Sun();
		sun.get("Barcelona", result -> {
			textView.setText(result);
		});
	}

}
