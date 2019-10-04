package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import id.ac.polinema.idealbodyweight.fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.util.BrocaIndex;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener,
		BrocaIndexFragment.OnFragmentInteractionListener {

	// Deklarasikan atribut Fragment di sini
	private AboutFragment aboutFragment;
	private MenuFragment menuFragment;
	private BrocaIndexFragment brocaIndexFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aboutFragment = AboutFragment.newInstance("Muhammad Saifuddin Jazuli");
		menuFragment = new MenuFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container,menuFragment).addToBackStack(null).commit();
		brocaIndexFragment = new BrocaIndexFragment();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini

		if(item.getItemId() == R.id.menu_about){
			getSupportFragmentManager().beginTransaction().
					replace(R.id.fragment_container,aboutFragment).addToBackStack(null)
					.commit();
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,brocaIndexFragment).
				addToBackStack(null).commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {

	}

	@Override
	public void onCalculate(float index) {

	}
}
