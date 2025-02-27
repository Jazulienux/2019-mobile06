package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import id.ac.polinema.idealbodyweight.fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.fragments.BMIFragments;
import id.ac.polinema.idealbodyweight.fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.fragments.ResultFragment;
import id.ac.polinema.idealbodyweight.util.BrocaIndex;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener,
		BrocaIndexFragment.OnFragmentInteractionListener,
		ResultFragment.OnFragmentInteractionListener,
		BMIFragments.OnFragmentInteractionListener {

	// Deklarasikan atribut Fragment di sini
	private AboutFragment aboutFragment;
	private MenuFragment menuFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private ResultFragment resultFragment;
	private BMIFragments bmiFragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aboutFragment = AboutFragment.newInstance("Muhammad Saifuddin Jazuli");
		menuFragment = new MenuFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container,menuFragment).addToBackStack(null).commit();
		brocaIndexFragment = new BrocaIndexFragment();
		resultFragment = new ResultFragment();
		bmiFragments = new BMIFragments();

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
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,brocaIndexFragment , "boca").
				addToBackStack(null).commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction().
				replace(R.id.fragment_container,bmiFragments , "bmi_idx").addToBackStack(null)
				.commit();
	}

	@Override
	public void onCalculate(float index) {
		resultFragment.setInformation(String.format("Your Ideal Height Is %.2f kg", index));
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,resultFragment)
				.addToBackStack(null).commit();
	}

	@Override
	public void onTryAgainButtonClicked(String tag) {
		if(tag == "boca"){
			getSupportFragmentManager().beginTransaction().
					replace(R.id.fragment_container,brocaIndexFragment).addToBackStack(null)
					.commit();
		}
		else{
			getSupportFragmentManager().beginTransaction().
					replace(R.id.fragment_container,bmiFragments).addToBackStack(null)
					.commit();
		}
	}

	@Override
	public void onCalculateBMI(float index, String status) {
		resultFragment.setInformationBMI(String.format("Your BMI Is %.8f", index), "Your Status BMI is " + status);
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,resultFragment)
				.addToBackStack(null).commit();
	}
}
